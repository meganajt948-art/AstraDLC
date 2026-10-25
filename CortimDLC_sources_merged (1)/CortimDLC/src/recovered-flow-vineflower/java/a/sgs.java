package a;

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
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.world.Heightmap.Type;
import net.minecraft.world.attribute.EnvironmentAttributeInterpolator;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.dimension.DimensionType.Skybox;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

public class sgs extends kfe {
   private static final int sgt = 32;
   private static final float sgu = (float) (Math.PI / 180.0);
   private final vmc sgv = this.add(new vmc("Мокрость", 0.7, 0.0, 1.0, 0.01).percent());
   private final vmc sgw = this.add(new vmc("Лужи", 0.5, 0.0, 1.0, 0.01).percent());
   private final vmc sgx = this.add(new vmc("Отражения", 1.0, 0.0, 1.0, 0.05).percent());
   private final vmc sgy = this.add(new vmc("Затемнение", 0.55, 0.0, 1.0, 0.05).percent());
   private final vmc sgz = this.add(new vmc("Капли", 0.0, 0.0, 1.0, 0.05).percent());
   private final vkl sha = this.add(new vkl("Следы", true));
   private final vmc shb = this.add(new vmc("Время следов", 20.0, 5.0, 60.0, 1.0).suffix("с"));
   private final vkl shc = this.add(new vkl("Только под небом", true));
   private final vlv shd = this.add(new vlv("Качество", "Высокое", "Низкое", "Среднее", "Высокое"));
   private final ArrayDeque<sfz> she = new ArrayDeque<>();
   private final Map<UUID, sgk> shf = new HashMap<>();
   private final int[] shg = new int[16384];
   private final Mutable shh = new Mutable();
   private final Matrix4f shi = new Matrix4f();
   private final Matrix4f shj = new Matrix4f();
   private boolean shk;
   private int shl;
   private int shm;
   private int shn;
   private long sho;
   private float shp;

