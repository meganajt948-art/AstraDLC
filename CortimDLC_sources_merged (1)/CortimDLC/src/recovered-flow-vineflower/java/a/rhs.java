package a;

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

public class rhs extends kfe {
   private static rhs rht;
   private final vlj rhu = this.add(
      new vlj(
         "Mobs",
         vlg.MOBS,
         "minecraft:villager",
         "minecraft:zombie_villager",
         "minecraft:wandering_trader",
         "minecraft:iron_golem",
         "minecraft:snow_golem",
         "minecraft:magma_cube",
         "minecraft:wolf",
         "minecraft:cat",
         "minecraft:horse",
         "minecraft:donkey",
         "minecraft:mule",
         "minecraft:llama",
         "minecraft:parrot",
         "minecraft:allay",
         "minecraft:axolotl",
         "minecraft:shulker"
      )
   );
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
   private static final int[][] rim = new int[][]{{0, 1}, {2, 3}, {4, 5}, {6, 7}, {0, 2}, {1, 3}, {4, 6}, {5, 7}, {0, 4}, {1, 5}, {2, 6}, {3, 7}};
   private static final int[][] rin = new int[][]{{0, 1, 5, 4}, {2, 6, 7, 3}, {0, 2, 3, 1}, {4, 5, 7, 6}, {0, 4, 6, 2}, {1, 3, 7, 5}};

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

   public boolean picks(Entity var1) {
      if (var1 instanceof LivingEntity var2 && !(var1 instanceof PlayerEntity) && var2.method_5805() && !var1.method_31481()) {
         if (this.rif != this.rhu.version()) {
            this.riq();
         }

         int var3 = Registries.field_41177.method_10206(var1.method_5864());
         return var3 >= 0 && var3 < this.rie.length && this.rie[var3] ? !this.rhy.get() || rir(var1) : false;
      } else {
         return false;
      }
   }

   public int colorOf(Entity var1) {
      return this.rhw.get() ? kindColor(var1) : this.rhx.color() | 0xFF000000;
   }

   private void riq() {
      boolean[] var1 = new boolean[Registries.field_41177.method_10204()];

      for (String var3 : this.rhu.ids()) {
         Identifier var4 = Identifier.method_12829(var3);
         if (var4 != null && Registries.field_41177.method_10250(var4)) {
            int var5 = Registries.field_41177.method_10206((EntityType)Registries.field_41177.method_63535(var4));
            if (var5 >= 0 && var5 < var1.length) {
               var1[var5] = true;
            }
         }
      }

      this.rie = var1;
      this.rif = this.rhu.version();
   }

   private static boolean rir(Entity var0) {
      return !(var0 instanceof TameableEntity var1 && var1.method_6181()) && !(var0 instanceof AbstractHorseEntity var2 && var2.method_6727())
         ? var0.method_16914() || var0 instanceof MobEntity var3 && var3.method_60953()
         : true;
   }

   // $VF: Unable to simplify switch on enum
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static int kindColor(Entity var0) {
      EntityType var1 = var0.method_5864();
      if (var1 == EntityType.field_6077 || var1 == EntityType.field_17713) {
         return -12723068;
      } else if (var1 == EntityType.field_6054) {
         return -6563510;
      } else if (var1 == EntityType.field_6102) {
         return -48077;
      } else if (var1 == EntityType.field_6069) {
         return -7607718;
      } else if (var1 == EntityType.field_6147) {
         return -1517372;
      } else if (var1 == EntityType.field_6047) {
         return -1641217;
      } else if (var1 == EntityType.field_6099) {
         return -20163;
      } else if (var1 == EntityType.field_6055 || var1 == EntityType.field_16281 || var1 == EntityType.field_6081 || var1 == EntityType.field_17943) {
         return -15253;
      } else if (var1 == EntityType.field_6139
         || var1 == EntityType.field_6067
         || var1 == EntityType.field_6057
         || var1 == EntityType.field_6074
         || var1 == EntityType.field_17714
         || var1 == EntityType.field_40116
         || var1 == EntityType.field_6075
         || var1 == EntityType.field_6048) {
         return -3632802;
      } else if (var1 == EntityType.field_6104 || var1 == EntityType.field_38384) {
         return -11544321;
      } else if (var1 == EntityType.field_28315) {
         return -29992;
      } else if (var1 == EntityType.field_20346) {
         return -11443;
      } else if (var1 == EntityType.field_6109 || var1 == EntityType.field_6091 || var1 == EntityType.field_6128) {
         return -5018625;
      } else if (var1 == EntityType.field_22281 || var1 == EntityType.field_25751 || var1 == EntityType.field_6050) {
         return -11443;
      } else if (var1 == EntityType.field_6085 || var1 == EntityType.field_6143) {
         return -4158870;
      } else if (var1 == EntityType.field_6093 || var1 == EntityType.field_21973) {
         return -25932;
      } else if (var1 == EntityType.field_6115 || var1 == EntityType.field_6132) {
         return -724502;
      } else if (var1 != EntityType.field_6119 && var1 != EntityType.field_6116 && var1 != EntityType.field_38095) {
         SpawnGroup var2 = var1.method_5891();

         return switch (var2) {
            case field_6302 -> -41378;
            case field_6294 -> -8587360;
            case field_6300, field_30092, field_24460, field_34447 -> -11691009;
            case field_6303 -> -5197638;
            default -> -1;
         };
      } else {
         return -53910;
      }
   }

