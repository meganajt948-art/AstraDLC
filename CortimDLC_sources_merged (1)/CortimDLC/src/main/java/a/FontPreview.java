/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 */
package a;

import a.CosmeticThumbCard;
import a.Theme;
import a.UiKit;
import a.isn;
import a.WallpaperManager;
import a.Hud;
import a.MenuArtCache;
import a.WallpaperEntry;
import a.FontFace;
import a.Fonts;
import a.whl;
import flow.cosmetic.CosmeticItem;
import flow.cosmetic.Cosmetics;
import flow.dev.StringDecryptor;
import java.util.List;
import java.util.function.BooleanSupplier;
import net.minecraft.class_310;

public final class FontPreview {
    private static /* synthetic */ boolean hzm;
    private static /* synthetic */ long hzn;

    private FontPreview() {
    }

    public static void steps(List<BooleanSupplier> list) {
        float f;
        class_310 class_3102 = class_310.method_1551();
        FontPreview.hzp(UiKit.class);
        FontPreview.hzp(Hud.class);
        float f2 = 1.0f;
        if (class_3102.method_22683() != null) {
            f = class_3102.method_22683().method_4486();
            float f3 = class_3102.method_22683().method_4502();
            float f4 = Math.min((f - 16.0f) / 540.0f, (f3 - 16.0f) / 409.0f);
            f2 = Math.max(0.3f, Math.min((float)Theme.SCALE.get(), f4));
        }
        f = f2;
        for (FontFace vdn2 : Fonts.all()) {
            list.add(() -> FontPreview.hzo(vdn2, 1.0f));
            if (!(Math.abs(f - 1.0f) > 0.01f)) continue;
            list.add(() -> FontPreview.hzo(vdn2, f));
        }
        String string = WallpaperEntry.selected().key;
        list.add(() -> MenuArtCache.warm(string));
        list.add(() -> {
            whl.warm(string, WallpaperManager.selected());
            return true;
        });
        for (WallpaperEntry kbs2 : WallpaperEntry.values()) {
            list.add(() -> MenuArtCache.warmThumb(kbs2.key));
        }
        for (isn isn2 : WallpaperManager.entries()) {
            list.add(() -> isn2.isWorld() || isn2.failed || WallpaperManager.thumbnail(isn2) != null);
        }
        for (CosmeticItem cosmeticItem : Cosmetics.items()) {
            list.add(() -> {
                CosmeticThumbCard.thumb(cosmeticItem.id);
                return true;
            });
        }
    }

    private static boolean hzo(FontFace vdn2, float f) {
        FontFace.setRenderScale(f);
        try {
            vdn2.width("Aa Яя 0");
        }
        finally {
            FontFace.setRenderScale(1.0f);
        }
        return true;
    }

    private static void hzp(Class<?> clazz) {
        try {
            Class.forName(clazz.getName(), true, clazz.getClassLoader());
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static /* synthetic */ int aef(int n, int n2) {
        return n - n2 ^ 0x3123A5F4;
    }

    private static /* synthetic */ int aeg(int n, int n2) {
        return n + n2 + 422155920;
    }
}

