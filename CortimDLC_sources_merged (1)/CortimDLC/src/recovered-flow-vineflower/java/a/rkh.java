package a;

import java.lang.reflect.Field;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.AttackIndicator;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.fog.BlindnessEffectFogModifier;
import net.minecraft.client.render.fog.DarknessEffectFogModifier;
import net.minecraft.client.render.fog.FogModifier;
import net.minecraft.client.render.fog.FogRenderer;
import net.minecraft.client.render.fog.LavaFogModifier;
import net.minecraft.client.render.state.WorldRenderState;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleEffect;

public class rkh extends kfe {
   private static rkh rki;
   public final vkl fire = this.add(new vkl("Fire", true));
   public final vkl lava = this.add(new vkl("Lava", true));
   public final vkl scoreboard = this.add(new vkl("Scoreboard", false));
   public final vkl hurtShake = this.add(new vkl("Hurt shake", true));
   public final vkl walkShake = this.add(new vkl("View bobbing", false));
   public final vkl darkness = this.add(new vkl("Darkness", true));
   public final vkl blindness = this.add(new vkl("Blindness", false));
   public final vkl nausea = this.add(new vkl("Nausea", true));
   public final vkl attackIndicator = this.add(new vkl("Attack indicator", false));
   public final vkl effects = this.add(new vkl("Effects", false));
   public final vkl bossBar = this.add(new vkl("Boss bar", false));
   public final vkl bubbles = this.add(new vkl("Bubbles", false));
   public final vkl glowing = this.add(new vkl("Glowing", false));
   public final vkl rain = this.add(new vkl("Rain", false));
   public final vkl vignette = this.add(new vkl("Vignette", true));
   public final vkl pumpkin = this.add(new vkl("Pumpkin", true));
   private static final wbu<Double> rkj = new wbu<>(var0 -> var0.options.getDamageTiltStrength());
   private static final wbu<Boolean> rkk = new wbu<>(var0 -> var0.options.getBobView());
   private static final wbu<AttackIndicator> rkl = new wbu<>(var0 -> var0.options.getAttackIndicator());
   private static final wbu<Double> rkm = new wbu<>(var0 -> var0.options.getDarknessEffectScale());
   private static boolean rkn;
   private static TrackedData<List<ParticleEffect>> rko;
   private static boolean rkp;

   public rkh() {
      super(new String(new char[]{'N', 'o', 'R', 'e', 'n', 'd', 'e', 'r'}), "Hides effects and HUD parts you pick", kfa.RENDER);
      rki = this;
   }

   private static boolean rks(vkl var0) {
      return rki != null && rki.isEnabled() && var0.get();
   }

   public static boolean hidesScoreboard() {
      return rki != null && rks(rki.scoreboard);
   }

   public static boolean hidesBossBar() {
      return rki != null && rks(rki.bossBar);
   }

   public static boolean hidesAir() {
      return rki != null && rks(rki.bubbles);
   }

   public static boolean hidesEffectIcons() {
      return rki != null && rks(rki.effects);
   }

   public static boolean hidesPumpkin(MinecraftClient var0) {
      return rki != null
         && rks(rki.pumpkin)
         && var0.player != null
         && var0.options.getPerspective().isFirstPerson()
         && var0.player.getEquippedStack(EquipmentSlot.HEAD).isOf(Items.CARVED_PUMPKIN);
   }

   @Override
   protected void onEnable() {
      rkx();
   }

   @Override
   protected void onDisable() {
      rkj.release();
      rkk.release();
      rkl.release();
      rkm.release();
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      if (this.effects.get()) {
         rkw(var1.world);
      }

      this.rkt(var1);
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      this.rkt(var1);
   }

   @Override
   public void onWorldRender(MinecraftClient var1) {
      if (this.fire.get()) {
         rkv(var1);
      }
   }

   private void rkt(MinecraftClient var1) {
      rkx();
      boolean var2 = wbu.suspended(var1);
      rku(rkj, this.hurtShake.get() && !var2, 0.0);
      rku(rkk, this.walkShake.get() && !var2, false);
      rku(rkl, this.attackIndicator.get() && !var2, AttackIndicator.OFF);
      rku(rkm, this.darkness.get() && !var2, 0.0);
      ClientPlayerEntity var3 = var1.player;
      if (var3 != null) {
         if (this.fire.get()) {
            rkv(var1);
         }

         if (this.nausea.get()) {
            var3.nauseaIntensity = 0.0F;
            var3.lastNauseaIntensity = 0.0F;
         }

         if (this.rain.get() && var1.world != null) {
            var1.world.setRainGradient(0.0F);
            var1.world.setThunderGradient(0.0F);
         }

         if (this.vignette.get()) {
            var1.inGameHud.vignetteDarkness = 0.0F;
         }
      }
   }

   private static <T> void rku(wbu<T> var0, boolean var1, T var2) {
      if (var1) {
         var0.override(var2);
      } else {
         var0.release();
      }
   }

   private static void rkv(MinecraftClient var0) {
      if (var0.player != null && var0.player.isOnFire()) {
         var0.player.setOnFire(false);
      }
   }

   private static void rkw(ClientWorld var0) {
      if (var0 != null) {
         if (!rkp) {
            rkp = true;
            Field var1 = vxr.find(LivingEntity.class, "net.minecraft.class_1309", "field_49792", "Lnet/minecraft/class_2940;");

            try {
               rko = var1 == null ? null : (TrackedData)var1.get(null);
            } catch (ReflectiveOperationException | RuntimeException var4) {
               rko = null;
            }
         }

         if (rko != null) {
            for (Entity var2 : var0.getEntities()) {
               if (var2 instanceof LivingEntity var3 && !var3.getDataTracker().get(rko).isEmpty()) {
                  var3.getDataTracker().set(rko, List.of());
               }
            }
         }
      }
   }

   public static void afterExtraction(WorldRenderState var0) {
      if (rki != null && rks(rki.glowing)) {
         for (EntityRenderState var2 : var0.entityRenderStates) {
            var2.outlineColor = 0;
         }
      }
   }

   private static void rkx() {
      if (!rkn) {
         rkn = true;

         try {
            Field var0 = vxr.find(FogRenderer.class, "net.minecraft.class_758", "field_60586", "Ljava/util/List;");
            if (var0 == null) {
               return;
            }

            List var1 = (List)var0.get(null);

            for (int var2 = 0; var2 < var1.size(); var2++) {
               FogModifier var3 = (FogModifier)var1.get(var2);
               if (var3 instanceof LavaFogModifier) {
                  var1.set(var2, new rkc(var3, () -> rki != null && rks(rki.lava)));
               } else if (var3 instanceof BlindnessEffectFogModifier) {
                  var1.set(var2, new rkc(var3, () -> rki != null && rks(rki.blindness)));
               } else if (var3 instanceof DarknessEffectFogModifier) {
                  var1.set(var2, new rkc(var3, () -> rki != null && rks(rki.darkness)));
               }
            }
         } catch (Throwable var4) {
            System.out.println("fog rules can't be changed: " + var4);
         }
      }
   }
}
