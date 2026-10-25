/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.render.RenderTickCounter
 *  net.minecraft.client.render.entity.state.EntityRenderState
 *  net.minecraft.client.render.entity.state.LivingEntityRenderState
 *  net.minecraft.client.render.entity.state.PlayerEntityRenderState
 *  net.minecraft.client.render.state.WorldRenderState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SpawnGroup
 *  net.minecraft.entity.mob.MobEntity
 *  net.minecraft.entity.passive.AbstractHorseEntity
 *  net.minecraft.entity.passive.TameableEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.registry.Registries
 *  net.minecraft.util.Identifier
 *  net.minecraft.util.math.Vec3d
 */
package a;

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
import a.vlg;
import a.vlj;
import a.vlv;
import a.vmc;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.render.state.WorldRenderState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

public class rhs
extends kfe {
    private static rhs rht;
    private final vlj rhu = this.add(new vlj("Mobs", vlg.MOBS, "minecraft:villager", "minecraft:zombie_villager", "minecraft:wandering_trader", "minecraft:iron_golem", "minecraft:snow_golem", "minecraft:magma_cube", "minecraft:wolf", "minecraft:cat", "minecraft:horse", "minecraft:donkey", "minecraft:mule", "minecraft:llama", "minecraft:parrot", "minecraft:allay", "minecraft:axolotl", "minecraft:shulker"));
    private final vlv rhv = this.add(new vlv("Mode", "Outline", "Outline", "Box"));
    private final vkl rhw = this.add(new vkl("Mob colors", true));
    private final vla rhx = this.add(new vla("Color", "Theme"));
    private final vkl rhy = this.add(new vkl("Only owned", false));
    private final vmc rhz = this.add(new vmc("Range", 96.0, 16.0, 256.0, 8.0).suffix("blocks"));
    private final vmc ria = this.add(new vmc("Outline", 1.0, 0.0, 1.0, 0.05).percent());
    private final vmc rib = this.add(new vmc("Width", 1.5, 0.5, 4.0, 0.1));
    private final vmc ric = this.add(new vmc("Fill", 0.12, 0.0, 0.6, 0.01).percent());
    private final vmc rid = this.add(new vmc("Glow", 0.4, 0.0, 1.0, 0.05).percent());
    private boolean[] rie = new boolean[0];
    private int rif = -1;
    private long rig = -1L;
    private final double[][] rih = new double[8][3];
    private final float[][] rii = new float[8][2];
    private final boolean[] rij = new boolean[8];
    private final float[] rik = new float[4];
    private final float[] ril = new float[2];
    private static final int[][] rim;
    private static final int[][] rin;
    private static /* synthetic */ boolean rio;
    private static /* synthetic */ String rip;

    public rhs() {
        super(new String(new char[]{'M', 'o', 'b', 'E', 'S', 'P'}), "Chosen mobs through walls, each in its colour", kfa.RENDER);
        rht = this;
        this.rhx.visibleWhen(() -> !this.rhw.get());
        this.ria.visibleWhen(() -> this.rhv.is("Outline"));
        this.rid.visibleWhen(() -> this.rhv.is("Outline"));
    }

    public static rhs get() {
        return rht;
    }

    public boolean picks(Entity entity) {
        int n;
        block6: {
            block5: {
                if (!(entity instanceof LivingEntity)) break block5;
                LivingEntity livingEntity = (LivingEntity)entity;
                if (!(entity instanceof PlayerEntity) && livingEntity.method_5805() && !entity.method_31481()) break block6;
            }
            return false;
        }
        if (this.rif != this.rhu.version()) {
            this.riq();
        }
        if ((n = Registries.field_41177.method_10206((Object)entity.method_5864())) < 0 || n >= this.rie.length || !this.rie[n]) {
            return false;
        }
        return !this.rhy.get() || rhs.rir(entity);
    }

    public int colorOf(Entity entity) {
        return this.rhw.get() ? rhs.kindColor(entity) : this.rhx.color() | 0xFF000000;
    }

    private void riq() {
        boolean[] blArray = new boolean[Registries.field_41177.method_10204()];
        for (String string : this.rhu.ids()) {
            int n;
            Identifier identifier = Identifier.method_12829((String)string);
            if (identifier == null || !Registries.field_41177.method_10250(identifier) || (n = Registries.field_41177.method_10206((Object)((EntityType)Registries.field_41177.method_63535(identifier)))) < 0 || n >= blArray.length) continue;
            blArray[n] = true;
        }
        this.rie = blArray;
        this.rif = this.rhu.version();
    }

    private static boolean rir(Entity entity) {
        AbstractHorseEntity abstractHorseEntity;
        TameableEntity tameableEntity;
        if (entity instanceof TameableEntity && (tameableEntity = (TameableEntity)entity).method_6181() || entity instanceof AbstractHorseEntity && (abstractHorseEntity = (AbstractHorseEntity)entity).method_6727()) {
            return true;
        }
        return entity.method_16914() || entity instanceof MobEntity && (tameableEntity = (MobEntity)entity).method_60953();
    }

    public static int kindColor(Entity entity) {
        EntityType entityType = entity.method_5864();
        if (entityType == EntityType.field_6077 || entityType == EntityType.field_17713) {
            return -12723068;
        }
        if (entityType == EntityType.field_6054) {
            return -6563510;
        }
        if (entityType == EntityType.field_6102) {
            return -48077;
        }
        if (entityType == EntityType.field_6069) {
            return -7607718;
        }
        if (entityType == EntityType.field_6147) {
            return -1517372;
        }
        if (entityType == EntityType.field_6047) {
            return -1641217;
        }
        if (entityType == EntityType.field_6099) {
            return -20163;
        }
        if (entityType == EntityType.field_6055 || entityType == EntityType.field_16281 || entityType == EntityType.field_6081 || entityType == EntityType.field_17943) {
            return -15253;
        }
        if (entityType == EntityType.field_6139 || entityType == EntityType.field_6067 || entityType == EntityType.field_6057 || entityType == EntityType.field_6074 || entityType == EntityType.field_17714 || entityType == EntityType.field_40116 || entityType == EntityType.field_6075 || entityType == EntityType.field_6048) {
            return -3632802;
        }
        if (entityType == EntityType.field_6104 || entityType == EntityType.field_38384) {
            return -11544321;
        }
        if (entityType == EntityType.field_28315) {
            return -29992;
        }
        if (entityType == EntityType.field_20346) {
            return -11443;
        }
        if (entityType == EntityType.field_6109 || entityType == EntityType.field_6091 || entityType == EntityType.field_6128) {
            return -5018625;
        }
        if (entityType == EntityType.field_22281 || entityType == EntityType.field_25751 || entityType == EntityType.field_6050) {
            return -11443;
        }
        if (entityType == EntityType.field_6085 || entityType == EntityType.field_6143) {
            return -4158870;
        }
        if (entityType == EntityType.field_6093 || entityType == EntityType.field_21973) {
            return -25932;
        }
        if (entityType == EntityType.field_6115 || entityType == EntityType.field_6132) {
            return -724502;
        }
        if (entityType == EntityType.field_6119 || entityType == EntityType.field_6116 || entityType == EntityType.field_38095) {
            return -53910;
        }
        SpawnGroup spawnGroup = entityType.method_5891();
        return switch (spawnGroup) {
            case SpawnGroup.field_6302 -> -41378;
            case SpawnGroup.field_6294 -> -8587360;
            case SpawnGroup.field_6300, SpawnGroup.field_30092, SpawnGroup.field_24460, SpawnGroup.field_34447 -> -11691009;
            case SpawnGroup.field_6303 -> -5197638;
            default -> -1;
        };
    }

    private List<LivingEntity> ris(MinecraftClient minecraftClient, Vec3d vec3d, double d) {
        ArrayList<LivingEntity> arrayList = new ArrayList<LivingEntity>();
        double d2 = d * d;
        for (Entity entity : minecraftClient.field_1687.method_18112()) {
            if (entity == minecraftClient.method_1560() || !this.picks(entity) || !(entity.method_5707(vec3d) <= d2)) continue;
            arrayList.add((LivingEntity)entity);
        }
        arrayList.sort((livingEntity, livingEntity2) -> Double.compare(livingEntity.method_5707(vec3d), livingEntity2.method_5707(vec3d)));
        return arrayList;
    }

    public static void afterExtraction(WorldRenderState worldRenderState) {
        Object object2;
        rhs rhs2 = rht;
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        if (rhs2 == null || !rhs2.isEnabled() || !rhs2.rhv.is("Outline") || minecraftClient.field_1687 == null || minecraftClient.field_1724 == null) {
            return;
        }
        Vec3d vec3d = minecraftClient.field_1773.method_19418().method_71156();
        List<LivingEntity> list = rhs2.ris(minecraftClient, vec3d, rhs2.rhz.get());
        if (list.isEmpty()) {
            return;
        }
        ukl.style(4).set((float)rhs2.ric.get(), (float)rhs2.ria.get(), (float)rhs2.rib.get(), (float)rhs2.rid.get(), 0.4f, 0.6f);
        IdentityHashMap<EntityType, List> identityHashMap = new IdentityHashMap<EntityType, List>();
        for (Object object2 : worldRenderState.field_61735) {
            if (!(object2 instanceof LivingEntityRenderState)) continue;
            LivingEntityRenderState livingEntityRenderState = (LivingEntityRenderState)object2;
            if (object2 instanceof PlayerEntityRenderState || ((EntityRenderState)object2).field_58171 == null) continue;
            identityHashMap.computeIfAbsent(((EntityRenderState)object2).field_58171, entityType -> new ArrayList()).add(livingEntityRenderState);
        }
        float f = minecraftClient.method_61966().method_60637(true);
        object2 = new IdentityHashMap();
        for (LivingEntity livingEntity : list) {
            List list2 = (List)identityHashMap.get(livingEntity.method_5864());
            if (list2 == null) continue;
            Vec3d vec3d2 = livingEntity.method_30950(f);
            LivingEntityRenderState livingEntityRenderState = null;
            double d = 0.04;
            for (LivingEntityRenderState livingEntityRenderState2 : list2) {
                double d2 = livingEntityRenderState2.field_53325 - vec3d2.field_1352;
                double d3 = livingEntityRenderState2.field_53326 - vec3d2.field_1351;
                double d4 = livingEntityRenderState2.field_53327 - vec3d2.field_1350;
                double d5 = d2 * d2 + d3 * d3 + d4 * d4;
                if (!(d5 < d) || object2.containsKey(livingEntityRenderState2)) continue;
                d = d5;
                livingEntityRenderState = livingEntityRenderState2;
            }
            if (livingEntityRenderState == null) continue;
            object2.put(livingEntityRenderState, Boolean.TRUE);
            int n = rhs2.colorOf((Entity)livingEntity);
            ukl.paint(livingEntityRenderState, 4, n, ujt.lerp(n, -1, 0.35f));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void render(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        usn usn2;
        rhs rhs2 = rht;
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        if (rhs2 == null || !rhs2.isEnabled() || !rhs2.rhv.is("Box") || minecraftClient.field_1687 == null || minecraftClient.field_1724 == null || minecraftClient.field_1690.field_1842 || minecraftClient.field_1755 instanceof hlc) {
            return;
        }
        unf.observe(drawContext);
        if (unf.frame() == rhs2.rig) {
            return;
        }
        rhs2.rig = unf.frame();
        float f = renderTickCounter.method_60637(true);
        try {
            usn2 = usn.capture(f, drawContext.method_51421(), drawContext.method_51443());
        }
        catch (Throwable throwable) {
            return;
        }
        List<LivingEntity> list = rhs2.ris(minecraftClient, usn2.camera(), rhs2.rhz.get());
        if (list.isEmpty()) {
            return;
        }
        uut.beginFrame();
        uut.beginBatch();
        try {
            for (int i = list.size() - 1; i >= 0; --i) {
                LivingEntity livingEntity = list.get(i);
                rhs2.rit(drawContext, usn2, livingEntity, livingEntity.method_30950(f), rhs2.colorOf((Entity)livingEntity));
            }
        }
        finally {
            uut.endBatch();
        }
    }

    private void rit(DrawContext drawContext, usn usn2, LivingEntity livingEntity, Vec3d vec3d, int n) {
        int n2;
        double d = (double)livingEntity.method_17681() * 0.5 + 0.02;
        double d2 = (double)livingEntity.method_17682() + 0.02;
        for (int i = 0; i < 8; ++i) {
            this.rih[i][0] = (i & 1) == 0 ? vec3d.field_1352 - d : vec3d.field_1352 + d;
            this.rih[i][1] = (i & 2) == 0 ? vec3d.field_1351 : vec3d.field_1351 + d2;
            this.rih[i][2] = (i & 4) == 0 ? vec3d.field_1350 - d : vec3d.field_1350 + d;
            this.rij[i] = usn2.depth(this.rih[i][0], this.rih[i][1], this.rih[i][2]) > 0.05f && usn2.project(this.rih[i][0], this.rih[i][1], this.rih[i][2], this.rii[i]);
        }
        float f = (float)this.ric.get();
        if (f > 0.005f) {
            Vec3d vec3d2 = usn2.camera();
            n2 = ujt.withAlpha(n, Math.round(255.0f * f));
            int n3 = ujt.withAlpha(n, Math.round(255.0f * f * 0.25f));
            for (int i = 0; i < 6; ++i) {
                int[] nArray = rin[i];
                if (!this.rij[nArray[0]] || !this.rij[nArray[1]] || !this.rij[nArray[2]] || !this.rij[nArray[3]] || !rhs.riu(i, vec3d2, vec3d, d, d2)) continue;
                uut.quad(drawContext, this.rii[nArray[0]][0], this.rii[nArray[0]][1], (nArray[0] & 2) != 0 ? n2 : n3, this.rii[nArray[1]][0], this.rii[nArray[1]][1], (nArray[1] & 2) != 0 ? n2 : n3, this.rii[nArray[2]][0], this.rii[nArray[2]][1], (nArray[2] & 2) != 0 ? n2 : n3, this.rii[nArray[3]][0], this.rii[nArray[3]][1], (nArray[3] & 2) != 0 ? n2 : n3);
            }
        }
        float f2 = (float)this.rib.get();
        n2 = ujt.withAlpha(n, 220);
        for (int[] nArray : rim) {
            double[] dArray = this.rih[nArray[0]];
            double[] dArray2 = this.rih[nArray[1]];
            if (!usn2.projectSegment(dArray[0], dArray[1], dArray[2], dArray2[0], dArray2[1], dArray2[2], 0.05f, this.rik, this.ril)) continue;
            uut.line(drawContext, this.rik[0], this.rik[1], this.rik[2], this.rik[3], f2, n2);
        }
    }

    private static boolean riu(int n, Vec3d vec3d, Vec3d vec3d2, double d, double d2) {
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

    static {
        rim = new int[][]{{0, 1}, {2, 3}, {4, 5}, {6, 7}, {0, 2}, {1, 3}, {4, 6}, {5, 7}, {0, 4}, {1, 5}, {2, 6}, {3, 7}};
        rin = new int[][]{{0, 1, 5, 4}, {2, 6, 7, 3}, {0, 2, 3, 1}, {4, 5, 7, 6}, {0, 4, 6, 2}, {1, 3, 7, 5}};
    }

    private static /* synthetic */ int byx(int n, int n2) {
        return n + n2 ^ 0x7E9DFB35;
    }
}

