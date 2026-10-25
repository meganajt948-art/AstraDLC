/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.GpuDevice
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.GpuTexture
 *  com.mojang.blaze3d.textures.GpuTextureView
 *  com.mojang.blaze3d.textures.TextureFormat
 *  it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap
 *  net.minecraft.client.texture.NativeImage
 */
package a;

import a.vev;
import a.vfh;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.font.LineMetrics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import net.minecraft.client.texture.NativeImage;

final class vfk {
    static final String TEXT_CHARSET = vfk.vfv();
    private static final int vfl = 1;
    private static final int vfm = 1;
    private static final float vfn = 0.86f;
    final float pixelsPerUnit;
    final float ascent;
    final float descent;
    final float capHeight;
    final GpuTextureView view;
    private final GpuTexture vfo;
    private final Int2ObjectOpenHashMap<vev> vfp;
    private final Font vfq;
    private static /* synthetic */ String vfr;
    private static /* synthetic */ long vfs;

    private vfk(float f, float f2, float f3, float f4, GpuTexture gpuTexture, GpuTextureView gpuTextureView, Int2ObjectOpenHashMap<vev> int2ObjectOpenHashMap, Font font) {
        this.pixelsPerUnit = f;
        this.ascent = f2;
        this.descent = f3;
        this.capHeight = f4;
        this.vfo = gpuTexture;
        this.view = gpuTextureView;
        this.vfp = int2ObjectOpenHashMap;
        this.vfq = font;
    }

    vev glyph(int n) {
        vev vev2 = (vev)this.vfp.get(n);
        if (vev2 == null && n != 63) {
            vev2 = (vev)this.vfp.get(63);
        }
        return vev2;
    }

    boolean has(int n) {
        return this.vfp.containsKey(n);
    }

    boolean canDisplay(int n) {
        return this.vfq.canDisplay(n);
    }

    void close() {
        this.view.close();
        this.vfo.close();
    }

