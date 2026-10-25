/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.RenderPipelines
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.hud.InGameHud
 *  net.minecraft.entity.effect.StatusEffect
 *  net.minecraft.entity.effect.StatusEffectCategory
 *  net.minecraft.entity.effect.StatusEffectInstance
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.registry.entry.RegistryEntry
 */
package a;

import a.iov;
import a.izx;
import a.jeq;
import a.jht;
import a.ujt;
import a.uut;
import a.vhz;
import a.vkl;
import a.vlv;
import a.vmo;
import a.vxu;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;

public final class jie
extends jeq<jht> {
    public static final vkl HIDE_VANILLA = new vkl(a.b("\ubd50\uc4c0\u4e1e\ud06e\u5bfc\udd1b\u675f\ueea1\u70f9\ufa4d\u7d9e\u87e2\u0974\u908c\u1ad5\u9c28\u2666\ua9aa", -604521206), true);
    public static final vkl BARS = new vkl(a.b("\u110c\u6880\ue257\u7c2e\uf7bc\u714f\ucb1f\u42fd\udca3", -1391849135), true);
    public static final vlv COLORS = new vlv(a.b("\ua45b\uddc9\u5709\uc92a\u42be\uc403\u7e53\uf7a1\u69e4\ue352", -786389997), a.d("\u7837\u01a4\u8b77\u1500\u9edc\u1877", -416103728, -554845536), a.b("\uf54a\u8cd9\u060a\u987d\u13a1\u950a", 550106381), a.b("\u4599\u3c0b\ub6d8\u28aa\ua37b\u25dd", -1880013350));
    private static final float jif = 15.0f;
    private static final float jig = 10.0f;
    private final Map<String, Integer> jih = new HashMap<String, Integer>();
    private static /* synthetic */ boolean jii;
    private static /* synthetic */ long jij;

    jie() {
        super(a.b("\uff8f\u8621\u0ce9\u9285\u1954\u9fe4\u25aa", -783024136), a.c(-1335372626, "\ud4f9\uad77\u27bf\ub9d3\u3202\ub4b2\u0efc"), vhz.POTION, true, 2, 0, 6.0f, 6.0f);
    }

    @Override
    public List<vmo> settings() {
        return List.of(HIDE_VANILLA, BARS, COLORS);
    }

    public static boolean hidesVanilla() {
        return izx.ENABLED.get() && izx.POTIONS.enabled.get() && HIDE_VANILLA.get();
    }

    @Override
    List<jht> items(boolean bl) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        ArrayList<jht> arrayList = new ArrayList<jht>();
        HashSet<String> hashSet = new HashSet<String>();
        if (minecraftClient.player != null) {
            for (StatusEffectInstance statusEffectInstance : minecraftClient.player.getStatusEffects()) {
                if (!statusEffectInstance.shouldShowIcon()) continue;
                String string = statusEffectInstance.getEffectType().getIdAsString();
                hashSet.add(string);
                int n = statusEffectInstance.getDuration();
                int n2 = Math.max(n, this.jih.getOrDefault(string, 0));
                this.jih.put(string, n2);
                arrayList.add(jie.jik(string, (RegistryEntry<StatusEffect>)statusEffectInstance.getEffectType(), statusEffectInstance.getAmplifier(), n, statusEffectInstance.isInfinite(), statusEffectInstance.isInfinite() ? 1.0f : (float)n / (float)Math.max(1, n2)));
            }
        }
        this.jih.keySet().retainAll(hashSet);
        if (arrayList.isEmpty() && bl) {
            arrayList.add(jie.jik(a.d("\ud1ec\ua85f\u229b\ubcf9\u3731\ub18c\u0bcd\u8271\u1c67\u96d5\u1113\ueb62\u65b4", -1872825723, 1786848020), (RegistryEntry<StatusEffect>)StatusEffects.SPEED, 1, 1640, false, 0.72f));
            arrayList.add(jie.jik(a.b("\u8970\uf0c3\u7a07\ue465\u6fad\ue910\u5351\udaed\u44fb\uce4d\u4998\ub3fe\u3d22\ua49a\u2eda\ua837", -592672496), (RegistryEntry<StatusEffect>)StatusEffects.STRENGTH, 0, 780, false, 0.35f));
            arrayList.add(jie.jik(a.c(-60203935, "\u5c1d\u25ae\uaf6a\u3108\ubac0\u3c7d\u863c\u0f80\u9183\u1b3d\u9cf5\u6693"), (RegistryEntry<StatusEffect>)StatusEffects.FIRE_RESISTANCE, 0, 150, false, 0.08f));
        }
        arrayList.sort(Comparator.comparing(jht2 -> !jht2.jhy).thenComparing(jht2 -> -jht2.jhx));
        return arrayList;
    }

    private static jht jik(String string, RegistryEntry<StatusEffect> registryEntry, int n, int n2, boolean bl, float f) {
        StatusEffect statusEffect = (StatusEffect)registryEntry.value();
        String string2 = statusEffect.getName().getString();
        if (n > 0) {
            string2 = string2 + a.b("\uc78f", -1793538130) + jie.jil(n + 1);
        }
        return new jht(string, registryEntry, string2, n2, bl, f, 0xFF000000 | statusEffect.getColor(), statusEffect.getCategory() == StatusEffectCategory.HARMFUL);
    }

    private static String jil(int n) {
        String[] stringArray = new String[]{a.d("\ub7ac", 281513375, 1300314747), a.b("\ufd87\u8436", -2023293492), a.d("\u5298\u2b29\ua1fa", -1097380966, 1829640520), a.d("\u28fd\u5153", -1882600902, -579345780), a.c(-593828193, "\ue6c8"), a.c(-1122112025, "\uedb3\u941d"), a.d("\u2f12\u56bc\udc6f", -83604543, -543136634), a.b("\u56de\u2f70\ua5a3\u3bd2", -984787316), a.c(583954004, "\u6e1f\u17bf"), a.d("\u805b", -1924490571, 122952375)};
        return n >= 1 && n <= stringArray.length ? stringArray[n - 1] : String.valueOf(n);
    }

    static String time(int n, boolean bl) {
        if (bl) {
            return a.c(-2142459201, "\u88a0");
        }
        return vxu.clock(Math.max(0, n / 20));
    }

    @Override
    String key(jht jht2) {
        return jht2.jhu;
    }

    @Override
    float rowHeight() {
        return 15.0f;
    }

    @Override
    float rowWidth(jht jht2) {
        return 14.0f + izx.TEXT.width(jht2.jhw) + 12.0f + izx.VALUE.width(jie.time(jht2.jhx, jht2.jhy));
    }

    @Override
    void drawRow(DrawContext drawContext, jht jht2, float f, float f2, float f3, float f4, float f5, float f6) {
        boolean bl = BARS.get();
        float f7 = f2 + (bl ? 6.0f : f4 * 0.5f);
        int n = ujt.withAlpha(0xFFFFFF, Math.round(255.0f * uut.alpha()));
        drawContext.getMatrices().pushMatrix();
        drawContext.getMatrices().translate(f, f7 - 5.0f);
        drawContext.getMatrices().scale(0.5555556f, 0.5555556f);
        drawContext.drawGuiTexture(RenderPipelines.GUI_TEXTURED, InGameHud.getEffectTexture(jht2.jhv), 0, 0, 18, 18, n);
        drawContext.getMatrices().popMatrix();
        float f8 = f + 10.0f + 4.0f;
        String string = jie.time(jht2.jhx, jht2.jhy);
        float f9 = izx.VALUE.width(string);
        izx.TEXT.draw(drawContext, izx.TEXT.ellipsize(jht2.jhw, f3 - (f8 - f) - f9 - 8.0f), f8, izx.TEXT.centerTop(f7), jht2.jib ? ujt.lerp(iov.text, -1096636, 0.35f) : iov.text);
        float f10 = jht2.jhy ? -1.0f : (float)jht2.jhx / 20.0f;
        izx.VALUE.drawRight(drawContext, string, f + f3, izx.VALUE.centerTop(f7), jie.expiring(iov.textDim, f10));
        if (bl) {
            int n2;
            int n3;
            if (COLORS.is(a.b("\u43e5\u3a77\ub0a4\u2ed6\ua507\u23a1", -297909338))) {
                n3 = jht2.jia;
                n2 = ujt.lerp(jht2.jia, -1, 0.3f);
            } else if (jht2.jib) {
                n3 = -1096636;
                n2 = -429290;
            } else {
                n3 = iov.accent();
                n2 = iov.accent2();
            }
            jie.bar(drawContext, f8, f2 + f4 - 3.6f, f3 - (f8 - f), jht2.jhy ? 1.0f : jht2.jhz, n3, n2);
        }
    }

    private static /* synthetic */ int ans(int n, int n2) {
        return n * n2 ^ 0x26637ECB;
    }

    private static /* synthetic */ int ant(int n, int n2) {
        return jie.ans(n, n2) ^ 0x27C07B03;
    }

    private static /* synthetic */ int anu(int n, int n2) {
        return jie.ant(n, n2) + n;
    }
}

