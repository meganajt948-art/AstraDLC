package a;

import com.mojang.blaze3d.textures.GpuTextureView;
import flow.dev.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.render.state.WorldRenderState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;

public final class swh {
   static final float swi = 5.5F;
   static final float swj = 4.5F;
   static final float swk = 14.0F;
   static final float swl = 12.5F;
   static final float swm = 10.0F;
   static final float swn = 1.4F;
   static final float swo = 9.0F;
   static final float swp = 3.0F;
   static final float swq = 2.6F;
   static final float swr = 2.4F;
   static final float sws = 56.0F;
   static final float swt = 16.0F;
   static final float swu = 1.4F;
   static final float swv = 2.4F;
   static final double sww = 8.0;
   static final float swx = 0.3F;
   static final double swy = 0.3;
   static final int swz = -11870592;
   static final int sxa = -340971;
   static final int sxb = -38357;
   static final int sxc = -1096636;
   static final int sxd = -670639;
   static final int sxe = -11870592;
   static final int sxf = -15368131;
   static final int sxg = -1258291201;
   static final EquipmentSlot[] sxh = new EquipmentSlot[]{
      EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET, EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND
   };
   static final int sxi = 14;
   static final float[] sxj = sxq();
   static int step = 14;
   static final swb NAME = new swb(vek.SEMIBOLD, 7.4F);
   static final swb NAME_BOLD = new swb(vek.BOLD, 7.4F);
   static final swb sxk = new swb(vek.MEDIUM, 5.4F);
   static final swb sxl = new swb(vek.BOLD, 5.2F);
   static final Map<Integer, svy> sxm = new HashMap<>();
   static long sxn = -1L;

   static float[] sxq() {
      float[] var0 = new float[26];

      for (int var1 = 0; var1 < var0.length; var1++) {
         var0[var1] = (float)Math.pow(2.0, (var1 - 14) / 8.0);
      }

      var0[14] = 1.0F;
      return var0;
   }

   swh() {
   }

   public static void render(DrawContext var0, RenderTickCounter var1) {
      if (!(MinecraftClient.getInstance().currentScreen instanceof hlc)) {
         uut.beginFrame();
         sxu(var0, var1.getTickProgress(true));
      }
   }

   public static void renderInMenu(DrawContext var0) {
      sxu(var0, MinecraftClient.getInstance().getRenderTickCounter().getTickProgress(true));
   }

   public static void hideVanilla(WorldRenderState var0) {
      rjy var1 = rjy.get();
      MinecraftClient var2 = MinecraftClient.getInstance();
      if (var1 != null && var1.isEnabled() && var2.world != null) {
         boolean var3 = var1.mobs.get() && sxr();

         for (EntityRenderState var5 : var0.entityRenderStates) {
            if (var5 instanceof PlayerEntityRenderState var6
               && (var6.displayName != null || var6.playerName != null)
               && var2.world.getEntityById(var6.id) instanceof PlayerEntity var7
               && var1.shows(var2, var7)) {
               var6.displayName = null;
               var6.playerName = null;
            } else if (var3 && var5.displayName != null && var5 instanceof LivingEntityRenderState && !(var5 instanceof PlayerEntityRenderState) && sxs(var5)) {
               var5.displayName = null;
            }
         }
      }
   }

   static boolean sxr() {
      for (svy var1 : sxm.values()) {
         if (var1.mob) {
            return true;
         }
      }

      return false;
   }

   static boolean sxs(EntityRenderState var0) {
      for (svy var2 : sxm.values()) {
         if (var2.mob && var2.player.getType() == var0.entityType) {
            double var3 = var2.player.getX() - var0.x;
            double var5 = var2.player.getZ() - var0.z;
            double var7 = var2.player.getY() - var0.y;
            if (var3 * var3 + var7 * var7 + var5 * var5 < 1.0) {
               return true;
            }
         }
      }

      return false;
   }

   static boolean sxt(rjy var0, MinecraftClient var1, LivingEntity var2) {
      if (var2 instanceof PlayerEntity var4) {
         return var0.shows(var1, var4);
      } else {
         rhs var3 = rhs.get();
         return var3 != null && var0.showsMob(var1, var2) && var3.picks(var2);
      }
   }

