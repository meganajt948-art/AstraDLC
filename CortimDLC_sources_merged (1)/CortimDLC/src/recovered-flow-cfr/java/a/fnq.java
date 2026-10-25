/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.attribute.EntityAttributes
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.network.ClientConnection
 *  net.minecraft.network.packet.c2s.common.SyncedClientOptions
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.network.ConnectedClientData
 *  net.minecraft.server.network.ServerPlayerEntity
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.util.Hand
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.GameMode
 */
package a;

import a.fux;
import com.mojang.authlib.GameProfile;
import flow.dev.a;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.UUID;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.c2s.common.SyncedClientOptions;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ConnectedClientData;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameMode;

final class fnq {
    static final String NAME = a.c(-1790195458, "\uc8bf\ub124\u3bf4\ua59d\u2e7f\ua8e3\u12ab");
    private static final double fnr = 3.0;
    private static final float fns = 30.0f;
    static volatile boolean active;
    static volatile double aggression;
    static volatile boolean jumping;
    static volatile boolean strafing;
    static volatile int hits;
    static volatile int critHits;
    static volatile int spawned;
    static volatile int orbit;
    static volatile double orbitMin;
    static volatile double orbitMax;
    static volatile double orbitRadiusSum;
    static volatile double orbitTurnSum;
    static volatile int orbitTicks;
    private static ServerPlayerEntity fnt;
    private static fux fnu;
    private static UUID fnv;
    private static boolean fnw;
    private static final Random fnx;
    private static int fny;
    private static float fnz;
    private static int foa;
    private static float fob;
    private static float foc;
    private static int fod;
    private static int foe;
    private static int fof;
    private static double fog;
    private static double foh;
    private static double foi;
    private static /* synthetic */ String foj;
    private static /* synthetic */ int fok;

    private fnq() {
    }

    static void spawn(MinecraftServer minecraftServer, UUID uUID, double d, double d2, double d3) {
        if (!fnw) {
            fnw = true;
            ServerTickEvents.END_SERVER_TICK.register(fnq::fol);
        }
        fnv = uUID;
        ServerWorld serverWorld = minecraftServer.method_30002();
        UUID uUID2 = UUID.nameUUIDFromBytes(a.c(-425270718, "\ue218\u9b80\u1153\u8f28\u04fa\u824c\u3814\ub1d0\u2fb3\ua50f\u22c4\ud8a9\u5669\ucf90\u45bf\uc364\u7928\uf6e1\u6c67\uea1b\u63f7").getBytes(StandardCharsets.UTF_8));
        GameProfile gameProfile = new GameProfile(uUID2, a.d("\u22ba\u5b21\ud1f1\u4f98\uc47a\u42e6\uf8ae", 825027198, -1867593595));
        ServerPlayerEntity serverPlayerEntity = new ServerPlayerEntity(minecraftServer, serverWorld, gameProfile, SyncedClientOptions.method_53821());
        serverPlayerEntity.method_5808(d, d2, d3, 90.0f, 0.0f);
        fnu = new fux();
        minecraftServer.method_3760().method_14570((ClientConnection)fnu, serverPlayerEntity, new ConnectedClientData(gameProfile, 0, serverPlayerEntity.method_53823(), false));
        serverPlayerEntity.method_7336(GameMode.field_9215);
        serverPlayerEntity.method_5996(EntityAttributes.field_23716).method_6192(1024.0);
        serverPlayerEntity.method_6033(1024.0f);
        serverPlayerEntity.method_31548().method_5447(0, new ItemStack((ItemConvertible)Items.field_8802));
        serverPlayerEntity.method_31548().method_61496(0);
        fnt = serverPlayerEntity;
        spawned = serverPlayerEntity.method_5628();
    }

