/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockState
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.network.OtherClientPlayerEntity
 *  net.minecraft.client.render.model.BakedModelManager
 *  net.minecraft.client.texture.NativeImage
 *  net.minecraft.client.texture.Sprite
 *  net.minecraft.client.texture.SpriteContents
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.ItemEntity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.decoration.DisplayEntity
 *  net.minecraft.entity.mob.HostileEntity
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Vec3d
 */
package a;

import a.dtv;
import a.dxe;
import a.dxq;
import a.dxv;
import a.dxy;
import a.dye;
import a.ejl;
import a.elb;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.render.model.BakedModelManager;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteContents;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.DisplayEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

public final class dyh {
    public static final int WIDTH = 256;
    public static final int HEIGHT = 170;
    private static final double dyi = 56.0;
    private static final long dyj = 45000000L;
    private static final int dyk = Math.max(1, Math.min(6, Runtime.getRuntime().availableProcessors() - 1));
    private static final ExecutorService dyl = Executors.newFixedThreadPool(dyk, runnable -> {
        Thread thread = new Thread(runnable, a.b("\u6dbb\u1420\u9ef0\u0099\u8b0b\u0da8\ub7b9\u3e45\ua001\u2ae4\uad74\u5707\ud9dc\u4065\uca21\u4cc3", 422145517));
        thread.setDaemon(true);
        thread.setPriority(5);
        return thread;
    });
    private static final Map<BlockState, dxq> dym = new ConcurrentHashMap<BlockState, dxq>();
    private static final Map<Sprite, dxy> dyn = new ConcurrentHashMap<Sprite, dxy>();
    private static final long dyo = dyh.ead();
    private static final Direction[] dyp = Direction.values();
    private static final MinecraftClient dyq = MinecraftClient.getInstance();
    private static final Set<dyh> dyr = Collections.newSetFromMap(new IdentityHashMap());
    private static final double[] dys = dyh.eac();
    private final dtv dyt;
    private final int[] dyu = new int[43520];
    private final float[] dyv = new float[43520];
    private final List<dxe> dyw = new ArrayList<dxe>();
    private final dye[] dyx = new dye[dyk * 3];
    private final long[] dyy = new long[dyk * 3];
    private List<Future<?>> dyz;
    private ClientWorld dza;
    private ClientPlayerEntity dzb;
    private float dzc;
    private long dzd;
    private int dze;
    private elb dzf;
    private long dzg;
    private long dzh;
    private boolean dzi;
    private String dzj = a.c(-1071423468, "\u643a\u1d81\u975e\u0926\u8284\u0445\uba06\u37e5\ua9b2\u2302\ua4a4\u5edc\ud07c\u49c8\uc3ec\u451e\uff5f\u74ef\uee5c\u680d");
    private Object dzk;
    private float dzl;
    private float dzm;
    private double dzn;
    private double dzo;
    private double dzp;
    private double dzq;
    private double dzr;
    private double dzs;
    private double dzt;
    private double dzu;
    private double dzv;
    private double dzw;
    private double dzx;
    private double dzy;
    private double dzz;
    private static /* synthetic */ String eaa;
    private static /* synthetic */ String eab;

    dyh(dtv dtv2) {
        this.dyt = dtv2;
    }

    private static double[] eac() {
        double[] dArray = new double[61];
        for (int i = 0; i < dArray.length; ++i) {
            dArray[i] = 0.18 + 0.82 * Math.pow((double)i / 60.0, 1.25);
        }
        return dArray;
    }

    private static long ead() {
        try {
            return ejl.offset(SpriteContents.class, NativeImage.class);
        }
        catch (Throwable throwable) {
            return -1L;
        }
    }

    public void demand() {
        this.dzh = System.currentTimeMillis() + 1000L;
    }

    public boolean isReady() {
        return this.dzi;
    }

    public float getRenderMillis() {
        return this.dzl;
    }

    public float getTraceMillis() {
        return this.dzm;
    }

    public String getStatus() {
        return this.dzj;
    }

    public List<dxe> labels() {
        return this.dyw;
    }

