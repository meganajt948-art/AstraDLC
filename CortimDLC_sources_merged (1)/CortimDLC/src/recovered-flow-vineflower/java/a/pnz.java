package a;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;

public final class pnz {
   private long poa;
   private long pob;
   private Object poc;

   public boolean check(PlayerEntity var1, long var2, long var4) {
      ClientWorld var6 = MinecraftClient.getInstance().world;
      if (this.poc != null && this.poc != var6) {
         this.poc = null;
      }

      if (var1 != null && this.poc == null && poi.inLobby(var1)) {
         if (this.poa == 0L) {
            this.poa = var2;
         }

         if (var2 - this.poa >= 1500L && var2 >= this.pob) {
            this.pob = var2 + var4;
            return true;
         } else {
            return false;
         }
      } else {
         this.poa = 0L;
         return false;
      }
   }

   public void dismiss(Object var1) {
      this.poc = var1;
      this.poa = 0L;
   }

   public void reset() {
      this.poa = 0L;
      this.pob = 0L;
      this.poc = null;
   }
}