    private static void fol(MinecraftServer minecraftServer) {
        ServerPlayerEntity serverPlayerEntity;
        if (fnt == null) {
            return;
        }
        fnu.drain();
        if (fnt.method_31481()) {
            fnt = null;
            return;
        }
        fnt.method_7344().method_7580(20);
        if (fnt.method_6032() < 600.0f) {
            fnt.method_6033(1024.0f);
        }
        ServerPlayerEntity serverPlayerEntity2 = serverPlayerEntity = fnv == null ? null : minecraftServer.method_3760().method_14602(fnv);
        if (serverPlayerEntity != null && active && orbit != 0) {
            fnq.fom(serverPlayerEntity);
        } else if (serverPlayerEntity != null && active) {
            fnq.fon(serverPlayerEntity);
        } else {
            fnq.fnt.field_6250 = 0.0f;
            fnq.fnt.field_6212 = 0.0f;
            fnt.method_6100(false);
            fnt.method_5728(false);
        }
        double d = fnt.method_23318();
        fnt.method_14226();
        double d2 = fnt.method_23318() - d;
        if (fnt.method_24828() || d2 > 0.0) {
            fnq.fnt.field_6017 = 0.0;
        } else if (d2 < 0.0) {
            fnq.fnt.field_6017 -= d2;
        }
    }

    private static void fom(ServerPlayerEntity serverPlayerEntity) {
        boolean bl;
        float f;
        if (--fof <= 0) {
            fof = 25 + fnx.nextInt(60);
            foe = fnx.nextBoolean() ? 1 : -1;
        }
        double d = serverPlayerEntity.method_23317() - fnt.method_23317();
        double d2 = serverPlayerEntity.method_23321() - fnt.method_23321();
        double d3 = Math.max(0.001, Math.hypot(d, d2));
        float f2 = (float)Math.toDegrees(Math.atan2(d2, d)) - 90.0f;
        double d4 = MathHelper.method_15350((double)((d3 - (orbitMin + orbitMax) * 0.5) / 0.3), (double)-1.0, (double)1.0);
        double d5 = Math.toDegrees(Math.atan2(-d2, -d));
        if (!Double.isNaN(fog)) {
            orbitTurnSum += Math.abs(MathHelper.method_15338((double)(d5 - fog)));
            orbitRadiusSum += d3;
            ++orbitTicks;
        }
        fog = d5;
        if (orbit == 1) {
            f = f2;
            fnq.fnt.field_6250 = (float)d4;
            fnq.fnt.field_6212 = foe;
            fnt.method_5728(false);
        } else {
            foi = Double.isNaN(foi) ? d3 : foi + (d3 - foi) * 0.02;
            double d6 = (orbitMin + orbitMax) * 0.5;
            foh = MathHelper.method_15350((double)(foh + (d6 - foi) * 0.01), (double)1.6, (double)d6);
            double d7 = MathHelper.method_15350((double)((d3 - foh) / 0.25), (double)-1.0, (double)1.0);
            f = f2 + (float)foe * (float)(90.0 - d7 * 60.0);
            fnq.fnt.field_6250 = 1.0f;
            fnq.fnt.field_6212 = 0.0f;
            fnt.method_5728(true);
        }
        Vec3d vec3d = fnt.method_33571();
        double d8 = serverPlayerEntity.method_23320() - vec3d.field_1351;
        fnt.method_36456(f);
        fnt.method_5847(orbit == 1 ? f : f2);
        fnt.method_5636(f);
        fnt.method_36457((float)(-Math.toDegrees(Math.atan2(d8, d3))));
        fnt.method_6100(jumping);
        if (aggression <= 0.0) {
            return;
        }
        if (fod > 0) {
            --fod;
        }
        double d9 = serverPlayerEntity.method_5829().method_49271(vec3d);
        boolean bl2 = fnq.fnt.field_6017 > 0.0 && !fnt.method_24828();
        boolean bl3 = bl = bl2 || fnx.nextDouble() < aggression * 0.08;
        if (d9 <= 9.0 && fnt.method_7261(0.5f) > 0.9f && fod == 0 && bl && fnx.nextDouble() < 0.2 + 0.8 * aggression) {
            boolean bl4 = fnt.method_5624();
            if (bl2) {
                fnt.method_5728(false);
            }
            boolean bl5 = bl2 && !fnt.method_5624();
            fnt.method_7324((Entity)serverPlayerEntity);
            fnt.method_6104(Hand.field_5808);
            ++hits;
            if (bl5) {
                ++critHits;
            }
            fnt.method_5728(bl4);
            fod = aggression < 0.5 ? 10 + fnx.nextInt(20) : 0;
        }
    }

