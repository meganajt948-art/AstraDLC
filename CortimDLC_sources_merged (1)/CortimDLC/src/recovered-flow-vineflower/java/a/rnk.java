package a;

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
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;

public class rnk extends kfe {
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
   private static final vdn rnv = veo.semibold(6.0F);
   private static final rnb rnw = new rnb(1.5, 0.03, 0.99, 0.8, 0.0F, false);
   private static final rnb rnx = new rnb(0.5, 0.05, 0.99, 0.8, -20.0F, false);
   private static final rnb rny = new rnb(0.7, 0.07, 0.99, 0.8, -20.0F, false);
   private static final rnb rnz = new rnb(2.5, 0.05, 0.99, 0.99, 0.0F, true);
   private static final float[] roa = new float[]{0.0F, -10.0F, 10.0F};
   private final rmy[] rob = new rmy[]{new rmy(), new rmy(), new rmy()};
   private final List<rmy> roc = new ArrayList<>();
   private boolean rod;
   private int roe = 1;
   private final List<EnderPearlEntity> rof = new ArrayList<>();
   private final List<Entity> rog = new ArrayList<>();
   private final List<Box> roh = new ArrayList<>();
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

   public rnk() {
      super(new String(new char[]{'P', 'r', 'e', 'd', 'i', 'c', 't', 'i', 'o', 'n', 's'}), "Where throws and shots will land", kfa.RENDER);
      rnl = this;
   }

   public static void render(DrawContext var0, RenderTickCounter var1) {
      rnk var2 = rnl;
      MinecraftClient var3 = MinecraftClient.getInstance();
      if (var2 != null && var2.isEnabled() && var3.world != null && var3.player != null && !var3.options.hudHidden && !(var3.currentScreen instanceof hlc)) {
         unf.observe(var0);
         if (unf.frame() != var2.ros) {
            var2.ros = unf.frame();
            var2.roy(var0, var3, var1.getTickProgress(true));
         }
      }
   }

   private void roy(DrawContext var1, MinecraftClient var2, float var3) {
      ClientPlayerEntity var4 = var2.player;
      long var5 = var2.world.getTime();
      if (var5 != this.roi) {
         this.roi = var5;
         this.rpd(var2);
      }

      rnb var7 = null;
      ItemStack var8 = ItemStack.EMPTY;
      this.rod = false;
      this.roe = 1;

      for (Hand var12 : Hand.values()) {
         ItemStack var13 = var4.getStackInHand(var12);
         var7 = this.rpc(var4, var13);
         if (var7 != null) {
            break;
         }
      }

      if (var7 != null || !this.roc.isEmpty()) {
         usn var19;
         try {
            var19 = usn.capture(var3, var1.getScaledWindowWidth(), var1.getScaledWindowHeight());
         } catch (Throwable var18) {
            return;
         }

         uut.beginFrame();
         uut.beginBatch();

         try {
            this.roz(var1, var2, var4, var19, var7, var3);
         } finally {
            uut.endBatch();
         }
      }
   }