    public elb texture() {
        if (this.dyz != null) {
            for (Future<?> future : this.dyz) {
                if (future.isDone()) continue;
                return this.dzi ? this.dzf : null;
            }
            this.eaf();
        }
        long l = System.nanoTime();
        if (System.currentTimeMillis() <= this.dzh && l - this.dzg >= 45000000L) {
            this.dzg = l;
            try {
                this.eah();
            }
            catch (Throwable throwable) {
                this.dzj = a.d("\u930b\ueacc\u606f\ufe17\u75cb\uf370\u4d33\uc0d8\u5e8d\ud430\u53ea\ua9ee\u2732\ubaf2\u30bb", -1631684451, -307171417) + throwable.getClass().getSimpleName();
                this.dzi = false;
                this.dyz = null;
                dyr.remove(this);
            }
        }
        return this.dzi ? this.dzf : null;
    }

    static void awaitAll() {
        if (dyr.isEmpty()) {
            return;
        }
        for (dyh dyh2 : new ArrayList<dyh>(dyr)) {
            dyh2.eae();
        }
    }

    private void eae() {
        List<Future<?>> list = this.dyz;
        if (list == null) {
            dyr.remove(this);
            return;
        }
        for (Future<?> future : list) {
            try {
                future.get();
            }
            catch (Throwable throwable) {}
        }
    }

    private void eaf() {
        List<Future<?>> list = this.dyz;
        this.dyz = null;
        dyr.remove(this);
        try {
            for (Future<?> future : list) {
                future.get();
            }
            long l = this.dzd;
            for (long l2 : this.dyy) {
                l = Math.max(l, l2);
            }
            this.dzm = this.dzm * 0.8f + (float)(l - this.dzd) / 1000000.0f * 0.2f;
            long l3 = System.nanoTime();
            this.eak(this.dza, this.dzb, this.dzc);
            this.eag();
            this.dzl = this.dzl * 0.8f + (float)(System.nanoTime() - l3) / 1000000.0f * 0.2f;
            this.dzi = true;
        }
        catch (Throwable throwable) {
            Throwable throwable2 = throwable.getCause() != null ? throwable.getCause() : throwable;
            this.dzj = a.c(-1517101114, "\udbf7\ua230\u2893\ub6eb\u3d37\ubb8c\u05cf\u8824\u1671\u9ccc\u1b16\ue112\u6fce\uf20e\u7847") + throwable2.getClass().getSimpleName();
            this.dzi = false;
        }
        this.dza = null;
        this.dzb = null;
    }

    private void eag() {
        if (this.dzf == null) {
            this.dzf = new elb(a.b("\u17c2\u6e71\ue4ae\u7ad7\uf117\u77b5", -1310582873), 256, 170);
        }
        for (int i = 0; i < 170; ++i) {
            int n = i * 256;
            for (int j = 0; j < 256; ++j) {
                this.dzf.set(j, i, this.dyu[n + j]);
            }
        }
        this.dzf.upload();
    }

    void reset() {
        this.dzi = false;
        this.dzj = a.b("\u6b56\u12ed\u9832\u064a\u8de8\u0b29\ub56a\u3889\ua6de\u2c6e\uabc8\u51b0\udf10\u46a4\ucc80\u4a72\uf033\u7b83\ue130\u6761", -1364955272);
        this.dyw.clear();
    }

    void close() {
        this.eae();
        this.dyz = null;
        dyr.remove(this);
        if (this.dzf != null) {
            this.dzf.close();
            this.dzf = null;
        }
        this.dzi = false;
    }