   static void sxu(DrawContext var0, float var1) {
      MinecraftClient var2 = MinecraftClient.getInstance();
      rjy var3 = rjy.get();
      if (var3 != null && var3.isEnabled() && var2.world != null && var2.player != null && !var2.options.hudHidden) {
         unf.observe(var0);
         if (unf.frame() != sxn) {
            sxn = unf.frame();
            float var4 = unf.delta() * (float)iov.ANIMATION.get();
            iov.update(var4);
            float var5 = var0.getScaledWindowWidth();
            float var6 = var0.getScaledWindowHeight();

            usn var7;
            try {
               var7 = usn.capture(var1, var5, var6);
            } catch (Throwable var24) {
               return;
            }

            sxm.values().removeIf(var1x -> var1x.player.isRemoved() || var2.world.getEntityById(var1x.player.getId()) != var1x.player);

            for (PlayerEntity var9 : var2.world.getPlayers()) {
               if (var3.shows(var2, var9)) {
                  sxm.computeIfAbsent(var9.getId(), var1x -> new svy(var9));
               }
            }

            if (var3.mobs.get() && rhs.get() != null) {
               for (Entity var27 : var2.world.getEntities()) {
                  if (var27 instanceof LivingEntity var10 && !(var27 instanceof PlayerEntity) && sxt(var3, var2, var10)) {
                     sxm.computeIfAbsent(var10.getId(), var1x -> new svy(var10));
                  }
               }
            }

            ArrayList<svy> var26 = new ArrayList<>();
            ArrayList<Integer> var28 = new ArrayList<>();

            for (Entry<Integer, svy> var11 : sxm.entrySet()) {
               svy var12 = var11.getValue();
               LivingEntity var13 = var12.player;
               Vec3d var14 = var13.getLerpedPos(var1);
               double var15 = var14.x;
               double var17 = var14.y + var13.getHeight() + 0.3;
               double var19 = var14.z;
               boolean var21 = sxt(var3, var2, var13);
               boolean var22 = var7.project(var15, var17, var19, var12.screen);
               float var23 = var12.shown.step(var21 && var22, var4);
               if (var23 <= 0.004F) {
                  if (!var21) {
                     var28.add((Integer)var11.getKey());
                  }
               } else if (var22) {
                  var12.distance = var7.distance(var15, var17, var19);
                  var26.add(var12);
               }
            }

            for (Integer var32 : var28) {
               sxm.remove(var32);
            }

            if (!var26.isEmpty()) {
               var26.sort((var0x, var1x) -> Double.compare(var1x.distance, var0x.distance));
               sxv(var26);
               GpuTextureView var31 = null;
               if (var3.glass() && uij.TAGS.capture(var0, var3.blur.getInt(), null)) {
                  var31 = uij.TAGS.result(var0);
               }

               float var33 = Math.max(1, var2.getWindow().getScaleFactor());

               for (svy var35 : var26) {
                  if (!var35.folded) {
                     sxx(var0, var2, var3, var35, var31, var4, var33);
                  }
               }

               step = 14;
            }
         }
      } else {
         sxm.clear();
      }
   }

   static void sxv(List<svy> var0) {
      for (svy var2 : var0) {
         var2.crowd = 1;
         var2.folded = false;
      }

      for (int var5 = var0.size() - 1; var5 >= 0; var5--) {
         svy var7 = (svy)var0.get(var5);
         if (var7.mob && !var7.player.hasCustomName()) {
            for (int var3 = var0.size() - 1; var3 > var5; var3--) {
               svy var4 = (svy)var0.get(var3);
               if (var4.mob
                  && !var4.folded
                  && var4.player.getType() == var7.player.getType()
                  && !var4.player.hasCustomName()
                  && Math.abs(var4.screen[0] - var7.screen[0]) < 56.0F
                  && Math.abs(var4.screen[1] - var7.screen[1]) < 16.0F) {
                  var7.folded = true;
                  var4.crowd++;
                  break;
               }
            }
         }
      }

      for (svy var8 : var0) {
         if (var8.crowd != var8.crowdShown) {
            var8.crowdShown = var8.crowd;
            var8.crowdText = var8.crowd > 1 ? a.c(1988123643, "嬭") + var8.crowd : null;
         }
      }
   }

   static float sxw(rjy var0, double var1) {
      float var3 = (float)Math.max(0.3F, Math.min(1.0, 8.0 / Math.max(0.1, var1)));
      float var4 = (float)var0.shrink.get();
      return (float)var0.size.get() * (1.0F - var4 * (1.0F - var3));
   }

   static float stepScale() {
      return sxj[step];
   }

   static int stepFor(float var0) {
      double var1 = Math.log(Math.max(0.01F, var0)) / Math.log(2.0) * 8.0;
      return Math.max(0, Math.min(sxj.length - 1, (int)Math.round(var1) + 14));
   }

