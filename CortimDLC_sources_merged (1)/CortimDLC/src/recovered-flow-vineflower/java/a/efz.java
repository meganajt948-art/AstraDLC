package a;

import net.minecraft.client.option.KeyBinding;

public interface efz {
   void look(float var1, float var2);

   double mouseStep();

   boolean heldByHuman(KeyBinding var1);

   String getName();

   default void report(String var1, boolean var2) {
   }

   default int pendingPackets() {
      return 0;
   }

   default void halted() {
   }
}
