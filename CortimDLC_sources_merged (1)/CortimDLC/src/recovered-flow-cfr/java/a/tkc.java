/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.RaycastContext
 *  net.minecraft.world.RaycastContext$FluidHandling
 *  net.minecraft.world.RaycastContext$ShapeType
 */
package a;

import a.tbp;
import a.tiq;
import a.tme;
import a.tmh;
import flow.dev.a;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;

public final class tkc {
    private static final int tkd = 1200;
    private static final long tke = 180000L;
    public final tiq profile;
    private final tmh tkf = new tmh();
    private final List<tme> tkg = new ArrayList<tme>();
    private final String tkh;
    private final ArrayDeque<Integer> tki = new ArrayDeque();
    private boolean tkj = true;
    private int tkk;
    private int tkl;
    private float tkm;
    private float tkn;
    private int tko;
    private int tkp;
    private int tkq;
    private boolean tkr;
    private boolean tks;
    private long tkt = System.currentTimeMillis();
    public int hits;
    public int samples;
    public int failures;
    private int tku;
    public int recorded;
    public boolean paused;
    public String pauseReason = "";
    private static /* synthetic */ long tkv;
    private static /* synthetic */ int tkw;

    public tkc(tiq tiq2, int n, Vec3d vec3d, float f) {
        this.profile = tiq2;
        this.tkh = tiq2.newTapeName();
        this.tkf.created = System.currentTimeMillis();
        this.tkf.source = n;
        this.tkf.originX = Math.floor(vec3d.field_1352);
        this.tkf.originY = Math.floor(vec3d.field_1351);
        this.tkf.originZ = Math.floor(vec3d.field_1350);
        this.tkf.unit = f;
    }

    public void presses(int n) {
        this.tkk += n;
    }

    public void hit(Entity entity, Vec3d vec3d, ClientPlayerEntity clientPlayerEntity) {
        if (this.tkl != 0) {
            return;
        }
        Box box = entity.method_5829();
        double d = (box.field_1323 + box.field_1320) * 0.5;
        double d2 = (box.field_1321 + box.field_1324) * 0.5;
        Vec3d vec3d2 = clientPlayerEntity.method_33571();
        this.tkl = entity.method_5628() == 0 ? 1 : entity.method_5628();
        this.tkm = (float)tbp.hitU(vec3d2.field_1352, vec3d2.field_1350, d, d2, (box.field_1320 - box.field_1323) * 0.5, vec3d.field_1352, vec3d.field_1350);
        this.tkn = (float)tbp.hitV(box.field_1322, box.field_1325 - box.field_1322, vec3d.field_1351);
    }

    public void aim(MinecraftClient minecraftClient, List<? extends Entity> list) {
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (this.tkl != 0 || clientPlayerEntity == null || minecraftClient.field_1687 == null) {
            return;
        }
        Vec3d vec3d = clientPlayerEntity.method_33571();
        Vec3d vec3d2 = vec3d.method_1019(clientPlayerEntity.method_5828(1.0f).method_1021(8.0));
        double d = 8.0;
        BlockHitResult blockHitResult = minecraftClient.field_1687.method_17742(new RaycastContext(vec3d, vec3d2, RaycastContext.ShapeType.field_17558, RaycastContext.FluidHandling.field_1348, (Entity)clientPlayerEntity));
        if (blockHitResult.method_17783() != HitResult.Type.field_1333) {
            d = blockHitResult.method_17784().method_1022(vec3d);
        }
        Entity entity = null;
        Vec3d vec3d3 = null;
        double d2 = d;
        for (Entity entity2 : list) {
            Box box = entity2.method_5829().method_1014((double)entity2.method_5871());
            Optional optional = box.method_992(vec3d, vec3d2);
            if (!optional.isPresent() || !(((Vec3d)optional.get()).method_1022(vec3d) < d2)) continue;
            d2 = ((Vec3d)optional.get()).method_1022(vec3d);
            entity = entity2;
            vec3d3 = (Vec3d)optional.get();
        }
        if (entity != null) {
            this.hit(entity, vec3d3, clientPlayerEntity);
        }
    }

    public void pause(String string) {
        this.paused = true;
        this.pauseReason = string;
        this.tkj = true;
        this.tkk = 0;
        this.tkl = 0;
    }

