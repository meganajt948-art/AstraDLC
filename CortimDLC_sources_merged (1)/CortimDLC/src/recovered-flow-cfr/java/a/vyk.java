/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.scoreboard.ReadableScoreboardScore
 *  net.minecraft.scoreboard.ScoreHolder
 *  net.minecraft.scoreboard.Scoreboard
 *  net.minecraft.scoreboard.ScoreboardDisplaySlot
 *  net.minecraft.scoreboard.ScoreboardObjective
 */
package a;

import a.vyd;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.scoreboard.ReadableScoreboardScore;
import net.minecraft.scoreboard.ScoreHolder;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardDisplaySlot;
import net.minecraft.scoreboard.ScoreboardObjective;

public final class vyk {
    public static final int HIDDEN = 1000;
    private static /* synthetic */ boolean vyl;
    private static /* synthetic */ long vym;

    private vyk() {
    }

    public static vyd of(LivingEntity livingEntity) {
        PlayerEntity playerEntity;
        Integer n;
        float f = Math.max(1.0f, livingEntity.getMaxHealth());
        if (livingEntity instanceof PlayerEntity && (n = vyk.belowName(playerEntity = (PlayerEntity)livingEntity)) != null) {
            if (n >= 1000) {
                return new vyd(f, 0.0f, f, true);
            }
            return new vyd(Math.max(0, n), 0.0f, f, false);
        }
        float f2 = livingEntity.getHealth();
        boolean bl = livingEntity.isInvisible() || Float.isNaN(f2) || f2 > Math.max(f, 20.0f) * 1.5f;
        return new vyd(f2, livingEntity.getAbsorptionAmount(), f, bl);
    }

    public static Integer belowName(PlayerEntity playerEntity) {
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        if (minecraftClient.world == null) {
            return null;
        }
        Scoreboard scoreboard = minecraftClient.world.getScoreboard();
        ScoreboardObjective scoreboardObjective = scoreboard.getObjectiveForSlot(ScoreboardDisplaySlot.BELOW_NAME);
        if (scoreboardObjective == null) {
            return null;
        }
        ReadableScoreboardScore readableScoreboardScore = scoreboard.getScore((ScoreHolder)playerEntity, scoreboardObjective);
        return readableScoreboardScore != null ? Integer.valueOf(readableScoreboardScore.getScore()) : null;
    }

    private static /* synthetic */ int dmo(int n, int n2) {
        return n - n2 | 0xDA4721DC;
    }

    private static /* synthetic */ int dmp(int n, int n2) {
        return n * n2 + -331469670;
    }

    private static /* synthetic */ int dmq(int n, int n2) {
        return n * n2 + 900728126;
    }
}

