package a;

import net.minecraft.client.network.ClientPlayerEntity;

public interface vhe {
   boolean active();

   float time();

   float fill();

   float glow();

   float rim();

   int[] colors(ClientPlayerEntity var1);
}
