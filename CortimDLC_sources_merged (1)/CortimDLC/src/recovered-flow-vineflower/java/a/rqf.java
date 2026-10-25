package a;

import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.world.dimension.DimensionType.Skybox;
import org.joml.Matrix4f;

public class rqf extends kfe {
   private static final String rqg = "Own";
   private final vlv rqh = this.add(new vlv("Sky", uxt.AURORA.title, uxt.titles()));
   private final vlv rqi = this.add(new vlv("Palette", "Own", "Own", "Custom"));
   private final vla rqj = this.add(new vla("Colour", "Violet"));
   private final vmc rqk = this.add(new vmc("Brightness", 1.0, 0.3, 1.6, 0.05).percent());
   private final vmc rql = this.add(new vmc("Speed", 1.0, 0.0, 4.0, 0.1).unit("x"));
   private final vmc rqm = this.add(new vmc("Stars", 1.0, 0.0, 2.0, 0.05).percent());
   private final vmc rqn = this.add(new vmc("Horizon blend", 1.0, 0.0, 1.0, 0.05).percent());
   private final vkl rqo = this.add(new vkl("Hide clouds", true));
   private final vlv rqp = this.add(new vlv("Quality", "High", "Low", "High"));
   private final Matrix4f rqq = new Matrix4f();
   private long rqr;
   private float rqs;

   public rqf() {
      super(new String(new char[]{'S', 'h', 'a', 'd', 'e', 'r', 'S', 'k', 'y'}), "Animated shader sky", kfa.RENDER);
      this.rqj.visibleWhen(() -> this.rqi.is("Custom"));
      this.rqm.activeWhen(() -> uxt.of(this.rqh.get()).stars > 0.0F);
   }

   @Override
   protected void onEnable() {
      this.rqr = 0L;
      uxi.release();
   }

   @Override
   protected void onDisable() {
      ujl.hide(this, false);
   }

   @Override
   public void onWorldRender(MinecraftClient var1) {
      Camera var2 = var1.field_1773.method_19418();
      Skybox var3 = var1.field_1687.method_8597().comp_5220();
      boolean var4 = var3 != Skybox.field_64385 && var2.method_19332() && var2.method_19334() == CameraSubmersionType.field_27888;
      ujl.hide(this, var4 && this.rqo.get());
      long var5 = System.nanoTime();
      this.rqs = this.rqs + (this.rqr == 0L ? 0.0F : Math.min(0.1F, (float)(var5 - this.rqr) / 1.0E9F) * (float)this.rql.get());
      this.rqr = var5;
      if (var4) {
         uxt var7 = uxt.of(this.rqh.get());
         int var8 = var7.color1;
         int var9 = var7.color2;
         if (this.rqi.is("Custom")) {
            int[] var10 = this.rqj.vivid(new int[]{var7.color1, var7.color2});
            var8 = var10[0];
            var9 = var10[1];
         }

         this.rqq.rotation(var2.method_23767());
         float var11 = var3 == Skybox.field_64386 ? (float)this.rqn.get() : 0.0F;
         uxi.draw(this.rqq, var7, 40.0F + this.rqs, (float)this.rqk.get(), var11, var8, var9, this.rqp.is("Low") ? 3 : 4, var7.stars * (float)this.rqm.get());
      }
   }
}
