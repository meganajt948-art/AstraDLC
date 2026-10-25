/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.option.AttackIndicator
 *  net.minecraft.client.render.entity.state.EntityRenderState
 *  net.minecraft.client.render.fog.BlindnessEffectFogModifier
 *  net.minecraft.client.render.fog.DarknessEffectFogModifier
 *  net.minecraft.client.render.fog.FogModifier
 *  net.minecraft.client.render.fog.FogRenderer
 *  net.minecraft.client.render.fog.LavaFogModifier
 *  net.minecraft.client.render.state.WorldRenderState
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.data.TrackedData
 *  net.minecraft.item.Items
 *  net.minecraft.particle.ParticleEffect
 */
package a;

import a.kfa;
import a.kfe;
import a.rkc;
import a.vkl;
import a.vxr;
import a.wbu;
import java.lang.reflect.Field;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.AttackIndicator;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.fog.BlindnessEffectFogModifier;
import net.minecraft.client.render.fog.DarknessEffectFogModifier;
import net.minecraft.client.render.fog.FogModifier;
import net.minecraft.client.render.fog.FogRenderer;
import net.minecraft.client.render.fog.LavaFogModifier;
import net.minecraft.client.render.state.WorldRenderState;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleEffect;

public class rkh
extends kfe {
    private static rkh rki;
    public final vkl fire = this.add(new vkl("Fire", true));
    public final vkl lava = this.add(new vkl("Lava", true));
    public final vkl scoreboard = this.add(new vkl("Scoreboard", false));
    public final vkl hurtShake = this.add(new vkl("Hurt shake", true));
    public final vkl walkShake = this.add(new vkl("View bobbing", false));
    public final vkl darkness = this.add(new vkl("Darkness", true));
    public final vkl blindness = this.add(new vkl("Blindness", false));
    public final vkl nausea = this.add(new vkl("Nausea", true));
    public final vkl attackIndicator = this.add(new vkl("Attack indicator", false));
    public final vkl effects = this.add(new vkl("Effects", false));
    public final vkl bossBar = this.add(new vkl("Boss bar", false));
    public final vkl bubbles = this.add(new vkl("Bubbles", false));
    public final vkl glowing = this.add(new vkl("Glowing", false));
    public final vkl rain = this.add(new vkl("Rain", false));
    public final vkl vignette = this.add(new vkl("Vignette", true));
    public final vkl pumpkin = this.add(new vkl("Pumpkin", true));
    private static final wbu<Double> rkj;
    private static final wbu<Boolean> rkk;
    private static final wbu<AttackIndicator> rkl;
    private static final wbu<Double> rkm;
    private static boolean rkn;
    private static TrackedData<List<ParticleEffect>> rko;
    private static boolean rkp;
    private static /* synthetic */ boolean rkq;
    private static /* synthetic */ int rkr;

    public rkh() {
        super(new String(new char[]{'N', 'o', 'R', 'e', 'n', 'd', 'e', 'r'}), "Hides effects and HUD parts you pick", kfa.RENDER);
        rki = this;
    }

    private static boolean rks(vkl vkl2) {
        return rki != null && rki.isEnabled() && vkl2.get();
    }

    public static boolean hidesScoreboard() {
        return rki != null && rkh.rks(rkh.rki.scoreboard);
    }

    public static boolean hidesBossBar() {
        return rki != null && rkh.rks(rkh.rki.bossBar);
    }

    public static boolean hidesAir() {
        return rki != null && rkh.rks(rkh.rki.bubbles);
    }

    public static boolean hidesEffectIcons() {
        return rki != null && rkh.rks(rkh.rki.effects);
    }

    public static boolean hidesPumpkin(MinecraftClient minecraftClient) {
        return rki != null && rkh.rks(rkh.rki.pumpkin) && minecraftClient.field_1724 != null && minecraftClient.field_1690.method_31044().method_31034() && minecraftClient.field_1724.method_6118(EquipmentSlot.field_6169).method_31574(Items.field_17519);
    }

    @Override
    protected void onEnable() {
        rkh.rkx();
    }

    @Override
    protected void onDisable() {
        rkj.release();
        rkk.release();
        rkl.release();
        rkm.release();
    }

    @Override
    public void onStartTick(MinecraftClient minecraftClient) {
        if (this.effects.get()) {
            rkh.rkw(minecraftClient.field_1687);
        }
        this.rkt(minecraftClient);
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        this.rkt(minecraftClient);
    }

    @Override
    public void onWorldRender(MinecraftClient minecraftClient) {
        if (this.fire.get()) {
            rkh.rkv(minecraftClient);
        }
    }

    private void rkt(MinecraftClient minecraftClient) {
        rkh.rkx();
        boolean bl = wbu.suspended(minecraftClient);
        rkh.rku(rkj, this.hurtShake.get() && !bl, 0.0);
        rkh.rku(rkk, this.walkShake.get() && !bl, false);
        rkh.rku(rkl, this.attackIndicator.get() && !bl, AttackIndicator.field_18151);
        rkh.rku(rkm, this.darkness.get() && !bl, 0.0);
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (clientPlayerEntity == null) {
            return;
        }
        if (this.fire.get()) {
            rkh.rkv(minecraftClient);
        }
        if (this.nausea.get()) {
            clientPlayerEntity.field_44911 = 0.0f;
            clientPlayerEntity.field_44912 = 0.0f;
        }
        if (this.rain.get() && minecraftClient.field_1687 != null) {
            minecraftClient.field_1687.method_8519(0.0f);
            minecraftClient.field_1687.method_8496(0.0f);
        }
        if (this.vignette.get()) {
            minecraftClient.field_1705.field_2013 = 0.0f;
        }
    }

    private static <T> void rku(wbu<T> wbu2, boolean bl, T t) {
        if (bl) {
            wbu2.override(t);
        } else {
            wbu2.release();
        }
    }

    private static void rkv(MinecraftClient minecraftClient) {
        if (minecraftClient.field_1724 != null && minecraftClient.field_1724.method_5809()) {
            minecraftClient.field_1724.method_33572(false);
        }
    }

    private static void rkw(ClientWorld clientWorld) {
        if (clientWorld == null) {
            return;
        }
        if (!rkp) {
            rkp = true;
            Field field = vxr.find(LivingEntity.class, "net.minecraft.class_1309", "field_49792", "Lnet/minecraft/class_2940;");
            try {
                rko = field == null ? null : (TrackedData)field.get(null);
            }
            catch (ReflectiveOperationException | RuntimeException exception) {
                rko = null;
            }
        }
        if (rko == null) {
            return;
        }
        for (Entity entity : clientWorld.method_18112()) {
            LivingEntity livingEntity;
            if (!(entity instanceof LivingEntity) || ((List)(livingEntity = (LivingEntity)entity).method_5841().method_12789(rko)).isEmpty()) continue;
            livingEntity.method_5841().method_12778(rko, List.of());
        }
    }

    public static void afterExtraction(WorldRenderState worldRenderState) {
        if (rki == null || !rkh.rks(rkh.rki.glowing)) {
            return;
        }
        for (EntityRenderState entityRenderState : worldRenderState.field_61735) {
            entityRenderState.field_61821 = 0;
        }
    }

    private static void rkx() {
        if (rkn) {
            return;
        }
        rkn = true;
        try {
            Field field = vxr.find(FogRenderer.class, "net.minecraft.class_758", "field_60586", "Ljava/util/List;");
            if (field == null) {
                return;
            }
            List list = (List)field.get(null);
            for (int i = 0; i < list.size(); ++i) {
                FogModifier fogModifier = (FogModifier)list.get(i);
                if (fogModifier instanceof LavaFogModifier) {
                    list.set(i, new rkc(fogModifier, () -> rki != null && rkh.rks(rkh.rki.lava)));
                    continue;
                }
                if (fogModifier instanceof BlindnessEffectFogModifier) {
                    list.set(i, new rkc(fogModifier, () -> rki != null && rkh.rks(rkh.rki.blindness)));
                    continue;
                }
                if (!(fogModifier instanceof DarknessEffectFogModifier)) continue;
                list.set(i, new rkc(fogModifier, () -> rki != null && rkh.rks(rkh.rki.darkness)));
            }
        }
        catch (Throwable throwable) {
            System.out.println("fog rules can't be changed: " + throwable);
        }
    }

    static {
        rkj = new wbu(minecraftClient -> minecraftClient.field_1690.method_48974());
        rkk = new wbu(minecraftClient -> minecraftClient.field_1690.method_42448());
        rkl = new wbu(minecraftClient -> minecraftClient.field_1690.method_42565());
        rkm = new wbu(minecraftClient -> minecraftClient.field_1690.method_42472());
    }

    private static /* synthetic */ int bzl(int n, int n2) {
        return n ^ n2 | 0x420899D6;
    }
}

