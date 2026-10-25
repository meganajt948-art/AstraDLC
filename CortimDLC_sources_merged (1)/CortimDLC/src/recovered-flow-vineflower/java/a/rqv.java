package a;

import flow.cosmetic.Cosmetics;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.render.state.WorldRenderState;
import net.minecraft.item.ItemStack;

public class rqv extends kfe {
   static rqv rqw;
   static final Map<Class<?>, List<Field>> rqx = new HashMap<>();
   static final Map<Class<?>, Constructor<?>> rqy = new HashMap<>();
   static final Set<EntityRenderState> rqz = Collections.newSetFromMap(new IdentityHashMap<>());
   static Field rra;
   static boolean rrb;
   final vmc rrc = this.add(new vmc("Transparency", 0.5, 0.0, 0.95, 0.05).percent());
   final vkl rrd = this.add(new vkl("Mobs", false));

   public rqv() {
      super(new String(new char[]{'S', 'h', 'o', 'w', 'I', 'n', 'v', 'i', 's', 'i', 'b', 'l', 'e'}), "Invisible players show up see-through", kfa.RENDER);
      rqw = this;
   }

   public static boolean isFadedBody(EntityRenderState var0) {
      return !rqz.isEmpty() && rqz.contains(var0);
   }

   public static void afterExtraction(WorldRenderState var0) {
      rqz.clear();
      rqv var1 = rqw;
      if (var1 != null && var1.isEnabled() && MinecraftClient.getInstance().world != null) {
         boolean var2 = ukl.canFade();
         ArrayList var3 = null;

         for (EntityRenderState var5 : var0.entityRenderStates) {
            if (var5 instanceof LivingEntityRenderState var6
               && var6.invisibleToPlayer
               && (var5 instanceof PlayerEntityRenderState || var1.rrd.get())
               && !Cosmetics.hidesBody(var5)) {
               var6.invisibleToPlayer = false;
               if (var2) {
                  var6.invisible = false;
                  boolean var7 = var5 instanceof PlayerEntityRenderState var8 && Cosmetics.wears(var8.id);
                  if (var5 instanceof BipedEntityRenderState var10 && (var7 || rrg(var10))) {
                     BipedEntityRenderState var9 = rrh(var10);
                     if (var9 != null) {
                        if (var3 == null) {
                           var3 = new ArrayList();
                        }

                        var3.add(var9);
                        if (var7) {
                           rqz.add(var5);
                        }

                        var10.equippedHeadStack = ItemStack.EMPTY;
                        var10.equippedChestStack = ItemStack.EMPTY;
                        var10.equippedLegsStack = ItemStack.EMPTY;
                        var10.equippedFeetStack = ItemStack.EMPTY;
                     }
                  }

                  ukl.fade(var5, 1.0F - (float)var1.rrc.get());
               }
            }
         }

         if (var3 != null) {
            var0.entityRenderStates.addAll(var3);
         }
      }
   }

   static boolean rrg(BipedEntityRenderState var0) {
      return !var0.equippedHeadStack.isEmpty() || !var0.equippedChestStack.isEmpty() || !var0.equippedLegsStack.isEmpty() || !var0.equippedFeetStack.isEmpty();
   }

   static BipedEntityRenderState rrh(BipedEntityRenderState var0) {
      if (rrb) {
         return null;
      }

      try {
         Class var1 = var0.getClass();
         Constructor var2 = rqy.get(var1);
         if (var2 == null) {
            var2 = var1.getDeclaredConstructor();
            var2.setAccessible(true);
            rqy.put(var1, var2);
         }

         BipedEntityRenderState var3 = (BipedEntityRenderState)var2.newInstance();

         for (Field var5 : rri(var1)) {
            var5.set(var3, var5.get(var0));
         }

         var3.invisible = true;
         var3.invisibleToPlayer = true;
         var3.outlineColor = 0;
         var3.displayName = null;
         var3.nameLabelPos = null;
         var3.leashDatas = null;
         var3.shadowRadius = 0.0F;
         if (rra != null) {
            rra.set(var3, new ArrayList());
         }

         return var3;
      } catch (Throwable var6) {
         rrb = true;
         System.out
            .println(
               new String(
                     new char[]{
                        '[',
                        'F',
                        'l',
                        'o',
                        'w',
                        '2',
                        ']',
                        ' ',
                        's',
                        'o',
                        'l',
                        'i',
                        'd',
                        ' ',
                        'a',
                        'r',
                        'm',
                        'o',
                        'u',
                        'r',
                        ' ',
                        'u',
                        'n',
                        'a',
                        'v',
                        'a',
                        'i',
                        'l',
                        'a',
                        'b',
                        'l',
                        'e',
                        ':',
                        ' '
                     }
                  )
                  + var6
            );
         return null;
      }
   }

   static List<Field> rri(Class<?> var0) {
      List var1 = rqx.get(var0);
      if (var1 != null) {
         return var1;
      }

      ArrayList var2 = new ArrayList();

      for (Class var3 = var0; var3 != null && var3 != Object.class; var3 = var3.getSuperclass()) {
         for (Field var7 : var3.getDeclaredFields()) {
            if (!Modifier.isStatic(var7.getModifiers())) {
               var7.setAccessible(true);
               var2.add(var7);
               if (var3 == EntityRenderState.class && var7.getType() == List.class && var7.getName().equals("shadowPieces")) {
                  rra = var7;
               }
            }
         }
      }

      if (rra == null) {
         for (Field var9 : var2) {
            if (var9.getDeclaringClass() == EntityRenderState.class && var9.getType() == List.class && Modifier.isFinal(var9.getModifiers())) {
               rra = var9;
            }
         }
      }

      rqx.put(var0, var2);
      return var2;
   }
}
