package dev.dj.cortim.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NoFriendDamage extends Module {

    private final BoolSetting protectAll = add(new BoolSetting("Все игроки", "Бить нельзя вообще всех игроков", false));

    private static final Path FILE = FabricLoader.getInstance().getConfigDir().resolve("cortim_friends.json");
    private static final Set<String> FRIENDS = new HashSet<>();

    public NoFriendDamage() { super("NoFriendDamage", Category.COMBAT); load(); }

    public static void load() {
        try {
            if (!Files.exists(FILE)) return;
            String json = Files.readString(FILE);
            List<String> list = new Gson().fromJson(json, new TypeToken<List<String>>(){}.getType());
            if (list != null) {
                FRIENDS.clear();
                FRIENDS.addAll(list);
            }
        } catch (Throwable ignored) {}
    }

    public static void save() {
        try {
            Files.createDirectories(FILE.getParent());
            Files.writeString(FILE, new GsonBuilder().setPrettyPrinting().create().toJson(FRIENDS));
        } catch (IOException ignored) {}
    }

    public static void addFriend(String name) { FRIENDS.add(name); save(); }
    public static void removeFriend(String name) { FRIENDS.remove(name); save(); }
    public static boolean isFriend(String name) { return FRIENDS.contains(name); }

    @Override
    public void onTick() {}

    public static boolean isProtected(Entity target) {
        MinecraftClient client = MinecraftClient.getInstance();
        NoFriendDamage inst = (NoFriendDamage) ModuleRegistry.byName("NoFriendDamage");
        if (inst == null || !inst.isEnabled()) return false;

        if (inst.protectAll.get()) {
            return target instanceof PlayerEntity && target != client.player;
        }

        if (target instanceof PlayerEntity p) {
            String name = p.getName().getString();
            return FRIENDS.contains(name);
        }
        return false;
    }
}