   static void sxx(DrawContext var0, MinecraftClient var1, rjy var2, svy var3, GpuTextureView var4, float var5, float var6) {
      LivingEntity var7 = var3.player;
      step = stepFor(sxw(var2, var3.distance));
      float var8 = sxj[step];
      long var9 = var1.world.getTime();
      var3.info(var1, var9);
      boolean var11 = var2.friends.get() && var3.friend;
      List var12 = var3.name(var9);
      boolean var13 = var3.reading.unknown();
      syd(var3, var3.reading.fraction(), var5);
      int var14 = var13 ? -1258291201 : healthColor(var3.health.get());
      String var15 = var3.hpLabel;
      String var16 = var3.absText;
      String var17 = var2.distance.get() ? var3.distance(var3.distance) : null;
      int var18 = var2.ping.get() ? var3.ping : -1;
      String var19 = var18 >= 0 ? var3.pingText : null;
      List var20 = var2.items.is(a.b("蟞﹆璕", 754091922)) ? List.of() : var3.gear;
      boolean var21 = var2.items.is(a.d("俨㙾벯⋛ꤋ⾱", -683901274, -1671155455)) && !var20.isEmpty();
      boolean var22 = var2.showsHealthBar();
      if (var3.widthStep != step || var3.widthTick != var9) {
         var3.widthStep = step;
         var3.widthTick = var9;
         var3.nameW = svp.width(var12, NAME, NAME_BOLD);
         var3.hpTextW = NAME.width(var15) + (var16 != null ? 2.0F + sxk.width(var16) : 0.0F) + 5.0F;
      }

      float var23 = var3.nameW;
      float var24 = var2.showsHealthText() ? var3.hpTextW : 0.0F;
      int var25 = var3.mob && rhs.get() != null ? rhs.get().colorOf(var7) : 0;
      float var26 = var11 ? 14.6F : (var25 != 0 ? 13.3F : 5.5F);
      String var27 = var3.crowdText;
      float var28 = var26 + var23;
      if (var27 != null) {
         var28 += 3.6000001F + sxk.width(var27);
      }

      if (var24 > 0.0F) {
         var28 += 4.5F + var24;
      }

      if (var17 != null) {
         var28 += 4.5F + sxk.width(var17);
      }

      if (var19 != null) {
         var28 += 3.6000001F + sxk.width(var19);
      }

      if (var21) {
         var28 += 4.5F + var20.size() * 10.0F + (var20.size() - 1) * 1.4F;
      }

      var28 += 5.5F;
      float var29 = var21 ? 14.0F : 12.5F;
      float var30 = var29 + (var22 ? 2.4F : 0.0F);
      float var31 = -var28 * 0.5F;
      float var32 = -var30;
      float var33 = var32 + var29 * 0.5F;
      float var34 = var30 * 0.5F * (float)var2.rounding.get();
      float var35 = var3.shown.get();
      float var36 = vcq.outCubic(var35);
      float var37 = var35 * (var7.isInvisible() ? 0.55F : 1.0F);
      float var38 = Math.round(var3.screen[0] * var6) / var6;
      float var39 = Math.round(var3.screen[1] * var6) / var6;
      float var40 = var8 * (0.86F + 0.14F * var36);
      float var41 = (!var21 && !var20.isEmpty() ? var32 - 2.0F - 10.0F : var32) - 2.0F;
      float var42 = var39 + (1.0F - var36) * 4.0F;
      if (!(var38 + (var31 - 2.0F) * var40 > var0.getScaledWindowWidth())
         && !(var38 - (var31 - 2.0F) * var40 < 0.0F)
         && !(var42 + var41 * var40 > var0.getScaledWindowHeight())
         && !(var42 + 4.0F * var40 < 0.0F)) {
         var0.getMatrices().pushMatrix();
         var0.getMatrices().translate(var38, var39 + (1.0F - var36) * 4.0F);
         var0.getMatrices().scale(var40, var40);
         uut.pushAlpha(var37);

         try {
            boolean var43 = var2.background.is(a.c(297556089, "堳↣ꭱ㔋"));
            sxy(var0, var2, var4, var31, var32, var28, var30, var34);
            int var44 = ujt.withAlpha(0, var43 ? 170 : 110);
            if (var11) {
               sxz(var0, var31 + 2.6F, var33);
            } else if (var25 != 0) {
               uut.circle(var0, var31 + 5.5F + 2.4F, var33, 2.4F, var25);
            }

            float var45 = var31 + var26;
            var45 = svp.draw(var0, var12, var45, var33, NAME, NAME_BOLD, var44);
            if (var27 != null) {
               var45 += 3.6000001F;
               var45 = sxk.draw(var0, var27, var45, sxk.centerTop(var33), var25 != 0 ? var25 : -1258291201);
            }

            if (var24 > 0.0F) {
               var45 += 4.5F;
               float var46 = NAME.capHeight() + 4.2F;
               uut.round(var0, var45, var33 - var46 * 0.5F, var24, var46, Math.min(var46 * 0.5F, 2.6F), ujt.withAlpha(var14, 44));
               float var47 = var45 + 2.5F;
               float var48 = NAME.centerTop(var33);
               NAME.draw(var0, var15, var47 + 0.55F, var48 + 0.55F, var44);
               var47 = NAME.draw(var0, var15, var47, var48, var14);
               if (var16 != null) {
                  sxk.draw(var0, var16, var47 + 2.0F, sxk.centerTop(var33), -670639);
               }

               var45 += var24;
            }

            if (var17 != null) {
               var45 += 4.5F;
               var45 = sxk.draw(var0, var17, var45, sxk.centerTop(var33), -1258291201);
            }

            if (var19 != null) {
               var45 += 3.6000001F;
               var45 = sxk.draw(var0, var19, var45, sxk.centerTop(var33), syf(var18));
            }

            if (var21) {
               var45 += 4.5F;
               sya(var0, var20, var45, var33 - 5.0F, var37);
            } else if (!var20.isEmpty()) {
               float var59 = var20.size() * 10.0F + (var20.size() - 1) * 1.4F;
               sya(var0, var20, -var59 * 0.5F, var32 - 2.0F - 10.0F, var37);
            }

            if (var22) {
               syb(var0, var3, var31 + var34 * 0.5F + 2.0F, -2.5F, var28 - var34 - 4.0F, var13);
            }
         } finally {
            uut.popAlpha();
            var0.getMatrices().popMatrix();
         }
      }
   }

