/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 */
package a;

import a.kfa;
import a.kfe;
import a.vkl;
import a.vlv;
import a.vmc;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

public class rjy
extends kfe {
    private static rjy rjz;
    public final vlv background = this.add(new vlv("Background", "Solid", "Glass", "Liquid", "Solid", "None"));
    public final vmc blur = this.add(new vmc("Blur", 2.0, 0.0, 6.0, 1.0));
    public final vmc opacity = this.add(new vmc("Opacity", 0.45, 0.0, 1.0, 0.05).percent());
    public final vlv tint = this.add(new vlv("Tint", "Theme", "Theme", "Dark", "Accent"));
    public final vmc rounding = this.add(new vmc("Rounding", 0.55, 0.0, 1.0, 0.05).percent());
    public final vmc size = this.add(new vmc("Size", 1.0, 0.5, 2.0, 0.05).percent());
    public final vmc shrink = this.add(new vmc("Shrink", 0.7, 0.0, 1.0, 0.05).percent());
    public final vlv health = this.add(new vlv("Health", "Text", "Text", "Bar", "Both", "Off"));
    public final vlv items = this.add(new vlv("Items", "Inline", "Inline", "Above", "Off"));
    public final vkl distance = this.add(new vkl("Distance", false));
    public final vkl ping = this.add(new vkl("Ping", false));
    public final vkl friends = this.add(new vkl("Friends", true));
    public final vkl self = this.add(new vkl("Self", false));
    public final vmc range = this.add(new vmc("Range", 128.0, 16.0, 512.0, 8.0).suffix("m"));
    public final vkl mobs = this.add(new vkl("Mobs", false));
    public final vmc mobRange = this.add(new vmc("Mob range", 48.0, 8.0, 256.0, 8.0).suffix("m"));
    private static /* synthetic */ boolean rka;
    private static /* synthetic */ boolean rkb;

    public rjy() {
        super(new String(new char[]{'N', 'a', 'm', 'e', 't', 'a', 'g', 's'}), "Tags above players and mobs: name, health, armour", kfa.RENDER);
        rjz = this;
        this.mobRange.visibleWhen(this.mobs::get);
        this.blur.activeWhen(this::glass);
        this.opacity.activeWhen(() -> !this.background.is("None"));
        this.tint.activeWhen(() -> !this.background.is("None"));
    }

    public static rjy get() {
        return rjz;
    }

    public boolean glass() {
        return this.background.is("Glass") || this.background.is("Liquid");
    }

    public boolean showsHealthText() {
        return this.health.is("Text") || this.health.is("Both");
    }

    public boolean showsHealthBar() {
        return this.health.is("Bar") || this.health.is("Both");
    }

    public boolean shows(MinecraftClient minecraftClient, PlayerEntity playerEntity) {
        if (!this.isEnabled() || minecraftClient.field_1724 == null || playerEntity.method_7325() || !playerEntity.method_5805() || playerEntity.method_31481()) {
            return false;
        }
        if (playerEntity == minecraftClient.field_1724 && (!this.self.get() || minecraftClient.field_1690.method_31044().method_31034())) {
            return false;
        }
        if (playerEntity == minecraftClient.method_1560() && playerEntity != minecraftClient.field_1724) {
            return false;
        }
        double d = this.range.get();
        return minecraftClient.field_1773.method_19418().method_71156().method_1025(playerEntity.method_73189()) <= d * d;
    }

    public boolean showsMob(MinecraftClient minecraftClient, LivingEntity livingEntity) {
        if (!this.isEnabled() || !this.mobs.get() || minecraftClient.field_1724 == null || !livingEntity.method_5805() || livingEntity.method_31481() || livingEntity == minecraftClient.method_1560()) {
            return false;
        }
        double d = this.mobRange.get();
        return minecraftClient.field_1773.method_19418().method_71156().method_1025(livingEntity.method_73189()) <= d * d;
    }

    private static /* synthetic */ int bzf(int n, int n2) {
        return n * n2 + 1397167129;
    }
}

