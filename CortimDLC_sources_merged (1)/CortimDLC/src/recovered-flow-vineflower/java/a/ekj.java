package a;

import net.minecraft.client.Mouse;

final class ekj extends Mouse {
   ekj() {
      super(null);
   }

   @Override
   public boolean isCursorLocked() {
      return true;
   }

   @Override
   public void lockCursor() {
   }

   @Override
   public void unlockCursor() {
   }

   @Override
   public void tick() {
   }
}
