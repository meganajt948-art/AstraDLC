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
      float var1 = Math.max(1.0F, var0.method_6063());
      if (var0 instanceof PlayerEntity var2) {
         Integer var3 = belowName(var2);
         if (var3 != null) {
            if (var3 >= 1000) {
               return new vyd(var1, 0.0F, var1, true);
            }

            return new vyd(Math.max(0, var3), 0.0F, var1, false);
         }
      }

      float var4 = var0.method_6032();
      boolean var5 = var0.method_5767() || Float.isNaN(var4) || var4 > Math.max(var1, 20.0F) * 1.5F;
      return new vyd(var4, var0.method_6067(), var1, var5);
   }

   public static Integer belowName(PlayerEntity var0) {
      MinecraftClient var1 = MinecraftClient.method_1551();
      if (var1.field_1687 == null) {
         return null;
      } else {
         Scoreboard var2 = var1.field_1687.method_8428();
         ScoreboardObjective var3 = var2.method_1189(ScoreboardDisplaySlot.field_45158);
         if (var3 == null) {
            return null;
         } else {
            ReadableScoreboardScore var4 = var2.method_55430(var0, var3);
            return var4 != null ? var4.method_55397() : null;
         }
      }
   }
}
