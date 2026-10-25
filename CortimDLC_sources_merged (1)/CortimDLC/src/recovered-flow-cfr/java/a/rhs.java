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
                if (!(entity instanceof PlayerEntity) && livingEntity.isAlive() && !entity.isRemoved()) break block6;
            }
            return false;
        }
        if (this.rif != this.rhu.version()) {
            this.riq();
        }
        if ((n = Registries.ENTITY_TYPE.getRawId((Object)entity.getType())) < 0 || n >= this.rie.length || !this.rie[n]) {
            return false;
        }
        return !this.rhy.get() || rhs.rir(entity);
    }

    public int colorOf(Entity entity) {
        return this.rhw.get() ? rhs.kindColor(entity) : this.rhx.color() | 0xFF000000;
    }

    private void riq() {
        boolean[] blArray = new boolean[Registries.ENTITY_TYPE.size()];
        for (String string : this.rhu.ids()) {
            int n;
            Identifier identifier = Identifier.tryParse((String)string);
            if (identifier == null || !Registries.ENTITY_TYPE.containsId(identifier) || (n = Registries.ENTITY_TYPE.getRawId((Object)((EntityType)Registries.ENTITY_TYPE.get(identifier)))) < 0 || n >= blArray.length) continue;
            blArray[n] = true;
        }
        this.rie = blArray;
        this.rif = this.rhu.version();
    }

    private static boolean rir(Entity entity) {
        AbstractHorseEntity abstractHorseEntity;
        TameableEntity tameableEntity;
        if (entity instanceof TameableEntity && (tameableEntity = (TameableEntity)entity).isTamed() || entity instanceof AbstractHorseEntity && (abstractHorseEntity = (AbstractHorseEntity)entity).isTame()) {
            return true;
        }
        return entity.hasCustomName() || entity instanceof MobEntity && (tameableEntity = (MobEntity)entity).isLeashed();
    }

    public static int kindColor(Entity entity) {
        EntityType entityType = entity.getType();
        if (entityType == EntityType.VILLAGER || entityType == EntityType.WANDERING_TRADER) {
            return -12723068;
        }
        if (entityType == EntityType.ZOMBIE_VILLAGER) {
            return -6563510;
        }
        if (entityType == EntityType.MAGMA_CUBE) {
            return -48077;
        }
        if (entityType == EntityType.SLIME) {
            return -7607718;
        }
        if (entityType == EntityType.IRON_GOLEM) {
            return -1517372;
        }
        if (entityType == EntityType.SNOW_GOLEM) {
            return -1641217;
        }
        if (entityType == EntityType.BLAZE) {
            return -20163;
        }
        if (entityType == EntityType.WOLF || entityType == EntityType.CAT || entityType == EntityType.OCELOT || entityType == EntityType.FOX) {
            return -15253;
        }
        if (entityType == EntityType.HORSE || entityType == EntityType.DONKEY || entityType == EntityType.MULE || entityType == EntityType.LLAMA || entityType == EntityType.TRADER_LLAMA || entityType == EntityType.CAMEL || entityType == EntityType.SKELETON_HORSE || entityType == EntityType.ZOMBIE_HORSE) {
            return -3632802;
        }
        if (entityType == EntityType.PARROT || entityType == EntityType.ALLAY) {
            return -11544321;
        }
        if (entityType == EntityType.AXOLOTL) {
            return -29992;
        }
        if (entityType == EntityType.BEE) {
            return -11443;
        }
        if (entityType == EntityType.SHULKER || entityType == EntityType.ENDERMAN || entityType == EntityType.ENDERMITE) {
            return -5018625;
        }
        if (entityType == EntityType.PIGLIN || entityType == EntityType.PIGLIN_BRUTE || entityType == EntityType.ZOMBIFIED_PIGLIN) {
            return -11443;
        }
        if (entityType == EntityType.COW || entityType == EntityType.MOOSHROOM) {
            return -4158870;
        }
        if (entityType == EntityType.PIG || entityType == EntityType.HOGLIN) {
            return -25932;
        }
        if (entityType == EntityType.SHEEP || entityType == EntityType.CHICKEN) {
            return -724502;
        }
        if (entityType == EntityType.WITHER || entityType == EntityType.ENDER_DRAGON || entityType == EntityType.WARDEN) {
            return -53910;
        }
        SpawnGroup spawnGroup = entityType.getSpawnGroup();
        return switch (spawnGroup) {
            case SpawnGroup.MONSTER -> -41378;
            case SpawnGroup.CREATURE -> -8587360;
            case SpawnGroup.WATER_CREATURE, SpawnGroup.UNDERGROUND_WATER_CREATURE, SpawnGroup.WATER_AMBIENT, SpawnGroup.AXOLOTLS -> -11691009;
            case SpawnGroup.AMBIENT -> -5197638;
            default -> -1;
        };
    }

    private List<LivingEntity> ris(MinecraftClient minecraftClient, Vec3d vec3d, double d) {
        ArrayList<LivingEntity> arrayList = new ArrayList<LivingEntity>();
        double d2 = d * d;
        for (Entity entity : minecraftClient.world.getEntities()) {
            if (entity == minecraftClient.getCameraEntity() || !this.picks(entity) || !(entity.squaredDistanceTo(vec3d) <= d2)) continue;
            arrayList.add((LivingEntity)entity);
        }
        arrayList.sort((livingEntity, livingEntity2) -> Double.compare(livingEntity.squaredDistanceTo(vec3d), livingEntity2.squaredDistanceTo(vec3d)));
        return arrayList;
    }

    public static void afterExtraction(WorldRenderState worldRenderState) {
        Object object2;
        rhs rhs2 = rht;
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (rhs2 == null || !rhs2.isEnabled() || !rhs2.rhv.is("Outline") || minecraftClient.world == null || minecraftClient.player == null) {
            return;
        }
        Vec3d vec3d = minecraftClient.gameRenderer.getCamera().getCameraPos();
        List<LivingEntity> list = rhs2.ris(minecraftClient, vec3d, rhs2.rhz.get());
        if (list.isEmpty()) {
            return;
        }
        ukl.style(4).set((float)rhs2.ric.get(), (float)rhs2.ria.get(), (float)rhs2.rib.get(), (float)rhs2.rid.get(), 0.4f, 0.6f);
        IdentityHashMap<EntityType, List> identityHashMap = new IdentityHashMap<EntityType, List>();
        for (Object object2 : worldRenderState.entityRenderStates) {
            if (!(object2 instanceof LivingEntityRenderState)) continue;
            LivingEntityRenderState livingEntityRenderState = (LivingEntityRenderState)object2;
            if (object2 instanceof PlayerEntityRenderState || ((EntityRenderState)object2).entityType == null) continue;
            identityHashMap.computeIfAbsent(((EntityRenderState)object2).entityType, entityType -> new ArrayList()).add(livingEntityRenderState);
        }
        float f = minecraftClient.getRenderTickCounter().getTickProgress(true);
        object2 = new IdentityHashMap();
        for (LivingEntity livingEntity : list) {
            List list2 = (List)identityHashMap.get(livingEntity.getType());
            if (list2 == null) continue;
            Vec3d vec3d2 = livingEntity.getLerpedPos(f);
            LivingEntityRenderState livingEntityRenderState = null;
            double d = 0.04;
            for (LivingEntityRenderState livingEntityRenderState2 : list2) {
                double d2 = livingEntityRenderState2.x - vec3d2.x;
                double d3 = livingEntityRenderState2.y - vec3d2.y;
                double d4 = livingEntityRenderState2.z - vec3d2.z;
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
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (rhs2 == null || !rhs2.isEnabled() || !rhs2.rhv.is("Box") || minecraftClient.world == null || minecraftClient.player == null || minecraftClient.options.hudHidden || minecraftClient.currentScreen instanceof hlc) {
            return;
        }
        unf.observe(drawContext);
        if (unf.frame() == rhs2.rig) {
            return;
        }
        rhs2.rig = unf.frame();
        float f = renderTickCounter.getTickProgress(true);
        try {
            usn2 = usn.capture(f, drawContext.getScaledWindowWidth(), drawContext.getScaledWindowHeight());
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
                rhs2.rit(drawContext, usn2, livingEntity, livingEntity.getLerpedPos(f), rhs2.colorOf((Entity)livingEntity));
            }
        }
        finally {
            uut.endBatch();
        }
    }

    private void rit(DrawContext drawContext, usn usn2, LivingEntity livingEntity, Vec3d vec3d, int n) {
        int n2;
        double d = (double)livingEntity.getWidth() * 0.5 + 0.02;
        double d2 = (double)livingEntity.getHeight() + 0.02;
        for (int i = 0; i < 8; ++i) {
            this.rih[i][0] = (i & 1) == 0 ? vec3d.x - d : vec3d.x + d;
            this.rih[i][1] = (i & 2) == 0 ? vec3d.y : vec3d.y + d2;
            this.rih[i][2] = (i & 4) == 0 ? vec3d.z - d : vec3d.z + d;
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
                if (vec3d.y < vec3d2.y) {
                    yield true;
                }
                yield false;
            }
            case 1 -> {
                if (vec3d.y > vec3d2.y + d2) {
                    yield true;
                }
                yield false;
            }
            case 2 -> {
                if (vec3d.z < vec3d2.z - d) {
                    yield true;
                }
                yield false;
            }
            case 3 -> {
                if (vec3d.z > vec3d2.z + d) {
                    yield true;
                }
                yield false;
            }
            case 4 -> {
                if (vec3d.x < vec3d2.x - d) {
                    yield true;
                }
                yield false;
            }
            default -> vec3d.x > vec3d2.x + d;
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

