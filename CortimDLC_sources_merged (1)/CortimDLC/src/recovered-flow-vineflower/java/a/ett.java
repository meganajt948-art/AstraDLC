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
   private static Unsafe etu;
   private static long etv = -1L;
   private static Camera etw;
   private static boolean etx;
   private static boolean ety;
   private static float etz;
   private boolean eua;
   private static float eub;
   private static float euc;
   private static boolean eud;
   private static long eue;
   private static boolean euf = true;

   private ett() {
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

   private void eui() {
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
         this.method_19325(this.method_19330() - eub, Math.max(-90.0F, Math.min(90.0F, this.method_19329() - euc)));
      }
   }

   public static void install(MinecraftClient var0) {
      if (!etx && etw == null && var0 != null && var0.field_1773 != null && !dry.armed()) {
         try {
            GameRenderer var1 = var0.field_1773;
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
      if (etw != null && var0 != null && var0.field_1773 != null) {
         try {
            euk().putObject(var0.field_1773, etv, etw);
         } catch (Throwable var2) {
         }

         etw = null;
         euj(var0, false);
      }
   }

   public void method_19321(World var1, Entity var2, boolean var3, boolean var4, float var5) {
      MinecraftClient var6 = MinecraftClient.method_1551();
      if (!var3 || var2 == null || dry.armed() || var2 instanceof LivingEntity var7 && var7.method_6113()) {
         this.eua = var3;
         super.method_19321(var1, var2, var3, var4, var5);
         if (!var3 && var2 == var6.field_1724) {
            this.eui();
         }

         euj(var6, false);
      } else {
         super.method_19321(var1, var2, false, var4, var5);
         this.eua = true;
         if (var2 == var6.field_1724) {
            this.eui();
         }

         if (var4) {
            this.method_19325(this.method_19330() + 180.0F, -this.method_19329());
         }

         float var15 = 4.0F;
         float var8 = 1.0F;
         if (var2 instanceof LivingEntity var9) {
            var8 = var9.method_55693();
            var15 = (float)var9.method_45325(EntityAttributes.field_59674);
         }

         float var16 = var8;
         float var10 = var15;
         if (var2.method_5765() && var2.method_5854() instanceof LivingEntity var11) {
            var16 = var11.method_55693();
            var10 = (float)var11.method_45325(EntityAttributes.field_59674);
         }

         float var17 = Math.max(var8 * var15, var16 * var10);
         this.method_19324(-(etz > 0.0F ? etz * var8 : var17), 0.0F, 0.0F);
         boolean var18 = false;
         if (var1 != null) {
            BlockPos var13 = this.method_19328();
            BlockState var14 = var1.method_8320(var13);
            var18 = var14.method_26216();
         }

         euj(var6, var18);
      }
   }

   public boolean method_19333() {
      return this.eua;
   }

   private static void euj(MinecraftClient var0, boolean var1) {
      if (var0 != null && var1 != ety) {
         ety = var1;
         if (var1) {
            euf = var0.field_1730;
            var0.field_1730 = false;
         } else {
            var0.field_1730 = euf;
         }
      }
   }

   private static Unsafe euk() throws ReflectiveOperationException {
      if (etu == null) {
         Field var0 = Unsafe.class.getDeclaredField(a.b("餅\ue0a8橶\uf437翛亮䌶쫀咜", -1765172872));
         var0.setAccessible(true);
         etu = (Unsafe)var0.get(null);
      }

      return etu;
   }
}
