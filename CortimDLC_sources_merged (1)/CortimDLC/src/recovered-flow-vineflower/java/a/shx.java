package a;

import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;

public class shx extends kfe {
   private static shx shy;
   private final vlv shz = this.add(new vlv("Anchor", "World", "World", "Follow view"));
   private final vmc sia = this.add(new vmc("Distance", 5.5, 2.5, 12.0, 0.5).suffix("blocks"));
   private final vmc sib = this.add(new vmc("Size", 1.0, 0.5, 2.0, 0.05).percent());
   private final vmc sic = this.add(new vmc("Spread", 0.6, 0.0, 1.0, 0.05).percent());
   private final vkl sid = this.add(new vkl("Cover color", true));
   private final vla sie = this.add(new vla("Color", "Theme"));
   private final vmc sif = this.add(new vmc("Glow", 0.6, 0.0, 1.0, 0.05).percent());
   private final vkl sig = this.add(new vkl("Shadow", true));
   private final vkl sih = this.add(new vkl("Particles", true));
   private final vkl sii = this.add(new vkl("Song title", true));
   private final vkl sij = this.add(new vkl("Through walls", false));
   private final vmc sik = this.add(new vmc("Sync offset", 0.0, -2000.0, 2000.0, 50.0).suffix("ms"));
   private static final float sil = 0.3F;
   private static final long sim = 120L;
   private static final long sin = 1500L;
   private static final float sio = 5.5F;
   private static final float sip = 2.0F;
   private static final float siq = 2.2F;
   private final List<snp> sir = new ArrayList<>();
   private final Random sis = new Random();
   private final float[] sit = new float[2];
   private String siu;
   private sle siv;
   private int siw = -1;
   private snp six;
   private snp siy;
   private float siz = 1.0F;
   private long sja = -1L;

   public shx() {
      super("Lyrics", "The words of the song you are listening to appear in the world in front of you", kfa.RENDER);
      shy = this;
      this.sie.visibleWhen(() -> !this.sid.get());
   }

   public static boolean wantsMusic() {
      shx var0 = shy;
      return var0 != null && var0.isEnabled();
   }

   @Override
   protected void onEnable() {
      this.sjd();
   }

   @Override
   protected void onDisable() {
      this.sjd();
   }

   private void sjd() {
      this.sir.clear();
      this.siu = null;
      this.siv = null;
      this.siw = -1;
      this.six = null;
      this.siy = null;
      this.siz = 1.0F;
   }

   public static void render(DrawContext var0, RenderTickCounter var1) {
      shx var2 = shy;
      MinecraftClient var3 = MinecraftClient.method_1551();
      if (var2 != null
         && var2.isEnabled()
         && var3.field_1687 != null
         && var3.field_1724 != null
         && !var3.field_1690.field_1842
         && !(var3.field_1755 instanceof hlc)) {
         unf.observe(var0);
         if (unf.frame() != var2.sja) {
            var2.sja = unf.frame();

            usn var4;
            try {
               var4 = usn.capture(var1.method_60637(true), var0.method_51421(), var0.method_51443());
            } catch (Throwable var6) {
               return;
            }

            uut.beginFrame();
            vdn.setRenderScale(1.0F);
            var2.sje(var0, var4, Math.min(0.1F, unf.delta()));
         }
      }
   }