   private List<LivingEntity> ris(MinecraftClient var1, Vec3d var2, double var3) {
      ArrayList var5 = new ArrayList();
      double var6 = var3 * var3;

      for (Entity var9 : var1.field_1687.method_18112()) {
         if (var9 != var1.method_1560() && this.picks(var9) && var9.method_5707(var2) <= var6) {
            var5.add((LivingEntity)var9);
         }
      }

      var5.sort((var1x, var2x) -> Double.compare(var1x.method_5707(var2), var2x.method_5707(var2)));
      return var5;
   }

   public static void afterExtraction(WorldRenderState var0) {
      rhs var1 = rht;
      MinecraftClient var2 = MinecraftClient.method_1551();
      if (var1 != null && var1.isEnabled() && var1.rhv.is("Outline") && var2.field_1687 != null && var2.field_1724 != null) {
         Vec3d var3 = var2.field_1773.method_19418().method_71156();
         List var4 = var1.ris(var2, var3, var1.rhz.get());
         if (!var4.isEmpty()) {
            ukl.style(4).set((float)var1.ric.get(), (float)var1.ria.get(), (float)var1.rib.get(), (float)var1.rid.get(), 0.4F, 0.6F);
            IdentityHashMap var5 = new IdentityHashMap();

            for (EntityRenderState var7 : var0.field_61735) {
               if (var7 instanceof LivingEntityRenderState var8 && !(var7 instanceof PlayerEntityRenderState) && var7.field_58171 != null) {
                  var5.computeIfAbsent(var7.field_58171, var0x -> new ArrayList<>()).add(var8);
               }
            }

            float var25 = var2.method_61966().method_60637(true);
            IdentityHashMap var26 = new IdentityHashMap();

            for (LivingEntity var9 : var4) {
               List var10 = (List)var5.get(var9.method_5864());
               if (var10 != null) {
                  Vec3d var11 = var9.method_30950(var25);
                  LivingEntityRenderState var12 = null;
                  double var13 = 0.04;

                  for (LivingEntityRenderState var16 : var10) {
                     double var17 = var16.field_53325 - var11.field_1352;
                     double var19 = var16.field_53326 - var11.field_1351;
                     double var21 = var16.field_53327 - var11.field_1350;
                     double var23 = var17 * var17 + var19 * var19 + var21 * var21;
                     if (var23 < var13 && !var26.containsKey(var16)) {
                        var13 = var23;
                        var12 = var16;
                     }
                  }

                  if (var12 != null) {
                     var26.put(var12, Boolean.TRUE);
                     int var28 = var1.colorOf(var9);
                     ukl.paint(var12, 4, var28, ujt.lerp(var28, -1, 0.35F));
                  }
               }
            }
         }
      }
   }

