package a;

import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import sun.misc.Unsafe;

public final class ett extends Camera {
   static Unsafe etu;
   static long etv = -1L;
   static Camera etw;
   static boolean etx;
   static boolean ety;
   static float etz;
   boolean eua;
   static float eub;
   static float euc;
   static boolean eud;
   static long eue;
   static boolean euf = true;

   ett() {
   }

   public static void distance(float var0) {
      etz = Math.max(0.0F, var0);
   }

   public static void viewOffset(float var0, float var1) {
      eub = var0;
      euc = var1;
      eud = true;
   }

   public static void releaseView() {
      eud = false;
   }

   void eui() {
      long var1 = System.nanoTime();
      float var3 = eue == 0L ? 0.0F : Math.min(0.1F, (float)(var1 - eue) / 1.0E9F);
      eue = var1;
      if (!eud && (eub != 0.0F || euc != 0.0F)) {
         float var4 = (float)Math.exp(-var3 * 14.0F);
         eub *= var4;
         euc *= var4;
         if (Math.abs(eub) < 0.02F && Math.abs(euc) < 0.02F) {
            eub = 0.0F;
            euc = 0.0F;
         }
      }

      if (eub != 0.0F || euc != 0.0F) {
         this.setRotation(this.getYaw() - eub, Math.max(-90.0F, Math.min(90.0F, this.getPitch() - euc)));
      }
   }

   public static void install(MinecraftClient var0) {
      if (!etx && etw == null && var0 != null && var0.gameRenderer != null && !dry.armed()) {
         try {
            GameRenderer var1 = var0.gameRenderer;
            Unsafe var2 = euk();
            long var3 = -1L;

            for (Field var8 : GameRenderer.class.getDeclaredFields()) {
               if (!Modifier.isStatic(var8.getModifiers()) && var8.getType() == Camera.class) {
                  var3 = var2.objectFieldOffset(var8);
                  break;
               }
            }

            if (var3 < 0L) {
               throw new IllegalStateException(a.d("똦쾕䕊\udb33僳홑汃\ue5f4箤\uf119盃貺ȩ鯖ᆄ靮\u2d75ꋢ㡘븓㟿䶤", 19321258, -1240045575));
            }

            Camera var10 = (Camera)var2.getObject(var1, var3);
            if (var10 instanceof ett) {
               return;
            }

            etv = var3;
            etw = var10;
            var2.putObject(var1, var3, new ett());
         } catch (Throwable var9) {
            etx = true;
            System.out.println(a.b("\ue00f馣ፚ质ۧ耓㨯뎣ⶨ꜅⃗\udabd呼춄䞊셮笶\uf4e6湉\ue819憠᮲锃ໞ袩ɯ믏㗟꽻⤭ꊋ层혇侥즠䌆ﳞ皨\uf07e槏\ue39d鴷\u177e", 142270591) + var9);
         }
      }
   }

   public static void uninstall(MinecraftClient var0) {
      if (etw != null && var0 != null && var0.gameRenderer != null) {
         try {
            euk().putObject(var0.gameRenderer, etv, etw);
         } catch (Throwable var2) {
         }

         etw = null;
         euj(var0, false);
      }
   }

   @Override
   public void update(World area, Entity focusedEntity, boolean thirdPerson, boolean inverseView, float tickProgress) {
      MinecraftClient var6 = MinecraftClient.getInstance();
      if (!thirdPerson || focusedEntity == null || dry.armed() || focusedEntity instanceof LivingEntity var7 && var7.isSleeping()) {
         this.eua = thirdPerson;
         super.update(area, focusedEntity, thirdPerson, inverseView, tickProgress);
         if (!thirdPerson && focusedEntity == var6.player) {
            this.eui();
         }

         euj(var6, false);
      } else {
         super.update(area, focusedEntity, false, inverseView, tickProgress);
         this.eua = true;
         if (focusedEntity == var6.player) {
            this.eui();
         }

         if (inverseView) {
            this.setRotation(this.getYaw() + 180.0F, -this.getPitch());
         }

         float var15 = 4.0F;
         float var8 = 1.0F;
         if (focusedEntity instanceof LivingEntity var9) {
            var8 = var9.getScale();
            var15 = (float)var9.getAttributeValue(EntityAttributes.CAMERA_DISTANCE);
         }

         float var16 = var8;
         float var10 = var15;
         if (focusedEntity.hasVehicle() && focusedEntity.getVehicle() instanceof LivingEntity var11) {
            var16 = var11.getScale();
            var10 = (float)var11.getAttributeValue(EntityAttributes.CAMERA_DISTANCE);
         }

         float var17 = Math.max(var8 * var15, var16 * var10);
         this.moveBy(-(etz > 0.0F ? etz * var8 : var17), 0.0F, 0.0F);
         boolean var18 = false;
         if (area != null) {
            BlockPos var13 = this.getBlockPos();
            BlockState var14 = area.getBlockState(var13);
            var18 = var14.isOpaqueFullCube();
         }

         euj(var6, var18);
      }
   }

   @Override
   public boolean isThirdPerson() {
      return this.eua;
   }

   static void euj(MinecraftClient var0, boolean var1) {
      if (var0 != null && var1 != ety) {
         ety = var1;
         if (var1) {
            euf = var0.chunkCullingEnabled;
            var0.chunkCullingEnabled = false;
         } else {
            var0.chunkCullingEnabled = euf;
         }
      }
   }

   static Unsafe euk() throws ReflectiveOperationException {
      if (etu == null) {
         Field var0 = Unsafe.class.getDeclaredField(a.b("餅\ue0a8橶\uf437翛亮䌶쫀咜", -1765172872));
         var0.setAccessible(true);
         etu = (Unsafe)var0.get(null);
      }

      return etu;
   }
}