    private boolean eah() {
        ClientPlayerEntity clientPlayerEntity = this.dyt.getPlayer();
        ClientWorld clientWorld = this.dyt.getWorld();
        if (clientPlayerEntity == null || clientWorld == null) {
            this.dzj = a.d("\uc62d\ubf93\u353c\uaf2f\u20e5\ua65c\u181a\u95f9\u0fb4\u811d\u06c5\ufcc7\u7265", -630914101, 1761526234);
            return false;
        }
        BakedModelManager bakedModelManager = dyq.getBakedModelManager();
        if (bakedModelManager != this.dzk) {
            this.dzk = bakedModelManager;
            dym.clear();
            dyn.clear();
        }
        float f = this.dyt.partialTick();
        Vec3d vec3d = clientPlayerEntity.getCameraPosVec(f);
        float f2 = clientPlayerEntity.getYaw(f);
        float f3 = clientPlayerEntity.getPitch(f);
        this.dzn = vec3d.x;
        this.dzo = vec3d.y;
        this.dzp = vec3d.z;
        double d = Math.toRadians(f2);
        double d2 = Math.toRadians(f3);
        this.dzq = -Math.sin(d) * Math.cos(d2);
        this.dzr = -Math.sin(d2);
        this.dzs = Math.cos(d) * Math.cos(d2);
        this.dzt = -Math.cos(d);
        this.dzu = -Math.sin(d);
        this.dzv = -this.dzu * this.dzr;
        this.dzw = this.dzu * this.dzq - this.dzt * this.dzs;
        this.dzx = this.dzt * this.dzr;
        double d3 = dyh.dyq.options == null ? 70.0 : (double)((Integer)dyh.dyq.options.getFov().getValue()).intValue();
        this.dzz = Math.tan(Math.toRadians(d3) * 0.5);
        this.dzy = this.dzz * 256.0 / 170.0;
        dxv dxv2 = new dxv(clientWorld, clientPlayerEntity, this.dyt.crosshair);
        int n = this.dyx.length;
        boolean bl = ++this.dze % 40 == 0;
        for (int i = 0; i < n; ++i) {
            if (this.dyx[i] == null) {
                this.dyx[i] = new dye();
            }
            this.dyx[i].begin(dxv2, bl);
        }
        this.dza = clientWorld;
        this.dzb = clientPlayerEntity;
        this.dzc = f;
        this.dzd = System.nanoTime();
        ArrayList arrayList = new ArrayList(n);
        int n2 = 0;
        while (n2 < n) {
            int n3 = n2++;
            this.dyy[n3] = this.dzd;
            arrayList.add(dyl.submit(() -> {
                dye dye2 = this.dyx[n3];
                for (int i = n3; i < 170; i += n) {
                    this.eai(dye2, i);
                }
                this.dyy[n] = System.nanoTime();
            }));
        }
        this.dyz = arrayList;
        dyr.add(this);
        return true;
    }

    private void eai(dye dye2, int n) {
        double d = (1.0 - 2.0 * ((double)n + 0.5) / 170.0) * this.dzz;
        int n2 = n * 256;
        for (int i = 0; i < 256; ++i) {
            double d2 = (2.0 * ((double)i + 0.5) / 256.0 - 1.0) * this.dzy;
            double d3 = this.dzq + this.dzt * d2 + this.dzv * d;
            double d4 = this.dzr + this.dzw * d;
            double d5 = this.dzs + this.dzu * d2 + this.dzx * d;
            double d6 = Math.sqrt(d3 * d3 + d4 * d4 + d5 * d5);
            this.dyu[n2 + i] = dye2.trace(this.dzn, this.dzo, this.dzp, d3 /= d6, d4 /= d6, d5 /= d6);
            this.dyv[n2 + i] = (float)dye2.hitDistance;
        }
    }

    private boolean eaj(double d, double d2, double d3, double[] dArray) {
        double d4 = d - this.dzn;
        double d5 = d2 - this.dzo;
        double d6 = d3 - this.dzp;
        double d7 = d4 * this.dzq + d5 * this.dzr + d6 * this.dzs;
        if (d7 <= 0.05) {
            return false;
        }
        double d8 = d4 * this.dzt + d6 * this.dzu;
        double d9 = d4 * this.dzv + d5 * this.dzw + d6 * this.dzx;
        dArray[0] = (d8 / d7 / this.dzy + 1.0) * 0.5 * 256.0;
        dArray[1] = (1.0 - d9 / d7 / this.dzz) * 0.5 * 170.0;
        dArray[2] = d7;
        return true;
    }

