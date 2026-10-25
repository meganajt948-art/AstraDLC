/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.Std140Builder
 *  net.minecraft.block.enums.CameraSubmersionType
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.render.Camera
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$Mutable
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.Heightmap$Type
 *  net.minecraft.world.attribute.EnvironmentAttributes
 *  net.minecraft.world.dimension.DimensionType$Skybox
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 */
package a;

import a.kfa;
import a.kfe;
import a.sfz;
import a.sgk;
import a.vbb;
import a.vkl;
import a.vlv;
import a.vmc;
import com.mojang.blaze3d.buffers.Std140Builder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Heightmap;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.dimension.DimensionType;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;

public class sgs
extends kfe {
    private static final int sgt = 32;
    private static final float sgu = (float)Math.PI / 180;
    private final vmc sgv = this.add(new vmc("\u041c\u043e\u043a\u0440\u043e\u0441\u0442\u044c", 0.7, 0.0, 1.0, 0.01).percent());
    private final vmc sgw = this.add(new vmc("\u041b\u0443\u0436\u0438", 0.5, 0.0, 1.0, 0.01).percent());
    private final vmc sgx = this.add(new vmc("\u041e\u0442\u0440\u0430\u0436\u0435\u043d\u0438\u044f", 1.0, 0.0, 1.0, 0.05).percent());
    private final vmc sgy = this.add(new vmc("\u0417\u0430\u0442\u0435\u043c\u043d\u0435\u043d\u0438\u0435", 0.55, 0.0, 1.0, 0.05).percent());
    private final vmc sgz = this.add(new vmc("\u041a\u0430\u043f\u043b\u0438", 0.0, 0.0, 1.0, 0.05).percent());
    private final vkl sha = this.add(new vkl("\u0421\u043b\u0435\u0434\u044b", true));
    private final vmc shb = this.add(new vmc("\u0412\u0440\u0435\u043c\u044f \u0441\u043b\u0435\u0434\u043e\u0432", 20.0, 5.0, 60.0, 1.0).suffix("\u0441"));
    private final vkl shc = this.add(new vkl("\u0422\u043e\u043b\u044c\u043a\u043e \u043f\u043e\u0434 \u043d\u0435\u0431\u043e\u043c", true));
    private final vlv shd = this.add(new vlv("\u041a\u0430\u0447\u0435\u0441\u0442\u0432\u043e", "\u0412\u044b\u0441\u043e\u043a\u043e\u0435", "\u041d\u0438\u0437\u043a\u043e\u0435", "\u0421\u0440\u0435\u0434\u043d\u0435\u0435", "\u0412\u044b\u0441\u043e\u043a\u043e\u0435"));
    private final ArrayDeque<sfz> she = new ArrayDeque();
    private final Map<UUID, sgk> shf = new HashMap<UUID, sgk>();
    private final int[] shg = new int[16384];
    private final BlockPos.Mutable shh = new BlockPos.Mutable();
    private final Matrix4f shi = new Matrix4f();
    private final Matrix4f shj = new Matrix4f();
    private boolean shk;
    private int shl;
    private int shm;
    private int shn;
    private long sho;
    private float shp;
    private static /* synthetic */ int shq;
    private static /* synthetic */ boolean shr;

    public sgs() {
        super(new String(new char[]{'W', 'e', 't', 'G', 'r', 'o', 'u', 'n', 'd'}), "Wet ground after rain: puddles with reflections, ripples and footprints", kfa.RENDER);
        this.shb.visibleWhen(this.sha::get);
    }

    @Override
    protected void onEnable() {
        this.shk = false;
        this.shn = 0;
        this.sho = 0L;
        this.she.clear();
        this.shf.clear();
    }

    @Override
    protected void onDisable() {
        vbb.release();
        this.she.clear();
        this.shf.clear();
    }

    @Override
    public void onEndTick(MinecraftClient minecraftClient) {
        ++this.shn;
        ClientWorld clientWorld = minecraftClient.world;
        if (clientWorld == null || minecraftClient.player == null) {
            return;
        }
        long l = System.nanoTime();
        long l2 = (long)(this.shb.get() * 1.0E9);
        while (!this.she.isEmpty() && l - this.she.peekFirst().sgg > l2) {
            this.she.pollFirst();
        }
        if (!this.sha.get()) {
            this.she.clear();
            this.shf.clear();
            return;
        }
        HashMap<UUID, Boolean> hashMap = new HashMap<UUID, Boolean>();
        for (PlayerEntity playerEntity : clientWorld.getPlayers()) {
            if (playerEntity.isSpectator() || playerEntity.squaredDistanceTo((Entity)minecraftClient.player) > 2304.0) continue;
            hashMap.put(playerEntity.getUuid(), Boolean.TRUE);
            this.shs(playerEntity, l, playerEntity == minecraftClient.player ? 1.0f : 0.8f);
        }
        this.shf.keySet().removeIf(uUID -> !hashMap.containsKey(uUID));
    }

    private void shs(PlayerEntity playerEntity, long l, float f) {
        sgk sgk2 = this.shf.computeIfAbsent(playerEntity.getUuid(), uUID -> new sgk());
        double d = playerEntity.getX();
        double d2 = playerEntity.getZ();
        boolean bl = playerEntity.isOnGround();
        if (!sgk2.sgl) {
            sgk2.sgl = true;
            sgk2.sgn = d;
            sgk2.sgo = d2;
            sgk2.sgm = bl;
            return;
        }
        double d3 = d - sgk2.sgn;
        double d4 = d2 - sgk2.sgo;
        double d5 = Math.sqrt(d3 * d3 + d4 * d4);
        if (d5 > 6.0) {
            sgk2.sgn = d;
            sgk2.sgo = d2;
            sgk2.sgm = bl;
            return;
        }
        if (bl && !sgk2.sgm) {
            float f2 = playerEntity.getYaw() * ((float)Math.PI / 180);
            float f3 = (float)(-Math.sin(f2));
            float f4 = (float)Math.cos(f2);
            this.sht(d, playerEntity.getY(), d2, f3, f4, 1.0f, l, f);
            this.sht(d, playerEntity.getY(), d2, f3, f4, -1.0f, l, f);
            sgk2.sgn = d;
            sgk2.sgo = d2;
        } else if (bl) {
            double d6;
            double d7 = playerEntity.isSneaking() ? 0.42 : (d6 = playerEntity.isSprinting() ? 0.85 : 0.62);
            if (d5 >= d6) {
                float f5 = (float)(d3 / d5);
                float f6 = (float)(d4 / d5);
                sgk2.sgp = -sgk2.sgp;
                this.sht(d, playerEntity.getY(), d2, f5, f6, sgk2.sgp, l, f);
                sgk2.sgn = d;
                sgk2.sgo = d2;
            }
        } else {
            sgk2.sgn = d;
            sgk2.sgo = d2;
        }
        sgk2.sgm = bl;
    }

    private void sht(double d, double d2, double d3, float f, float f2, float f3, long l, float f4) {
        double d4 = (double)(-f2 * f3) * 0.14;
        double d5 = (double)(f * f3) * 0.14;
        this.she.addLast(new sfz(d + d4, d2, d3 + d5, f, f2, f3, l, f4));
        while (this.she.size() > 32) {
            this.she.pollFirst();
        }
    }

    @Override
    public void onWorldRender(MinecraftClient minecraftClient) {
        float f;
        float f2;
        float f3;
        ClientWorld clientWorld = minecraftClient.world;
        Camera camera = minecraftClient.gameRenderer.getCamera();
        if (clientWorld == null || minecraftClient.player == null || !camera.isReady() || camera.getSubmersionType() != CameraSubmersionType.NONE) {
            this.sho = 0L;
            return;
        }
        long l = System.nanoTime();
        float f4 = this.sho == 0L ? 0.0f : Math.min(0.1f, (float)(l - this.sho) / 1.0E9f);
        this.sho = l;
        this.shp = (this.shp + f4) % 3600.0f;
        float f5 = minecraftClient.getRenderTickCounter().getTickProgress(false);
        Vec3d vec3d = camera.getCameraPos();
        int n = (int)Math.floor(vec3d.x);
        int n2 = (int)Math.floor(vec3d.y);
        int n3 = (int)Math.floor(vec3d.z);
        int n4 = 64;
        if (!this.shk || Math.abs(n - (this.shl + n4)) > 24 || Math.abs(n3 - (this.shm + n4)) > 24 || this.shn >= 40) {
            this.shv(clientWorld, n - n4, n3 - n4);
        }
        int n5 = switch (this.shd.get()) {
            case "\u041d\u0438\u0437\u043a\u043e\u0435" -> 16;
            case "\u0421\u0440\u0435\u0434\u043d\u0435\u0435" -> 28;
            default -> 40;
        };
        String string = camera.getEnvironmentAttributeInterpolator();
        float f6 = clientWorld.getRainGradient(f5);
        float[] fArray = new float[]{0.0f, 1.0f, 0.0f, 0.0f};
        float[] fArray2 = new float[]{1.0f, 1.0f, 1.0f};
        float[] fArray3 = new float[]{0.5f, 0.65f, 0.9f};
        if (clientWorld.getDimension().skybox() == DimensionType.Skybox.OVERWORLD) {
            f3 = Math.max(0.0f, 1.0f - 0.85f * f6);
            f2 = ((Float)string.get(EnvironmentAttributes.SUN_ANGLE_VISUAL, f5)).floatValue() * ((float)Math.PI / 180);
            float f7 = ((Float)string.get(EnvironmentAttributes.MOON_ANGLE_VISUAL, f5)).floatValue() * ((float)Math.PI / 180);
            f = (float)Math.cos(f2);
            float f8 = (float)Math.cos(f7);
            if (f > -0.05f) {
                float f9 = sgs.shw(0.0f, 0.4f, f);
                fArray = new float[]{(float)(-Math.sin(f2)), f, 0.0f, sgs.shw(-0.05f, 0.12f, f) * f3};
                fArray2 = new float[]{1.0f, 0.62f + 0.35f * f9, 0.38f + 0.52f * f9};
            } else {
                fArray = new float[]{(float)(-Math.sin(f7)), f8, 0.0f, sgs.shw(-0.05f, 0.15f, f8) * f3 * 0.35f};
                fArray2 = new float[]{0.6f, 0.7f, 1.0f};
            }
            int n6 = (Integer)string.get(EnvironmentAttributes.SKY_COLOR_VISUAL, f5);
            fArray3 = new float[]{(float)(n6 >> 16 & 0xFF) / 255.0f, (float)(n6 >> 8 & 0xFF) / 255.0f, (float)(n6 & 0xFF) / 255.0f};
        }
        f3 = Math.max((float)this.sgz.get(), f6);
        f2 = Math.min((float)minecraftClient.options.getClampedViewDistance() * 16.0f, 200.0f);
        this.shi.rotation((Quaternionfc)camera.getRotation());
        this.shj.rotation((Quaternionfc)camera.getRotation().conjugate(new Quaternionf()));
        ArrayList<sfz> arrayList = new ArrayList<sfz>(this.she);
        f = (float)this.shb.get();
        float[] fArray4 = fArray;
        float[] fArray5 = fArray2;
        float[] fArray6 = fArray3;
        int n7 = n5;
        boolean bl = this.shc.get();
        boolean bl2 = this.shk;
        int n8 = this.shl - n;
        int n9 = this.shm - n3;
        vbb.draw(std140Builder -> {
            std140Builder.putMat4f((Matrix4fc)this.shi);
            std140Builder.putMat4f((Matrix4fc)this.shj);
            std140Builder.putVec4((float)Math.floorMod(n, 4096), (float)n2, (float)Math.floorMod(n3, 4096), this.shp);
            std140Builder.putVec4((float)(vec3d.x - (double)n), (float)(vec3d.y - (double)n2), (float)(vec3d.z - (double)n3), f3);
            std140Builder.putVec4((float)this.sgv.get(), (float)this.sgw.get(), (float)this.sgx.get(), (float)this.sgy.get());
            std140Builder.putVec4(fArray4[0], fArray4[1], fArray4[2], fArray4[3]);
            std140Builder.putVec4(fArray5[0], fArray5[1], fArray5[2], 0.0f);
            std140Builder.putVec4(fArray6[0], fArray6[1], fArray6[2], bl ? 1.0f : 0.0f);
            std140Builder.putVec4((float)n8, (float)n9, 128.0f, bl2 ? 1.0f : 0.0f);
            std140Builder.putVec4((float)n7, f2, (float)arrayList.size(), f);
            this.shu((Std140Builder)std140Builder, (List<sfz>)arrayList, vec3d, l);
        });
    }

    private void shu(Std140Builder std140Builder, List<sfz> list, Vec3d vec3d, long l) {
        int n;
        sfz sfz22;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (sfz sfz3 : list) {
            f += (float)(sfz3.sga - vec3d.x);
            f2 += (float)(sfz3.sgb - vec3d.y);
            f3 += (float)(sfz3.sgc - vec3d.z);
        }
        int n2 = Math.max(1, list.size());
        f /= (float)n2;
        f2 /= (float)n2;
        f3 /= (float)n2;
        float f4 = 0.0f;
        for (sfz sfz22 : list) {
            float f5 = (float)(sfz22.sga - vec3d.x) - f;
            float f6 = (float)(sfz22.sgb - vec3d.y) - f2;
            float f7 = (float)(sfz22.sgc - vec3d.z) - f3;
            f4 = Math.max(f4, (float)Math.sqrt(f5 * f5 + f6 * f6 + f7 * f7));
        }
        std140Builder.putVec4(f, f2, f3, list.isEmpty() ? 0.0f : f4 + 2.5f);
        for (n = 0; n < 32; ++n) {
            if (n < list.size()) {
                sfz22 = list.get(list.size() - 1 - n);
                std140Builder.putVec4((float)(sfz22.sga - vec3d.x), (float)(sfz22.sgb - vec3d.y), (float)(sfz22.sgc - vec3d.z), (float)(l - sfz22.sgg) / 1.0E9f);
                continue;
            }
            std140Builder.putVec4(0.0f, -1000.0f, 0.0f, 1000.0f);
        }
        for (n = 0; n < 32; ++n) {
            if (n < list.size()) {
                sfz22 = list.get(list.size() - 1 - n);
                std140Builder.putVec4(sfz22.sgd, sfz22.sge, sfz22.sgf, sfz22.sgh);
                continue;
            }
            std140Builder.putVec4(0.0f, 1.0f, 1.0f, 0.0f);
        }
    }

    private void shv(ClientWorld clientWorld, int n, int n2) {
        int n3 = 128;
        for (int i = 0; i < n3; ++i) {
            for (int j = 0; j < n3; ++j) {
                int n4 = clientWorld.getTopY(Heightmap.Type.MOTION_BLOCKING, n + j, n2 + i);
                int n5 = Math.max(0, Math.min(65535, n4 + 64));
                boolean bl = !clientWorld.getFluidState((BlockPos)this.shh.set(n + j, n4 - 1, n2 + i)).isEmpty();
                this.shg[i * n3 + j] = 0xFF000000 | (n5 & 0xFF) << 16 | (n5 >> 8 & 0xFF) << 8 | (bl ? 255 : 0);
            }
        }
        vbb.uploadHeights(this.shg);
        this.shl = n;
        this.shm = n2;
        this.shn = 0;
        this.shk = true;
    }

    private static float shw(float f, float f2, float f3) {
        float f4 = Math.max(0.0f, Math.min(1.0f, (f3 - f) / (f2 - f)));
        return f4 * f4 * (3.0f - 2.0f * f4);
    }

    private static /* synthetic */ int cdq(int n, int n2) {
        return n - n2 | 0xDB2E6F4F;
    }

    private static /* synthetic */ int cdr(int n, int n2) {
        return n - n2 ^ 0x7311E235;
    }
}