   public static void render(DrawContext var0, RenderTickCounter var1) {
      rhs var2 = rht;
      MinecraftClient var3 = MinecraftClient.method_1551();
      if (var2 != null
         && var2.isEnabled()
         && var2.rhv.is("Box")
         && var3.field_1687 != null
         && var3.field_1724 != null
         && !var3.field_1690.field_1842
         && !(var3.field_1755 instanceof hlc)) {
         unf.observe(var0);
         if (unf.frame() != var2.rig) {
            var2.rig = unf.frame();
            float var4 = var1.method_60637(true);

            usn var5;
            try {
               var5 = usn.capture(var4, var0.method_51421(), var0.method_51443());
            } catch (Throwable var12) {
               return;
            }

            List var6 = var2.ris(var3, var5.camera(), var2.rhz.get());
            if (!var6.isEmpty()) {
               uut.beginFrame();
               uut.beginBatch();

               try {
                  for (int var7 = var6.size() - 1; var7 >= 0; var7--) {
                     LivingEntity var8 = (LivingEntity)var6.get(var7);
                     var2.rit(var0, var5, var8, var8.method_30950(var4), var2.colorOf(var8));
                  }
               } finally {
                  uut.endBatch();
               }
            }
         }
      }
   }

   private void rit(DrawContext var1, usn var2, LivingEntity var3, Vec3d var4, int var5) {
      double var6 = var3.method_17681() * 0.5 + 0.02;
      double var8 = var3.method_17682() + 0.02;

      for (int var10 = 0; var10 < 8; var10++) {
         this.rih[var10][0] = (var10 & 1) == 0 ? var4.field_1352 - var6 : var4.field_1352 + var6;
         this.rih[var10][1] = (var10 & 2) == 0 ? var4.field_1351 : var4.field_1351 + var8;
         this.rih[var10][2] = (var10 & 4) == 0 ? var4.field_1350 - var6 : var4.field_1350 + var6;
         this.rij[var10] = var2.depth(this.rih[var10][0], this.rih[var10][1], this.rih[var10][2]) > 0.05F
            && var2.project(this.rih[var10][0], this.rih[var10][1], this.rih[var10][2], this.rii[var10]);
      }

      float var19 = (float)this.ric.get();
      if (var19 > 0.005F) {
         Vec3d var11 = var2.camera();
         int var12 = ujt.withAlpha(var5, Math.round(255.0F * var19));
         int var13 = ujt.withAlpha(var5, Math.round(255.0F * var19 * 0.25F));

         for (int var14 = 0; var14 < 6; var14++) {
            int[] var15 = rin[var14];
            if (this.rij[var15[0]] && this.rij[var15[1]] && this.rij[var15[2]] && this.rij[var15[3]] && riu(var14, var11, var4, var6, var8)) {
               uut.quad(
                  var1,
                  this.rii[var15[0]][0],
                  this.rii[var15[0]][1],
                  (var15[0] & 2) != 0 ? var12 : var13,
                  this.rii[var15[1]][0],
                  this.rii[var15[1]][1],
                  (var15[1] & 2) != 0 ? var12 : var13,
                  this.rii[var15[2]][0],
                  this.rii[var15[2]][1],
                  (var15[2] & 2) != 0 ? var12 : var13,
                  this.rii[var15[3]][0],
                  this.rii[var15[3]][1],
                  (var15[3] & 2) != 0 ? var12 : var13
               );
            }
         }
      }

      float var20 = (float)this.rib.get();
      int var21 = ujt.withAlpha(var5, 220);

      for (int[] var16 : rim) {
         double[] var17 = this.rih[var16[0]];
         double[] var18 = this.rih[var16[1]];
         if (var2.projectSegment(var17[0], var17[1], var17[2], var18[0], var18[1], var18[2], 0.05F, this.rik, this.ril)) {
            uut.line(var1, this.rik[0], this.rik[1], this.rik[2], this.rik[3], var20, var21);
         }
      }
   }

   private static boolean riu(int var0, Vec3d var1, Vec3d var2, double var3, double var5) {
      return switch (var0) {
         case 0 -> var1.field_1351 < var2.field_1351;
         case 1 -> var1.field_1351 > var2.field_1351 + var5;
         case 2 -> var1.field_1350 < var2.field_1350 - var3;
         case 3 -> var1.field_1350 > var2.field_1350 + var3;
         case 4 -> var1.field_1352 < var2.field_1352 - var3;
         default -> var1.field_1352 > var2.field_1352 + var3;
      };
   }
}
