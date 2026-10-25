package a;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.scoreboard.ReadableScoreboardScore;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardDisplaySlot;
import net.minecraft.scoreboard.ScoreboardObjective;

public final class vyk {
   public static final int HIDDEN = 1000;

   private vyk() {
   }

   public static vyd of(LivingEntity var0) {
      float var1 = Math.max(1.0F, var0.getMaxHealth());
      if (var0 instanceof PlayerEntity var2) {
         Integer var3 = belowName(var2);
         if (var3 != null) {
            if (var3 >= 1000) {
               return new vyd(var1, 0.0F, var1, true);
            }

            return new vyd(Math.max(0, var3), 0.0F, var1, false);
         }
      }

      float var4 = var0.getHealth();
      boolean var5 = var0.isInvisible() || Float.isNaN(var4) || var4 > Math.max(var1, 20.0F) * 1.5F;
      return new vyd(var4, var0.getAbsorptionAmount(), var1, var5);
   }

   public static Integer belowName(PlayerEntity var0) {
      MinecraftClient var1 = MinecraftClient.getInstance();
      if (var1.world == null) {
         return null;
      }

      Scoreboard var2 = var1.world.getScoreboard();
      ScoreboardObjective var3 = var2.getObjectiveForSlot(ScoreboardDisplaySlot.BELOW_NAME);
      if (var3 == null) {
         return null;
      }

      ReadableScoreboardScore var4 = var2.getScore(var0, var3);
      return var4 != null ? var4.getScore() : null;
   }
}
