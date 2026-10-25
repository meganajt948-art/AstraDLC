/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.ShapeContext
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.render.RenderTickCounter
 *  net.minecraft.component.DataComponentTypes
 *  net.minecraft.component.type.ChargedProjectilesComponent
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.projectile.thrown.EnderPearlEntity
 *  net.minecraft.item.BowItem
 *  net.minecraft.item.CrossbowItem
 *  net.minecraft.item.EggItem
 *  net.minecraft.item.EnderPearlItem
 *  net.minecraft.item.ExperienceBottleItem
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.item.SnowballItem
 *  net.minecraft.item.ThrowablePotionItem
 *  net.minecraft.item.TridentItem
 *  net.minecraft.registry.tag.FluidTags
 *  net.minecraft.util.Hand
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Direction$Axis
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.RaycastContext
 *  net.minecraft.world.RaycastContext$FluidHandling
 *  net.minecraft.world.RaycastContext$ShapeType
 *  net.minecraft.world.World
 */
package a;

import a.hlc;
import a.kfa;
import a.kfe;
import a.rmy;
import a.rnb;
import a.ujt;
import a.unf;
import a.usn;
import a.uut;
import a.vdn;
import a.veo;
import a.vkl;
import a.vla;
import a.vxu;
import a.wap;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ChargedProjectilesComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.EggItem;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.ExperienceBottleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SnowballItem;
import net.minecraft.item.ThrowablePotionItem;
import net.minecraft.item.TridentItem;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class rnk
extends kfe {
    private static rnk rnl;
    private final vkl rnm = this.add(new vkl("Pearls", true));
    private final vkl rnn = this.add(new vkl("Bows", true));
    private final vkl rno = this.add(new vkl("Tridents", true));
    private final vkl rnp = this.add(new vkl("Throwables", true));
    private final vkl rnq = this.add(new vkl("Flying pearls", true));
    private final vkl rnr = this.add(new vkl("Path", true));
    private final vkl rns = this.add(new vkl("Time", false));
    private final vla rnt = this.add(new vla("Color", "Theme"));
    private static final int rnu = 240;
    private static final vdn rnv;
    private static final rnb rnw;
    private static final rnb rnx;
    private static final rnb rny;
    private static final rnb rnz;
    private static final float[] roa;
    private final rmy[] rob = new rmy[]{new rmy(), new rmy(), new rmy()};
    private final List<rmy> roc = new ArrayList<rmy>();
    private boolean rod;
    private int roe = 1;
    private final List<EnderPearlEntity> rof = new ArrayList<EnderPearlEntity>();
    private final List<Entity> rog = new ArrayList<Entity>();
    private final List<Box> roh = new ArrayList<Box>();
    private long roi = Long.MIN_VALUE;
    private rnb roj;
    private boolean rok;
    private int rol;
    private long rom = Long.MIN_VALUE;
    private Vec3d ron;
    private Vec3d roo;
    private float rop;
    private float roq;
    private boolean ror;
    private long ros = -1L;
    private final float[] rot = new float[2];
    private final float[] rou = new float[4];
    private final float[] rov = new float[2];
    private static /* synthetic */ long row;
    private static /* synthetic */ String rox;

    public rnk() {
        super(new String(new char[]{'P', 'r', 'e', 'd', 'i', 'c', 't', 'i', 'o', 'n', 's'}), "Where throws and shots will land", kfa.RENDER);
        rnl = this;
    }

    public static void render(DrawContext drawContext, RenderTickCounter renderTickCounter) {
        rnk rnk2 = rnl;
        MinecraftClient minecraftClient = MinecraftClient.method_1551();
        if (rnk2 == null || !rnk2.isEnabled() || minecraftClient.field_1687 == null || minecraftClient.field_1724 == null || minecraftClient.field_1690.field_1842 || minecraftClient.field_1755 instanceof hlc) {
            return;
        }
        unf.observe(drawContext);
        if (unf.frame() == rnk2.ros) {
            return;
        }
        rnk2.ros = unf.frame();
        rnk2.roy(drawContext, minecraftClient, renderTickCounter.method_60637(true));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void roy(DrawContext drawContext, MinecraftClient minecraftClient, float f) {
        usn usn2;
        ClientPlayerEntity clientPlayerEntity = minecraftClient.field_1724;
        long l = minecraftClient.field_1687.method_75260();
        if (l != this.roi) {
            this.roi = l;
            this.rpd(minecraftClient);
        }
        rnb rnb2 = null;
        ItemStack itemStack = ItemStack.field_8037;
        this.rod = false;
        this.roe = 1;
        for (Hand hand : Hand.values()) {
            ItemStack itemStack2 = clientPlayerEntity.method_5998(hand);
            rnb2 = this.rpc(clientPlayerEntity, itemStack2);
            if (rnb2 == null) continue;
            itemStack = itemStack2;
            break;
        }
        if (rnb2 == null && this.roc.isEmpty()) {
            return;
        }
        try {
            usn2 = usn.capture(f, drawContext.method_51421(), drawContext.method_51443());
        }
        catch (Throwable throwable) {
            return;
        }
        uut.beginFrame();
        uut.beginBatch();
        try {
            this.roz(drawContext, minecraftClient, clientPlayerEntity, usn2, rnb2, f);
        }
        finally {
            uut.endBatch();
        }
    }

    private void roz(DrawContext drawContext, MinecraftClient minecraftClient, ClientPlayerEntity clientPlayerEntity, usn usn2, rnb rnb2, float f) {
        int n = this.rnt.color() | 0xFF000000;
        for (rmy rmy2 : this.roc) {
            this.rpg(drawContext, usn2, rmy2, ujt.lerp(n, -1, 0.25f), 0.7f, 0);
        }
        if (rnb2 != null) {
            Vec3d vec3d = clientPlayerEntity.method_5836(f).method_1023(0.0, 0.1, 0.0);
            float f2 = clientPlayerEntity.method_36455();
            float f3 = clientPlayerEntity.method_36454();
            Vec3d vec3d2 = clientPlayerEntity.method_18798();
            boolean bl = Objects.equals(rnb2, this.roj) && this.rok == this.rod && this.rol == this.roe && this.rom == this.roi && vec3d.equals((Object)this.ron) && vec3d2.equals((Object)this.roo) && f2 == this.rop && f3 == this.roq && this.ror == clientPlayerEntity.method_24828();
            this.roj = rnb2;
            this.rok = this.rod;
            this.rol = this.roe;
            this.rom = this.roi;
            this.ron = vec3d;
            this.roo = vec3d2;
            this.rop = f2;
            this.roq = f3;
            this.ror = clientPlayerEntity.method_24828();
            if (bl) {
                for (int i = 0; i < (this.rod ? this.roe : 1); ++i) {
                    this.rpg(drawContext, usn2, this.rob[i], n, i == 0 ? 1.0f : 0.85f, 3);
                }
                return;
            }
            if (this.rod) {
                Vec3d vec3d3 = rnk.rpa(f2, f3);
                Vec3d vec3d4 = rnk.rpa(f2 - 90.0f, f3);
                for (int i = 0; i < this.roe; ++i) {
                    Vec3d vec3d5 = rnk.rpb(vec3d3, vec3d4, roa[i] * ((float)Math.PI / 180));
                    this.rpf((World)minecraftClient.field_1687, (Entity)clientPlayerEntity, vec3d, vec3d5.method_1021(rnb2.rnc), rnb2, this.rob[i]);
                    this.rpg(drawContext, usn2, this.rob[i], n, i == 0 ? 1.0f : 0.85f, 3);
                }
            } else {
                Vec3d vec3d6 = rnk.rpe(f2 + rnb2.rng, f3, f2);
                Vec3d vec3d7 = vec3d6.method_1021(rnb2.rnc);
                vec3d7 = vec3d7.method_1031(vec3d2.field_1352, clientPlayerEntity.method_24828() ? 0.0 : vec3d2.field_1351, vec3d2.field_1350);
                this.rpf((World)minecraftClient.field_1687, (Entity)clientPlayerEntity, vec3d, vec3d7, rnb2, this.rob[0]);
                this.rpg(drawContext, usn2, this.rob[0], n, 1.0f, 3);
            }
        }
    }

    private static Vec3d rpa(float f, float f2) {
        float f3 = (float)Math.PI / 180;
        float f4 = f * f3;
        float f5 = -f2 * f3;
        float f6 = MathHelper.method_15362((double)f5);
        float f7 = MathHelper.method_15374((double)f5);
        float f8 = MathHelper.method_15362((double)f4);
        float f9 = MathHelper.method_15374((double)f4);
        return new Vec3d((double)(f7 * f8), (double)(-f9), (double)(f6 * f8));
    }

    private static Vec3d rpb(Vec3d vec3d, Vec3d vec3d2, float f) {
        if (f == 0.0f) {
            return vec3d;
        }
        double d = Math.cos(f);
        double d2 = Math.sin(f);
        Vec3d vec3d3 = vec3d2.method_1036(vec3d);
        return vec3d.method_1021(d).method_1019(vec3d3.method_1021(d2)).method_1019(vec3d2.method_1021(vec3d2.method_1026(vec3d) * (1.0 - d)));
    }

    private rnb rpc(ClientPlayerEntity clientPlayerEntity, ItemStack itemStack) {
        if (itemStack.method_7960()) {
            return null;
        }
        if (itemStack.method_7909() instanceof BowItem) {
            if (!this.rnn.get() || !clientPlayerEntity.method_6115() || clientPlayerEntity.method_6030() != itemStack) {
                return null;
            }
            float f = BowItem.method_7722((int)clientPlayerEntity.method_6048());
            return f < 0.1f ? null : new rnb((double)f * 3.0, 0.05, 0.99, 0.6, 0.0f, true);
        }
        if (itemStack.method_7909() instanceof CrossbowItem) {
            if (!this.rnn.get() || !CrossbowItem.method_7781((ItemStack)itemStack)) {
                return null;
            }
            ChargedProjectilesComponent chargedProjectilesComponent = (ChargedProjectilesComponent)itemStack.method_58694(DataComponentTypes.field_49649);
            if (chargedProjectilesComponent != null && chargedProjectilesComponent.method_57438(Items.field_8639)) {
                return null;
            }
            this.rod = true;
            this.roe = chargedProjectilesComponent != null && chargedProjectilesComponent.method_57437().size() >= 3 ? 3 : 1;
            return new rnb(3.15, 0.05, 0.99, 0.6, 0.0f, true);
        }
        if (itemStack.method_7909() instanceof TridentItem) {
            return this.rno.get() && clientPlayerEntity.method_6115() && clientPlayerEntity.method_6030() == itemStack ? rnz : null;
        }
        if (itemStack.method_7909() instanceof EnderPearlItem) {
            return this.rnm.get() ? rnw : null;
        }
        if (!this.rnp.get()) {
            return null;
        }
        if (itemStack.method_7909() instanceof SnowballItem || itemStack.method_7909() instanceof EggItem) {
            return rnw;
        }
        if (itemStack.method_7909() instanceof ThrowablePotionItem) {
            return rnx;
        }
        if (itemStack.method_7909() instanceof ExperienceBottleItem) {
            return rny;
        }
        return null;
    }

    private void rpd(MinecraftClient minecraftClient) {
        Object object;
        this.rog.clear();
        this.roh.clear();
        this.rof.clear();
        Box box = minecraftClient.field_1724.method_5829().method_1009(96.0, 64.0, 96.0);
        for (Entity entity : minecraftClient.field_1687.method_8335((Entity)minecraftClient.field_1724, box)) {
            if (entity instanceof LivingEntity && (object = (LivingEntity)entity).method_5805() && !entity.method_7325() && entity.method_5863()) {
                this.rog.add(entity);
                this.roh.add(entity.method_5829().method_1014(0.3));
                continue;
            }
            if (!(entity instanceof EnderPearlEntity)) continue;
            EnderPearlEntity enderPearlEntity = (EnderPearlEntity)entity;
            if (!this.rnq.get() || enderPearlEntity.method_31481()) continue;
            this.rof.add(enderPearlEntity);
        }
        while (this.roc.size() < this.rof.size()) {
            this.roc.add(new rmy());
        }
        while (this.roc.size() > this.rof.size()) {
            this.roc.remove(this.roc.size() - 1);
        }
        for (int i = 0; i < this.rof.size(); ++i) {
            Entity entity;
            entity = this.rof.get(i);
            object = new rnb(0.0, entity.method_56989(), 0.99, 0.8, 0.0f, false);
            this.rpf((World)minecraftClient.field_1687, entity.method_24921(), entity.method_73189(), entity.method_18798(), (rnb)object, this.roc.get(i));
        }
    }

    private static Vec3d rpe(float f, float f2, float f3) {
        float f4 = (float)Math.PI / 180;
        double d = -MathHelper.method_15374((double)(f2 * f4)) * MathHelper.method_15362((double)(f3 * f4));
        double d2 = -MathHelper.method_15374((double)(f * f4));
        double d3 = MathHelper.method_15362((double)(f2 * f4)) * MathHelper.method_15362((double)(f3 * f4));
        return new Vec3d(d, d2, d3).method_1029();
    }

    private void rpf(World world, Entity entity, Vec3d vec3d, Vec3d vec3d2, rnb rnb2, rmy rmy2) {
        rmy2.n = 0;
        rmy2.hit = HitResult.Type.field_1333;
        rmy2.entity = null;
        double d = vec3d.field_1352;
        double d2 = vec3d.field_1351;
        double d3 = vec3d.field_1350;
        double d4 = vec3d2.field_1352;
        double d5 = vec3d2.field_1351;
        double d6 = vec3d2.field_1350;
        rmy2.add(d, d2, d3);
        boolean bl = false;
        int n = world.method_31607() - 32;
        for (int i = 1; i <= 240; ++i) {
            double d7;
            if (!rnb2.rnh) {
                d7 = bl ? rnb2.rnf : rnb2.rne;
                d5 -= rnb2.rnd;
                d4 *= d7;
                d5 *= d7;
                d6 *= d7;
            }
            d7 = d + d4;
            double d8 = d2 + d5;
            double d9 = d3 + d6;
            Vec3d vec3d3 = new Vec3d(d, d2, d3);
            Vec3d vec3d4 = new Vec3d(d7, d8, d9);
            BlockHitResult blockHitResult = world.method_17742(entity == null ? new RaycastContext(vec3d3, vec3d4, RaycastContext.ShapeType.field_17558, RaycastContext.FluidHandling.field_1348, ShapeContext.method_16194()) : new RaycastContext(vec3d3, vec3d4, RaycastContext.ShapeType.field_17558, RaycastContext.FluidHandling.field_1348, entity));
            double d10 = blockHitResult.method_17783() == HitResult.Type.field_1333 ? Double.MAX_VALUE : blockHitResult.method_17784().method_1025(vec3d3);
            Entity entity2 = null;
            Vec3d vec3d5 = null;
            double d11 = Math.min(d, d7);
            double d12 = Math.min(d2, d8);
            double d13 = Math.min(d3, d9);
            double d14 = Math.max(d, d7);
            double d15 = Math.max(d2, d8);
            double d16 = Math.max(d3, d9);
            int n2 = this.rog.size();
            for (int j = 0; j < n2; ++j) {
                double d17;
                Optional optional;
                Entity entity3 = this.rog.get(j);
                if (entity3 == entity && i < 5) continue;
                Box box = this.roh.get(j);
                if (box.field_1320 < d11 || box.field_1323 > d14 || box.field_1325 < d12 || box.field_1322 > d15 || box.field_1324 < d13 || box.field_1321 > d16 || !(optional = box.method_992(vec3d3, vec3d4)).isPresent() || !((d17 = ((Vec3d)optional.get()).method_1025(vec3d3)) < d10)) continue;
                d10 = d17;
                entity2 = entity3;
                vec3d5 = (Vec3d)optional.get();
            }
            if (entity2 != null) {
                rmy2.hit = HitResult.Type.field_1331;
                rmy2.entity = entity2;
                rmy2.hx = vec3d5.field_1352;
                rmy2.hy = vec3d5.field_1351;
                rmy2.hz = vec3d5.field_1350;
                rmy2.add(vec3d5.field_1352, vec3d5.field_1351, vec3d5.field_1350);
                rmy2.ticks = i;
                return;
            }
            if (blockHitResult.method_17783() != HitResult.Type.field_1333) {
                Vec3d vec3d6 = blockHitResult.method_17784();
                rmy2.hit = HitResult.Type.field_1332;
                rmy2.hx = vec3d6.field_1352;
                rmy2.hy = vec3d6.field_1351;
                rmy2.hz = vec3d6.field_1350;
                rmy2.face = blockHitResult.method_17780();
                rmy2.add(vec3d6.field_1352, vec3d6.field_1351, vec3d6.field_1350);
                rmy2.ticks = i;
                return;
            }
            d = d7;
            d2 = d8;
            d3 = d9;
            rmy2.add(d, d2, d3);
            if (rnb2.rnh) {
                double d18 = bl ? rnb2.rnf : rnb2.rne;
                d4 *= d18;
                d5 *= d18;
                d6 *= d18;
                d5 -= rnb2.rnd;
            }
            bl = world.method_8316(BlockPos.method_49637((double)d, (double)d2, (double)d3)).method_15767(FluidTags.field_15517);
            if (!(d2 < (double)n)) continue;
            return;
        }
    }

    private void rpg(DrawContext drawContext, usn usn2, rmy rmy2, int n, float f, int n2) {
        Object object;
        if (rmy2.n < 2) {
            return;
        }
        uut.pushAlpha(f);
        if (this.rnr.get()) {
            this.rph(drawContext, usn2, rmy2, n, n2);
        }
        if (rmy2.hit == HitResult.Type.field_1332) {
            this.rpi(drawContext, usn2, rmy2.hx, rmy2.hy, rmy2.hz, rmy2.face, 0.32, n);
        } else if (rmy2.hit == HitResult.Type.field_1331 && rmy2.entity != null) {
            object = rmy2.entity.method_73189();
            int n3 = ujt.lerp(n, -45730, 0.65f);
            this.rpi(drawContext, usn2, object.field_1352, object.field_1351 + 0.02, object.field_1350, Direction.field_11036, (double)rmy2.entity.method_17681() * 0.5 + 0.25, n3);
        }
        if (this.rns.get() && rmy2.hit != HitResult.Type.field_1333 && usn2.project(rmy2.hx, rmy2.hy, rmy2.hz, this.rot)) {
            object = vxu.fixed((double)rmy2.ticks / 20.0, 1) + wap.unit("s");
            float f2 = rnv.width((String)object);
            rnv.draw(drawContext, (String)object, this.rot[0] - f2 * 0.5f + 0.5f, rnv.centerTop(this.rot[1] + 12.0f) + 0.5f, -1879048192);
            rnv.draw(drawContext, (String)object, this.rot[0] - f2 * 0.5f, rnv.centerTop(this.rot[1] + 12.0f), -268435457);
        }
        uut.popAlpha();
    }

    private void rph(DrawContext drawContext, usn usn2, rmy rmy2, int n, int n2) {
        double[] dArray = rmy2.pts;
        double d = 0.0;
        for (int i = Math.max(1, n2); i < rmy2.n; ++i) {
            double d2 = dArray[(i - 1) * 3];
            double d3 = dArray[(i - 1) * 3 + 1];
            double d4 = dArray[(i - 1) * 3 + 2];
            double d5 = dArray[i * 3];
            double d6 = dArray[i * 3 + 1];
            double d7 = dArray[i * 3 + 2];
            d += Math.sqrt((d5 - d2) * (d5 - d2) + (d6 - d3) * (d6 - d3) + (d7 - d4) * (d7 - d4));
            if (!usn2.projectSegment(d2, d3, d4, d5, d6, d7, 0.2f, this.rou, this.rov)) continue;
            float f = (float)Math.min(1.0, d / 3.0);
            float f2 = usn2.unitsPerBlock(d5, d6, d7);
            float f3 = Math.max(0.9f, Math.min(2.0f, f2 * 0.03f));
            uut.line(drawContext, this.rou[0], this.rou[1], this.rou[2], this.rou[3], f3, ujt.withAlpha(n, Math.round(210.0f * f)));
        }
    }

    private void rpi(DrawContext drawContext, usn usn2, double d, double d2, double d3, Direction direction, double d4, int n) {
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        double d11;
        double d12;
        double d13 = switch (direction.method_10166()) {
            case Direction.Axis.field_11052 -> {
                d12 = 1.0;
                d11 = 0.0;
                d10 = 0.0;
                d9 = 0.0;
                d8 = 0.0;
                yield 1.0;
            }
            case Direction.Axis.field_11051 -> {
                d12 = 1.0;
                d11 = 0.0;
                d10 = 0.0;
                d9 = 0.0;
                d8 = 1.0;
                yield 0.0;
            }
            default -> {
                d12 = 0.0;
                d11 = 0.0;
                d10 = 1.0;
                d9 = 0.0;
                d8 = 1.0;
                yield 0.0;
            }
        };
        float f = usn2.unitsPerBlock(d += (double)direction.method_10148() * 0.01, d2 += (double)direction.method_10164() * 0.01, d3 += (double)direction.method_10165() * 0.01);
        if (f <= 0.0f) {
            return;
        }
        float f2 = Math.max(1.1f, Math.min(3.2f, f * 0.05f));
        int n2 = ujt.withAlpha(n, 235);
        int n3 = 36;
        double d14 = 0.0;
        double d15 = 0.0;
        double d16 = 0.0;
        for (int i = 0; i <= n3; ++i) {
            double d17 = Math.PI * 2 * (double)i / (double)n3;
            d7 = d + (Math.cos(d17) * d12 + Math.sin(d17) * d9) * d4;
            d6 = d2 + (Math.cos(d17) * d11 + Math.sin(d17) * d8) * d4;
            d5 = d3 + (Math.cos(d17) * d10 + Math.sin(d17) * d13) * d4;
            if (i > 0 && usn2.projectSegment(d14, d15, d16, d7, d6, d5, 0.1f, this.rou, this.rov)) {
                uut.line(drawContext, this.rou[0], this.rou[1], this.rou[2], this.rou[3], f2, n2);
            }
            d14 = d7;
            d15 = d6;
            d16 = d5;
        }
        double d18 = d4 * 0.7071;
        for (int i = -1; i <= 1; i += 2) {
            d7 = d + (d12 + d9 * (double)i) * d18;
            d6 = d2 + (d11 + d8 * (double)i) * d18;
            d5 = d3 + (d10 + d13 * (double)i) * d18;
            double d19 = d - (d12 + d9 * (double)i) * d18;
            double d20 = d2 - (d11 + d8 * (double)i) * d18;
            double d21 = d3 - (d10 + d13 * (double)i) * d18;
            if (!usn2.projectSegment(d7, d6, d5, d19, d20, d21, 0.1f, this.rou, this.rov)) continue;
            uut.line(drawContext, this.rou[0], this.rou[1], this.rou[2], this.rou[3], f2, n2);
        }
    }

    static {
        rnv = veo.semibold(6.0f);
        rnw = new rnb(1.5, 0.03, 0.99, 0.8, 0.0f, false);
        rnx = new rnb(0.5, 0.05, 0.99, 0.8, -20.0f, false);
        rny = new rnb(0.7, 0.07, 0.99, 0.8, -20.0f, false);
        rnz = new rnb(2.5, 0.05, 0.99, 0.99, 0.0f, true);
        roa = new float[]{0.0f, -10.0f, 10.0f};
    }

    private static /* synthetic */ int cak(int n, int n2) {
        return n - n2 | 0x1334211B;
    }

    private static /* synthetic */ int cal(int n, int n2) {
        return n - n2 + -287743757;
    }

    private static /* synthetic */ int cam(int n, int n2) {
        return rnk.cal(n, n2) ^ 0xC35EAFF3;
    }
}