    private void eak(ClientWorld clientWorld, ClientPlayerEntity clientPlayerEntity, float f) {
        this.dyw.clear();
        double[] dArray = new double[3];
        Entity entity = clientPlayerEntity.getRootVehicle();
        for (Entity entity2 : clientWorld.getEntities()) {
            if (entity2 == clientPlayerEntity || entity2 == entity || entity2.isRemoved() || entity2 instanceof DisplayEntity || entity2.isInvisible()) continue;
            Vec3d vec3d = entity2.getLerpedPos(f);
            double d = vec3d.x - this.dzn;
            double d2 = vec3d.y - this.dzo;
            double d3 = vec3d.z - this.dzp;
            if (d * d + d2 * d2 + d3 * d3 > 3136.0) continue;
            Box box = entity2.getBoundingBox().offset(vec3d.subtract(entity2.getEntityPos()));
            int n = dyh.eal(entity2);
            if (entity2 instanceof OtherClientPlayerEntity) {
                int n2;
                double d4 = Math.min(0.5, box.getLengthY() * 0.28);
                this.eam(box.withMinY(box.maxY - d4).expand(0.02, 0.0, 0.02), -2050932);
                this.eam(box.withMaxY(box.maxY - d4), n);
                if (!this.eaj(vec3d.x, box.maxY + 0.35, vec3d.z, dArray) || !(dArray[0] >= 0.0) || !(dArray[0] < 256.0) || !(dArray[1] >= 0.0) || !(dArray[1] < 170.0) || !((double)this.dyv[n2 = (int)dArray[1] * 256 + (int)dArray[0]] + 0.5 >= dArray[2]) && !(dArray[2] < 6.0)) continue;
                this.dyw.add(new dxe(entity2.getName().getString(), (float)(dArray[0] / 256.0), (float)(dArray[1] / 170.0), -1));
                continue;
            }
            this.eam(box, n);
        }
    }

    private static int eal(Entity entity) {
        if (entity instanceof OtherClientPlayerEntity) {
            return -12685352;
        }
        if (entity instanceof ItemEntity) {
            return -863670;
        }
        if (entity instanceof HostileEntity) {
            return -8408516;
        }
        if (entity instanceof LivingEntity) {
            return -3630230;
        }
        return -6249300;
    }

    private void eam(Box box, int n) {
        double d;
        int n2;
        double[] dArray = new double[3];
        double d2 = Double.MAX_VALUE;
        double d3 = Double.MAX_VALUE;
        double d4 = -1.7976931348623157E308;
        double d5 = -1.7976931348623157E308;
        int n3 = 0;
        for (n2 = 0; n2 < 8; ++n2) {
            double d6 = (n2 & 1) == 0 ? box.minX : box.maxX;
            double d7 = (n2 & 2) == 0 ? box.minY : box.maxY;
            double d8 = d = (n2 & 4) == 0 ? box.minZ : box.maxZ;
            if (!this.eaj(d6, d7, d, dArray)) continue;
            ++n3;
            d2 = Math.min(d2, dArray[0]);
            d4 = Math.max(d4, dArray[0]);
            d3 = Math.min(d3, dArray[1]);
            d5 = Math.max(d5, dArray[1]);
        }
        if (n3 < 8) {
            return;
        }
        n2 = Math.max(0, (int)Math.floor(d2));
        int n4 = Math.min(255, (int)Math.ceil(d4));
        int n5 = Math.max(0, (int)Math.floor(d3));
        int n6 = Math.min(169, (int)Math.ceil(d5));
        for (int i = n5; i <= n6; ++i) {
            d = (1.0 - 2.0 * ((double)i + 0.5) / 170.0) * this.dzz;
            for (int j = n2; j <= n4; ++j) {
                double d9;
                double d10;
                int n7;
                double d11 = (2.0 * ((double)j + 0.5) / 256.0 - 1.0) * this.dzy;
                double d12 = this.dzq + this.dzt * d11 + this.dzv * d;
                double d13 = this.dzr + this.dzw * d;
                double d14 = this.dzs + this.dzu * d11 + this.dzx * d;
                double d15 = Math.sqrt(d12 * d12 + d13 * d13 + d14 * d14);
                double d16 = -1.7976931348623157E308;
                double d17 = Double.MAX_VALUE;
                int n8 = -1;
                double[] dArray2 = new double[]{this.dzn, this.dzo, this.dzp};
                double[] dArray3 = new double[]{d12 /= d15, d13 /= d15, d14 /= d15};
                double[] dArray4 = new double[]{box.minX, box.minY, box.minZ};
                double[] dArray5 = new double[]{box.maxX, box.maxY, box.maxZ};
                boolean bl = false;
                for (n7 = 0; n7 < 3; ++n7) {
                    if (Math.abs(dArray3[n7]) < 1.0E-9) {
                        if (!(dArray2[n7] < dArray4[n7]) && !(dArray2[n7] > dArray5[n7])) continue;
                        bl = true;
                        break;
                    }
                    d10 = (dArray4[n7] - dArray2[n7]) / dArray3[n7];
                    d9 = (dArray5[n7] - dArray2[n7]) / dArray3[n7];
                    if (d10 > d9) {
                        double d18 = d10;
                        d10 = d9;
                        d9 = d18;
                    }
                    if (d10 > d16) {
                        d16 = d10;
                        n8 = n7;
                    }
                    d17 = Math.min(d17, d9);
                }
                if (bl || d16 > d17 || d16 <= 0.0 || d16 >= (double)this.dyv[n7 = i * 256 + j]) continue;
                d10 = n8 == 1 ? (dArray3[1] < 0.0 ? 1.0 : 0.55) : (n8 == 0 ? 0.72 : 0.86);
                d9 = Math.min(1.0, d16 / 56.0);
                int n9 = dyh.scale(n, d10);
                this.dyu[n7] = dyh.mix(n9, this.dyu[n7], d9 * d9 * 0.6);
                this.dyv[n7] = (float)d16;
            }
        }
    }