   private void roz(DrawContext var1, MinecraftClient var2, ClientPlayerEntity var3, usn var4, rnb var5, float var6) {
      int var7 = this.rnt.color() | 0xFF000000;

      for (rmy var9 : this.roc) {
         this.rpg(var1, var4, var9, ujt.lerp(var7, -1, 0.25F), 0.7F, 0);
      }

      if (var5 != null) {
         Vec3d var17 = var3.getCameraPosVec(var6).subtract(0.0, 0.1, 0.0);
         float var18 = var3.getPitch();
         float var10 = var3.getYaw();
         Vec3d var11 = var3.getVelocity();
         boolean var12 = Objects.equals(var5, this.roj)
            && this.rok == this.rod
            && this.rol == this.roe
            && this.rom == this.roi
            && var17.equals(this.ron)
            && var11.equals(this.roo)
            && var18 == this.rop
            && var10 == this.roq
            && this.ror == var3.isOnGround();
         this.roj = var5;
         this.rok = this.rod;
         this.rol = this.roe;
         this.rom = this.roi;
         this.ron = var17;
         this.roo = var11;
         this.rop = var18;
         this.roq = var10;
         this.ror = var3.isOnGround();
         if (var12) {
            for (int var20 = 0; var20 < (this.rod ? this.roe : 1); var20++) {
               this.rpg(var1, var4, this.rob[var20], var7, var20 == 0 ? 1.0F : 0.85F, 3);
            }

            return;
         }

         if (this.rod) {
            Vec3d var13 = rpa(var18, var10);
            Vec3d var14 = rpa(var18 - 90.0F, var10);

            for (int var15 = 0; var15 < this.roe; var15++) {
               Vec3d var16 = rpb(var13, var14, roa[var15] * (float) (Math.PI / 180.0));
               this.rpf(var2.world, var3, var17, var16.multiply(var5.rnc), var5, this.rob[var15]);
               this.rpg(var1, var4, this.rob[var15], var7, var15 == 0 ? 1.0F : 0.85F, 3);
            }
         } else {
            Vec3d var19 = rpe(var18 + var5.rng, var10, var18);
            Vec3d var21 = var19.multiply(var5.rnc);
            var21 = var21.add(var11.x, var3.isOnGround() ? 0.0 : var11.y, var11.z);
            this.rpf(var2.world, var3, var17, var21, var5, this.rob[0]);
            this.rpg(var1, var4, this.rob[0], var7, 1.0F, 3);
         }
      }
   }

   private static Vec3d rpa(float var0, float var1) {
      float var2 = (float) (Math.PI / 180.0);
      float var3 = var0 * var2;
      float var4 = -var1 * var2;
      float var5 = MathHelper.cos(var4);
      float var6 = MathHelper.sin(var4);
      float var7 = MathHelper.cos(var3);
      float var8 = MathHelper.sin(var3);
      return new Vec3d(var6 * var7, -var8, var5 * var7);
   }

   private static Vec3d rpb(Vec3d var0, Vec3d var1, float var2) {
      if (var2 == 0.0F) {
         return var0;
      }

      double var3 = Math.cos(var2);
      double var5 = Math.sin(var2);
      Vec3d var7 = var1.crossProduct(var0);
      return var0.multiply(var3).add(var7.multiply(var5)).add(var1.multiply(var1.dotProduct(var0) * (1.0 - var3)));
   }

   private rnb rpc(ClientPlayerEntity var1, ItemStack var2) {
      if (var2.isEmpty()) {
         return null;
      }

      if (var2.getItem() instanceof BowItem) {
         if (this.rnn.get() && var1.isUsingItem() && var1.getActiveItem() == var2) {
            float var4 = BowItem.getPullProgress(var1.getItemUseTime());
            return var4 < 0.1F ? null : new rnb(var4 * 3.0, 0.05, 0.99, 0.6, 0.0F, true);
         } else {
            return null;
         }
      } else if (var2.getItem() instanceof CrossbowItem) {
         if (this.rnn.get() && CrossbowItem.isCharged(var2)) {
            ChargedProjectilesComponent var3 = var2.get(DataComponentTypes.CHARGED_PROJECTILES);
            if (var3 != null && var3.contains(Items.FIREWORK_ROCKET)) {
               return null;
            }

            this.rod = true;
            this.roe = var3 != null && var3.getProjectiles().size() >= 3 ? 3 : 1;
            return new rnb(3.15, 0.05, 0.99, 0.6, 0.0F, true);
         } else {
            return null;
         }
      } else if (!(var2.getItem() instanceof TridentItem)) {
         if (var2.getItem() instanceof EnderPearlItem) {
            return this.rnm.get() ? rnw : null;
         } else if (!this.rnp.get()) {
            return null;
         } else if (var2.getItem() instanceof SnowballItem || var2.getItem() instanceof EggItem) {
            return rnw;
         } else if (var2.getItem() instanceof ThrowablePotionItem) {
            return rnx;
         } else {
            return var2.getItem() instanceof ExperienceBottleItem ? rny : null;
         }
      } else {
         return this.rno.get() && var1.isUsingItem() && var1.getActiveItem() == var2 ? rnz : null;
      }
   }