   private void sje(DrawContext var1, usn var2, float var3) {
      jgd var4 = jgn.track();
      String var5 = var4 == null ? null : var4.title() + '\u0001' + var4.artist();
      if (!Objects.equals(var5, this.siu)) {
         this.siu = var5;
         this.siv = null;
         this.siw = -1;
         this.six = null;

         for (snp var7 : this.sir) {
            var7.dissolve();
         }

         this.siy = null;
         if (var4 != null && this.sii.get()) {
            snp var15 = snp.card(var4.title(), var4.artist(), this.sis);
            if (!var15.isEmpty()) {
               this.sji(var15);
               this.sir.add(var15);
               this.siy = var15;
            }
         }
      }

      long var16 = 0L;
      if (var4 != null) {
         var16 = var4.position() + (long)this.sik.get() + 120L;
         if (this.siv == null) {
            this.siv = sls.get(var4.title(), var4.artist(), var4.duration());
         }

         if (this.siv != null && !this.siv.isEmpty()) {
            this.sjf(var16);
         }
      }

      if (this.siy != null && (this.siy.age > 5.5F || !this.sii.get())) {
         this.siy.dissolve();
         this.siy = null;
      }

      this.siz = this.siz + ((var4 != null && !var4.playing() ? 0.45F : 1.0F) - this.siz) * Math.min(1.0F, var3 * 4.0F);
      Vec3d var8 = var2.camera();
      boolean var9 = !this.shz.is("Follow view");
      float var10 = Math.min(1.0F, var3 * 6.0F);

      for (int var11 = this.sir.size() - 1; var11 >= 0; var11--) {
         snp var12 = this.sir.get(var11);
         var12.update(var3, var16);
         if (var12.finished()) {
            this.sir.remove(var11);
         } else {
            if (var9) {
               var12.y += var3 * 0.03;
            } else {
               Vec3d var13 = this.sjj(var12);
               float var14 = Math.min(1.0F, var3 * 2.2F);
               var12.x = var12.x + (var13.field_1352 - var12.x) * var14;
               var12.y = var12.y + (var13.field_1351 - var12.y) * var14;
               var12.z = var12.z + (var13.field_1350 - var12.z) * var14;
            }

            boolean var17 = !this.sij.get() && this.sjk(var8, var12);
            var12.hidden = var12.hidden + ((var17 ? 1.0F : 0.0F) - var12.hidden) * var10;
         }
      }

      if (!this.sir.isEmpty()) {
         this.sjg(var1, var2);
      }
   }

   private void sjf(long var1) {
      List var3 = this.siv.lines();
      int var4 = this.siv.indexAt(var1);
      if (this.siw >= 0 && var4 < this.siw && var1 > ((skx)var3.get(this.siw)).start() - 1500L) {
         var4 = this.siw;
      }

      if (var4 != this.siw) {
         if (this.six != null) {
            this.six.dissolve();
            this.six = null;
         }

         this.siw = var4;
         if (var4 >= 0) {
            skx var5 = (skx)var3.get(var4);
            if (!var5.blank() && var1 < var5.end()) {
               snp var6 = snp.line(var4, var5, this.sis);
               if (!var6.isEmpty()) {
                  if (this.siy != null && this.siy.age >= 2.0F) {
                     this.siy.dissolve();
                     this.siy = null;
                  }

                  this.sji(var6);
                  this.sir.add(var6);
                  this.six = var6;
               }
            }
         }
      }

      if (this.six != null && var1 > this.six.holdUntil) {
         this.six.dissolve();
         this.six = null;
      }
   }

   private void sjg(DrawContext var1, usn var2) {
      GpuTextureView var3 = unm.view();
      int[] var4 = this.sjh();
      sng var5 = new sng(var4[0], var4[1], (float)this.sif.get(), this.sig.get(), this.sih.get(), this.siz);
      this.sir.sort((var1x, var2x) -> Double.compare(var2.distance(var2x.x, var2x.y, var2x.z), var2.distance(var1x.x, var1x.y, var1x.z)));
      float var6 = (float)this.sib.get() * 0.3F;
      float var7 = var2.height() * 0.16F;
      uut.beginBatch();

      try {
         for (snp var9 : this.sir) {
            if (var2.project(var9.x, var9.y, var9.z, this.sit)) {
               float var10 = var2.unitsPerBlock(var9.x, var9.y, var9.z) * var6;
               if (!(var10 < 2.5F)) {
                  var9.draw(var1, this.sit[0], this.sit[1], Math.min(var7, var10), var5, var3);
               }
            }
         }
      } finally {
         uut.additive(false);
         uut.endBatch();
      }
   }

