package a;

import com.mojang.blaze3d.textures.GpuTextureView;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntityStatusS2CPacket;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class rrx extends kfe {
   private static rrx rry;
   private final vlv rrz = this.add(new vlv("Style", "Angel", "Angel", "Glass"));
   private final vkl rsa = this.add(new vkl("On kill", true));
   private final vkl rsb = this.add(new vkl("On totem pop", true));
   private final vkl rsc = this.add(new vkl("Only my targets", true));
   private final vkl rsd = this.add(new vkl("Mobs", false));
   private final vla rse = this.add(new vla("Color", "Ice"));
   private final vla rsf = this.add(new vla("Totem color", "Gold"));
   private final vmc rsg = this.add(new vmc("Size", 1.0, 0.6, 1.6, 0.05).percent());
   private final vmc rsh = this.add(new vmc("Duration", 3.0, 1.5, 5.0, 0.1).suffix("s"));
   private final vkl rsi = this.add(new vkl("Wings", true));
   private final vkl rsj = this.add(new vkl("Halo", true));
   private final vlv rsk = this.add(new vlv("Pieces", "Shards", "Shards", "Cubes"));
   private final vkl rsl = this.add(new vkl("Sound", true));
   private final vkl rsm = this.add(new vkl("Particles", true));
   private static final long rsn = 12000L;
   private static final int rso = 6;
   private static final float rsp = (float) (Math.PI * 2);
   private static final float rsq = 0.0625F;
   private static final Queue<rrj> rsr = new ConcurrentLinkedQueue<>();
   private static final Map<Integer, Long> rss = new HashMap<>();
   private final List<rru> rst = new ArrayList<>();
   private long rsu = -1L;
   private float rsv;
   private static final int rsw = 4;
   private final List<rrj> rsx = new ArrayList<>();
   private final List<sql> rsy = new ArrayList<>();
   private final List<uwg> rsz = new ArrayList<>();
   private final Matrix4f rta = new Matrix4f();
   private final Quaternionf rtb = new Quaternionf();
   private final Random rtc = new Random();
   private final double[] rtd = new double[6];
   private long rte;
   private final Matrix4f rtf = new Matrix4f();
   private final Vector3f rtg = new Vector3f();
   private final float[][] rth = new float[8][2];
   private final boolean[] rti = new boolean[8];
   private final double[][] rtj = new double[8][3];
   private final float[] rtk = new float[2];
   private final float[] rtl = new float[2];
   private final float[] rtm = new float[2];
   private final float[] rtn = new float[2];
   private final int[] rto = new int[4];
   private final float[][] rtp;
   private final boolean[] rtq;
   private static final float[][] rtr = new float[][]{
      {0.1F, 0.28F},
      {0.28F, 0.55F},
      {0.5F, 0.78F},
      {0.74F, 0.92F},
      {0.98F, 0.96F},
      {1.16F, 0.86F},
      {1.1F, 0.66F},
      {1.2F, 0.52F},
      {1.06F, 0.4F},
      {1.12F, 0.24F},
      {0.94F, 0.16F},
      {0.96F, -0.02F},
      {0.78F, -0.02F},
      {0.76F, -0.22F},
      {0.58F, -0.16F},
      {0.52F, -0.36F},
      {0.36F, -0.22F},
      {0.26F, -0.4F},
      {0.12F, -0.14F}
   };
   private static final int[][] rts = new int[][]{{0, 1, 5, 4}, {2, 6, 7, 3}, {0, 2, 3, 1}, {4, 5, 7, 6}, {0, 4, 6, 2}, {1, 3, 7, 5}};
   private static final float[][] rtt = new float[][]{
      {0.0F, -1.0F, 0.0F}, {0.0F, 1.0F, 0.0F}, {0.0F, 0.0F, -1.0F}, {0.0F, 0.0F, 1.0F}, {-1.0F, 0.0F, 0.0F}, {1.0F, 0.0F, 0.0F}
   };

   public rrx() {
      super(new String(new char[]{'S', 'o', 'u', 'l', 'E', 'S', 'P'}), "A soul or glass copy on a kill", kfa.RENDER);
      this.rtp = new float[rtr.length][2];
      this.rtq = new boolean[rtr.length];
      rry = this;
      wcn.listen(rrx::rtw);
      this.rsf.visibleWhen(this.rsb::get);
      this.rsg.visibleWhen(() -> this.rrz.is("Angel"));
      this.rsh.visibleWhen(() -> this.rrz.is("Angel"));
      this.rsi.visibleWhen(() -> this.rrz.is("Angel"));
      this.rsj.visibleWhen(() -> this.rrz.is("Angel"));
      this.rsk.visibleWhen(() -> this.rrz.is("Glass"));
      this.rsl.visibleWhen(() -> this.rrz.is("Glass"));
      this.rsm.visibleWhen(() -> this.rrz.is("Glass"));
   }

   public static int activeGlass() {
      return rry == null ? 0 : rry.rsy.size();
   }

   public static void trigger(LivingEntity var0, boolean var1) {
      if (rry != null && rry.isEnabled()) {
         rsr.add(new rrj(var0.getId(), var0.getX(), var0.getY(), var0.getZ(), var0.bodyYaw, var0.getHeight(), var0 instanceof PlayerEntity, var1));
      }
   }

   public static void onAttack(Entity var0) {
      if (rry != null && rry.isEnabled()) {
         rss.put(var0.getId(), System.currentTimeMillis());
      }
   }

   private static void rtw(Packet<?> var0) {
      rrx var1 = rry;
      if (var1 != null && var1.isEnabled() && var0 instanceof EntityStatusS2CPacket var2) {
         byte var3 = var2.getStatus();
         if (var3 == 3 || var3 == 35) {
            ClientWorld var4 = MinecraftClient.getInstance().world;
            if (var4 != null) {
               Entity var5 = var2.getEntity(var4);
               if (var5 instanceof LivingEntity var6 && var5 != MinecraftClient.getInstance().player) {
                  rsr.add(
                     new rrj(var5.getId(), var5.getX(), var5.getY(), var5.getZ(), var6.bodyYaw, var5.getHeight(), var5 instanceof PlayerEntity, var3 == 35)
                  );
                  if (rsr.size() > 32) {
                     rsr.poll();
                  }
               }
            }
         }
      }
   }

   @Override
   protected void onDisable() {
      this.rst.clear();
      rsr.clear();
      rss.clear();
      this.rsx.clear();
      this.rsy.clear();
      this.rte = 0L;
      uwt.release();
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      wcn.ensure(var1);
      long var2 = System.currentTimeMillis();
      rss.values().removeIf(var2x -> var2 - var2x > 12000L);

      rrj var4;
      while ((var4 = rsr.poll()) != null) {
         if ((var4.rrr ? this.rsb.get() : this.rsa.get()) && (var4.rrq || this.rsd.get()) && (!this.rsc.get() || rss.containsKey(var4.rrk))) {
            if (this.rrz.is("Glass")) {
               if (this.rsx.size() < 8) {
                  this.rsx.add(var4);
               }
            } else {
               if (this.rst.size() >= 6) {
                  this.rst.remove(0);
               }

               rru var5 = new rru();
               var5.x = var4.rrl;
               var5.y = var4.rrm;
               var5.z = var4.rrn;
               var5.yaw = var4.rro;
               var5.scale = (float)this.rsg.get() * Math.max(0.5F, Math.min(1.4F, var4.rrp / 1.8F));
               var5.totem = var4.rrr;
               var5.seed = (float)(Math.random() * 100.0);
               this.rst.add(var5);
            }
         }
      }
   }

   @Override
   public void onWorldRenderLate(MinecraftClient var1) {
      if (this.rsx.isEmpty() && this.rsy.isEmpty()) {
         this.rte = 0L;
      } else {
         ClientWorld var2 = var1.world;
         if (var2 != null && var1.player != null) {
            long var3 = System.nanoTime();
            float var5 = this.rte == 0L ? 0.0F : Math.min(0.1F, (float)(var3 - this.rte) / 1.0E9F);
            this.rte = var3;
            float var6 = var1.getRenderTickCounter().getTickProgress(false);

            for (rrj var8 : this.rsx) {
               Entity var9 = var2.getEntityById(var8.rrk);
               int var10 = (var8.rrr ? this.rsf : this.rse).color();
               sql var11 = sql.create(
                  var1,
                  var9 instanceof LivingEntity var12 ? var12 : null,
                  var8.rrl,
                  var8.rrm,
                  var8.rrn,
                  var8.rro,
                  var8.rrp,
                  var8.rrq,
                  var8.rrr,
                  this.rsk.is("Cubes"),
                  var10,
                  var6
               );
               if (this.rsy.size() >= 4) {
                  this.rsy.remove(0);
               }

               this.rsy.add(var11);
            }

            this.rsx.clear();
            int var15 = 0;

            for (int var16 = this.rsy.size() - 1; var16 >= 0; var16--) {
               sql var18 = this.rsy.get(var16);
               if (!var18.update(var5)) {
                  this.rsy.remove(var16);
               } else {
                  this.rtx(var2, var18);
                  var15 += var18.vertices();
               }
            }

            if (!this.rsy.isEmpty()) {
               Camera var17 = var1.gameRenderer.getCamera();
               Vec3d var19 = var17.getCameraPos();
               ByteBuffer var20 = uwt.staging(var15);
               this.rsz.clear();
               int var21 = 0;

               for (sql var13 : this.rsy) {
                  int var14 = var13.write(var20, var19.x, var19.y, var19.z);
                  this.rsz
                     .add(
                        new uwg(
                           var21,
                           var14,
                           var13.red,
                           var13.green,
                           var13.blue,
                           var13.alpha(),
                           (float)(var13.y + var13.scan() - var19.y),
                           (float)(var13.y + var13.sweep() - var19.y),
                           var13.flash(),
                           var13.broken()
                        )
                     );
                  var21 += var14;
               }

               this.rta.rotation(var17.getRotation().conjugate(this.rtb));
               uwt.draw(this.rta, 0.36F, 0.86F, 0.36F, 1.0F, this.rsz, var20);
            }
         } else {
            this.rsx.clear();
            this.rsy.clear();
         }
      }
   }

   private void rtx(ClientWorld var1, sql var2) {
      int var3 = var2.takeEvents();
      if (var3 != 0) {
         double var4 = var2.centerX();
         double var6 = var2.centerY();
         double var8 = var2.centerZ();
         if (this.rsl.get()) {
            if ((var3 & 1) != 0) {
               var1.playSoundClient(var4, var6, var8, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.PLAYERS, 0.9F, 1.4F, false);
            }

            if ((var3 & 2) != 0) {
               if (var2.totem) {
                  var1.playSoundClient(var4, var6, var8, SoundEvents.BLOCK_AMETHYST_CLUSTER_BREAK, SoundCategory.PLAYERS, 0.9F, 1.2F, false);
               } else {
                  var1.playSoundClient(var4, var6, var8, SoundEvents.BLOCK_GLASS_HIT, SoundCategory.PLAYERS, 0.8F, 0.7F, false);
               }
            }

            if ((var3 & 4) != 0) {
               if (var2.totem) {
                  var1.playSoundClient(var4, var6, var8, SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.PLAYERS, 0.35F, 1.6F, false);
               } else {
                  var1.playSoundClient(
                     var4, var6, var8, SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.PLAYERS, 1.0F, 0.92F + this.rtc.nextFloat() * 0.14F, false
                  );
                  var1.playSoundClient(var4, var6, var8, SoundEvents.BLOCK_AMETHYST_BLOCK_BREAK, SoundCategory.PLAYERS, 0.5F, 1.35F, false);
               }
            }
         }

         if (this.rsm.get() && (var3 & 4) != 0) {
            BlockStateParticleEffect var10 = new BlockStateParticleEffect(ParticleTypes.BLOCK, Blocks.GLASS.getDefaultState());
            int var11 = var2.totem ? 8 : 40;

            for (int var12 = 0; var12 < var11; var12++) {
               if (var2.sample(this.rtc, this.rtd)) {
                  var1.addParticleClient(var10, this.rtd[0], this.rtd[1], this.rtd[2], this.rtd[3] * 0.3, this.rtd[4] * 0.3, this.rtd[5] * 0.3);
               }
            }

            int var14 = var2.totem ? 5 : 14;

            for (int var13 = 0; var13 < var14; var13++) {
               var1.addParticleClient(
                  ParticleTypes.END_ROD,
                  var4 + (this.rtc.nextDouble() - 0.5) * 0.6,
                  var6 + (this.rtc.nextDouble() - 0.5) * 1.4,
                  var8 + (this.rtc.nextDouble() - 0.5) * 0.6,
                  (this.rtc.nextDouble() - 0.5) * 0.12,
                  this.rtc.nextDouble() * 0.08,
                  (this.rtc.nextDouble() - 0.5) * 0.12
               );
            }
         }
      }
   }

   public static void render(DrawContext var0, RenderTickCounter var1) {
      rrx var2 = rry;
      MinecraftClient var3 = MinecraftClient.getInstance();
      if (var2 != null && var2.isEnabled() && !var2.rst.isEmpty() && var3.world != null && !var3.options.hudHidden && !(var3.currentScreen instanceof hlc)) {
         unf.observe(var0);
         if (unf.frame() != var2.rsu) {
            var2.rsu = unf.frame();
            float var4 = unf.delta();
            var2.rsv += var4;

            usn var5;
            try {
               var5 = usn.capture(var1.getTickProgress(true), var0.getScaledWindowWidth(), var0.getScaledWindowHeight());
            } catch (Throwable var12) {
               return;
            }

            float var6 = (float)var2.rsh.get();
            uut.beginFrame();

            try {
               for (int var7 = var2.rst.size() - 1; var7 >= 0; var7--) {
                  rru var8 = var2.rst.get(var7);
                  var8.age += var4;
                  if (var8.age >= var6) {
                     var2.rst.remove(var7);
                  } else {
                     var2.rty(var0, var5, var8, var8.age / var6);
                  }
               }
            } finally {
               uut.additive(false);
            }
         }
      }
   }

   private void rty(DrawContext var1, usn var2, rru var3, float var4) {
      float var5 = vcq.outCubic(Math.min(1.0F, var4 / 0.12F));
      float var6 = var4 < 0.55F ? 1.0F : 1.0F - vcq.inCubic((var4 - 0.55F) / 0.45F);
      float var7 = var5 * var6;
      if (!(var7 <= 0.01F)) {
         float var8 = (var3.totem ? 1.8F : 3.2F) * vcq.outCubic(var4) * var3.scale;
         float var9 = (float)Math.sin(this.rsv * 2.2F + var3.seed) * 0.06F;
         double var10 = var3.y + var8 + var9 + 0.1;
         vla var12 = var3.totem ? this.rsf : this.rse;
         int var13 = var12.color() | 0xFF000000;
         int var14 = var12.color2() | 0xFF000000;
         float var15 = vcq.outCubic(Math.min(1.0F, var4 / 0.45F));
         float var16 = (float)Math.toRadians(-var3.yaw) + var4 * 0.6F;
         if (this.rsi.get()) {
            this.rub(var1, var2, var3, var10, var16, var15, var7, var13, var14);
         }

         this.rtz(var1, var2, var3, var10, var16, var15, var7, var13, var14);
         uut.additive(true);
         this.rue(var1, var2, var3, var10, var7, var13, var14, var4);
         uut.additive(false);
         uut.additive(true);
         if (this.rsj.get()) {
            this.rud(var1, var2, var3, var10 + 2.2 * var3.scale, var7, var13, var14);
         }

         this.ruf(var1, var2, var3, var10, var7, var13, var14);
         uut.additive(false);
      }
   }

   private void rtz(DrawContext var1, usn var2, rru var3, double var4, float var6, float var7, float var8, int var9, int var10) {
      float var11 = var3.scale;
      float var12 = -(0.35F + 2.1F * var7);
      this.rua(var1, var2, var3, var4, var6, var11, -4.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, -2.0F, 12.0F, 0.0F, -0.15F * var7, var8 * 0.55F, var9, var10);
      this.rua(var1, var2, var3, var4, var6, var11, 0.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 2.0F, 12.0F, 0.0F, 0.1F * var7, var8 * 0.55F, var9, var10);
      this.rua(var1, var2, var3, var4, var6, var11, -4.0F, 12.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, 12.0F, 0.0F, 0.0F, var8 * 0.75F, var9, var10);
      this.rua(var1, var2, var3, var4, var6, var11, -4.0F, 24.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, 24.0F, 0.0F, -0.25F * var7, var8 * 0.9F, var9, var10);
      this.rua(var1, var2, var3, var4, var6, var11, -8.0F, 12.0F, -2.0F, 4.0F, 12.0F, 4.0F, -5.0F, 22.0F, var12, 0.0F, var8 * 0.7F, var9, var10);
      this.rua(var1, var2, var3, var4, var6, var11, 4.0F, 12.0F, -2.0F, 4.0F, 12.0F, 4.0F, 5.0F, 22.0F, -var12, 0.0F, var8 * 0.7F, var9, var10);
   }

   private void rua(
      DrawContext var1,
      usn var2,
      rru var3,
      double var4,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13,
      float var14,
      float var15,
      float var16,
      float var17,
      float var18,
      int var19,
      int var20
   ) {
      this.rtf.identity().rotateY(var6).scale(var7 * 0.0625F).translate(var14, var15, 0.0F).rotateZ(var16).rotateX(var17).translate(-var14, -var15, 0.0F);
      Vec3d var21 = var2.camera();

      for (int var22 = 0; var22 < 8; var22++) {
         this.rtg.set((var22 & 1) == 0 ? var8 : var8 + var11, (var22 & 2) == 0 ? var9 : var9 + var12, (var22 & 4) == 0 ? var10 : var10 + var13);
         this.rtf.transformPosition(this.rtg);
         this.rtj[var22][0] = var3.x + this.rtg.x;
         this.rtj[var22][1] = var4 + this.rtg.y;
         this.rtj[var22][2] = var3.z + this.rtg.z;
         this.rti[var22] = var2.depth(this.rtj[var22][0], this.rtj[var22][1], this.rtj[var22][2]) > 0.05F
            && var2.project(this.rtj[var22][0], this.rtj[var22][1], this.rtj[var22][2], this.rth[var22]);
      }

      float var35 = Math.min(1.0F, (var9 + var12) / 32.0F);
      float var23 = Math.min(1.0F, var9 / 32.0F);
      int var24 = ujt.withAlpha(ujt.lerp(var19, -1, 0.2F), Math.round(125.0F * var18 * (0.35F + 0.65F * var35)));
      int var25 = ujt.withAlpha(ujt.lerp(var19, var20, 0.4F), Math.round(125.0F * var18 * (0.08F + 0.92F * var23)));

      for (int var26 = 0; var26 < 6; var26++) {
         int[] var27 = rts[var26];
         if (this.rti[var27[0]] && this.rti[var27[1]] && this.rti[var27[2]] && this.rti[var27[3]]) {
            this.rtg.set(rtt[var26][0], rtt[var26][1], rtt[var26][2]);
            this.rtf.transformDirection(this.rtg);
            double var28 = (this.rtj[var27[0]][0] + this.rtj[var27[2]][0]) * 0.5;
            double var30 = (this.rtj[var27[0]][1] + this.rtj[var27[2]][1]) * 0.5;
            double var32 = (this.rtj[var27[0]][2] + this.rtj[var27[2]][2]) * 0.5;
            if (!(this.rtg.x * (var21.x - var28) + this.rtg.y * (var21.y - var30) + this.rtg.z * (var21.z - var32) <= 0.0)) {
               for (int var34 = 0; var34 < 4; var34++) {
                  this.rto[var34] = (var27[var34] & 2) != 0 ? var24 : var25;
               }

               uut.quad(
                  var1,
                  this.rth[var27[0]][0],
                  this.rth[var27[0]][1],
                  this.rto[0],
                  this.rth[var27[1]][0],
                  this.rth[var27[1]][1],
                  this.rto[1],
                  this.rth[var27[2]][0],
                  this.rth[var27[2]][1],
                  this.rto[2],
                  this.rth[var27[3]][0],
                  this.rth[var27[3]][1],
                  this.rto[3]
               );
            }
         }
      }
   }

   private void rub(DrawContext var1, usn var2, rru var3, double var4, float var6, float var7, float var8, int var9, int var10) {
      float var11 = var3.scale;
      float var12 = (float)Math.sin(this.rsv * 3.2F + var3.seed) * 0.16F;
      double var13 = 0.95 * var11 * (0.35 + 0.65 * var7);
      double var15 = Math.cos(var6);
      double var17 = Math.sin(var6);
      int var19 = ujt.withAlpha(ujt.lerp(var9, -1, 0.3F), Math.round(150.0F * var8));
      int var20 = ujt.withAlpha(ujt.lerp(var10, var9, 0.3F), Math.round(26.0F * var8));
      int var21 = ujt.withAlpha(ujt.lerp(var9, -1, 0.5F), Math.round(170.0F * var8));

      for (byte var22 = -1; var22 <= 1; var22 += 2) {
         double var23 = 0.45 - 0.3 * var7 + var12;
         double var25 = var22 * Math.cos(var23);
         double var27 = -Math.sin(var23);
         double var29 = var22 * 0.1 * var11;
         double var31 = 1.32 * var11;
         double var33 = -0.16 * var11;
         if (ruc(var2, var3, var4, var29, var31, var33, var15, var17, this.rtk)) {
            for (int var35 = 0; var35 < rtr.length; var35++) {
               double var36 = rtr[var35][0] * var13;
               double var38 = rtr[var35][1] * var13;
               this.rtq[var35] = ruc(var2, var3, var4, var29 + var25 * var36, var31 + var38, var33 + var27 * var36, var15, var17, this.rtp[var35]);
            }

            for (int var40 = 0; var40 + 1 < rtr.length; var40++) {
               if (this.rtq[var40] && this.rtq[var40 + 1]) {
                  float[] var42 = this.rtp[var40];
                  float[] var37 = this.rtp[var40 + 1];
                  uut.quad(var1, this.rtk[0], this.rtk[1], var19, var42[0], var42[1], var20, var37[0], var37[1], var20, var37[0], var37[1], var20);
               }
            }

            uut.additive(true);

            for (int var41 = 0; var41 + 1 < rtr.length; var41++) {
               if (this.rtq[var41] && this.rtq[var41 + 1]) {
                  uut.line(var1, this.rtp[var41][0], this.rtp[var41][1], this.rtp[var41 + 1][0], this.rtp[var41 + 1][1], 0.9F, var21);
               }
            }

            uut.additive(false);
         }
      }
   }

   private static boolean ruc(usn var0, rru var1, double var2, double var4, double var6, double var8, double var10, double var12, float[] var14) {
      return var0.project(var1.x + var4 * var10 + var8 * var12, var2 + var6, var1.z - var4 * var12 + var8 * var10, var14);
   }

   private void rud(DrawContext var1, usn var2, rru var3, double var4, float var6, int var7, int var8) {
      float var9 = var2.unitsPerBlock(var3.x, var4, var3.z);
      if (!(var9 <= 0.0F)) {
         double var10 = 0.3 * var3.scale;
         float var12 = Math.max(0.8F, Math.min(2.4F, var9 * 0.025F));
         byte var13 = 28;
         boolean var14 = var2.project(var3.x + var10, var4, var3.z, this.rtk);

         for (int var15 = 1; var15 <= var13; var15++) {
            double var16 = (float) (Math.PI * 2) * var15 / var13;
            boolean var18 = var2.project(
               var3.x + Math.cos(var16) * var10, var4 + Math.sin(var16 * 2.0 + this.rsv) * 0.01, var3.z + Math.sin(var16) * var10, this.rtl
            );
            if (var14 && var18) {
               uut.softLine(var1, this.rtk[0], this.rtk[1], this.rtl[0], this.rtl[1], var12, var12 * 3.0F, ujt.withAlpha(var7, Math.round(90.0F * var6)));
               uut.line(
                  var1, this.rtk[0], this.rtk[1], this.rtl[0], this.rtl[1], var12 * 0.6F, ujt.withAlpha(ujt.lerp(var8, -1, 0.6F), Math.round(230.0F * var6))
               );
            }

            this.rtk[0] = this.rtl[0];
            this.rtk[1] = this.rtl[1];
            var14 = var18;
         }
      }
   }

   private void rue(DrawContext var1, usn var2, rru var3, double var4, float var6, int var7, int var8, float var9) {
      float var10 = var2.unitsPerBlock(var3.x, var4 + 1.0, var3.z);
      if (!(var10 <= 0.0F)) {
         float var11 = Math.max(0.7F, Math.min(2.0F, var10 * 0.02F));
         byte var12 = 30;

         for (int var13 = 0; var13 < 2; var13++) {
            float var14 = var13 * (float) Math.PI;
            boolean var15 = false;

            for (int var16 = 0; var16 <= var12; var16++) {
               float var17 = (float)var16 / var12;
               double var18 = -0.2 + var17 * 2.4 * var3.scale;
               double var20 = (0.25 + Math.sin(var17 * Math.PI) * 0.55) * var3.scale;
               double var22 = var17 * (float) (Math.PI * 2) * 1.6 + this.rsv * 2.4F + var14;
               boolean var24 = var2.project(var3.x + Math.cos(var22) * var20, var4 + var18, var3.z + Math.sin(var22) * var20, this.rtl);
               if (var15 && var24) {
                  float var25 = var6 * (float)Math.sin(var17 * Math.PI) * Math.min(1.0F, var9 * 4.0F);
                  uut.softLine(
                     var1,
                     this.rtk[0],
                     this.rtk[1],
                     this.rtl[0],
                     this.rtl[1],
                     var11,
                     var11 * 3.5F,
                     ujt.withAlpha(ujt.lerp(var7, var8, var17), Math.round(80.0F * var25))
                  );
                  uut.line(
                     var1,
                     this.rtk[0],
                     this.rtk[1],
                     this.rtl[0],
                     this.rtl[1],
                     var11 * 0.5F,
                     ujt.withAlpha(ujt.lerp(var7, -1, 0.5F), Math.round(200.0F * var25))
                  );
               }

               this.rtk[0] = this.rtl[0];
               this.rtk[1] = this.rtl[1];
               var15 = var24;
            }
         }
      }
   }

   private void ruf(DrawContext var1, usn var2, rru var3, double var4, float var6, int var7, int var8) {
      GpuTextureView var9 = unm.view();
      float var10 = var2.unitsPerBlock(var3.x, var4 + 1.0, var3.z);
      if (var9 != null && !(var10 <= 0.0F)) {
         byte var11 = 14;

         for (int var12 = 0; var12 < var11; var12++) {
            float var13 = (float)Math.abs(Math.sin(var12 * 12.9898 + var3.seed) * 43758.5453) % 1.0F;
            float var14 = var12 * 2.399F + var3.seed;
            float var15 = (var13 + var3.age * (0.25F + 0.2F * var13)) % 1.0F;
            double var16 = (0.35 + 0.4 * var13) * var3.scale;
            double var18 = var4 - 0.3 + var15 * 2.8 * var3.scale;
            if (var2.project(var3.x + Math.cos(var14 + var15 * 2.0F) * var16, var18, var3.z + Math.sin(var14 + var15 * 2.0F) * var16, this.rtk)) {
               float var20 = var6 * (float)Math.sin(var15 * Math.PI);
               float var21 = Math.min(10.0F, Math.max(2.0F, var10 * 0.07F));
               uut.sprite(var1, var9, this.rtk[0], this.rtk[1], var21 * 3.0F, ujt.withAlpha(var7, Math.round(70.0F * var20)));
               uut.sprite(var1, var9, this.rtk[0], this.rtk[1], var21, ujt.withAlpha(ujt.lerp(var8, -1, 0.6F), Math.round(220.0F * var20)));
            }
         }
      }
   }
}
