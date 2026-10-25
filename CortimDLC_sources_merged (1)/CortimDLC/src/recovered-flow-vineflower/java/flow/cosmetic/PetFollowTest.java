package flow.cosmetic;

import java.util.Locale;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

public final class PetFollowTest {
   private static CosmeticItem pet;
   private static Motion m;

   private PetFollowTest() {
   }

   public static String step(MinecraftClient mc, float dt) {
      if (pet == null) {
         CosmeticItem.Bone bone = new CosmeticItem.Bone("body", -1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
         bone.solid = new float[]{-3.0F, -4.0F, -3.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 3.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F};
         pet = new CosmeticItem(
            "test_pet",
            "test",
            "test",
            "",
            "",
            "pet",
            "pet",
            0,
            1,
            0.0F,
            new float[]{6.0F, 22.0F, 0.0F},
            0.0F,
            0.0F,
            0.0F,
            new CosmeticItem.Bone[]{bone},
            Map.of(),
            new CosmeticItem.Emitter[0],
            null,
            null
         );
         m = new Motion(-1);
      }

      PlayerEntity p = mc.player;
      m.bodyYaw = p.getBodyYaw();
      Vec3d pp = p.getEntityPos();
      Vec3d target = Cosmetics.groundSpot(mc, p, pp, m, pet);
      if (m.petPos != null && m.petWorld == mc.world && !(m.petPos.squaredDistanceTo(target) > 196.0)) {
         Cosmetics.follow(m, target, dt, true);
      } else {
         m.petPos = target;
         m.petVel = Vec3d.ZERO;
         m.petWorld = mc.world;
      }

      double feet = m.petPos.y - 0.25;
      return String.format(
         Locale.ROOT,
         "feet-over-player-floor %.2f, distance %.2f, speed %.2f, running %s",
         feet - pp.y,
         Math.hypot(m.petPos.x - pp.x, m.petPos.z - pp.z),
         Math.hypot(m.petVel.x, m.petVel.z),
         m.petRun
      );
   }
}