    public void tick(MinecraftClient minecraftClient, List<? extends Entity> list) {
        int n;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        if (clientPlayerEntity == null) {
            return;
        }
        this.paused = false;
        this.pauseReason = "";
        tme tme2 = new tme();
        tme2.flags = 1 | (clientPlayerEntity.method_24828() ? 2 : 0) | (this.tkj ? 4 : 0);
        this.tkj = false;
        tme2.yaw = clientPlayerEntity.method_36454();
        tme2.pitch = clientPlayerEntity.method_36455();
        Vec3d vec3d = clientPlayerEntity.method_33571();
        tme2.eyeX = (float)(vec3d.field_1352 - this.tkf.originX);
        tme2.eyeY = (float)(vec3d.field_1351 - this.tkf.originY);
        tme2.eyeZ = (float)(vec3d.field_1350 - this.tkf.originZ);
        tme2.cooldown = clientPlayerEntity.method_7261(0.5f);
        tme2.presses = this.tkk;
        tme2.hitId = this.tkl;
        tme2.hitU = this.tkm;
        tme2.hitV = this.tkn;
        int n2 = Math.min(list.size(), 6);
        tme2.ids = new int[n2];
        tme2.boxes = new float[n2 * 5];
        for (n = 0; n < n2; ++n) {
            Entity entity = list.get(n);
            Box box = entity.method_5829();
            tme2.ids[n] = entity.method_5628() == 0 ? 1 : entity.method_5628();
            tme2.boxes[n * 5] = (float)((box.field_1323 + box.field_1320) * 0.5 - this.tkf.originX);
            tme2.boxes[n * 5 + 1] = (float)(box.field_1322 - this.tkf.originY);
            tme2.boxes[n * 5 + 2] = (float)((box.field_1321 + box.field_1324) * 0.5 - this.tkf.originZ);
            tme2.boxes[n * 5 + 3] = (float)((box.field_1320 - box.field_1323) * 0.5);
            tme2.boxes[n * 5 + 4] = (float)(box.field_1325 - box.field_1322);
        }
        n = this.tkg.size();
        this.tkg.add(tme2);
        ++this.recorded;
        if ((tme2.flags & 4) != 0) {
            this.tku = n;
        }
        if (this.tkl != 0) {
            ++this.hits;
            this.samples += Math.max(0, Math.min(n - this.tku, 60));
            this.tku = n;
            this.tki.clear();
        }
        int n3 = this.tkk - (this.tkl != 0 ? 1 : 0);
        if (this.tkl == 0 && n3 > 0) {
            this.tki.add(n);
        }
        while (!this.tki.isEmpty() && n - this.tki.peekFirst() > 8) {
            this.tku = Math.max(this.tku, this.tki.pollFirst());
            ++this.failures;
        }
        this.tkk = 0;
        this.tkl = 0;
        if (this.tkg.size() - this.tko >= 1200) {
            this.save();
        }
    }

    public void save() {
        if (this.tkg.size() <= this.tko && this.failures == this.tkq && !this.tks) {
            return;
        }
        boolean bl = this.tkg.size() > this.tko || this.tks;
        ArrayList<tme> arrayList = new ArrayList<tme>(this.tkg);
        this.profile.add(a.d("\u9ca1\ue50d\u6fd4\uf1ad\u7a62", 563037651, 962517251), arrayList.size() - this.tko);
        this.profile.add(a.c(1583620581, "\u2189\u5839\ud2f7\u4c81"), this.hits - this.tkp);
        this.profile.add(a.d("\uf231\u8b8f\u0159\u9f30\u14f6\u9250\u2814\ua1e4", -674687841, -1441601856), this.failures - this.tkq);
        this.tko = arrayList.size();
        this.tkp = this.hits;
        this.tkq = this.failures;
        this.profile.save();
        if (bl) {
            tmh tmh2 = new tmh();
            tmh2.created = this.tkf.created;
            tmh2.unit = this.tkf.unit;
            tmh2.originX = this.tkf.originX;
            tmh2.originY = this.tkf.originY;
            tmh2.originZ = this.tkf.originZ;
            tmh2.source = this.tkf.source;
            tmh2.ticks.addAll(arrayList);
            this.profile.putTape(this.tkh, tmh2);
            long l = System.currentTimeMillis();
            if (this.tks || l - this.tkt > 180000L) {
                this.tks = false;
                this.tkt = l;
                this.profile.uploadTape(this.tkh, tmh2);
            }
        }
    }

    public void finish() {
        while (!this.tki.isEmpty()) {
            this.tki.pollFirst();
            ++this.failures;
        }
        if (this.recorded > 0 && !this.tkr) {
            this.tkr = true;
            this.profile.add(a.c(-1345304403, "\u48d6\u3171\ubbb4\u25c5\uae08\u28bf\u92ed\u1b01"), 1L);
        }
        this.tks = this.recorded > 0;
        this.save();
    }

    public int seconds() {
        return this.recorded / 20;
    }

    private static /* synthetic */ int cly(int n, int n2) {
        return n + n2 | 0x9A3B4510;
    }
}

