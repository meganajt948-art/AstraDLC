/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.AbstractClientPlayerEntity
 *  net.minecraft.client.network.ClientPlayNetworkHandler
 *  net.minecraft.client.network.PlayerListEntry
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.player.SkinTextures
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.Vec3d
 */
package a;

import a.ewk;
import a.hgz;
import a.hhc;
import a.izx;
import a.vhz;
import a.vkl;
import a.vmc;
import a.vmo;
import a.wap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.SkinTextures;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;

public final class hhf {
    public static final vkl PROTECT = new vkl(a.d("\u0325\u7ab6\uf078\u6e12\ue5d4\u6363\ud927\u5082\uce9b\u443e\uc3f6\u398b\ub757\u2eec\ua4a8", 1895487715, -1268130919), true);
    public static final List<vmo> OPTIONS = List.of(PROTECT);
    public static final vkl CLICK = new vkl(a.b("\ued12\u948c\u1e5a\u8021\u0bfe\u8d04\u3711\ubef4\u20b0\uaa0d\u2dd5\ud7ae", 316468573), true);
    public static final vmc CLICK_RANGE = new vmc(a.d("\u0d1e\u7480\ufe56\u602d\uebf2\u6d08\ud709\u5eeb\uc0bb\u4a03\ucdd2", 1756299799, 7343937), 8.0, 3.0, 160.0, 1.0).suffix(a.d("\u1a9c\u6323\ue9f3\u778e\ufc51\u7af8", 1401237017, 409548001));
    public static final List<vmo> CLICK_OPTIONS = List.of(CLICK_RANGE);
    public static final List<vmo> ALL = List.of(PROTECT, CLICK, CLICK_RANGE);
    public static final int MAX_NAME = 20;
    private static final double hhg = 0.3;
    private static final Gson hhh = new GsonBuilder().setPrettyPrinting().create();
    private static final List<hhc> hhi = new ArrayList<hhc>();
    private static final Set<String> hhj = new HashSet<String>();
    private static boolean hhk;
    private static int hhl;
    private static /* synthetic */ int hhm;
    private static /* synthetic */ long hhn;

    private hhf() {
    }

    public static int version() {
        return hhl;
    }

    public static List<hhc> all() {
        hhf.hhq();
        return Collections.unmodifiableList(hhi);
    }

    public static boolean isFriend(String string) {
        hhf.hhq();
        return string != null && hhj.contains(hhf.hho(string));
    }

    public static boolean isFriend(Entity entity) {
        PlayerEntity playerEntity;
        return entity instanceof PlayerEntity && hhf.isFriend(hhf.nameOf(playerEntity = (PlayerEntity)entity));
    }

    public static boolean protects(Entity entity) {
        return PROTECT.get() && hhf.isFriend(entity);
    }

    public static boolean add(String string) {
        hhf.hhq();
        String string2 = hhf.clean(string);
        if (string2 == null || hhj.contains(hhf.hho(string2))) {
            return false;
        }
        hhi.add(new hhc(string2));
        hhj.add(hhf.hho(string2));
        hhf.hhp();
        return true;
    }

    public static boolean remove(String string) {
        hhf.hhq();
        if (string == null || !hhj.remove(hhf.hho(string))) {
            return false;
        }
        hhi.removeIf(hhc2 -> hhf.hho(hhc2.name).equals(hhf.hho(string)));
        hhf.hhp();
        return true;
    }

    public static boolean toggle(String string) {
        if (hhf.isFriend(string)) {
            hhf.remove(string);
            return false;
        }
        return hhf.add(string);
    }

    public static String nameOf(PlayerEntity playerEntity) {
        return playerEntity.getName().getString();
    }

    public static String clean(String string) {
        if (string == null) {
            return null;
        }
        String string2 = string.trim();
        if (string2.isEmpty() || string2.length() > 20 || string2.chars().anyMatch(n -> n <= 32 || n == 167)) {
            return null;
        }
        return string2;
    }

    private static String hho(String string) {
        return string.toLowerCase(Locale.ROOT);
    }

