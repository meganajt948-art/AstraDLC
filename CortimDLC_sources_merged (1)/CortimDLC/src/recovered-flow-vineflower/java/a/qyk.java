package a;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

public class qyk extends kfe {
   private static qyk qyl;
   private final vmc qym = this.add(new vmc("Range", 64.0, 8.0, 256.0, 8.0).suffix("m"));
   private final vmc qyn = this.add(new vmc("Radius", 44.0, 20.0, 140.0, 2.0));
   private final vmc qyo = this.add(new vmc("Size", 1.0, 0.6, 1.8, 0.05).percent());
   private final vla qyp = this.add(new vla("Color", "Theme"));
   private final vkl qyq = this.add(new vkl("Friends", true));
   private final vla qyr = this.add(new vla("Friend color", "Mint"));
   private final vkl qys = this.add(new vkl("Distance", false));
   private final vkl qyt = this.add(new vkl("Mobs", false));
   private final vmc qyu = this.add(new vmc("Mob range", 64.0, 8.0, 256.0, 8.0).suffix("m"));
   private static final vdn qyv = veo.semibold(5.6F);
   private final Map<Integer, vcj> qyw = new HashMap<>();
   private final Set<Integer> qyx = new HashSet<>();
   private long qyy = -1L;

   public qyk() {
      super(new String(new char[]{'A', 'r', 'r', 'o', 'w', 's'}), "Arrows pointing at players and mobs around you", kfa.RENDER);
      qyl = this;
      this.qyr.visibleWhen(this.qyq::get);
      this.qyu.visibleWhen(this.qyt::get);
   }

   public static void render(DrawContext var0, RenderTickCounter var1) {
      qyk var2 = qyl;
      MinecraftClient var3 = MinecraftClient.method_1551();
      if (var2 != null
         && var2.isEnabled()
         && var3.field_1687 != null
         && var3.field_1724 != null
         && !var3.field_1690.field_1842
         && !(var3.field_1755 instanceof hlc)) {
         unf.observe(var0);
         if (unf.frame() != var2.qyy) {
            var2.qyy = unf.frame();
            var2.qzb(var0, var3, var1.method_60637(true), unf.delta());
         }
      } else {
         if (var2 != null) {
            var2.qyw.clear();
         }
      }
   }

   private void qzb(DrawContext var1, MinecraftClient var2, float var3, float var4) {
      Camera var5 = var2.field_1773.method_19418();
      Vec3d var6 = var5.method_71156();
      float var7 = var5.method_19330();
      float var8 = var1.method_51421() * 0.5F;
      float var9 = var1.method_51443() * 0.5F;
      double var10 = this.qym.get();
      float var12 = (float)this.qyo.get();
      iov.update(var4);
      uut.beginFrame();
      this.qyx.clear();

      for (PlayerEntity var14 : var2.field_1687.method_18456()) {
         if (var14 != var2.field_1724 && var14 != var2.method_1560() && !var14.method_7325() && var14.method_5805()) {
            boolean var15 = hhf.isFriend(var14);
            if (!var15 || this.qyq.get()) {
               int var16 = var15 ? this.qyr.color() : this.qyp.color();
               this.qzc(var1, var14, var3, var6, var7, var8, var9, var10, var12, var4, var16);
            }
         }
      }

      rhs var20 = rhs.get();
      if (this.qyt.get() && var20 != null) {
         double var21 = this.qyu.get();
         double var22 = (var21 + 4.0) * (var21 + 4.0);

         for (Entity var19 : var2.field_1687.method_18112()) {
            if (var19 != var2.method_1560() && var19.method_5707(var6) <= var22 && var20.picks(var19)) {
               this.qzc(var1, var19, var3, var6, var7, var8, var9, var21, var12, var4, var20.colorOf(var19));
            }
         }
      }

      this.qyw.keySet().retainAll(this.qyx);
   }

   private void qzc(DrawContext var1, Entity var2, float var3, Vec3d var4, float var5, float var6, float var7, double var8, float var10, float var11, int var12) {
      Vec3d var13 = var2.method_30950(var3);
      double var14 = var13.field_1352 - var4.field_1352;
      double var16 = var13.field_1350 - var4.field_1350;
      double var18 = Math.sqrt(var14 * var14 + var16 * var16 + (var13.field_1351 - var4.field_1351) * (var13.field_1351 - var4.field_1351));
      vcj var20 = this.qyw.computeIfAbsent(var2.method_5628(), var0 -> new vcj(10.0F));
      this.qyx.add(var2.method_5628());
      float var21 = var20.step(var18 <= var8, var11);
      if (!(var21 <= 0.01F)) {
         double var22 = Math.toRadians(Math.toDegrees(Math.atan2(var16, var14)) - 90.0 - var5);
         float var24 = (float)Math.max(0.25, 1.0 - var18 / Math.max(1.0, var8));
         qzd(var1, var6, var7, (float)var22, (float)this.qyn.get(), var10, var12 | 0xFF000000, var21 * (0.45F + 0.55F * var24));
         if (this.qys.get()) {
            String var25 = Math.round(var18) + wap.unit("m");
            float var26 = (float)this.qyn.get() + 10.0F * var10;
            float var27 = var6 + (float)Math.sin(var22) * var26;
            float var28 = var7 - (float)Math.cos(var22) * var26;
            float var29 = qyv.width(var25);
            uut.pushAlpha(var21);
            qyv.draw(var1, var25, var27 - var29 * 0.5F + 0.5F, qyv.centerTop(var28) + 0.5F, -1946157056);
            qyv.draw(var1, var25, var27 - var29 * 0.5F, qyv.centerTop(var28), -419430401);
            uut.popAlpha();
         }
      }
   }

   private static void qzd(DrawContext var0, float var1, float var2, float var3, float var4, float var5, int var6, float var7) {
      var0.method_51448().pushMatrix();
      var0.method_51448().translate(var1, var2);
      var0.method_51448().rotate(var3);
      var0.method_51448().translate(0.0F, -var4);
      uut.pushAlpha(var7);
      float var8 = 5.2F * var5;
      float var9 = 4.2F * var5;
      float var10 = 1.8F * var5;
      uut.shadow(var0, -var8, -var9, var8 * 2.0F, var9 * 2.0F, var9, 3.0F * var5, 1174405120);
      uut.line(var0, -var8, var9 * 0.5F, 0.0F, -var9 * 0.5F, var10, var6);
      uut.line(var0, var8, var9 * 0.5F, 0.0F, -var9 * 0.5F, var10, var6);
      uut.popAlpha();
      var0.method_51448().popMatrix();
   }
}
