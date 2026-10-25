/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.render.RenderTickCounter
 *  net.minecraft.client.render.entity.state.EntityRenderState
 *  net.minecraft.client.render.entity.state.PlayerEntityRenderState
 *  net.minecraft.client.render.state.WorldRenderState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 */
package a;

import a.hhf;
import a.hlc;
import a.kfa;
import a.kfe;
import a.ujt;
import a.ukl;
import a.unf;
import a.usn;
import a.uut;
import a.vkl;
import a.vla;
import a.vlv;
import a.vmc;
import a.vyk;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.render.state.WorldRenderState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class rky
extends kfe {
    private static rky rkz;
    private final vlv rla = this.add(new vlv("Mode", "Outline", "Outline", "Box"));
    private final vla rlb = this.add(new vla("Color", "Theme"));
    private final vkl rlc = this.add(new vkl("Friends", true));
    private final vkl rld = this.add(new vkl("Health color", false));
    private final vkl rle = this.add(new vkl("Health bar", true));
    private final vmc rlf = this.add(new vmc("Outline", 1.0, 0.0, 1.0, 0.05).percent());
    private final vmc rlg = this.add(new vmc("Width", 1.5, 0.5, 4.0, 0.1));
    private final vmc rlh = this.add(new vmc("Fill", 0.1, 0.0, 0.6, 0.01).percent());
    private final vmc rli = this.add(new vmc("Glow", 0.5, 0.0, 1.0, 0.05).percent());
    private final vmc rlj = this.add(new vmc("Glow size", 0.5, 0.0, 1.0, 0.05).percent());
    private final vmc rlk = this.add(new vmc("Animation", 1.0, 0.0, 3.0, 0.1).unit("x"));
    private final vmc rll = this.add(new vmc("Range", 128.0, 16.0, 256.0, 8.0).suffix("blocks"));
    private final vkl rlm = this.add(new vkl("Self", false));
    static final int FRIEND = -10686326;
    private long rln = -1L;
    private final float[] rlo = new float[2];
    private final float[] rlp = new float[4];
    private final float[] rlq = new float[2];
    private final double[][] rlr = new double[8][3];
    private final float[][] rls = new float[8][2];
    private final boolean[] rlt = new boolean[8];
    private static final int[][] rlu;
    private static final int[][] rlv;
    private float rlw;
    private float rlx;
    private float rly;
    private float rlz;
    private boolean rma;
    private static /* synthetic */ boolean rmb;
    private static /* synthetic */ boolean rmc;

    public rky() {
        super(new String(new char[]{'P', 'l', 'a', 'y', 'e', 'r', 'E', 'S', 'P'}), "Players through walls: outline or box", kfa.RENDER);
        rkz = this;
        this.rle.visibleWhen(() -> this.rla.is("Box"));
        this.rlf.visibleWhen(() -> this.rla.is("Outline"));
        this.rli.visibleWhen(() -> this.rla.is("Outline"));
        this.rlj.visibleWhen(() -> this.rla.is("Outline") && this.rli.get() > 0.0);
        this.rlk.visibleWhen(() -> this.rla.is("Outline"));
    }

    private boolean rmd(MinecraftClient minecraftClient, PlayerEntity playerEntity) {
        if (playerEntity == minecraftClient.field_1724) {
            return this.rlm.get() && !minecraftClient.field_1690.method_31044().method_31034();
        }
        if (!playerEntity.method_5805() || playerEntity.method_7325() || playerEntity == minecraftClient.method_1560()) {
            return false;
        }
        if (!this.rlc.get() && hhf.isFriend((Entity)playerEntity)) {
            return false;
        }
        double d = this.rll.get();
        return minecraftClient.field_1724.method_5858((Entity)playerEntity) <= d * d;
    }

    private int rme(PlayerEntity playerEntity) {
        if (hhf.isFriend((Entity)playerEntity)) {
            return -10686326;
        }
        int n = this.rlb.color() | 0xFF000000;
        if (this.rld.get()) {
            float f = vyk.of((LivingEntity)playerEntity).fraction();
            return ujt.lerp(-45730, -10686326, f);
        }
        return n;
    }

    public static void afterExtraction(WorldRenderState worldRenderState) {
        rky rky2 = rkz;
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        if (rky2 == null || !rky2.isEnabled() || !rky2.rla.is("Outline") || minecraftClient.field_1687 == null || minecraftClient.field_1724 == null) {
            return;
        }
        ukl.style(0).set((float)rky2.rlh.get(), (float)rky2.rlf.get(), (float)rky2.rlg.get(), (float)rky2.rli.get(), (float)rky2.rlj.get(), (float)rky2.rlk.get());
        int n = rky2.rlb.color() | 0xFF000000;
        int n2 = rky2.rlb.color2() | 0xFF000000;
        boolean bl = rky2.rld.get();
        for (EntityRenderState entityRenderState : worldRenderState.field_61735) {
            PlayerEntity playerEntity;
            if (!(entityRenderState instanceof PlayerEntityRenderState)) continue;
            PlayerEntityRenderState playerEntityRenderState = (PlayerEntityRenderState)entityRenderState;
            Entity entity = minecraftClient.field_1687.method_8469(playerEntityRenderState.field_53528);
            if (!(entity instanceof PlayerEntity) || !rky2.rmd(minecraftClient, playerEntity = (PlayerEntity)entity)) continue;
            boolean bl2 = hhf.isFriend((Entity)playerEntity);
            int n3 = bl2 ? -10686326 : (bl ? ujt.lerp(-45730, -10686326, vyk.of((LivingEntity)playerEntity).fraction()) : n);
            int n4 = bl2 || bl ? ujt.lerp(n3, -1, 0.35f) : n2;
            ukl.paint(entityRenderState, 0, n3, n4);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void render(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        usn usn2;
        rky rky2 = rkz;
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        if (rky2 == null || !rky2.isEnabled() || rky2.rla.is("Outline") || minecraftClient.field_1687 == null || minecraftClient.field_1724 == null || minecraftClient.field_1690.field_1842 || minecraftClient.field_1755 instanceof hlc) {
            return;
        }
        unf.observe(drawContext);
        if (unf.frame() == rky2.rln) {
            return;
        }
        rky2.rln = unf.frame();
        float f = renderTickCounter.method_60637(true);
        try {
            usn2 = usn.capture(f, drawContext.method_51421(), drawContext.method_51443());
        }
        catch (Throwable throwable) {
            return;
        }
        uut.beginFrame();
        uut.beginBatch();
        try {
            for (PlayerEntity playerEntity : minecraftClient.field_1687.method_18456()) {
                if (!rky2.rmd(minecraftClient, playerEntity)) continue;
                Vec3d vec3d = playerEntity.method_30950(f);
                int n = rky2.rme(playerEntity);
                rky2.rmg(drawContext, usn2, playerEntity, vec3d, n);
            }
        }
        finally {
            uut.endBatch();
        }
    }

    private void rmf(double d, double d2, double d3, double d4, double d5) {
        for (int i = 0; i < 8; ++i) {
            this.rlr[i][0] = (i & 1) == 0 ? d - d4 : d + d4;
            this.rlr[i][1] = (i & 2) == 0 ? d2 : d2 + d5;
            this.rlr[i][2] = (i & 4) == 0 ? d3 - d4 : d3 + d4;
        }
    }

    private void rmg(DrawContext drawContext, usn usn2, PlayerEntity playerEntity, Vec3d vec3d, int n) {
        int n2;
        double d = (double)playerEntity.method_17681() * 0.5 + 0.02;
        this.rmf(vec3d.field_1352, vec3d.field_1351, vec3d.field_1350, d, (double)playerEntity.method_17682() + 0.02);
        for (int i = 0; i < 8; ++i) {
            this.rlt[i] = usn2.depth(this.rlr[i][0], this.rlr[i][1], this.rlr[i][2]) > 0.05f && usn2.project(this.rlr[i][0], this.rlr[i][1], this.rlr[i][2], this.rls[i]);
        }
        float f = (float)this.rlh.get();
        if (f > 0.005f) {
            Vec3d vec3d2 = usn2.camera();
            n2 = ujt.withAlpha(n, Math.round(255.0f * f));
            int n3 = ujt.withAlpha(n, Math.round(255.0f * f * 0.25f));
            for (int i = 0; i < 6; ++i) {
                int[] nArray = rlv[i];
                if (!this.rlt[nArray[0]] || !this.rlt[nArray[1]] || !this.rlt[nArray[2]] || !this.rlt[nArray[3]] || !this.rmh(i, vec3d2, vec3d, d, playerEntity.method_17682())) continue;
                uut.quad(drawContext, this.rls[nArray[0]][0], this.rls[nArray[0]][1], (nArray[0] & 2) != 0 ? n2 : n3, this.rls[nArray[1]][0], this.rls[nArray[1]][1], (nArray[1] & 2) != 0 ? n2 : n3, this.rls[nArray[2]][0], this.rls[nArray[2]][1], (nArray[2] & 2) != 0 ? n2 : n3, this.rls[nArray[3]][0], this.rls[nArray[3]][1], (nArray[3] & 2) != 0 ? n2 : n3);
            }
        }
        float f2 = (float)this.rlg.get();
        n2 = ujt.withAlpha(n, 220);
        for (int[] nArray : rlu) {
            double[] dArray = this.rlr[nArray[0]];
            double[] dArray2 = this.rlr[nArray[1]];
            if (!usn2.projectSegment(dArray[0], dArray[1], dArray[2], dArray2[0], dArray2[1], dArray2[2], 0.05f, this.rlp, this.rlq)) continue;
            uut.line(drawContext, this.rlp[0], this.rlp[1], this.rlp[2], this.rlp[3], f2, n2);
        }
        if (this.rle.get()) {
            this.rmi(usn2);
            if (this.rma) {
                this.rmj(drawContext, playerEntity);
            }
        }
    }

    private boolean rmh(int n, Vec3d vec3d, Vec3d vec3d2, double d, double d2) {
        return switch (n) {
            case 0 -> {
                if (vec3d.field_1351 < vec3d2.field_1351) {
                    yield true;
                }
                yield false;
            }
            case 1 -> {
                if (vec3d.field_1351 > vec3d2.field_1351 + d2) {
                    yield true;
                }
                yield false;
            }
            case 2 -> {
                if (vec3d.field_1350 < vec3d2.field_1350 - d) {
                    yield true;
                }
                yield false;
            }
            case 3 -> {
                if (vec3d.field_1350 > vec3d2.field_1350 + d) {
                    yield true;
                }
                yield false;
            }
            case 4 -> {
                if (vec3d.field_1352 < vec3d2.field_1352 - d) {
                    yield true;
                }
                yield false;
            }
            default -> vec3d.field_1352 > vec3d2.field_1352 + d;
        };
    }

    private void rmi(usn usn2) {
        this.rma = false;
        this.rlw = Float.MAX_VALUE;
        this.rlx = Float.MAX_VALUE;
        this.rly = -3.4028235E38f;
        this.rlz = -3.4028235E38f;
        for (int i = 0; i < 8; ++i) {
            if (usn2.depth(this.rlr[i][0], this.rlr[i][1], this.rlr[i][2]) <= 0.05f || !usn2.project(this.rlr[i][0], this.rlr[i][1], this.rlr[i][2], this.rlo)) {
                return;
            }
            this.rlw = Math.min(this.rlw, this.rlo[0]);
            this.rlx = Math.min(this.rlx, this.rlo[1]);
            this.rly = Math.max(this.rly, this.rlo[0]);
            this.rlz = Math.max(this.rlz, this.rlo[1]);
        }
        this.rma = this.rly - this.rlw > 1.0f && this.rlz - this.rlx > 1.0f;
    }

    private void rmj(DrawContext drawContext, PlayerEntity playerEntity) {
        float f = MathHelper.method_15363((float)vyk.of((LivingEntity)playerEntity).fraction(), (float)0.0f, (float)1.0f);
        float f2 = this.rlz - this.rlx;
        float f3 = Math.max(1.5f, Math.min(3.0f, f2 * 0.025f));
        float f4 = this.rlw - f3 - 3.0f;
        uut.round(drawContext, f4 - 0.6f, this.rlx - 0.6f, f3 + 1.2f, f2 + 1.2f, f3 * 0.5f + 0.6f, Integer.MIN_VALUE);
        int n = ujt.lerp(-45730, -10686326, f);
        float f5 = f2 * f;
        uut.round(drawContext, f4, this.rlx + f2 - f5, f3, f5, f3 * 0.5f, n);
    }

    static {
        rlu = new int[][]{{0, 1}, {2, 3}, {4, 5}, {6, 7}, {0, 2}, {1, 3}, {4, 6}, {5, 7}, {0, 4}, {1, 5}, {2, 6}, {3, 7}};
        rlv = new int[][]{{0, 1, 5, 4}, {2, 6, 7, 3}, {0, 2, 3, 1}, {4, 5, 7, 6}, {0, 4, 6, 2}, {1, 3, 7, 5}};
    }

    private static /* synthetic */ int bzo(int n, int n2) {
        return n * n2 + -660459049;
    }

    private static /* synthetic */ int bzp(int n, int n2) {
        return rky.bzo(n, n2) + n;
    }
}