    static int scale(int n, double d) {
        int n2 = (int)Math.min(255.0, (double)(n >> 16 & 0xFF) * d);
        int n3 = (int)Math.min(255.0, (double)(n >> 8 & 0xFF) * d);
        int n4 = (int)Math.min(255.0, (double)(n & 0xFF) * d);
        return 0xFF000000 | n2 << 16 | n3 << 8 | n4;
    }

    static int mul(int n, int n2) {
        int n3 = (n >> 16 & 0xFF) * (n2 >> 16 & 0xFF) / 255;
        int n4 = (n >> 8 & 0xFF) * (n2 >> 8 & 0xFF) / 255;
        int n5 = (n & 0xFF) * (n2 & 0xFF) / 255;
        return n & 0xFF000000 | n3 << 16 | n4 << 8 | n5;
    }

    static int mix(int n, int n2, double d) {
        double d2 = 1.0 - d;
        int n3 = (int)((double)(n >> 16 & 0xFF) * d2 + (double)(n2 >> 16 & 0xFF) * d);
        int n4 = (int)((double)(n >> 8 & 0xFF) * d2 + (double)(n2 >> 8 & 0xFF) * d);
        int n5 = (int)((double)(n & 0xFF) * d2 + (double)(n2 & 0xFF) * d);
        return 0xFF000000 | n3 << 16 | n4 << 8 | n5;
    }

    private static dxy ean(Sprite sprite2) {
        if (sprite2 == null || dyo < 0L) {
            return null;
        }
        return dyn.computeIfAbsent(sprite2, sprite -> {
            try {
                SpriteContents spriteContents = sprite.getContents();
                NativeImage nativeImage = (NativeImage)ejl.get(spriteContents, dyo);
                int n = spriteContents.getWidth();
                int n2 = spriteContents.getHeight();
                if (nativeImage == null || n <= 0 || n2 <= 0) {
                    return null;
                }
                int[] nArray = new int[n * n2];
                for (int i = 0; i < n2; ++i) {
                    for (int j = 0; j < n; ++j) {
                        nArray[i * n + j] = nativeImage.getColorArgb(j, i);
                    }
                }
                return new dxy(n, n2, nArray);
            }
            catch (Throwable throwable) {
                return null;
            }
        });
    }

    private static /* synthetic */ int ca(int n, int n2) {
        return n + n2 + -241313394;
    }

    private static /* synthetic */ int cb(int n, int n2) {
        return dyh.ca(n, n2) * n2;
    }

    private static /* synthetic */ int cc(int n, int n2) {
        return dyh.ca(n, n2) ^ 0xF0551AA1;
    }
}