   static void sxy(DrawContext var0, rjy var1, GpuTextureView var2, float var3, float var4, float var5, float var6, float var7) {
      if (!var1.background.is(a.c(1139034866, "䪸㌨맺➀"))) {
         float var8 = (float)var1.opacity.get();

                  int var9;
         if (java.util.Objects.equals(var1.tint.get(), a.b("\udcc1ꕕ⾕뇽", -1104946047))) {
            var9 = -16119283;
         }
         else if (java.util.Objects.equals(var1.tint.get(), a.b("붭쐾仭킚孆\udded", 853786090))) {
            var9 = ujt.lerp(iov.accent(), -16777216, 0.55F) | 0xFF000000;
         }
         else {
            var9 = ujt.lerp(iov.window, -16316661, 0.2F + 0.7F * iov.lightness()) | 0xFF000000;
         }
         ukf.shadow(var0, var3, var4, var5, var6, var7, 1.2F, 0.0F);
         boolean var12 = false;
         if (var2 != null) {
            int var13 = hyv.tint(var9, var8);
            var12 = var1.background.is(a.d("ۻ罯\uf5a4毑\ue01a暦", -801835555, 274920300))
               ? uut.liquid(var0, var2, var3, var4, var5, var6, var7, var13, 1.0F, hyv.lens(Math.min((float)hyv.EDGE.get(), var6 * 0.42F)))
               : uut.glass(var0, var2, var3, var4, var5, var6, var7, var13, 1.0F);
         }

         if (!var12) {
            float var14 = var1.glass() ? Math.max(0.55F, var8) : var8;
            uut.round(var0, var3, var4, var5, var6, var7, ujt.withAlpha(var9, Math.round(255.0F * var14)));
         }

         ukf.sheen(var0, var3, var4, var5, var6, var7, 0.8F);
         ukf.rim(var0, var3, var4, var5, var6, var7, 0.0F, var12 && var1.background.is(a.b("ﰈ薜བྷ鄢\u1ae9鱕", -1254097854)) ? 0.6F : 1.0F);
      }
   }

   static void sxz(DrawContext var0, float var1, float var2) {
      float var3 = var2 - 4.5F;
      float var4 = var1 + 4.5F;
      float var5 = 4.5F;
      uut.shadow(var0, var1, var3 + 0.6F, 9.0F, 9.0F, var5, 3.2F, ujt.withAlpha(-15368131, 150));
      uut.gradientV(var0, var1, var3, 9.0F, 9.0F, var5, -11870592, -15368131);
      uut.outlineGradientV(var0, var1, var3, 9.0F, 9.0F, var5, 0.6F, -2130706433, 285212671);
      syc(var0, vhz.FRIEND_BADGE, var4, var2 + 0.45F, 6.2999997F, 1342516758);
      syc(var0, vhz.FRIEND_BADGE, var4, var2 + 0.1F, 6.2999997F, -1);
   }