    public static PlayerEntity aimed(MinecraftClient minecraftClient, double d) {
        PlayerEntity playerEntity;
        Entity entity = minecraftClient.getCameraEntity();
        if (entity == null || minecraftClient.world == null || minecraftClient.player == null) {
            return null;
        }
        Entity entity2 = minecraftClient.targetedEntity;
        if (entity2 instanceof PlayerEntity && (playerEntity = (PlayerEntity)entity2) != minecraftClient.player) {
            return playerEntity;
        }
        playerEntity = entity.getCameraPosVec(1.0f);
        entity2 = entity.getRotationVec(1.0f);
        double d2 = d;
        HitResult hitResult = entity.raycast(d, 1.0f, false);
        if (hitResult != null && hitResult.getType() != HitResult.Type.MISS) {
            d2 = hitResult.getPos().distanceTo((Vec3d)playerEntity);
        }
        Vec3d vec3d = playerEntity.add(entity2.multiply(d2));
        PlayerEntity playerEntity2 = null;
        double d3 = Double.MAX_VALUE;
        for (PlayerEntity playerEntity3 : minecraftClient.world.getPlayers()) {
            double d4;
            Optional optional;
            if (playerEntity3 == minecraftClient.player || playerEntity3 == entity || playerEntity3.isSpectator() || !playerEntity3.isAlive() || !(optional = playerEntity3.getBoundingBox().expand(0.3).raycast((Vec3d)playerEntity, vec3d)).isPresent() || !((d4 = ((Vec3d)optional.get()).squaredDistanceTo((Vec3d)playerEntity)) < d3)) continue;
            d3 = d4;
            playerEntity2 = playerEntity3;
        }
        return playerEntity2;
    }

    public static void toggleAimed() {
        String string;
        if (!CLICK.get()) {
            return;
        }
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        PlayerEntity playerEntity = hhf.aimed(minecraftClient, CLICK_RANGE.get());
        if (playerEntity == null) {
            return;
        }
        boolean bl = hhf.toggle(string = hhf.nameOf(playerEntity));
        izx.alert(string, bl ? wap.s(a.b("\u5ba3\u2226\ua8ee\u3693\ubd4f\u3bf4", -983737373), a.b("\ud66d\uaf88\u2558\ubb59", -1335307651)) : wap.s(a.b("\u0296\u7b10\uf1cb\u6fb8\ue476\u62d4\ud886", 1320420035), a.c(1252930131, "\u3676\u4fd0\uc507\u5b7d\ud0c0\u561d")), vhz.FRIENDS, bl);
    }

    public static SkinTextures skinOf(String string) {
        Object object;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.world != null) {
            object = minecraftClient.world.getPlayers().iterator();
            while (object.hasNext()) {
                PlayerEntity playerEntity = (PlayerEntity)object.next();
                if (!hhf.nameOf(playerEntity).equalsIgnoreCase(string) || !(playerEntity instanceof AbstractClientPlayerEntity)) continue;
                AbstractClientPlayerEntity abstractClientPlayerEntity = (AbstractClientPlayerEntity)playerEntity;
                return abstractClientPlayerEntity.getSkin();
            }
        }
        return (object = hhf.listEntry(string)) != null ? object.getSkinTextures() : null;
    }

    public static PlayerListEntry listEntry(String string) {
        ClientPlayNetworkHandler clientPlayNetworkHandler = MinecraftClient.getInstance().getNetworkHandler();
        if (clientPlayNetworkHandler == null || string == null) {
            return null;
        }
        try {
            return clientPlayNetworkHandler.getCaseInsensitivePlayerInfo(string);
        }
        catch (RuntimeException runtimeException) {
            return null;
        }
    }

    public static PlayerEntity inWorld(String string) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.world == null) {
            return null;
        }
        for (PlayerEntity playerEntity : minecraftClient.world.getPlayers()) {
            if (!hhf.nameOf(playerEntity).equalsIgnoreCase(string)) continue;
            return playerEntity;
        }
        return null;
    }

    private static void hhp() {
        ++hhl;
        hhf.hhr();
    }

    private static void hhq() {
        if (hhk) {
            return;
        }
        hhk = true;
        String string = ewk.get(a.b("g\u79c2\uf30a\u6d77\ue6ab\u6010\uda54", 705691654));
        if (string == null || string.isBlank()) {
            return;
        }
        try {
            List list = (List)hhh.fromJson(string, new hgz().getType());
            if (list != null) {
                for (hhc hhc2 : list) {
                    String string2 = hhc2 != null ? hhf.clean(hhc2.name) : null;
                    if (string2 == null || !hhj.add(hhf.hho(string2))) continue;
                    hhc2.name = string2;
                    hhi.add(hhc2);
                }
            }
        }
        catch (Exception exception) {
            System.out.println(a.c(272987972, "\u7733\u0e80\u845c\u1a64\u91e0\u1705\uad04\u24e2\ubab9\u300d\ub79a\u4dad\uc36e\u5ac4\ud09b\u5661\uec24\u63e2\uf918\u7f53") + exception);
        }
    }

    private static void hhr() {
        ewk.put(a.d("\u5609\u2fac\ua564\u3b19\ub0c5\u367e\u8c3a", -1945592374, -1723479134), hhh.toJson(hhi));
    }

    private static /* synthetic */ int aaj(int n, int n2) {
        return n ^ n2 | 0xA5220EB6;
    }

    private static /* synthetic */ int aak(int n, int n2) {
        return hhf.aaj(n, n2) * n2;
    }

    private static /* synthetic */ int aal(int n, int n2) {
        return n * n2 ^ 0xCFFB2A11;
    }
}