   private int[] sjh() {
      if (this.sid.get() && jgn.cover() != null) {
         int var1 = jgn.coverColor() | 0xFF000000;
         return new int[]{var1, ujt.lerp(var1, -1, 0.45F)};
      } else {
         return this.sie.vivid(new int[]{-7635722, -10556716});
      }
   }

   private void sji(snp var1) {
      Camera var2 = this.mc.field_1773.method_19418();
      Vec3d var3 = var2.method_71156();
      float var4 = var2.method_19330();
      float var5 = MathHelper.method_15363(var2.method_19329(), -50.0F, 50.0F);
      float var6 = (float)this.sic.get();
      float var7 = -Float.MAX_VALUE;
      float var8 = 0.0F;
      float var9 = -8.0F;

      for (int var10 = 0; var10 < 10; var10++) {
         float var11 = (this.sis.nextFloat() * 2.0F - 1.0F) * 26.0F * var6;
         float var12 = var1.card ? -(10.0F + this.sis.nextFloat() * 6.0F * var6) : -(6.0F + this.sis.nextFloat() * 10.0F * var6);
         float var13 = 14.0F;

         for (snp var15 : this.sir) {
            double var16 = var15.x - var3.field_1352;
            double var18 = var15.y - var3.field_1351;
            double var20 = var15.z - var3.field_1350;
            float var22 = (float)(MathHelper.method_15349(var20, var16) * 180.0F / (float)Math.PI) - 90.0F;
            float var23 = (float)(-(MathHelper.method_15349(var18, Math.sqrt(var16 * var16 + var20 * var20)) * 180.0F / (float)Math.PI));
            float var24 = MathHelper.method_15393(var4 + var11 - var22);
            float var25 = var5 + var12 - var23;
            var13 = Math.min(var13, (float)Math.hypot(var24 * 0.3F, var25));
         }

         float var27 = var13 - 0.06F * Math.abs(var11) - 0.08F * Math.abs(var12 + 8.0F) + this.sis.nextFloat() * 0.5F;
         if (var27 > var7) {
            var7 = var27;
            var8 = var11;
            var9 = var12;
         }
      }

      var1.yawOff = var8;
      var1.pitchOff = var9;
      var1.dist = (float)this.sia.get() * (0.9F + this.sis.nextFloat() * 0.2F);
      Vec3d var26 = this.sjj(var1);
      var1.x = var26.field_1352;
      var1.y = var26.field_1351;
      var1.z = var26.field_1350;
   }

   private Vec3d sjj(snp var1) {
      Camera var2 = this.mc.field_1773.method_19418();
      Vec3d var3 = var2.method_71156();
      float var4 = MathHelper.method_15363(var2.method_19329(), -50.0F, 50.0F) + var1.pitchOff;
      Vec3d var5 = Vec3d.method_1030(var4, var2.method_19330() + var1.yawOff);
      double var6 = var1.dist;
      Vec3d var8 = var3.method_1019(var5.method_1021(var6));
      BlockHitResult var9 = this.mc
         .field_1687
         .method_17742(new RaycastContext(var3, var8, ShapeType.field_17558, FluidHandling.field_1348, this.mc.field_1724));
      if (var9.method_17783() != Type.field_1333) {
         var6 = Math.max(1.6, var9.method_17784().method_1022(var3) - 0.6);
      }

      return var3.method_1019(var5.method_1021(var6));
   }

   private boolean sjk(Vec3d var1, snp var2) {
      Vec3d var3 = new Vec3d(var2.x, var2.y, var2.z);
      double var4 = var3.method_1022(var1);
      if (var4 < 0.5) {
         return false;
      } else {
         BlockHitResult var6 = this.mc
            .field_1687
            .method_17742(new RaycastContext(var1, var3, ShapeType.field_23142, FluidHandling.field_1348, this.mc.field_1724));
         return var6.method_17783() != Type.field_1333 && var6.method_17784().method_1022(var1) < var4 - 0.3;
      }
   }
}
