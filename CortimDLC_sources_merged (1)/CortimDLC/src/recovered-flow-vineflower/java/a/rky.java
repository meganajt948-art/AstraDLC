package a;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.render.state.WorldRenderState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class rky extends kfe {
   static rky rkz;
   final vlv rla = this.add(new vlv("Mode", "Outline", "Outline", "Box"));
   final vla rlb = this.add(new vla("Color", "Theme"));
   final vkl rlc = this.add(new vkl("Friends", true));
   final vkl rld = this.add(new vkl("Health color", false));
   final vkl rle = this.add(new vkl("Health bar", true));
   final vmc rlf = this.add(new vmc("Outline", 1.0, 0.0, 1.0, 0.05).percent());
   final vmc rlg = this.add(new vmc("Width", 1.5, 0.5, 4.0, 0.1));
   final vmc rlh = this.add(new vmc("Fill", 0.1, 0.0, 0.6, 0.01).percent());
   final vmc rli = this.add(new vmc("Glow", 0.5, 0.0, 1.0, 0.05).percent());
   final vmc rlj = this.add(new vmc("Glow size", 0.5, 0.0, 1.0, 0.05).percent());
   final vmc rlk = this.add(new vmc("Animation", 1.0, 0.0, 3.0, 0.1).unit("x"));
   final vmc rll = this.add(new vmc("Range", 128.0, 16.0, 256.0, 8.0).suffix("blocks"));
   final vkl rlm = this.add(new vkl("Self", false));
   static final int FRIEND = -10686326;
   long rln = -1L;
   final float[] rlo = new float[2];
   final float[] rlp = new float[4];
   final float[] rlq = new float[2];
   final double[][] rlr = new double[8][3];
   final float[][] rls = new float[8][2];
   final boolean[] rlt = new boolean[8];
   static final int[][] rlu = new int[][]{{0, 1}, {2, 3}, {4, 5}, {6, 7}, {0, 2}, {1, 3}, {4, 6}, {5, 7}, {0, 4}, {1, 5}, {2, 6}, {3, 7}};
   static final int[][] rlv = new int[][]{{0, 1, 5, 4}, {2, 6, 7, 3}, {0, 2, 3, 1}, {4, 5, 7, 6}, {0, 4, 6, 2}, {1, 3, 7, 5}};
   float rlw;
   float rlx;
   float rly;
   float rlz;
   boolean rma;

   public rky() {
      super(new String(new char[]{'P', 'l', 'a', 'y', 'e', 'r', 'E', 'S', 'P'}), "Players through walls: outline or box", kfa.RENDER);
      rkz = this;
      this.rle.visibleWhen(() -> this.rla.is("Box"));
      this.rlf.visibleWhen(() -> this.rla.is("Outline"));
      this.rli.visibleWhen(() -> this.rla.is("Outline"));
      this.rlj.visibleWhen(() -> this.rla.is("Outline") && this.rli.get() > 0.0);
      this.rlk.visibleWhen(() -> this.rla.is("Outline"));
   }

   boolean rmd(MinecraftClient var1, PlayerEntity var2) {
      if (var2 != var1.player) {
         if (!var2.isAlive() || var2.isSpectator() || var2 == var1.getCameraEntity()) {
            return false;
         }

         if (!this.rlc.get() && hhf.isFriend(var2)) {
            return false;
         }

         double var3 = this.rll.get();
         return var1.player.squaredDistanceTo(var2) <= var3 * var3;
      } else {
         return this.rlm.get() && !var1.options.getPerspective().isFirstPerson();
      }
   }

   int rme(PlayerEntity var1) {
      if (hhf.isFriend(var1)) {
         return -10686326;
      } else {
         int var2 = this.rlb.color() | 0xFF000000;
         if (this.rld.get()) {
            float var3 = vyk.of(var1).fraction();
            return ujt.lerp(-45730, -10686326, var3);
         } else {
            return var2;
         }
      }
   }

   public static void afterExtraction(WorldRenderState var0) {
      rky var1 = rkz;
      MinecraftClient var2 = MinecraftClient.getInstance();
      if (var1 != null && var1.isEnabled() && var1.rla.is("Outline") && var2.world != null && var2.player != null) {
         ukl.style(0)
            .set((float)var1.rlh.get(), (float)var1.rlf.get(), (float)var1.rlg.get(), (float)var1.rli.get(), (float)var1.rlj.get(), (float)var1.rlk.get());
         int var3 = var1.rlb.color() | 0xFF000000;
         int var4 = var1.rlb.color2() | 0xFF000000;
         boolean var5 = var1.rld.get();

         for (EntityRenderState var7 : var0.entityRenderStates) {
            if (var7 instanceof PlayerEntityRenderState var8 && var2.world.getEntityById(var8.id) instanceof PlayerEntity var9 && var1.rmd(var2, var9)) {
               boolean var13 = hhf.isFriend(var9);
               int var11 = var13 ? -10686326 : (var5 ? ujt.lerp(-45730, -10686326, vyk.of(var9).fraction()) : var3);
               int var12 = !var13 && !var5 ? var4 : ujt.lerp(var11, -1, 0.35F);
               ukl.paint(var7, 0, var11, var12);
            }
         }
      }
   }

   public static void render(DrawContext var0, RenderTickCounter var1) {
      rky var2 = rkz;
      MinecraftClient var3 = MinecraftClient.getInstance();
      if (var2 != null
         && var2.isEnabled()
         && !var2.rla.is("Outline")
         && var3.world != null
         && var3.player != null
         && !var3.options.hudHidden
         && !(var3.currentScreen instanceof hlc)) {
         unf.observe(var0);
         if (unf.frame() != var2.rln) {
            var2.rln = unf.frame();
            float var4 = var1.getTickProgress(true);

            usn var5;
            try {
               var5 = usn.capture(var4, var0.getScaledWindowWidth(), var0.getScaledWindowHeight());
            } catch (Throwable var13) {
               return;
            }

            uut.beginFrame();
            uut.beginBatch();

            try {
               for (PlayerEntity var7 : var3.world.getPlayers()) {
                  if (var2.rmd(var3, var7)) {
                     Vec3d var8 = var7.getLerpedPos(var4);
                     int var9 = var2.rme(var7);
                     var2.rmg(var0, var5, var7, var8, var9);
                  }
               }
            } finally {
               uut.endBatch();
            }
         }
      }
   }

   void rmf(double var1, double var3, double var5, double var7, double var9) {
      for (int var11 = 0; var11 < 8; var11++) {
         this.rlr[var11][0] = (var11 & 1) == 0 ? var1 - var7 : var1 + var7;
         this.rlr[var11][1] = (var11 & 2) == 0 ? var3 : var3 + var9;
         this.rlr[var11][2] = (var11 & 4) == 0 ? var5 - var7 : var5 + var7;
      }
   }

   void rmg(DrawContext var1, usn var2, PlayerEntity var3, Vec3d var4, int var5) {
      double var6 = var3.getWidth() * 0.5 + 0.02;
      this.rmf(var4.x, var4.y, var4.z, var6, var3.getHeight() + 0.02);

      for (int var8 = 0; var8 < 8; var8++) {
         this.rlt[var8] = var2.depth(this.rlr[var8][0], this.rlr[var8][1], this.rlr[var8][2]) > 0.05F
            && var2.project(this.rlr[var8][0], this.rlr[var8][1], this.rlr[var8][2], this.rls[var8]);
      }

      float var17 = (float)this.rlh.get();
      if (var17 > 0.005F) {
         Vec3d var9 = var2.camera();
         int var10 = ujt.withAlpha(var5, Math.round(255.0F * var17));
         int var11 = ujt.withAlpha(var5, Math.round(255.0F * var17 * 0.25F));

         for (int var12 = 0; var12 < 6; var12++) {
            int[] var13 = rlv[var12];
            if (this.rlt[var13[0]] && this.rlt[var13[1]] && this.rlt[var13[2]] && this.rlt[var13[3]] && this.rmh(var12, var9, var4, var6, var3.getHeight())) {
               uut.quad(
                  var1,
                  this.rls[var13[0]][0],
                  this.rls[var13[0]][1],
                  (var13[0] & 2) != 0 ? var10 : var11,
                  this.rls[var13[1]][0],
                  this.rls[var13[1]][1],
                  (var13[1] & 2) != 0 ? var10 : var11,
                  this.rls[var13[2]][0],
                  this.rls[var13[2]][1],
                  (var13[2] & 2) != 0 ? var10 : var11,
                  this.rls[var13[3]][0],
                  this.rls[var13[3]][1],
                  (var13[3] & 2) != 0 ? var10 : var11
               );
            }
         }
      }

      float var18 = (float)this.rlg.get();
      int var19 = ujt.withAlpha(var5, 220);

      for (int[] var14 : rlu) {
         double[] var15 = this.rlr[var14[0]];
         double[] var16 = this.rlr[var14[1]];
         if (var2.projectSegment(var15[0], var15[1], var15[2], var16[0], var16[1], var16[2], 0.05F, this.rlp, this.rlq)) {
            uut.line(var1, this.rlp[0], this.rlp[1], this.rlp[2], this.rlp[3], var18, var19);
         }
      }

      if (this.rle.get()) {
         this.rmi(var2);
         if (this.rma) {
            this.rmj(var1, var3);
         }
      }
   }

   boolean rmh(int var1, Vec3d var2, Vec3d var3, double var4, double var6) {
      return switch (var1) {
         case 0 -> var2.y < var3.y;
         case 1 -> var2.y > var3.y + var6;
         case 2 -> var2.z < var3.z - var4;
         case 3 -> var2.z > var3.z + var4;
         case 4 -> var2.x < var3.x - var4;
         default -> var2.x > var3.x + var4;
      };
   }

   void rmi(usn var1) {
      this.rma = false;
      this.rlw = Float.MAX_VALUE;
      this.rlx = Float.MAX_VALUE;
      this.rly = -Float.MAX_VALUE;
      this.rlz = -Float.MAX_VALUE;

      for (int var2 = 0; var2 < 8; var2++) {
         if (var1.depth(this.rlr[var2][0], this.rlr[var2][1], this.rlr[var2][2]) <= 0.05F
            || !var1.project(this.rlr[var2][0], this.rlr[var2][1], this.rlr[var2][2], this.rlo)) {
            return;
         }

         this.rlw = Math.min(this.rlw, this.rlo[0]);
         this.rlx = Math.min(this.rlx, this.rlo[1]);
         this.rly = Math.max(this.rly, this.rlo[0]);
         this.rlz = Math.max(this.rlz, this.rlo[1]);
      }

      this.rma = this.rly - this.rlw > 1.0F && this.rlz - this.rlx > 1.0F;
   }

   void rmj(DrawContext var1, PlayerEntity var2) {
      float var3 = MathHelper.clamp(vyk.of(var2).fraction(), 0.0F, 1.0F);
      float var4 = this.rlz - this.rlx;
      float var5 = Math.max(1.5F, Math.min(3.0F, var4 * 0.025F));
      float var6 = this.rlw - var5 - 3.0F;
      uut.round(var1, var6 - 0.6F, this.rlx - 0.6F, var5 + 1.2F, var4 + 1.2F, var5 * 0.5F + 0.6F, Integer.MIN_VALUE);
      int var7 = ujt.lerp(-45730, -10686326, var3);
      float var8 = var4 * var3;
      uut.round(var1, var6, this.rlx + var4 - var8, var5, var8, var5 * 0.5F, var7);
   }
}
