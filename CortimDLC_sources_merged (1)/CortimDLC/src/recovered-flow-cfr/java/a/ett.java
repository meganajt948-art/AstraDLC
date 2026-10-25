/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockState
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.render.Camera
 *  net.minecraft.client.render.GameRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.attribute.EntityAttributes
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package a;

import a.dry;
import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import sun.misc.Unsafe;

public final class ett
extends Camera {
    private static Unsafe etu;
    private static long etv;
    private static Camera etw;
    private static boolean etx;
    private static boolean ety;
    private static float etz;
    private boolean eua;
    private static float eub;
    private static float euc;
    private static boolean eud;
    private static long eue;
    private static boolean euf;
    private static /* synthetic */ boolean eug;
    private static /* synthetic */ long euh;

    private ett() {
    }

    public static void distance(float f) {
        etz = Math.max(0.0f, f);
    }

    public static void viewOffset(float f, float f2) {
        eub = f;
        euc = f2;
        eud = true;
    }

    public static void releaseView() {
        eud = false;
    }

    private void eui() {
        long l = System.nanoTime();
        float f = eue == 0L ? 0.0f : Math.min(0.1f, (float)(l - eue) / 1.0E9f);
        eue = l;
        if (!(eud || eub == 0.0f && euc == 0.0f)) {
            float f2 = (float)Math.exp(-f * 14.0f);
            eub *= f2;
            euc *= f2;
            if (Math.abs(eub) < 0.02f && Math.abs(euc) < 0.02f) {
                eub = 0.0f;
                euc = 0.0f;
            }
        }
        if (eub != 0.0f || euc != 0.0f) {
            this.setRotation(this.getYaw() - eub, Math.max(-90.0f, Math.min(90.0f, this.getPitch() - euc)));
        }
    }

    public static void install(MinecraftClient minecraftClient) {
        if (etx || etw != null || minecraftClient == null || minecraftClient.gameRenderer == null || dry.armed()) {
            return;
        }
        try {
            GameRenderer gameRenderer = minecraftClient.gameRenderer;
            Unsafe unsafe = ett.euk();
            long l = -1L;
            for (Field field : GameRenderer.class.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()) || field.getType() != Camera.class) continue;
                l = unsafe.objectFieldOffset(field);
                break;
            }
            if (l < 0L) {
                throw new IllegalStateException(a.d("\ub626\ucf95\u454a\udb33\u50f3\ud651\u6c43\ue5f4\u7ba4\uf119\u76c3\u8cba\u0229\u9bd6\u1184\u976e\u2d75\ua2e2\u3858\ube13\u37ff\u4da4", 19321258, -1240045575));
            }
            Camera camera = (Camera)unsafe.getObject(gameRenderer, l);
            if (camera instanceof ett) {
                return;
            }
            etv = l;
            etw = camera;
            unsafe.putObject(gameRenderer, l, (Object)new ett());
        }
        catch (Throwable throwable) {
            etx = true;
            System.out.println(a.b("\ue00f\u99a3\u135a\u8d28\u06e7\u8013\u3a2f\ub3a3\u2da8\ua705\u20d7\udabd\u547c\ucd84\u478a\uc16e\u7b36\uf4e6\u6e49\ue819\u61a0\u1bb2\u9503\u0ede\u88a9\u026f\ubbcf\u35df\uaf7b\u292d\ua28b\u5c42\ud607\u4fa5\uc9a0\u4306\ufcde\u76a8\uf07e\u69cf\ue39d\u9d37\u177e", 142270591) + throwable);
        }
    }

    public static void uninstall(MinecraftClient minecraftClient) {
        if (etw == null || minecraftClient == null || minecraftClient.gameRenderer == null) {
            return;
        }
        try {
            ett.euk().putObject(minecraftClient.gameRenderer, etv, etw);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        etw = null;
        ett.euj(minecraftClient, false);
    }

    public void update(World area, Entity focusedEntity, boolean thirdPerson, boolean inverseView, float tickProgress) {
        Entity entity;
        LivingEntity livingEntity;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (!thirdPerson || focusedEntity == null || dry.armed() || focusedEntity instanceof LivingEntity && (livingEntity = (LivingEntity)focusedEntity).isSleeping()) {
            this.eua = thirdPerson;
            super.update(area, focusedEntity, thirdPerson, inverseView, tickProgress);
            if (!thirdPerson && focusedEntity == minecraftClient.player) {
                this.eui();
            }
            ett.euj(minecraftClient, false);
            return;
        }
        super.update(area, focusedEntity, false, inverseView, tickProgress);
        this.eua = true;
        if (focusedEntity == minecraftClient.player) {
            this.eui();
        }
        if (inverseView) {
            this.setRotation(this.getYaw() + 180.0f, -this.getPitch());
        }
        float f = 4.0f;
        float f2 = 1.0f;
        if (focusedEntity instanceof LivingEntity) {
            LivingEntity livingEntity2 = (LivingEntity)focusedEntity;
            f2 = livingEntity2.getScale();
            f = (float)livingEntity2.getAttributeValue(EntityAttributes.CAMERA_DISTANCE);
        }
        float f3 = f2;
        float f4 = f;
        if (focusedEntity.hasVehicle() && (entity = focusedEntity.getVehicle()) instanceof LivingEntity) {
            LivingEntity livingEntity3 = (LivingEntity)entity;
            f3 = livingEntity3.getScale();
            f4 = (float)livingEntity3.getAttributeValue(EntityAttributes.CAMERA_DISTANCE);
        }
        float f5 = Math.max(f2 * f, f3 * f4);
        this.moveBy(-(etz > 0.0f ? etz * f2 : f5), 0.0f, 0.0f);
        boolean bl = false;
        if (area != null) {
            BlockPos blockPos = this.getBlockPos();
            BlockState blockState = area.getBlockState(blockPos);
            bl = blockState.isOpaqueFullCube();
        }
        ett.euj(minecraftClient, bl);
    }

    public boolean isThirdPerson() {
        return this.eua;
    }

    private static void euj(MinecraftClient minecraftClient, boolean bl) {
        if (minecraftClient == null || bl == ety) {
            return;
        }
        ety = bl;
        if (bl) {
            euf = minecraftClient.chunkCullingEnabled;
            minecraftClient.chunkCullingEnabled = false;
        } else {
            minecraftClient.chunkCullingEnabled = euf;
        }
    }

    private static Unsafe euk() throws ReflectiveOperationException {
        if (etu == null) {
            Field field = Unsafe.class.getDeclaredField(a.b("\u9905\ue0a8\u6a76\uf437\u7fdb\uf977\u4336\ucac0\u549c", -1765172872));
            field.setAccessible(true);
            etu = (Unsafe)field.get(null);
        }
        return etu;
    }

    static {
        etv = -1L;
        euf = true;
    }

    private static /* synthetic */ int kw(int n, int n2) {
        return n + n2 + -1218004972;
    }

    private static /* synthetic */ int kx(int n, int n2) {
        return ett.kw(n, n2) + n;
    }

    private static /* synthetic */ int ky(int n, int n2) {
        return ett.kw(n, n2) * n2;
    }
}