   private void rpd(MinecraftClient var1) {
      this.rog.clear();
      this.roh.clear();
      this.rof.clear();
      Box var2 = var1.player.getBoundingBox().expand(96.0, 64.0, 96.0);

      for (Entity var4 : var1.world.getOtherEntities(var1.player, var2)) {
         if (var4 instanceof LivingEntity var5 && var5.isAlive() && !var4.isSpectator() && var4.canHit()) {
            this.rog.add(var4);
            this.roh.add(var4.getBoundingBox().expand(0.3));
         } else if (var4 instanceof EnderPearlEntity var6 && this.rnq.get() && !var6.isRemoved()) {
            this.rof.add(var6);
         }
      }

      while (this.roc.size() < this.rof.size()) {
         this.roc.add(new rmy());
      }

      while (this.roc.size() > this.rof.size()) {
         this.roc.remove(this.roc.size() - 1);
      }

      for (int var7 = 0; var7 < this.rof.size(); var7++) {
         EnderPearlEntity var8 = this.rof.get(var7);
         rnb var9 = new rnb(0.0, var8.getFinalGravity(), 0.99, 0.8, 0.0F, false);
         this.rpf(var1.world, var8.getOwner(), var8.getEntityPos(), var8.getVelocity(), var9, this.roc.get(var7));
      }
   }

   private static Vec3d rpe(float var0, float var1, float var2) {
      float var3 = (float) (Math.PI / 180.0);
      double var4 = -MathHelper.sin(var1 * var3) * MathHelper.cos(var2 * var3);
      double var6 = -MathHelper.sin(var0 * var3);
      double var8 = MathHelper.cos(var1 * var3) * MathHelper.cos(var2 * var3);
      return new Vec3d(var4, var6, var8).normalize();
   }

