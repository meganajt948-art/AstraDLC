/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.render.OverlayTexture
 *  net.minecraft.client.texture.NativeImage
 *  net.minecraft.client.texture.NativeImageBackedTexture
 */
package a;

import a.kfa;
import a.kfe;
import a.ujt;
import a.vkl;
import a.vla;
import a.vmc;
import java.lang.reflect.Field;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;

public class rfa
extends kfe {
    private static final int rfb = -1291911168;
    private final vla rfc = this.add(new vla("Color", "Sakura"));
    private final vmc rfd = this.add(new vmc("Strength", 0.45, 0.1, 0.85, 0.05).percent());
    private final vkl rfe = this.add(new vkl("Shimmer", true));
    private static Field rff;
    private static boolean rfg;
    private int rfh;
    private static /* synthetic */ String rfi;
    private static /* synthetic */ long rfj;

    public rfa() {
        super(new String(new char[]{'H', 'i', 't', 'C', 'o', 'l', 'o', 'r'}), "Your colour instead of the red hit flash", kfa.RENDER);
    }

    @Override
    protected void onDisable() {
        if (this.rfh != 0 && rfa.rfk(-1291911168)) {
            this.rfh = 0;
        }
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        int n;
        int n2;
        int n3 = this.rfc.color();
        if (this.rfe.get()) {
            float f = (float)(0.5 + 0.5 * Math.sin((double)System.nanoTime() / 1.0E9 * 1.6));
            n3 = ujt.lerp(n3, this.rfc.color2(), f * 0.8f);
        }
        if ((n2 = ujt.withAlpha(n3, n = Math.round(255.0f * (1.0f - (float)this.rfd.get())))) != this.rfh && rfa.rfk(n2)) {
            this.rfh = n2;
        }
    }

    private static boolean rfk(int n) {
        if (rfg) {
            return false;
        }
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        if (minecraftClient.field_1773 == null) {
            return false;
        }
        try {
            NativeImage nativeImage;
            int n2;
            NativeImageBackedTexture nativeImageBackedTexture;
            OverlayTexture overlayTexture = minecraftClient.field_1773.method_22975();
            if (rff == null) {
                nativeImageBackedTexture = OverlayTexture.class.getDeclaredFields();
                int n3 = ((Field[])nativeImageBackedTexture).length;
                for (n2 = 0; n2 < n3; ++n2) {
                    NativeImageBackedTexture nativeImageBackedTexture2 = nativeImageBackedTexture[n2];
                    if (nativeImageBackedTexture2.getType() != NativeImageBackedTexture.class) continue;
                    nativeImageBackedTexture2.setAccessible(true);
                    rff = nativeImageBackedTexture2;
                    break;
                }
                if (rff == null) {
                    throw new IllegalStateException("overlay texture field not found");
                }
            }
            if ((nativeImage = (nativeImageBackedTexture = (NativeImageBackedTexture)rff.get(overlayTexture)).method_4525()) == null) {
                return false;
            }
            for (n2 = 0; n2 < 8; ++n2) {
                for (int i = 0; i < 16; ++i) {
                    nativeImage.method_61941(i, n2, n);
                }
            }
            nativeImageBackedTexture.method_4524();
            return true;
        }
        catch (Throwable throwable) {
            rfg = true;
            System.out.println("hit colour unavailable: " + throwable);
            return false;
        }
    }

    private static /* synthetic */ int bxx(int n, int n2) {
        return n + n2 | 0x8EBBA6B8;
    }
}

