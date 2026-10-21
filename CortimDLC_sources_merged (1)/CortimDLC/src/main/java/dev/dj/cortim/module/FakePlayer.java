package dev.dj.cortim.module;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.entity.Entity;

import java.util.UUID;

public class FakePlayer extends Module {

    private static final UUID NPC_UUID = UUID.nameUUIDFromBytes("cortim_npc".getBytes());

    public final BoolSetting solid = add(new BoolSetting(
            "Твёрдый",
            "Есть коллизия — можно удариться",
            false
    ));

    public final BoolSetting copyYaw = add(new BoolSetting(
            "Копировать поворот",
            "Поворот NPC совпадает с твоим при спавне",
            true
    ));

    private OtherClientPlayerEntity npc = null;

    public FakePlayer() {
        super("FakePlayer", Category.VISUAL);
    }

    public OtherClientPlayerEntity getEntity() {
        return npc;
    }

    @Override
    public void onTick() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc == null || mc.world == null || mc.player == null) {
            despawn(mc);
            return;
        }

        if (!isEnabled()) {
            despawn(mc);
            return;
        }

        if (npc == null || npc.isRemoved() || npc.getEntityWorld() != mc.world) {
            spawn(mc);
        }

        if (npc != null) {
            npc.setHealth(npc.getMaxHealth());
            npc.deathTime = 0;
            npc.hurtTime = 0;
            npc.noClip = !solid.get();
        }
    }

    private void spawn(MinecraftClient mc) {
        try {
            GameProfile profile = new GameProfile(NPC_UUID, "NPC");
            PlayerListEntry entry = new PlayerListEntry(profile, false);

            OtherClientPlayerEntity entity = new OtherClientPlayerEntity(mc.world, profile);

            entity.setPosition(mc.player.getX(), mc.player.getY(), mc.player.getZ());
            if (copyYaw.get()) {
                entity.setYaw(mc.player.getYaw());
                entity.setPitch(mc.player.getPitch());
                entity.setHeadYaw(mc.player.getHeadYaw());
            }
            entity.setHealth(entity.getMaxHealth());
            entity.noClip = !solid.get();

            mc.world.addEntity(entity);
            npc = entity;
        } catch (Throwable t) {
            dev.dj.cortim.Cortim.LOG.warn("FakePlayer spawn failed", t);
            npc = null;
        }
    }

    private void despawn(MinecraftClient mc) {
        if (npc == null) return;
        if (mc != null && mc.world != null) {
            mc.world.removeEntity(npc.getId(), Entity.RemovalReason.DISCARDED);
        }
        npc = null;
    }

    @Override
    public void setEnabled(boolean v) {
        super.setEnabled(v);
        if (!v) despawn(MinecraftClient.getInstance());
    }
}