   private void rpf(World var1, Entity var2, Vec3d var3, Vec3d var4, rnb var5, rmy var6) {
      var6.n = 0;
      var6.hit = Type.MISS;
      var6.entity = null;
      double var7 = var3.x;
      double var9 = var3.y;
      double var11 = var3.z;
      double var13 = var4.x;
      double var15 = var4.y;
      double var17 = var4.z;
      var6.add(var7, var9, var11);
      boolean var19 = false;
      int var20 = var1.getBottomY() - 32;

      for (int var21 = 1; var21 <= 240; var21++) {
         if (!var5.rnh) {
            double var22 = var19 ? var5.rnf : var5.rne;
            var15 -= var5.rnd;
            var13 *= var22;
            var15 *= var22;
            var17 *= var22;
         }

         double var56 = var7 + var13;
         double var24 = var9 + var15;
         double var26 = var11 + var17;
         Vec3d var28 = new Vec3d(var7, var9, var11);
         Vec3d var29 = new Vec3d(var56, var24, var26);
         BlockHitResult var30 = var1.raycast(
            var2 == null
               ? new RaycastContext(var28, var29, ShapeType.COLLIDER, FluidHandling.NONE, ShapeContext.absent())
               : new RaycastContext(var28, var29, ShapeType.COLLIDER, FluidHandling.NONE, var2)
         );
         double var31 = var30.getType() == Type.MISS ? Double.MAX_VALUE : var30.getPos().squaredDistanceTo(var28);
         Entity var33 = null;
         Vec3d var34 = null;
         double var35 = Math.min(var7, var56);
         double var37 = Math.min(var9, var24);
         double var39 = Math.min(var11, var26);
         double var41 = Math.max(var7, var56);
         double var43 = Math.max(var9, var24);
         double var45 = Math.max(var11, var26);
         int var47 = 0;

         for (int var48 = this.rog.size(); var47 < var48; var47++) {
            Entity var49 = this.rog.get(var47);
            if (var49 != var2 || var21 >= 5) {
               Box var50 = this.roh.get(var47);
               if (!(var50.maxX < var35)
                  && !(var50.minX > var41)
                  && !(var50.maxY < var37)
                  && !(var50.minY > var43)
                  && !(var50.maxZ < var39)
                  && !(var50.minZ > var45)) {
                  Optional var51 = var50.raycast(var28, var29);
                  if (var51.isPresent()) {
                     double var52 = ((Vec3d)var51.get()).squaredDistanceTo(var28);
                     if (var52 < var31) {
                        var31 = var52;
                        var33 = var49;
                        var34 = (Vec3d)var51.get();
                     }
                  }
               }
            }
         }

         if (var33 != null) {
            var6.hit = Type.ENTITY;
            var6.entity = var33;
            var6.hx = var34.x;
            var6.hy = var34.y;
            var6.hz = var34.z;
            var6.add(var34.x, var34.y, var34.z);
            var6.ticks = var21;
            return;
         }

         if (var30.getType() != Type.MISS) {
            Vec3d var58 = var30.getPos();
            var6.hit = Type.BLOCK;
            var6.hx = var58.x;
            var6.hy = var58.y;
            var6.hz = var58.z;
            var6.face = var30.getSide();
            var6.add(var58.x, var58.y, var58.z);
            var6.ticks = var21;
            return;
         }

         var7 = var56;
         var9 = var24;
         var11 = var26;
         var6.add(var7, var9, var11);
         if (var5.rnh) {
            double var57 = var19 ? var5.rnf : var5.rne;
            var13 *= var57;
            var15 *= var57;
            var17 *= var57;
            var15 -= var5.rnd;
         }

         var19 = var1.getFluidState(BlockPos.ofFloored(var7, var9, var11)).isIn(FluidTags.WATER);
         if (var9 < var20) {
            return;
         }
      }
   }

   private void rpg(DrawContext var1, usn var2, rmy var3, int var4, float var5, int var6) {
      if (var3.n >= 2) {
         uut.pushAlpha(var5);
         if (this.rnr.get()) {
            this.rph(var1, var2, var3, var4, var6);
         }

         if (var3.hit == Type.BLOCK) {
            this.rpi(var1, var2, var3.hx, var3.hy, var3.hz, var3.face, 0.32, var4);
         } else if (var3.hit == Type.ENTITY && var3.entity != null) {
            Vec3d var7 = var3.entity.getEntityPos();
            int var8 = ujt.lerp(var4, -45730, 0.65F);
            this.rpi(var1, var2, var7.x, var7.y + 0.02, var7.z, Direction.UP, var3.entity.getWidth() * 0.5 + 0.25, var8);
         }

         if (this.rns.get() && var3.hit != Type.MISS && var2.project(var3.hx, var3.hy, var3.hz, this.rot)) {
            String var9 = vxu.fixed(var3.ticks / 20.0, 1) + wap.unit("s");
            float var10 = rnv.width(var9);
            rnv.draw(var1, var9, this.rot[0] - var10 * 0.5F + 0.5F, rnv.centerTop(this.rot[1] + 12.0F) + 0.5F, -1879048192);
            rnv.draw(var1, var9, this.rot[0] - var10 * 0.5F, rnv.centerTop(this.rot[1] + 12.0F), -268435457);
         }

         uut.popAlpha();
      }
   }