   static void sya(DrawContext var0, List<ItemStack> var1, float var2, float var3, float var4) {
      float var5 = 0.625F * Math.min(1.0F, var4 * 2.5F);

      for (ItemStack var7 : var1) {
         if (var5 > 0.02F) {
            var0.getMatrices().pushMatrix();
            var0.getMatrices().translate(var2 + 5.0F, var3 + 5.0F);
            var0.getMatrices().scale(var5, var5);
            var0.drawItem(var7, -8, -8);
            var0.getMatrices().popMatrix();
         }

         if (var7.isDamageable() && var7.isDamaged() && var7.getMaxDamage() > 0) {
            float var8 = 1.0F - (float)var7.getDamage() / var7.getMaxDamage();
            float var9 = 8.0F;
            uut.round(var0, var2 + 1.0F, var3 + 10.0F + 0.6F, var9, 1.1F, 0.55F, 1711276032);
            uut.round(var0, var2 + 1.0F, var3 + 10.0F + 0.6F, Math.max(1.1F, var9 * var8), 1.1F, 0.55F, healthColor(var8));
         }

         if (var7.getCount() > 1) {
            String var11 = String.valueOf(var7.getCount());
            float var12 = var2 + 10.0F + 0.8F - sxl.width(var11);
            float var10 = sxl.centerTop(var3 + 10.0F - 1.4F);
            sxl.draw(var0, var11, var12 + 0.5F, var10 + 0.5F, -1073741824);
            sxl.draw(var0, var11, var12, var10, -1);
         }

         var2 += 11.4F;
      }
   }

   static void syb(DrawContext var0, svy var1, float var2, float var3, float var4, boolean var5) {
      uut.round(var0, var2, var3, var4, 1.4F, 0.7F, 822083583);
      if (!var5) {
         float var6 = var1.health.get();
         float var7 = var1.trail.get();
         if (var7 > var6 + 0.002F) {
            uut.round(var0, var2, var3, Math.max(1.4F, var4 * var7), 1.4F, 0.7F, ujt.withAlpha(-1096636, 150));
         }

         uut.round(var0, var2, var3, Math.max(1.4F, var4 * var6), 1.4F, 0.7F, healthColor(var6));
      }
   }

   static void syc(DrawContext var0, vhz var1, float var2, float var3, float var4, int var5) {
      float var6 = sxj[step];
      var0.getMatrices().pushMatrix();
      var0.getMatrices().scale(1.0F / var6, 1.0F / var6);
      vjf.draw(var0, var1, var2 * var6, var3 * var6, var4 * var6, var5);
      var0.getMatrices().popMatrix();
   }

   static void syd(svy var0, float var1, float var2) {
      if (var0.health.get() < 0.0F) {
         var0.health.set(var1);
         var0.trail.set(var1);
      }

      long var3 = System.currentTimeMillis();
      float var5 = var0.health.get();
      if (var1 < var5 - 0.001F && var0.trail.get() <= var5 + 0.001F) {
         var0.trailHold = var3 + 350L;
         var0.trail.set(Math.max(var0.trail.get(), var5));
      }

      var0.health.step(var1, var2);
      if (var1 > var0.trail.get() || var3 > var0.trailHold) {
         var0.trail.step(Math.max(var1, var0.health.get()), var2);
      }
   }

   static int healthColor(float var0) {
      if (var0 >= 0.75F) {
         return ujt.lerp(-340971, -11870592, (var0 - 0.75F) / 0.25F);
      } else {
         return var0 >= 0.5F ? ujt.lerp(-38357, -340971, (var0 - 0.5F) / 0.25F) : ujt.lerp(-1096636, -38357, Math.max(0.0F, var0) / 0.5F);
      }
   }

   static int sye(MinecraftClient var0, PlayerEntity var1) {
      ClientPlayNetworkHandler var2 = var0.getNetworkHandler();
      PlayerListEntry var3 = var2 != null ? var2.getPlayerListEntry(var1.getUuid()) : null;
      return var3 != null ? var3.getLatency() : -1;
   }

   static int syf(int var0) {
      return var0 < 80 ? -11870592 : (var0 < 160 ? -340971 : -1096636);
   }

   static String syg(double var0) {
      String var2 = wap.unit(a.b("뫊", 866237094));
      return var0 < 10.0 ? vxu.fixed(var0, 1) + var2 : Math.round(var0) + var2;
   }
}
