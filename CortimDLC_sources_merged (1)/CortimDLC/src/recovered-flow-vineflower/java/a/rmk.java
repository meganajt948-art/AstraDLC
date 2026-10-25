package a;

import net.minecraft.client.MinecraftClient;

public class rmk extends kfe {
   private final vlv rml = this.add(new vlv("Look", "Soft", "Soft", "Vivid", "Warm", "Cold", "Cinema", "Custom"));
   private final vmc rmm = this.add(new vmc("Colour", 1.15, 0.5, 1.8, 0.05).percent());
   private final vmc rmn = this.add(new vmc("Contrast", 1.05, 0.7, 1.4, 0.01).percent());
   private final vmc rmo = this.add(new vmc("Warmth", 0.1, -1.0, 1.0, 0.05).percent());
   private final vmc rmp = this.add(new vmc("Vignette", 0.25, 0.0, 1.0, 0.05).percent());
   private final vmc rmq = this.add(new vmc("Sharpen", 0.3, 0.0, 1.0, 0.05).percent());
   private final vmc rmr = this.add(new vmc("Glow", 0.25, 0.0, 1.0, 0.05).percent());
   private static final float[][] rms = new float[][]{
      {1.12F, 1.04F, 0.08F, 0.22F, 0.25F, 0.2F},
      {1.38F, 1.1F, 0.05F, 0.25F, 0.35F, 0.25F},
      {1.15F, 1.05F, 0.5F, 0.3F, 0.25F, 0.3F},
      {1.1F, 1.06F, -0.45F, 0.25F, 0.25F, 0.2F},
      {0.92F, 1.16F, 0.2F, 0.55F, 0.2F, 0.35F}
   };

   public rmk() {
      super(new String(new char[]{'S', 'h', 'a', 'd', 'e', 'r', 's'}), "Richer colour, soft glow, crisp image", kfa.RENDER);

      for (vmc var4 : new vmc[]{this.rmm, this.rmn, this.rmo, this.rmp, this.rmq, this.rmr}) {
         var4.visibleWhen(() -> this.rml.is("Custom"));
      }
   }

   @Override
   protected void onDisable() {
      unr.release();
   }

   @Override
   public void onWorldRenderLate(MinecraftClient var1) {
      int var3 = this.rml.index();
      float[] var2;
      if (var3 < rms.length) {
         var2 = rms[var3];
      } else {
         var2 = new float[]{
            (float)this.rmm.get(), (float)this.rmn.get(), (float)this.rmo.get(), (float)this.rmp.get(), (float)this.rmq.get(), (float)this.rmr.get()
         };
      }

      unr.apply(var2[0], var2[1], var2[2], var2[3], var2[4], var2[5], 1.0F);
   }
}