   private void rph(DrawContext var1, usn var2, rmy var3, int var4, int var5) {
      double[] var6 = var3.pts;
      double var7 = 0.0;

      for (int var9 = Math.max(1, var5); var9 < var3.n; var9++) {
         double var10 = var6[(var9 - 1) * 3];
         double var12 = var6[(var9 - 1) * 3 + 1];
         double var14 = var6[(var9 - 1) * 3 + 2];
         double var16 = var6[var9 * 3];
         double var18 = var6[var9 * 3 + 1];
         double var20 = var6[var9 * 3 + 2];
         var7 += Math.sqrt((var16 - var10) * (var16 - var10) + (var18 - var12) * (var18 - var12) + (var20 - var14) * (var20 - var14));
         if (var2.projectSegment(var10, var12, var14, var16, var18, var20, 0.2F, this.rou, this.rov)) {
            float var22 = (float)Math.min(1.0, var7 / 3.0);
            float var23 = var2.unitsPerBlock(var16, var18, var20);
            float var24 = Math.max(0.9F, Math.min(2.0F, var23 * 0.03F));
            uut.line(var1, this.rou[0], this.rou[1], this.rou[2], this.rou[3], var24, ujt.withAlpha(var4, Math.round(210.0F * var22)));
         }
      }
   }

   // $VF: Unable to simplify switch on enum
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void rpi(DrawContext var1, usn var2, double var3, double var5, double var7, Direction var9, double var10, int var12) {
      double var13;
      double var15;
      double var17;
      double var19;
      double var21;
      double var23;
      switch (var9.getAxis()) {
         case Y:
            var13 = 1.0;
            var15 = 0.0;
            var17 = 0.0;
            var19 = 0.0;
            var21 = 0.0;
            var23 = 1.0;
            break;
         case Z:
            var13 = 1.0;
            var15 = 0.0;
            var17 = 0.0;
            var19 = 0.0;
            var21 = 1.0;
            var23 = 0.0;
            break;
         default:
            var13 = 0.0;
            var15 = 0.0;
            var17 = 1.0;
            var19 = 0.0;
            var21 = 1.0;
            var23 = 0.0;
      }

      var3 += var9.getOffsetX() * 0.01;
      var5 += var9.getOffsetY() * 0.01;
      var7 += var9.getOffsetZ() * 0.01;
      float var25 = var2.unitsPerBlock(var3, var5, var7);
      if (!(var25 <= 0.0F)) {
         float var26 = Math.max(1.1F, Math.min(3.2F, var25 * 0.05F));
         int var27 = ujt.withAlpha(var12, 235);
         byte var28 = 36;
         double var29 = 0.0;
         double var31 = 0.0;
         double var33 = 0.0;

         for (int var35 = 0; var35 <= var28; var35++) {
            double var36 = (Math.PI * 2) * var35 / var28;
            double var38 = var3 + (Math.cos(var36) * var13 + Math.sin(var36) * var19) * var10;
            double var40 = var5 + (Math.cos(var36) * var15 + Math.sin(var36) * var21) * var10;
            double var42 = var7 + (Math.cos(var36) * var17 + Math.sin(var36) * var23) * var10;
            if (var35 > 0 && var2.projectSegment(var29, var31, var33, var38, var40, var42, 0.1F, this.rou, this.rov)) {
               uut.line(var1, this.rou[0], this.rou[1], this.rou[2], this.rou[3], var26, var27);
            }

            var29 = var38;
            var31 = var40;
            var33 = var42;
         }

         double var53 = var10 * 0.7071;

         for (byte var37 = -1; var37 <= 1; var37 += 2) {
            double var54 = var3 + (var13 + var19 * var37) * var53;
            double var55 = var5 + (var15 + var21 * var37) * var53;
            double var56 = var7 + (var17 + var23 * var37) * var53;
            double var44 = var3 - (var13 + var19 * var37) * var53;
            double var46 = var5 - (var15 + var21 * var37) * var53;
            double var48 = var7 - (var17 + var23 * var37) * var53;
            if (var2.projectSegment(var54, var55, var56, var44, var46, var48, 0.1F, this.rou, this.rov)) {
               uut.line(var1, this.rou[0], this.rou[1], this.rou[2], this.rou[3], var26, var27);
            }
         }
      }
   }
}