    static vfk build(String string, Font font, float f, float f2, String string2, boolean bl) {
        Object object;
        float f3;
        Object object2;
        Object object3;
        int n;
        Font font2 = font.deriveFont(f * f2);
        FontRenderContext fontRenderContext = new FontRenderContext(null, true, true);
        ArrayList<vfh> arrayList = new ArrayList<vfh>();
        BitSet bitSet = new BitSet();
        int n2 = 0;
        while (n2 < string2.length()) {
            n = string2.codePointAt(n2);
            n2 += Character.charCount(n);
            if (n < 65536 && bitSet.get(n)) continue;
            if (n < 65536) {
                bitSet.set(n);
            }
            if (!font2.canDisplay(n) && n != 32) continue;
            object3 = font2.createGlyphVector(fontRenderContext, new String(Character.toChars(n)));
            object2 = ((GlyphVector)object3).getPixelBounds(fontRenderContext, 0.0f, 0.0f);
            float f4 = (float)((GlyphVector)object3).getGlyphPosition(((GlyphVector)object3).getNumGlyphs()).getX();
            arrayList.add(new vfh(n, (GlyphVector)object3, (Rectangle)object2, f4));
        }
        for (n2 = 256; (n = vfk.vft(arrayList, n2)) > n2 && n2 < 4096; n2 *= 2) {
        }
        n = Math.max(16, vfk.vfu(n));
        object3 = new BufferedImage(n2, n, 2);
        object2 = ((BufferedImage)object3).createGraphics();
        ((Graphics2D)object2).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        ((Graphics2D)object2).setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        ((Graphics2D)object2).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ((Graphics2D)object2).setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        ((Graphics2D)object2).setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        ((Graphics)object2).setColor(Color.WHITE);
        Int2ObjectOpenHashMap int2ObjectOpenHashMap = new Int2ObjectOpenHashMap();
        float f5 = 1.0f / f2;
        for (vfh vfh2 : arrayList) {
            if (vfh2.bounds.width <= 0 || vfh2.bounds.height <= 0) {
                int2ObjectOpenHashMap.put(vfh2.cp, (Object)new vev(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, vfh2.advance * f5));
                continue;
            }
            ((Graphics2D)object2).drawGlyphVector(vfh2.vector, vfh2.x + 1 - vfh2.bounds.x, vfh2.y + 1 - vfh2.bounds.y);
            int n3 = vfh2.bounds.width + 2;
            int n4 = vfh2.bounds.height + 2;
            int2ObjectOpenHashMap.put(vfh2.cp, (Object)new vev((float)vfh2.x / (float)n2, (float)vfh2.y / (float)n, (float)(vfh2.x + n3) / (float)n2, (float)(vfh2.y + n4) / (float)n, (float)(vfh2.bounds.x - 1) * f5, (float)(vfh2.bounds.y - 1) * f5, (float)n3 * f5, (float)n4 * f5, vfh2.advance * f5));
        }
        ((Graphics)object2).dispose();
        LineMetrics lineMetrics = font2.getLineMetrics("Hgy", fontRenderContext);
        float f6 = lineMetrics.getAscent() * f5;
        float f7 = lineMetrics.getDescent() * f5;
        if (bl) {
            f3 = f * 0.9f;
            f6 = f;
            f7 = 0.0f;
        } else {
            object = font2.createGlyphVector(fontRenderContext, "H").getPixelBounds(fontRenderContext, 0.0f, 0.0f);
            f3 = ((Rectangle)object).height > 0 ? (float)((Rectangle)object).height * f5 : f6 * 0.72f;
        }
        object = ((DataBufferInt)((BufferedImage)object3).getRaster().getDataBuffer()).getData();
        int[] nArray = new int[256];
        for (int i = 0; i < 256; ++i) {
            nArray[i] = Math.round((float)Math.pow((float)i / 255.0f, 0.86f) * 255.0f);
        }
        GpuDevice gpuDevice = RenderSystem.getDevice();
        GpuTexture gpuTexture = gpuDevice.createTexture(() -> "Flow2 font " + string, 5, TextureFormat.RGBA8, n2, n, 1, 1);
        try (NativeImage nativeImage = new NativeImage(n2, n, false);){
            for (int i = 0; i < n; ++i) {
                int n5 = i * n2;
                for (int j = 0; j < n2; ++j) {
                    int n6 = nArray[object[n5 + j] >>> 24 & 0xFF];
                    nativeImage.method_61941(j, i, n6 << 24 | 0xFFFFFF);
                }
            }
            RenderSystem.getDevice().createCommandEncoder().writeToTexture(gpuTexture, nativeImage);
        }
        nativeImage = gpuDevice.createTextureView(gpuTexture);
        return new vfk(f2, f6, f7, f3, gpuTexture, (GpuTextureView)nativeImage, (Int2ObjectOpenHashMap<vev>)int2ObjectOpenHashMap, font2);
    }

    private static int vft(List<vfh> list, int n) {
        int n2 = 1;
        int n3 = 1;
        int n4 = 0;
        for (vfh vfh2 : list) {
            if (vfh2.bounds.width <= 0 || vfh2.bounds.height <= 0) continue;
            int n5 = vfh2.bounds.width + 2;
            int n6 = vfh2.bounds.height + 2;
            if (n2 + n5 + 1 > n) {
                n2 = 1;
                n3 += n4 + 1;
                n4 = 0;
            }
            vfh2.x = n2;
            vfh2.y = n3;
            n2 += n5 + 1;
            n4 = Math.max(n4, n6);
        }
        return n3 + n4 + 1;
    }

    private static int vfu(int n) {
        int n2;
        for (n2 = 1; n2 < n; n2 <<= 1) {
        }
        return n2;
    }

    private static String vfv() {
        int n;
        StringBuilder stringBuilder = new StringBuilder();
        for (n = 32; n < 127; ++n) {
            stringBuilder.append((char)n);
        }
        for (n = 1040; n <= 1103; ++n) {
            stringBuilder.append((char)n);
        }
        stringBuilder.append("\u0401\u0451\u2026\u2022\u00b7\u2013\u2014\u00ab\u00bb\u00b0\u00b1\u00d7\u2190\u2192\u2191\u2193\u2116");
        return stringBuilder.toString();
    }

    private static /* synthetic */ int dej(int n, int n2) {
        return n + n2 + -1780071864;
    }

    private static /* synthetic */ int dek(int n, int n2) {
        return vfk.dej(n, n2) * n2;
    }
}

