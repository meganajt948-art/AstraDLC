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
            this.method_19325(this.method_19330() - eub, Math.max(-90.0f, Math.min(90.0f, this.method_19329() - euc)));
        }
    }

    public static void install(MinecraftClient minecraftClient) {
        if (etx || etw != null || minecraftClient == null || minecraftClient.field_1773 == null || dry.armed()) {
            return;
        }
        try {
            GameRenderer gameRenderer = minecraftClient.field_1773;
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
        if (etw == null || minecraftClient == null || minecraftClient.field_1773 == null) {
            return;
        }
        try {
            ett.euk().putObject(minecraftClient.field_1773, etv, etw);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        etw = null;
        ett.euj(minecraftClient, false);
    }

    public void method_19321(World world, Entity entity, boolean bl, boolean bl2, float f) {
        Entity entity2;
        LivingEntity livingEntity;
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        if (!bl || entity == null || dry.armed() || entity instanceof LivingEntity && (livingEntity = (LivingEntity)entity).method_6113()) {
            this.eua = bl;
            super.method_19321(world, entity, bl, bl2, f);
            if (!bl && entity == minecraftClient.field_1724) {
                this.eui();
            }
            ett.euj(minecraftClient, false);
            return;
        }
        super.method_19321(world, entity, false, bl2, f);
        this.eua = true;
        if (entity == minecraftClient.field_1724) {
            this.eui();
        }
        if (bl2) {
            this.method_19325(this.method_19330() + 180.0f, -this.method_19329());
        }
        float f2 = 4.0f;
        float f3 = 1.0f;
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity2 = (LivingEntity)entity;
            f3 = livingEntity2.method_55693();
            f2 = (float)livingEntity2.method_45325(EntityAttributes.field_59674);
        }
        float f4 = f3;
        float f5 = f2;
        if (entity.method_5765() && (entity2 = entity.method_5854()) instanceof LivingEntity) {
            LivingEntity livingEntity3 = (LivingEntity)entity2;
            f4 = livingEntity3.method_55693();
            f5 = (float)livingEntity3.method_45325(EntityAttributes.field_59674);
        }
        float f6 = Math.max(f3 * f2, f4 * f5);
        this.method_19324(-(etz > 0.0f ? etz * f3 : f6), 0.0f, 0.0f);
        boolean bl3 = false;
        if (world != null) {
            BlockPos blockPos = this.method_19328();
            BlockState blockState = world.method_8320(blockPos);
            bl3 = blockState.method_26216();
        }
        ett.euj(minecraftClient, bl3);
    }

    public boolean method_19333() {
        return this.eua;
    }

    private static void euj(MinecraftClient minecraftClient, boolean bl) {
        if (minecraftClient == null || bl == ety) {
            return;
        }
        ety = bl;
        if (bl) {
            euf = minecraftClient.field_1730;
            minecraftClient.field_1730 = false;
        } else {
            minecraftClient.field_1730 = euf;
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

