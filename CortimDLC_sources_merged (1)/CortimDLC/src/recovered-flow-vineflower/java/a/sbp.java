package a;

import com.mojang.blaze3d.buffers.Std140Builder;
import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.SugarCaneBlock;
import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.particle.ParticleRenderer;
import net.minecraft.client.particle.RainSplashParticle;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.state.WorldRenderState;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.LightType;
import net.minecraft.world.Heightmap.Type;
import net.minecraft.world.attribute.EnvironmentAttributeInterpolator;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.dimension.DimensionType.Skybox;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class sbp extends kfe {
   static final int sbq = 32;
   static final float sbr = (float) (Math.PI / 180.0);
   final vlv sbs = this.add(new vlv("Season", "Winter", "Winter", "Spring", "Summer", "Autumn", "Rain"));
   final vmc sbt = this.add(new vmc("Rainfall", 0.7, 0.0, 1.0, 0.05).percent());
   final vmc sbu = this.add(new vmc("Lightning", 0.5, 0.0, 1.0, 0.05).percent());
   final vmc sbv = this.add(new vmc("Gloom", 0.6, 0.0, 1.0, 0.05).percent());
   final vmc sbw = this.add(new vmc("Sounds", 0.8, 0.0, 1.0, 0.05).percent());
   final vkl sbx = this.add(new vkl("Lens drops", true));
   final vmc sby = this.add(new vmc("Particles", 0.6, 0.0, 1.0, 0.05).percent());
   final vmc sbz = this.add(new vmc("Ground cover", 0.7, 0.0, 1.0, 0.05).percent());
   final vmc sca = this.add(new vmc("Clouds", 0.9, 0.0, 1.0, 0.05).percent());
   final vmc scb = this.add(new vmc("Speed", 1.0, 0.3, 2.0, 0.1).unit("x"));
   final vkl scc = this.add(new vkl("Colour grade", true));
   final vmc scd = this.add(new vmc("Cold", 0.7, 0.0, 1.0, 0.05).percent());
   final vmc sce = this.add(new vmc("Cumulus", 0.5, 0.0, 1.0, 0.05).percent());
   final vmc scf = this.add(new vmc("Sun rays", 0.7, 0.0, 1.0, 0.05).percent());
   final vmc scg = this.add(new vmc("Light shafts", 0.6, 0.0, 1.0, 0.05).percent());
   final vkl sch = this.add(new vkl("Cloud shadows", true));
   final vmc sci = this.add(new vmc("Wetness", 0.7, 0.0, 1.0, 0.01).percent());
   final vmc scj = this.add(new vmc("Puddles", 0.5, 0.0, 1.0, 0.01).percent());
   final vmc sck = this.add(new vmc("Reflections", 1.0, 0.0, 1.0, 0.05).percent());
   final vmc scl = this.add(new vmc("Darken", 0.55, 0.0, 1.0, 0.05).percent());
   final vkl scm = this.add(new vkl("Footprints", true));
   final vmc scn = this.add(new vmc("Footprint time", 20.0, 5.0, 60.0, 1.0).suffix("s"));
   final vlv sco = this.add(new vlv("Quality", "Medium", "Low", "Medium", "High"));
   final vkl scp = this.add(new vkl("Only under the sky", true));
   final ArrayDeque<saw> scq = new ArrayDeque<>();
   final Map<UUID, sbh> scr = new HashMap<>();
   final Set<UUID> scs = new HashSet<>();
   final List<saw> sct = new ArrayList<>();
   final int[] scu = new int[16384];
   final Mutable scv = new Mutable();
   final Matrix4f scw = new Matrix4f();
   final Matrix4f scx = new Matrix4f();
   final Matrix4f scy = new Matrix4f();
   final Quaternionf scz = new Quaternionf();
   final Quaternionf sda = new Quaternionf();
   Vec3d sdb;
   boolean sdc;
   double sdd;
   double sde;
   double sdf;
   boolean sdg;
   boolean sdh;
   int sdi;
   int sdj;
   int sdk;
   int sdl;
   long sdm;
   float sdn;
   float sdo = -1.0F;
   float sdp;
   float sdq = 192.33F;
   float sdr;
   boolean sds;
   double sdt;
   double sdu;
   double sdv;
   double sdw;
   double sdx;
   double sdy;
   double sdz;
   double sea;
   double seb;
   static sbp sec;
   final stp sed = new stp();
   final sss see = new sss();
   final int[] sef = new int[16384];
   boolean seg;
   boolean seh;
   int sei;
   boolean sej;
   boolean sek;
   double sel;
   double sem;
   double sen;
   double seo;
   double sep;
   float seq = -1.0F;
   float ser = -1.0F;
   final float[] ses = new float[]{1.0F, 1.0F, 1.0F, 1.0F};
   double set;
   double seu;
   boolean sev;
   final List<Field> sew = new ArrayList<>();
   boolean sex;
   final float[] sey = new float[320];
   final float[] sez = new float[320];
   final Vector3f sfa = new Vector3f();

   public sbp() {
      super(new String(new char[]{'W', 'e', 'a', 't', 'h', 'e', 'r'}), "Seasons and weather effects", kfa.RENDER);
      sec = this;

      for (vmc var2 : List.of(this.sby, this.scb)) {
         var2.visibleWhen(() -> !this.sfd());
      }

      this.sbz.visibleWhen(() -> !this.sfd() && !this.sbs.is("Summer"));
      this.sca.visibleWhen(() -> this.sbs.is("Winter") || this.sfd());
      this.scd.visibleWhen(() -> this.sbs.is("Winter") && this.scc.get());

      for (vmo var5 : List.of(this.sce, this.scf, this.scg, this.sch)) {
         var5.visibleWhen(() -> this.sbs.is("Summer"));
      }

      for (vmo var6 : List.of(this.sbt, this.sbu, this.sbv, this.sbw, this.sbx, this.sci, this.scj, this.sck, this.scl)) {
         var6.visibleWhen(this::sfd);
      }

      this.scm.visibleWhen(this::sfe);
      this.sco.visibleWhen(() -> this.sfd() || this.sbs.is("Summer"));
      this.scn.visibleWhen(() -> this.sfe() && this.scm.get());
   }

   boolean sfd() {
      return this.sbs.is("Rain");
   }

   boolean sfe() {
      return this.sfd() || this.sbs.is("Winter");
   }

   @Override
   protected void onEnable() {
      this.sdg = false;
      this.sdl = 0;
      this.sdm = 0L;
      this.sdo = -1.0F;
      this.sdb = null;
      this.scq.clear();
      this.scr.clear();
      this.sed.reset();
      this.see.clear();
      this.seq = -1.0F;
      this.ser = -1.0F;
   }

   @Override
   protected void onDisable() {
      ujl.hide(this, false);
      vbb.release();
      uze.release();
      uxx.release();
      this.sdc = false;
      this.seg = false;
      this.seh = false;
      this.sek = false;
      this.sdb = null;
      this.scq.clear();
      this.scr.clear();
      this.see.clear();
      this.sed.reset();
      this.sev = false;
   }

   public static void hud(DrawContext var0, RenderTickCounter var1) {
      sbp var2 = sec;
      if (var2 != null && var2.isEnabled() && var2.seh && var2.sek) {
         uxx.drops();
      }
   }

   void sff(MinecraftClient var1) {
      var1.getSoundManager().stopSounds(SoundEvents.WEATHER_RAIN.id(), SoundCategory.WEATHER);
      var1.getSoundManager().stopSounds(SoundEvents.WEATHER_RAIN_ABOVE.id(), SoundCategory.WEATHER);
      if (!this.sex) {
         try {
            if (this.sew.isEmpty()) {
               for (Field var5 : ParticleManager.class.getDeclaredFields()) {
                  if (Map.class.isAssignableFrom(var5.getType())) {
                     var5.setAccessible(true);
                     this.sew.add(var5);
                  }
               }
            }

            for (Field var11 : this.sew) {
               if (var11.get(var1.particleManager) instanceof Map var13) {
                  for (Object var7 : var13.values()) {
                     if (var7 instanceof ParticleRenderer var8) {
                        var8.getParticles().removeIf(var0 -> var0.getClass() == RainSplashParticle.class);
                     }
                  }
               }
            }
         } catch (Throwable var9) {
            this.sex = true;
            System.out.println("can't hide vanilla rain splashes: " + var9);
         }
      }
   }

   public static void afterExtraction(WorldRenderState var0) {
      sbp var1 = sec;
      if (var1 != null && var1.isEnabled() && var1.sev && var0 != null) {
         var0.weatherRenderState.rainPieces.clear();
         var0.weatherRenderState.snowPieces.clear();
         var0.weatherRenderState.intensity = 0.0F;
      }
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      this.sdl++;
      ClientWorld var2 = var1.world;
      if (var2 != null && var1.player != null) {
         if (this.sev && var2.getRainGradient(1.0F) > 0.0F) {
            this.sff(var1);
         }

         long var3 = System.nanoTime();
         long var5 = (long)(this.scn.get() * 1.0E9);

         while (!this.scq.isEmpty() && var3 - this.scq.peekFirst().sbd > var5) {
            this.scq.pollFirst();
         }

         if (this.sfe() && this.scm.get()) {
            this.scs.clear();

            for (PlayerEntity var8 : var2.getPlayers()) {
               if (!var8.isSpectator() && !(var8.squaredDistanceTo(var1.player) > 2304.0)) {
                  this.scs.add(var8.getUuid());
                  this.sfg(var8, var3, var8 == var1.player ? 1.0F : 0.8F);
               }
            }

            this.scr.keySet().removeIf(var1x -> !this.scs.contains(var1x));
         } else {
            this.scq.clear();
            this.scr.clear();
         }
      }
   }

   void sfg(PlayerEntity var1, long var2, float var4) {
      sbh var5 = this.scr.computeIfAbsent(var1.getUuid(), var0 -> new sbh());
      double var6 = var1.getX();
      double var8 = var1.getZ();
      boolean var10 = var1.isOnGround();
      if (!var5.sbi) {
         var5.sbi = true;
         var5.sbk = var6;
         var5.sbl = var8;
         var5.sbj = var10;
      } else {
         double var11 = var6 - var5.sbk;
         double var13 = var8 - var5.sbl;
         double var15 = Math.sqrt(var11 * var11 + var13 * var13);
         if (var15 > 6.0) {
            var5.sbk = var6;
            var5.sbl = var8;
            var5.sbj = var10;
         } else {
            if (var10 && !var5.sbj) {
               float var21 = var1.getYaw() * (float) (Math.PI / 180.0);
               float var18 = (float)(-Math.sin(var21));
               float var22 = (float)Math.cos(var21);
               this.sfh(var6, var1.getY(), var8, var18, var22, 1.0F, var2, var4);
               this.sfh(var6, var1.getY(), var8, var18, var22, -1.0F, var2, var4);
               var5.sbk = var6;
               var5.sbl = var8;
            } else if (var10) {
               double var17 = var1.isSneaking() ? 0.42 : (var1.isSprinting() ? 0.85 : 0.62);
               if (var15 >= var17) {
                  float var19 = (float)(var11 / var15);
                  float var20 = (float)(var13 / var15);
                  var5.sbm = -var5.sbm;
                  this.sfh(var6, var1.getY(), var8, var19, var20, var5.sbm, var2, var4);
                  var5.sbk = var6;
                  var5.sbl = var8;
               }
            } else {
               var5.sbk = var6;
               var5.sbl = var8;
            }

            var5.sbj = var10;
         }
      }
   }

   void sfh(double var1, double var3, double var5, float var7, float var8, float var9, long var10, float var12) {
      double var13 = -var8 * var9 * 0.14;
      double var15 = var7 * var9 * 0.14;
      this.scq.addLast(new saw(var1 + var13, var3, var5 + var15, var7, var8, var9, var10, var12));

      while (this.scq.size() > 32) {
         this.scq.pollFirst();
      }
   }

   @Override
   public void onWorldRender(MinecraftClient var1) {
      this.seh = false;
      this.sek = false;
      this.sei = 0;
      this.sej = false;
      ClientWorld var2 = var1.world;
      Camera var3 = var1.gameRenderer.getCamera();
      this.sds = var2 != null && var2.getDimension().skybox() == Skybox.OVERWORLD;
      this.sev = false;
      vbb.wantEntityMask(!this.sfd() || this.sds);
      boolean var4 = this.sds && this.sbs.is("Summer");
      ujl.hide(this, this.sds && (this.sbs.is("Winter") && this.sca.get() > 0.01 || var4 && this.sce.get() > 0.01 || this.sfd()));
      if (!var4 && this.sdc) {
         uze.release();
         this.sdc = false;
         this.sdb = null;
      }

      if (!this.sfd() && this.seg) {
         uxx.release();
         this.seg = false;
         this.see.clear();
         this.sed.reset();
      }

      if (var2 != null && var1.player != null && var3.isReady() && var3.getSubmersionType() == CameraSubmersionType.NONE) {
         long var5 = System.nanoTime();
         float var7 = this.sdm == 0L ? 0.0F : Math.min(0.1F, (float)(var5 - this.sdm) / 1.0E9F);
         this.sdm = var5;
         this.sdn = (this.sdn + var7) % 3600.0F;
         this.sdp = var7;
         this.sdt += var7;
         float var8 = var1.getRenderTickCounter().getTickProgress(false);
         Vec3d var9 = var3.getCameraPos();
         int var10 = (int)Math.floor(var9.x);
         int var11 = (int)Math.floor(var9.y);
         int var12 = (int)Math.floor(var9.z);
         byte var13 = 64;
         if (!this.sdg || Math.abs(var10 - (this.sdj + var13)) > 24 || Math.abs(var12 - (this.sdk + var13)) > 24 || this.sdl >= 40) {
            this.sfs(var2, var10 - var13, var12 - var13);
         }

         this.scw.rotation(var3.getRotation());
         EnvironmentAttributeInterpolator var14 = var3.getEnvironmentAttributeInterpolator();
         float var15 = var2.getRainGradient(var8);
         this.sdr = var15;
         if (this.sds) {
            Float var16 = var14.get(EnvironmentAttributes.CLOUD_HEIGHT_VISUAL, var8);
            this.sdq = var16 != null && !var16.isNaN() ? var16 : 192.33F;
         }

         float[] var25 = new float[]{0.0F, 1.0F, 0.0F, 0.0F};
         float[] var17 = new float[]{1.0F, 1.0F, 1.0F};
         float[] var18 = new float[]{0.5F, 0.65F, 0.9F};
         if (this.sds) {
            float var19 = Math.max(0.0F, 1.0F - 0.85F * var15);
            float var20 = var14.get(EnvironmentAttributes.SUN_ANGLE_VISUAL, var8) * (float) (Math.PI / 180.0);
            float var21 = var14.get(EnvironmentAttributes.MOON_ANGLE_VISUAL, var8) * (float) (Math.PI / 180.0);
            float var22 = (float)Math.cos(var20);
            float var23 = (float)Math.cos(var21);
            if (var22 > -0.05F) {
               float var24 = sfy(0.0F, 0.4F, var22);
               var25 = new float[]{(float)(-Math.sin(var20)), var22, 0.0F, sfy(-0.05F, 0.12F, var22) * var19};
               var17 = new float[]{1.0F, 0.62F + 0.35F * var24, 0.38F + 0.52F * var24};
            } else {
               var25 = new float[]{(float)(-Math.sin(var21)), var23, 0.0F, sfy(-0.05F, 0.15F, var23) * var19 * 0.35F};
               var17 = new float[]{0.6F, 0.7F, 1.0F};
            }

            int var31 = var14.get(EnvironmentAttributes.SKY_COLOR_VISUAL, var8);
            var18 = new float[]{(var31 >> 16 & 0xFF) / 255.0F, (var31 >> 8 & 0xFF) / 255.0F, (var31 & 0xFF) / 255.0F};
         }

         float var26 = this.sds ? uhs.daylight(var1) : 0.6F;
         float var27 = uhs.boost(var1);
         float var28 = uhs.light(var1);
         float var29 = var2.getLightLevel(LightType.SKY, var3.getBlockPos()) / 15.0F;
         this.sdo = this.sdo < 0.0F ? var29 : this.sdo + (var29 - this.sdo) * Math.min(1.0F, var7 * 2.0F);
         float var30 = Math.min(var1.options.getClampedViewDistance() * 16.0F, 200.0F);
         if (this.sfd()) {
            this.sfk(var1, var2, var3, var9, var10, var11, var12, var5, var7, var25, var17, var27, var26, var30);
         } else {
            this.sfj(var1, var9, var10, var11, var12, var5, var25, var17, var18, var28, var26, var27, var30);
         }

         if (var4) {
            this.sfi(var3, var9, var10, var11, var12, var7, var25, var17, var18, var26, var27, var15);
         }
      } else {
         this.sdm = 0L;
         this.sdb = null;
      }
   }

   void sfi(
      Camera var1, Vec3d var2, int var3, int var4, int var5, float var6, float[] var7, float[] var8, float[] var9, float var10, float var11, float var12
   ) {
      this.sdc = true;
      float var13 = (float)this.scb.get();
      double var14 = 0.88;
      double var16 = 0.47;
      double var18 = 3.2 * var13 * var6;
      this.sdd = (this.sdd + var14 * var18) % 65536.0;
      this.sde = (this.sde + var16 * var18) % 65536.0;
      this.sdf = (this.sdf + 0.012 * var13 * var6) % 64.0;
      boolean var20 = this.sdb != null && this.sdb.squaredDistanceTo(var2) < 64.0;
      if (this.sdb == null) {
         this.sda.set(var1.getRotation());
         this.sdb = var2;
      }

      this.scy.rotation(this.sda.conjugate(new Quaternionf()));
      float var21 = (float)(var2.x - this.sdb.x);
      float var22 = (float)(var2.y - this.sdb.y);
      float var23 = (float)(var2.z - this.sdb.z);
      this.sda.set(var1.getRotation());
      this.sdb = var2;
      float var24;
      float var25;
      byte var26;
      byte var27;
      byte var28;
      byte var29;
      float var30;
      float var31;
      switch (this.sco.get()) {
         case "Low":
            var24 = 0.34F;
            var25 = 0.03F;
            var26 = 40;
            var27 = 4;
            var28 = 10;
            var29 = 24;
            var30 = 96.0F;
            var31 = 1200.0F;
            break;
         case "High":
            var24 = 0.5F;
            var25 = 0.015F;
            var26 = 80;
            var27 = 6;
            var28 = 20;
            var29 = 48;
            var30 = 160.0F;
            var31 = 3000.0F;
            break;
         default:
            var24 = 0.42F;
            var25 = 0.022F;
            var26 = 48;
            var27 = 5;
            var28 = 12;
            var29 = 28;
            var30 = 128.0F;
            var31 = 2000.0F;
      }

      float var49 = this.sdq;
      float var50 = (float)this.sce.get() * 0.85F;
      float var34 = sfw(var2.x - this.sdd, 8192.0);
      float var35 = sfw(var2.z - this.sde, 8192.0);
      float var36 = (float)(var14 * var18);
      float var37 = (float)(var16 * var18);
      boolean var38 = var8[2] > var8[0];
      float var39 = (float)this.scg.get();
      float var40 = (float)this.scf.get();
      float var41 = this.sch.get() ? 0.38F : 0.0F;
      boolean var42 = this.sdg;
      int var43 = this.sdj - var3;
      int var44 = this.sdk - var5;
      float[] var45 = var7;
      float[] var46 = var8;
      float[] var47 = var9;
      float var48 = var12;
      uze.draw(var24, var25, var20, (float)this.sdf, var10, var36x -> {
         var36x.putMat4f(this.scw);
         var36x.putMat4f(this.scy);
         var36x.putVec4(var21, var22, var23, 0.0F);
         var36x.putVec4(var34, (float)var2.y, var35, var48);
         var36x.putVec4(var45[0], var45[1], var45[2], var45[3]);
         var36x.putVec4(var46[0], var46[1], var46[2], var38 ? 1.0F : 0.0F);
         var36x.putVec4(var47[0], var47[1], var47[2], var11);
         var36x.putVec4(var49, var49 + 150.0F, var50, 1.5F + 0.5F * var48);
         var36x.putVec4(var36, var37, (float)var14, (float)var16);
         var36x.putVec4(var39 * (1.0F - 0.6F * var48), var30, 0.0016F, var40 * (1.0F - 0.7F * var48));
         var36x.putVec4(var41, 7000.0F, var31, 0.0F);
         var36x.putVec4(var43, var44, 128.0F, var42 ? 1.0F : 0.0F);
         var36x.putVec4((float)(var2.x - var3), (float)(var2.y - var4), (float)(var2.z - var5), var4);
         var36x.putVec4(var26, var27, var28, var29);
      });
   }

   void sfj(
      MinecraftClient var1,
      Vec3d var2,
      int var3,
      int var4,
      int var5,
      long var6,
      float[] var8,
      float[] var9,
      float[] var10,
      float var11,
      float var12,
      float var13,
      float var14
   ) {
      int var15 = this.sbs.index();
      float var16 = 1.0F - sfy(0.25F, 0.6F, var12);
      float var17;
      float var18;
      switch (var15) {
         case 1:
            var17 = 0.55F + 0.25F * (float)Math.sin(this.sdt * 0.35);
            var18 = 0.3F;
            break;
         case 2:
            var17 = 0.08F;
            var18 = 0.05F;
            break;
         case 3:
            var17 = 0.35F + 0.2F * (float)Math.sin(this.sdt * 0.27);
            var18 = 0.18F;
            break;
         default:
            float var19 = 1.0F + 0.45F * (float)Math.sin(this.sdt * 0.23) + 0.25F * (float)Math.sin(this.sdt * 0.61 + 1.3);
            var17 = 0.34F * var19;
            var18 = 0.14F * var19;
      }

      boolean var56 = this.sdg;
      int var20 = this.sdj - var3;
      int var21 = this.sdk - var5;
      float var22 = (float)this.sby.get();
      float var23 = (float)this.sbz.get();
      float var24 = (float)this.scb.get();
      boolean var25 = this.scc.get();
      boolean var26 = this.scp.get();
      float var27 = var17 * var24;
      float var28 = var18 * var24;
      this.sdu = (this.sdu + var27 * this.sdp) % 65536.0;
      this.sdv = (this.sdv + var28 * this.sdp) % 65536.0;
      double var29 = Math.max(1.0E-4, Math.hypot(var17, var18));
      double var31 = var17 / var29;
      double var33 = var18 / var29;
      double var35 = 2.2 * (0.5 + 0.5 * var24) * this.sdp;
      this.sdw += var31 * var35;
      this.sdx += var33 * var35;
      this.sdy += (var31 * 0.94 - var33 * 0.34) * var35 * 2.4;
      this.sdz += (var33 * 0.94 + var31 * 0.34) * var35 * 2.4;
      float var37 = var15 == 0 && this.sds ? (float)this.sca.get() : 0.0F;
      float var38 = var15 == 0 && var25 ? (float)this.scd.get() : 0.0F;
      float var39 = Math.max(this.sdq - (float)var2.y, 40.0F);
      float var40 = !this.sds ? -1.0F : (0.0012F + 0.0068F * var22) * (0.55F + 0.45F * var37) * (1.0F + 0.5F * this.sdr);
      float var41 = sfw((var2.x - this.sdw) / 80.0, 256.0);
      float var42 = sfw((var2.z - this.sdx) / 80.0, 256.0);
      float var43 = sfw((var2.x - this.sdw) / 640.0, 256.0);
      float var44 = sfw((var2.z - this.sdx) / 640.0, 256.0);
      float var45 = sfw((var2.x - this.sdy) / 28.0, 256.0);
      float var46 = sfw((var2.z - this.sdz) / 28.0, 256.0);
      this.sea = (this.sea + 0.55 * var24 * this.sdp) % 256.0;
      this.seb = (this.seb + 0.9 * var24 * this.sdp) % 256.0;
      float var47 = (float)this.sea;
      float var48 = (float)this.seb;
      float var49 = sfw(this.sdt * 0.035, Math.PI * 2);
      float var50 = sfw(this.sdt * 0.052, Math.PI * 2);

      int[] var51 = switch (var15) {
         case 0 -> new int[]{28000, 30000};
         case 1 -> new int[]{1600, 2600};
         case 2 -> new int[]{700, 1100};
         default -> new int[]{1300, 2100};
      };
      int var52 = Math.round(var51[0] * var22);
      int var53 = Math.round(var51[1] * var22);
      this.scx.rotation(var1.gameRenderer.getCamera().getRotation().conjugate(this.scz));
      this.sct.clear();
      if (var15 == 0) {
         this.sct.addAll(this.scq);
      }

      float var54 = (float)this.scn.get();
      boolean var55 = vbb.drawSeason(var43x -> {
         var43x.putMat4f(this.scw);
         var43x.putMat4f(this.scx);
         var43x.putVec4(Math.floorMod(var3, 4096), var4, Math.floorMod(var5, 4096), this.sdn);
         var43x.putVec4((float)(var2.x - var3), (float)(var2.y - var4), (float)(var2.z - var5), var15);
         var43x.putVec4(var22, var23, var25 ? 1.0F : 0.0F, var24);
         var43x.putVec4(var11, var12, var16, this.sdo);
         var43x.putVec4(var8[0], var8[1], var8[2], var8[3]);
         var43x.putVec4(var9[0], var9[1], var9[2], var13);
         var43x.putVec4(var20, var21, 128.0F, var56 ? 1.0F : 0.0F);
         var43x.putVec4((float)this.sdu, var54, (float)this.sdv, var14);
         var43x.putVec4(var10[0], var10[1], var10[2], var26 ? 1.0F : 0.0F);
         var43x.putVec4(var52, var53, vbb.entityMask() ? 1.0F : 0.0F, 0.0F);
         var43x.putVec4(var37, var38, var39, var40);
         var43x.putVec4(var41, var42, var43, var44);
         var43x.putVec4(var45, var46, var47, var48);
         var43x.putVec4(var27, var28, var49, var50);
         this.sfr(var43x, this.sct, var2, var6);
      });
      this.sdi = var55 ? var52 + var53 : 0;
      this.sdh = var55 && var38 > 0.0F;
   }

   @Override
   public void onWorldRenderLate(MinecraftClient var1) {
      if (this.sdi > 0) {
         vbb.drawParticles(this.sdi);
         this.sdi = 0;
      }

      if (this.sei > 0 && this.seh) {
         uxx.rain(this.sei);
         this.sei = 0;
      }
   }

   @Override
   public void onWorldRenderFinal(MinecraftClient var1) {
      if (this.sdh) {
         vbb.gradeSeason();
         this.sdh = false;
      }

      if (this.sej && this.seh) {
         uxx.grade();
         this.sej = false;
      }
   }

   void sfk(
      MinecraftClient var1,
      ClientWorld var2,
      Camera var3,
      Vec3d var4,
      int var5,
      int var6,
      int var7,
      long var8,
      float var10,
      float[] var11,
      float[] var12,
      float var13,
      float var14,
      float var15
   ) {
      if (this.sds) {
         this.seg = true;
         float var16 = (float)this.sbt.get();
         float var17 = (float)this.sca.get();
         float var18 = (float)this.sbv.get();
         int var19 = this.sco.index();
         this.seq = this.seq < 0.0F ? var14 : this.seq + (var14 - this.seq) * Math.min(1.0F, var10 * 0.7F);
         float var20 = this.seq;
         float var21 = 1.0F - sfy(0.2F, 0.7F, var20);
         float var22 = this.sfq(var4);
         this.ser = this.ser < 0.0F ? var22 : this.ser + (var22 - this.ser) * Math.min(1.0F, var10 * 4.0F);
         double var23 = 0.55 + 0.35 * Math.sin(this.sdt * 0.011);
         double var25 = Math.cos(var23);
         double var27 = Math.sin(var23);
         double var29 = (4.0 + 5.0 * var17) * var10;
         this.sel = (this.sel + var25 * var29) % 491520.0;
         this.sem = (this.sem + var27 * var29) % 491520.0;
         this.sen = (this.sen + var25 * var29 * 2.4) % 1000000.0;
         this.seo = (this.seo + var27 * var29 * 2.4) % 1000000.0;
         float var31 = Math.max(80.0F, Math.min(600.0F, this.sdq - (float)var4.y + 60.0F));
         float var32 = sfw((var4.x - this.sel) / 240.0, 2048.0);
         float var33 = sfw((var4.z - this.sem) / 240.0, 2048.0);
         float var34 = sfw((var4.x - this.sen) * 0.0042307692307692315, 256.0);
         float var35 = sfw((var4.z - this.seo) * 0.0042307692307692315, 256.0);
         float var36 = 1.0F + 0.35F * (float)Math.sin(this.sdt * 0.31) + 0.2F * (float)Math.sin(this.sdt * 0.83 + 1.1);
         float var37 = (1.0F + 1.4F * var36) * (0.4F + 0.6F * var16);
         float var38 = (float)var25 * var37;
         float var39 = (float)var27 * var37;
         float var40 = 8.5F;
         float var41 = var1.isPaused() ? 0.0F : var10;
         this.sep = (this.sep + var40 * var41) % 54912.0;
         this.set = (this.set + var38 * var41) % 6864.0;
         this.seu = (this.seu + var39 * var41) % 6864.0;
         float var42 = sfw(this.set, 6864.0);
         float var43 = sfw(this.seu, 6864.0);
         float var44 = sfw(var4.x, 6864.0);
         float var45 = sfw(var4.z, 6864.0);
         this.sed.update(var41, (float)this.sbu.get() * (0.35F + 0.65F * var17), var4, var31, Math.min(var2.getSeaLevel(), var4.y - 40.0));
         boolean var46 = var1.options.getHideLightningFlashes().getValue();
         float var47 = this.sed.brightness() * (var46 ? 0.15F : 1.0F);
         float var48 = Math.max(1.0F, this.sed.distance());
         float var49 = var47 * sfx(1.25F - var48 / 2600.0F, 0.25F, 1.0F) * 0.5F * (0.1F + 0.9F * this.ser);
         float var50 = this.sed.boltBrightness() * (var46 ? 0.4F : 1.6F);
         float var51 = var47 * sfx(1.3F - var48 / 2000.0F, 0.15F, 1.0F) * (0.2F + 0.8F * var21) * 0.7F;
         float var52 = var1.gameRenderer.getFarPlaneDistance();
         float var53 = this.sfm(var4);
         float var54 = Math.min(1.0F, var52 * 0.8F / Math.max(1.0F, var53));
         if (!var46 && var47 > 0.5F && var48 < 1500.0F) {
            var2.setLightningTicksLeft(1);
         }

         float var55 = var1.options.getSoundVolume(SoundCategory.MASTER) * var1.options.getSoundVolume(SoundCategory.WEATHER);
         float var56 = var1.isPaused() ? 0.0F : (float)this.sbw.get() * var55;

         sti var57;
         while ((var57 = this.sed.nextThunder()) != null) {
            this.sfo(var3, var4, var57, var56);
         }

         float var58 = this.ser + (1.0F - this.ser) * 0.7F * Math.max(this.sdo, 0.0F);
         float var59 = sfy(0.35F, 1.0F, var16);
         vss.listener(var3.getYaw());
         vss.rain(var56 * var58 * var59 * 0.9F, var56 * var58 * Math.min(1.0F, var16 * 2.2F) * (1.0F - 0.55F * var59) * 1.5F, 1.0F - this.ser, this.sfp(var4));
         float var60 = sfx((-var3.getPitch() + 15.0F) / 55.0F, 0.0F, 1.0F);
         this.see.update(var41, this.sbx.get() ? var16 * this.ser * var60 * 2.6F : 0.0F, 1.0F - this.ser);
         float var61 = var19 == 0 ? 0.45F : (var19 == 1 ? 0.75F : 1.0F);
         int var62 = Math.round(10000.0F * var16 * var61);
         int var63 = Math.round(8000.0F * var16 * var61);
         int var64 = Math.round(1400.0F * var16 * var61);
         int var65 = var19 == 0 ? 16 : (var19 == 1 ? 28 : 40);
         boolean var66 = var12[2] > var12[0];
         float var67 = var66 ? 0.12F : 0.38F;
         float var68 = sfy(-0.05F, 0.12F, var11[1]) * var67 * (1.0F - 0.5F * var17);
         float var69 = sfy(-0.12F, 0.05F, var11[1]) * (1.0F - sfy(0.25F, 0.5F, var11[1])) * (1.1F - 0.4F * var17) * (var66 ? 0.15F : 1.0F);
         float var70 = (0.0018F + 0.0045F * var16) * (0.7F + 0.6F * var18);
         float var71 = 1.0F - var20;
         float var72 = (0.07F + 0.36F * var13) * (0.4F + 0.6F * var71);
         float var73 = (0.09F + 0.42F * var13) * (0.4F + 0.6F * var71);
         float var74 = (0.15F + 0.5F * var13) * (0.4F + 0.6F * var71);
         boolean var75 = vbb.entityMask();
         boolean var76 = this.scc.get();
         float var77 = var76 ? 0.55F + 0.45F * var18 : 0.0F;
         boolean var78 = this.sbx.get() && this.see.any();
         this.scx.rotation(var3.getRotation().conjugate(this.scz));
         this.sct.clear();
         this.sct.addAll(this.scq);
         float var79 = (float)this.scn.get();
         boolean var80 = this.scp.get();
         boolean var81 = this.sdg;
         int var82 = this.sdj - var5;
         int var83 = this.sdk - var7;
         float var84 = (float)(this.sed.x() - var4.x);
         float var85 = (float)(this.sed.y() - var4.y);
         float var86 = (float)(this.sed.z() - var4.z);
         int var87 = this.sed.segments();
         float[] var88 = this.sed.segA();
         float[] var89 = this.sed.segB();
         float[] var90 = this.sfl(var88, var87, var84, var85, var86);
         float[] var91 = this.sfl(var89, var87, var84, var85, var86);
         float var92 = var75 ? 1.0F : 0.0F;
         float var93 = 30.0F * var1.getFramebuffer().textureHeight / 1080.0F;
         float var94 = this.ser;
         float var95 = this.sdn;
         boolean var96 = uxx.upload(var63x -> {
            var63x.putMat4f(this.scw);
            var63x.putMat4f(this.scx);
            var63x.putVec4(Math.floorMod(var5, 4096), var6, Math.floorMod(var7, 4096), var95);
            var63x.putVec4((float)(var4.x - var5), (float)(var4.y - var6), (float)(var4.z - var7), var16);
            var63x.putVec4(var11[0], var11[1], var11[2], var68);
            var63x.putVec4(var12[0], var12[1], var12[2], var69);
            var63x.putVec4(var20, var13, var94, var92);
            var63x.putVec4(var31, var17, var18, var70);
            var63x.putVec4(var32, var33, var34, var35);
            var63x.putVec4((float)this.sep, var40, var38, var39);
            var63x.putVec4(var84, var85, var86, var47);
            var63x.putVec4(var49, var50, var51, var54);
            var63x.putVec4(var82, var83, 128.0F, var81 ? 1.0F : 0.0F);
            var63x.putVec4((float)this.sci.get(), (float)this.scj.get(), (float)this.sck.get(), (float)this.scl.get());
            var63x.putVec4(var62, var63, var64, var19);
            var63x.putVec4(var76 ? 1.0F : 0.0F, var77, var78 ? 16.0F : 0.0F, var76 ? 0.18F + 0.14F * var18 : 0.0F);
            var63x.putVec4(this.sct.size(), var79, var15, var80 ? 1.0F : 0.0F);
            var63x.putVec4(var72, var73, var74, var65);
            var63x.putVec4(var42, var44, var43, var45);
            var63x.putVec4(var87, var93, 0.0F, 0.0F);
            this.sfr(var63x, this.sct, var4, var8);

            for (int var64x = 0; var64x < 80; var64x++) {
               if (var64x < var87) {
                  var63x.putVec4(var90[var64x * 4], var90[var64x * 4 + 1], var90[var64x * 4 + 2], var88[var64x * 4 + 3]);
               } else {
                  var63x.putVec4(0.0F, 0.0F, 0.0F, 0.0F);
               }
            }

            for (int var65x = 0; var65x < 80; var65x++) {
               if (var65x < var87) {
                  var63x.putVec4(var91[var65x * 4], var91[var65x * 4 + 1], var91[var65x * 4 + 2], var89[var65x * 4 + 3]);
               } else {
                  var63x.putVec4(0.0F, 0.0F, 0.0F, 0.0F);
               }
            }

            this.see.write(var63x);
         });
         if (var96) {
            this.seh = true;
            this.sev = true;
            uxx.sky(var87);
            uxx.wet(var75);
            this.sei = var62 + var63 + var64;
            this.sej = var76 || var49 > 0.005F;
            this.sek = var78;
         }
      }
   }

   public void testStrike(float var1, boolean var2, double var3, double var5) {
      MinecraftClient var7 = MinecraftClient.getInstance();
      Vec3d var8 = var7.gameRenderer.getCamera().getCameraPos();
      float var9 = Math.max(80.0F, Math.min(600.0F, this.sdq - (float)var8.y + 60.0F));
      this.sed.strike(var8, var9, Math.min(var7.world.getSeaLevel(), var8.y - 40.0), var1, var2, var3);
      this.sed.freeze(var5);
   }

   float[] sfl(float[] var1, int var2, float var3, float var4, float var5) {
      float[] var6 = var1 == this.sed.segA() ? this.sey : this.sez;

      for (int var7 = 0; var7 < var2; var7++) {
         this.sfa.set(var3 + var1[var7 * 4], var4 + var1[var7 * 4 + 1], var5 + var1[var7 * 4 + 2]);
         this.scx.transformDirection(this.sfa);
         var6[var7 * 4] = this.sfa.x;
         var6[var7 * 4 + 1] = this.sfa.y;
         var6[var7 * 4 + 2] = this.sfa.z;
      }

      return var6;
   }

   float sfm(Vec3d var1) {
      float var2 = Math.max(1.0F, this.sed.distance());
      int var3 = this.sed.segments();
      if (var3 == 0) {
         return var2;
      }

      float[] var4 = this.sed.segA();
      float[] var5 = this.sed.segB();
      double var6 = this.sed.x() - var1.x;
      double var8 = this.sed.y() - var1.y;
      double var10 = this.sed.z() - var1.z;

      for (int var12 = 0; var12 < var3; var12++) {
         var2 = Math.max(var2, (float)Math.sqrt(sfn(var6 + var4[var12 * 4]) + sfn(var8 + var4[var12 * 4 + 1]) + sfn(var10 + var4[var12 * 4 + 2])));
         var2 = Math.max(var2, (float)Math.sqrt(sfn(var6 + var5[var12 * 4]) + sfn(var8 + var5[var12 * 4 + 1]) + sfn(var10 + var5[var12 * 4 + 2])));
      }

      return var2;
   }

   static double sfn(double var0) {
      return var0 * var0;
   }

   void sfo(Camera var1, Vec3d var2, sti var3, float var4) {
      vss.listener(var1.getYaw());
      vss.thunder(var3.distance(), var3.bolt(), (float)(var3.x() - var2.x), (float)(var3.z() - var2.z), var4);
   }

   float[] sfp(Vec3d var1) {
      float[] var2 = this.ses;
      if (!this.sdg) {
         Arrays.fill(var2, 1.0F);
         return var2;
      }

      short var3 = 128;
      double var4 = var1.y + 0.6;
      double var6 = var1.y + 2.0;

      for (int var8 = 0; var8 < 4; var8++) {
         double var9 = var8 != 0 && var8 != 3 ? -0.7071 : 0.7071;
         double var11 = var8 < 2 ? 0.7071 : -0.7071;
         float var13 = 0.0F;
         float var14 = 0.0F;

         for (int var15 = -1; var15 <= 1; var15++) {
            double var16 = var15 * 0.45;
            double var18 = var9 * Math.cos(var16) - var11 * Math.sin(var16);
            double var20 = var9 * Math.sin(var16) + var11 * Math.cos(var16);
            float var22 = 1.0F;

            for (int var23 = 1; var23 <= 8; var23++) {
               float var24 = 1.0F / (1.0F + 0.2F * var23);
               var14 += var24;
               int var25 = (int)Math.floor(var1.x + var18 * var23) - this.sdj;
               int var26 = (int)Math.floor(var1.z + var20 * var23) - this.sdk;
               if (var25 >= 0 && var26 >= 0 && var25 < var3 && var26 < var3) {
                  int var27 = this.sef[var26 * var3 + var25];
                  if (var27 <= var4) {
                     var13 += var22 * var24;
                  } else if (var27 > var6) {
                     var22 *= 0.45F;
                  }
               } else {
                  var13 += var22 * var24;
               }
            }
         }

         var2[var8] = var14 <= 0.0F ? 1.0F : var13 / var14;
      }

      return var2;
   }

   float sfq(Vec3d var1) {
      if (!this.sdg) {
         return 1.0F;
      }

      short var2 = 128;
      int var3 = (int)Math.floor(var1.x) - this.sdj;
      int var4 = (int)Math.floor(var1.z) - this.sdk;
      float var5 = 0.0F;
      float var6 = 0.0F;

      for (int var7 = -4; var7 <= 4; var7++) {
         for (int var8 = -4; var8 <= 4; var8++) {
            int var9 = var3 + var8;
            int var10 = var4 + var7;
            if (var9 >= 0 && var10 >= 0 && var9 < var2 && var10 < var2) {
               float var11 = var8 == 0 && var7 == 0 ? 6.0F : 1.0F / (1.0F + 0.35F * (var8 * var8 + var7 * var7));
               var6 += var11;
               if (this.sef[var10 * var2 + var9] <= var1.y + 0.6) {
                  var5 += var11;
               }
            }
         }
      }

      return var6 <= 0.0F ? 1.0F : var5 / var6;
   }

   void sfr(Std140Builder var1, List<saw> var2, Vec3d var3, long var4) {
      float var6 = 0.0F;
      float var7 = 0.0F;
      float var8 = 0.0F;

      for (saw var10 : var2) {
         var6 += (float)(var10.sax - var3.x);
         var7 += (float)(var10.say - var3.y);
         var8 += (float)(var10.saz - var3.z);
      }

      int var19 = Math.max(1, var2.size());
      var6 /= var19;
      var7 /= var19;
      var8 /= var19;
      float var20 = 0.0F;

      for (saw var12 : var2) {
         float var13 = (float)(var12.sax - var3.x) - var6;
         float var14 = (float)(var12.say - var3.y) - var7;
         float var15 = (float)(var12.saz - var3.z) - var8;
         var20 = Math.max(var20, (float)Math.sqrt(var13 * var13 + var14 * var14 + var15 * var15));
      }

      var1.putVec4(var6, var7, var8, var2.isEmpty() ? 0.0F : var20 + 2.5F);

      for (int var21 = 0; var21 < 32; var21++) {
         if (var21 < var2.size()) {
            saw var23 = (saw)var2.get(var2.size() - 1 - var21);
            var1.putVec4((float)(var23.sax - var3.x), (float)(var23.say - var3.y), (float)(var23.saz - var3.z), (float)(var4 - var23.sbd) / 1.0E9F);
         } else {
            var1.putVec4(0.0F, -1000.0F, 0.0F, 1000.0F);
         }
      }

      for (int var22 = 0; var22 < 32; var22++) {
         if (var22 < var2.size()) {
            saw var24 = (saw)var2.get(var2.size() - 1 - var22);
            var1.putVec4(var24.sba, var24.sbb, var24.sbc, var24.sbe);
         } else {
            var1.putVec4(0.0F, 1.0F, 1.0F, 0.0F);
         }
      }
   }

   void sfs(ClientWorld var1, int var2, int var3) {
      short var4 = 128;
      int var5 = var1.getBottomY();
      boolean var6 = false;

      for (int var7 = 0; var7 < var4; var7++) {
         for (int var8 = 0; var8 < var4; var8++) {
            int var9 = var1.getTopY(Type.MOTION_BLOCKING, var2 + var8, var3 + var7);
            if (var9 <= var5 && !var6) {
               var6 = !var1.getChunkManager().isChunkLoaded(var2 + var8 >> 4, var3 + var7 >> 4);
            }

            BlockState var10 = var1.getBlockState(this.scv.set(var2 + var8, var9 - 1, var3 + var7));

            for (int var11 = 0; var11 < 96 && var9 > var5 && !sft(var10); var11++) {
               var9--;
               var10 = var1.getBlockState(this.scv.set(var2 + var8, var9 - 1, var3 + var7));
            }

            boolean var16 = !var10.getFluidState().isEmpty();
            if (!var16 && sfu(var1, var10, this.scv)) {
               var9--;
            }

            int var12 = Math.max(0, Math.min(65535, var9 + 64));
            boolean var13 = var10.isIn(BlockTags.LEAVES);
            int var14 = var1.getLightLevel(LightType.BLOCK, this.scv.set(var2 + var8, var9, var3 + var7)) * 17;
            int var15 = 0;

            while (var15 < 15 && sfv(var1.getBlockState(this.scv.set(var2 + var8, var9 + var15, var3 + var7)))) {
               var15++;
            }

            this.scu[var7 * var4 + var8] = var14 << 24 | (var12 & 0xFF) << 16 | (var12 >> 8 & 0xFF) << 8 | (var16 ? 128 : 0) | (var13 ? 64 : 0) | var15;
            this.sef[var7 * var4 + var8] = var9;
         }
      }

      vbb.uploadHeights(this.scu);
      this.sdj = var2;
      this.sdk = var3;
      this.sdl = var6 ? 32 : 0;
      this.sdg = true;
   }

   static boolean sft(BlockState var0) {
      return !var0.getFluidState().isEmpty() ? true : var0.blocksMovement() && var0.getRenderType() != BlockRenderType.INVISIBLE;
   }

   static boolean sfu(ClientWorld var0, BlockState var1, BlockPos var2) {
      if (var1.isIn(BlockTags.LEAVES)) {
         return false;
      }

      try {
         VoxelShape var3 = var1.getCollisionShape(var0, var2);
         return !var3.isEmpty() && var3.getMax(Axis.Y) <= 0.55;
      } catch (Throwable var4) {
         return false;
      }
   }

   static boolean sfv(BlockState var0) {
      Block var1 = var0.getBlock();
      return var1 instanceof PlantBlock || var1 instanceof SugarCaneBlock;
   }

   static float sfw(double var0, double var2) {
      double var4 = var0 % var2;
      return (float)(var4 < 0.0 ? var4 + var2 : var4);
   }

   static float sfx(float var0, float var1, float var2) {
      return Math.max(var1, Math.min(var2, var0));
   }

   static float sfy(float var0, float var1, float var2) {
      float var3 = Math.max(0.0F, Math.min(1.0F, (var2 - var0) / (var1 - var0)));
      return var3 * var3 * (3.0F - 2.0F * var3);
   }
}
