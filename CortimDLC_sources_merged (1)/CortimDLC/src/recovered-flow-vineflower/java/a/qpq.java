package a;

import net.minecraft.screen.slot.SlotActionType;

public record qpq(int slot, int button, SlotActionType type) {
   private final int qpr;
   private final int qps;
   private final SlotActionType qpt;

   public qpq(int slot, int button, SlotActionType type) {
      this.qpr = slot;
      this.qps = button;
      this.qpt = type;
   }

   public int slot() {
      return this.qpr;
   }

   public int button() {
      return this.qps;
   }

   public SlotActionType type() {
      return this.qpt;
   }
}