   public sgs() {
      super(
         new String(new char[]{'W', 'e', 't', 'G', 'r', 'o', 'u', 'n', 'd'}),
         "Wet ground after rain: puddles with reflections, ripples and footprints",
         kfa.RENDER
      );
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
   public void onEndTick(MinecraftClient var1) {
      this.shn++;
      ClientWorld var2 = var1.field_1687;
      if (var2 != null && var1.field_1724 != null) {
         long var3 = System.nanoTime();
         long var5 = (long)(this.shb.get() * 1.0E9);

         while (!this.she.isEmpty() && var3 - this.she.peekFirst().sgg > var5) {
            this.she.pollFirst();
         }

         if (!this.sha.get()) {
            this.she.clear();
            this.shf.clear();
         } else {
            HashMap var7 = new HashMap();

            for (PlayerEntity var9 : var2.method_18456()) {
               if (!var9.method_7325() && !(var9.method_5858(var1.field_1724) > 2304.0)) {
                  var7.put(var9.method_5667(), Boolean.TRUE);
                  this.shs(var9, var3, var9 == var1.field_1724 ? 1.0F : 0.8F);
               }
            }

            this.shf.keySet().removeIf(var1x -> !var7.containsKey(var1x));
         }
      }
   }

   private void shs(PlayerEntity var1, long var2, float var4) {
      sgk var5 = this.shf.computeIfAbsent(var1.method_5667(), var0 -> new sgk());
      double var6 = var1.method_23317();
      double var8 = var1.method_23321();
      boolean var10 = var1.method_24828();
      if (!var5.sgl) {
         var5.sgl = true;
         var5.sgn = var6;
         var5.sgo = var8;
         var5.sgm = var10;
      } else {
         double var11 = var6 - var5.sgn;
         double var13 = var8 - var5.sgo;
         double var15 = Math.sqrt(var11 * var11 + var13 * var13);
         if (var15 > 6.0) {
            var5.sgn = var6;
            var5.sgo = var8;
            var5.sgm = var10;
         } else {
            if (var10 && !var5.sgm) {
               float var21 = var1.method_36454() * (float) (Math.PI / 180.0);
               float var18 = (float)(-Math.sin(var21));
               float var22 = (float)Math.cos(var21);
               this.sht(var6, var1.method_23318(), var8, var18, var22, 1.0F, var2, var4);
               this.sht(var6, var1.method_23318(), var8, var18, var22, -1.0F, var2, var4);
               var5.sgn = var6;
               var5.sgo = var8;
            } else if (var10) {
               double var17 = var1.method_5715() ? 0.42 : (var1.method_5624() ? 0.85 : 0.62);
               if (var15 >= var17) {
                  float var19 = (float)(var11 / var15);
                  float var20 = (float)(var13 / var15);
                  var5.sgp = -var5.sgp;
                  this.sht(var6, var1.method_23318(), var8, var19, var20, var5.sgp, var2, var4);
                  var5.sgn = var6;
                  var5.sgo = var8;
               }
            } else {
               var5.sgn = var6;
               var5.sgo = var8;
            }

            var5.sgm = var10;
         }
      }
   }

   private void sht(double var1, double var3, double var5, float var7, float var8, float var9, long var10, float var12) {
      double var13 = -var8 * var9 * 0.14;
      double var15 = var7 * var9 * 0.14;
      this.she.addLast(new sfz(var1 + var13, var3, var5 + var15, var7, var8, var9, var10, var12));

      while (this.she.size() > 32) {
         this.she.pollFirst();
      }
   }

   @Override
   public void onWorldRender(MinecraftClient var1) {
      ClientWorld var2 = var1.field_1687;
      Camera var3 = var1.field_1773.method_19418();
      if (var2 != null && var1.field_1724 != null && var3.method_19332() && var3.method_19334() == CameraSubmersionType.field_27888) {
         long var4 = System.nanoTime();
         float var6 = this.sho == 0L ? 0.0F : Math.min(0.1F, (float)(var4 - this.sho) / 1.0E9F);
         this.sho = var4;
         this.shp = (this.shp + var6) % 3600.0F;
         float var7 = var1.method_61966().method_60637(false);
         Vec3d var8 = var3.method_71156();
         int var9 = (int)Math.floor(var8.field_1352);
         int var10 = (int)Math.floor(var8.field_1351);
         int var11 = (int)Math.floor(var8.field_1350);
         byte var12 = 64;
         if (!this.shk || Math.abs(var9 - (this.shl + var12)) > 24 || Math.abs(var11 - (this.shm + var12)) > 24 || this.shn >= 40) {
            this.shv(var2, var9 - var12, var11 - var12);
         }

         String var14 = this.shd.get();

         byte var13 = switch (var14) {
            case "Низкое" -> 16;
            case "Среднее" -> 28;
            default -> 40;
         };
         EnvironmentAttributeInterpolator var31 = var3.method_75756();
         float var32 = var2.method_8430(var7);
         float[] var16 = new float[]{0.0F, 1.0F, 0.0F, 0.0F};
         float[] var17 = new float[]{1.0F, 1.0F, 1.0F};
         float[] var18 = new float[]{0.5F, 0.65F, 0.9F};
         if (var2.method_8597().comp_5220() == Skybox.field_64386) {
            float var19 = Math.max(0.0F, 1.0F - 0.85F * var32);
            float var20 = (Float)var31.method_75689(EnvironmentAttributes.field_64340, var7) * (float) (Math.PI / 180.0);
            float var21 = (Float)var31.method_75689(EnvironmentAttributes.field_64341, var7) * (float) (Math.PI / 180.0);
            float var22 = (float)Math.cos(var20);
            float var23 = (float)Math.cos(var21);
            if (var22 > -0.05F) {
               float var24 = shw(0.0F, 0.4F, var22);
               var16 = new float[]{(float)(-Math.sin(var20)), var22, 0.0F, shw(-0.05F, 0.12F, var22) * var19};
               var17 = new float[]{1.0F, 0.62F + 0.35F * var24, 0.38F + 0.52F * var24};
            } else {
               var16 = new float[]{(float)(-Math.sin(var21)), var23, 0.0F, shw(-0.05F, 0.15F, var23) * var19 * 0.35F};
               var17 = new float[]{0.6F, 0.7F, 1.0F};
            }

            int var38 = (Integer)var31.method_75689(EnvironmentAttributes.field_63746, var7);
            var18 = new float[]{(var38 >> 16 & 0xFF) / 255.0F, (var38 >> 8 & 0xFF) / 255.0F, (var38 & 0xFF) / 255.0F};
         }

         float var33 = Math.max((float)this.sgz.get(), var32);
         float var34 = Math.min(var1.field_1690.method_38521() * 16.0F, 200.0F);
         this.shi.rotation(var3.method_23767());
         this.shj.rotation(var3.method_23767().conjugate(new Quaternionf()));
         ArrayList var35 = new ArrayList<>(this.she);
         float var36 = (float)this.shb.get();
         float[] var37 = var16;
         float[] var39 = var17;
         float[] var25 = var18;
         boolean var27 = this.shc.get();
         boolean var28 = this.shk;
         int var29 = this.shl - var9;
         int var30 = this.shm - var11;
         vbb.draw(var19x -> {
            var19x.putMat4f(this.shi);
            var19x.putMat4f(this.shj);
            var19x.putVec4(Math.floorMod(var9, 4096), var10, Math.floorMod(var11, 4096), this.shp);
            var19x.putVec4((float)(var8.field_1352 - var9), (float)(var8.field_1351 - var10), (float)(var8.field_1350 - var11), var33);
            var19x.putVec4((float)this.sgv.get(), (float)this.sgw.get(), (float)this.sgx.get(), (float)this.sgy.get());
            var19x.putVec4(var37[0], var37[1], var37[2], var37[3]);
            var19x.putVec4(var39[0], var39[1], var39[2], 0.0F);
            var19x.putVec4(var25[0], var25[1], var25[2], var27 ? 1.0F : 0.0F);
            var19x.putVec4(var29, var30, 128.0F, var28 ? 1.0F : 0.0F);
            var19x.putVec4(var13, var34, var35.size(), var36);
            this.shu(var19x, var35, var8, var4);
         });
      } else {
         this.sho = 0L;
      }
   }

   private void shu(Std140Builder var1, List<sfz> var2, Vec3d var3, long var4) {
      float var6 = 0.0F;
      float var7 = 0.0F;
      float var8 = 0.0F;

      for (sfz var10 : var2) {
         var6 += (float)(var10.sga - var3.field_1352);
         var7 += (float)(var10.sgb - var3.field_1351);
         var8 += (float)(var10.sgc - var3.field_1350);
      }

      int var19 = Math.max(1, var2.size());
      var6 /= var19;
      var7 /= var19;
      var8 /= var19;
      float var20 = 0.0F;

      for (sfz var12 : var2) {
         float var13 = (float)(var12.sga - var3.field_1352) - var6;
         float var14 = (float)(var12.sgb - var3.field_1351) - var7;
         float var15 = (float)(var12.sgc - var3.field_1350) - var8;
         var20 = Math.max(var20, (float)Math.sqrt(var13 * var13 + var14 * var14 + var15 * var15));
      }

      var1.putVec4(var6, var7, var8, var2.isEmpty() ? 0.0F : var20 + 2.5F);

      for (int var21 = 0; var21 < 32; var21++) {
         if (var21 < var2.size()) {
            sfz var23 = (sfz)var2.get(var2.size() - 1 - var21);
            var1.putVec4(
               (float)(var23.sga - var3.field_1352),
               (float)(var23.sgb - var3.field_1351),
               (float)(var23.sgc - var3.field_1350),
               (float)(var4 - var23.sgg) / 1.0E9F
            );
         } else {
            var1.putVec4(0.0F, -1000.0F, 0.0F, 1000.0F);
         }
      }

      for (int var22 = 0; var22 < 32; var22++) {
         if (var22 < var2.size()) {
            sfz var24 = (sfz)var2.get(var2.size() - 1 - var22);
            var1.putVec4(var24.sgd, var24.sge, var24.sgf, var24.sgh);
         } else {
            var1.putVec4(0.0F, 1.0F, 1.0F, 0.0F);
         }
      }
   }

   private void shv(ClientWorld var1, int var2, int var3) {
      short var4 = 128;

      for (int var5 = 0; var5 < var4; var5++) {
         for (int var6 = 0; var6 < var4; var6++) {
            int var7 = var1.method_8624(Type.field_13197, var2 + var6, var3 + var5);
            int var8 = Math.max(0, Math.min(65535, var7 + 64));
            boolean var9 = !var1.method_8316(this.shh.method_10103(var2 + var6, var7 - 1, var3 + var5)).method_15769();
            this.shg[var5 * var4 + var6] = 0xFF000000 | (var8 & 0xFF) << 16 | (var8 >> 8 & 0xFF) << 8 | (var9 ? 255 : 0);
         }
      }

      vbb.uploadHeights(this.shg);
      this.shl = var2;
      this.shm = var3;
      this.shn = 0;
      this.shk = true;
   }

   private static float shw(float var0, float var1, float var2) {
      float var3 = Math.max(0.0F, Math.min(1.0F, (var2 - var0) / (var1 - var0)));
      return var3 * var3 * (3.0F - 2.0F * var3);
   }
}