    private static void fon(ServerPlayerEntity serverPlayerEntity) {
        boolean bl;
        float f;
        if (--foa <= 0) {
            foa = 5 + fnx.nextInt(12);
            fob = (float)fnx.nextGaussian() * 5.0f;
            foc = 0.7f + fnx.nextFloat() * 0.8f;
        }
        Vec3d vec3d = fnt.method_33571();
        Vec3d vec3d2 = serverPlayerEntity.method_73189().method_1031(0.0, (double)foc, 0.0);
        double d = vec3d2.field_1352 - vec3d.field_1352;
        double d2 = vec3d2.field_1351 - vec3d.field_1351;
        double d3 = vec3d2.field_1350 - vec3d.field_1350;
        double d4 = Math.sqrt(d * d + d3 * d3);
        float f2 = (float)(MathHelper.method_15349((double)d3, (double)d) * 57.2957763671875) - 90.0f + fob;
        float f3 = (float)(-(MathHelper.method_15349((double)d2, (double)d4) * 57.2957763671875));
        float f4 = fnt.method_36454() + MathHelper.method_15363((float)MathHelper.method_15393((float)(f2 - fnt.method_36454())), (float)-30.0f, (float)30.0f);
        float f5 = MathHelper.method_15363((float)(fnt.method_36455() + MathHelper.method_15363((float)(f3 - fnt.method_36455()), (float)-20.0f, (float)20.0f)), (float)-90.0f, (float)90.0f);
        fnt.method_36456(f4);
        fnt.method_5847(f4);
        fnt.method_5636(f4);
        fnt.method_36457(f5);
        if (--fny <= 0) {
            fny = 10 + fnx.nextInt(30);
            int n = fnx.nextInt(3);
            float f6 = n == 0 ? 0.0f : (fnz = n == 1 ? 1.0f : -1.0f);
        }
        fnq.fnt.field_6250 = f = d4 > 2.7 ? 1.0f : (d4 < 1.5 ? -0.7f : 0.3f);
        fnq.fnt.field_6212 = strafing ? fnz : 0.0f;
        fnt.method_6100(jumping);
        boolean bl2 = f > 0.5f && d4 > 2.2;
        double d5 = serverPlayerEntity.method_5829().method_49271(vec3d);
        float f7 = fnt.method_7261(0.5f);
        boolean bl3 = fnq.fnt.field_6017 > 0.0 && !fnt.method_24828();
        float f8 = Math.abs(MathHelper.method_15393((float)(f2 - fob - f4)));
        if (fod > 0) {
            --fod;
        }
        boolean bl4 = bl = bl3 || !jumping || fnx.nextDouble() < aggression * 0.08;
        if (d5 <= 9.0 && f7 > 0.9f && f8 < 30.0f && fod == 0 && bl && fnx.nextDouble() < 0.2 + 0.8 * aggression) {
            if (bl3) {
                bl2 = false;
            }
            fnt.method_5728(bl2);
            boolean bl5 = bl3 && !fnt.method_5624();
            fnt.method_7324((Entity)serverPlayerEntity);
            fnt.method_6104(Hand.field_5808);
            ++hits;
            if (bl5) {
                ++critHits;
            }
            fod = aggression < 0.5 ? 10 + fnx.nextInt(20) : 0;
        } else {
            fnt.method_5728(bl2);
        }
    }

    static {
        orbitMin = 2.6;
        orbitMax = 2.8;
        fnx = new Random(5L);
        foe = 1;
        fog = Double.NaN;
        foh = 2.5;
        foi = Double.NaN;
    }

    private static /* synthetic */ int qc(int n, int n2) {
        return (n ^ n2) + 402314077;
    }

    private static /* synthetic */ int qd(int n, int n2) {
        return n + n2 | 0x170499F2;
    }
}

