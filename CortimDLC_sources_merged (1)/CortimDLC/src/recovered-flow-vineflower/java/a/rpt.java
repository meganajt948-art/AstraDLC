package a;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;

public class rpt extends kfe implements vhe {
   private final vla rpu = this.add(new vla("Color", "Aurora"));
   private final vkl rpv = this.add(new vkl("Item color", false));
   private final vmc rpw = this.add(new vmc("Fill", 0.4, 0.0, 1.0, 0.05).percent());
   private final vmc rpx = this.add(new vmc("Glow", 0.6, 0.0, 1.0, 0.05).percent());
   private final vmc rpy = this.add(new vmc("Edge", 0.7, 0.0, 1.0, 0.05).percent());
   private final vmc rpz = this.add(new vmc("Speed", 1.0, 0.2, 3.0, 0.1).unit("x"));
   private float rqa;
   private long rqb;

   public rpt() {
      super(new String(new char[]{'S', 'h', 'a', 'd', 'e', 'r', 'H', 'a', 'n', 'd', 's'}), "A soft glow around your hands", kfa.RENDER);
      vhf.register(this);
      this.rpu.visibleWhen(() -> !this.rpv.get());
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      vgj.ensureInstalled(var1);
   }

   @Override
   public boolean active() {
      return this.isEnabled();
   }

   @Override
   public float time() {
      long var1 = System.nanoTime();
      if (this.rqb != 0L) {
         this.rqa = this.rqa + Math.min(0.1F, (float)(var1 - this.rqb) / 1.0E9F) * (float)this.rpz.get();
      }

      this.rqb = var1;
      return this.rqa % 3600.0F;
   }

   @Override
   public float fill() {
      return (float)this.rpw.get();
   }

   @Override
   public float glow() {
      return (float)this.rpx.get();
   }

   @Override
   public float rim() {
      return (float)this.rpy.get();
   }

   @Override
   public int[] colors(ClientPlayerEntity var1) {
      if (this.rpv.get()) {
         int var2 = rqe(var1.getMainHandStack().isEmpty() ? var1.getOffHandStack() : var1.getMainHandStack());
         if (var2 != 0) {
            return new int[]{var2, ujt.lerp(var2, -1, 0.45F)};
         }
      }

      return new int[]{this.rpu.color() | 0xFF000000, this.rpu.color2() | 0xFF000000};
   }

   private static int rqe(ItemStack var0) {
      if (var0.isEmpty()) {
         return 0;
      } else {
         String var1 = Registries.ITEM.getId(var0.getItem()).getPath();
         if (var1.contains("netherite")) {
            return -7573584;
         } else if (var1.contains("diamond")) {
            return -11149328;
         } else if (var1.contains("gold")) {
            return -11443;
         } else if (var1.contains("iron")) {
            return -2564890;
         } else if (var1.contains("emerald")) {
            return -12723068;
         } else if (var1.contains("mace") || var1.contains("wind")) {
            return -4601601;
         } else if (var1.contains("trident")) {
            return -10559288;
         } else {
            return var1.contains("totem") ? -8090 : 0;
         }
      }
   }
}
