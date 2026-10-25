package a;

import net.minecraft.screen.slot.SlotActionType;

final class nwj {
   private final int nwk;
   private final int nwl;
   private final SlotActionType nwm;
   private final int nwn;

   private nwj(int slot, int button, SlotActionType type, int cursor) {
      this.nwk = slot;
      this.nwl = button;
      this.nwm = type;
      this.nwn = cursor;
   }

   public int slot() {
      return this.nwk;
   }

   public int button() {
      return this.nwl;
   }

   public SlotActionType type() {
      return this.nwm;
   }

   public int cursor() {
      return this.nwn;
   }
}
