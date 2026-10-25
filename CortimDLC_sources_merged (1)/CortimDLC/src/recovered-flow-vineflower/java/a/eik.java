package a;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.recipebook.ClientRecipeBook;
import net.minecraft.client.sound.BiomeEffectSoundPlayer;
import net.minecraft.client.sound.BubbleColumnSoundPlayer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.stat.StatHandler;
import net.minecraft.text.Text;
import net.minecraft.util.PlayerInput;

public final class eik extends ClientPlayerEntity {
   final dtv eil;

   eik(MinecraftClient var1, ClientWorld var2, ClientPlayNetworkHandler var3, StatHandler var4, ClientRecipeBook var5, PlayerInput var6, boolean var7, dtv var8) {
      super(var1, var2, var3, var4, var5, var6, var7);
      this.eil = var8;
      this.eio();
   }

   void eio() {
      for (Field var4 : ClientPlayerEntity.class.getDeclaredFields()) {
         if (!Modifier.isStatic(var4.getModifiers()) && List.class.isAssignableFrom(var4.getType())) {
            try {
               var4.setAccessible(true);
               if (var4.get(this) instanceof List var5) {
                  var5.removeIf(var0 -> var0 instanceof BubbleColumnSoundPlayer || var0 instanceof BiomeEffectSoundPlayer);
               }
            } catch (Throwable var7) {
            }
         }
      }
   }

   public dtv getBot() {
      return this.eil;
   }

   @Override
   public void sendMessage(Text message, boolean overlay) {
      this.eil.onLocalMessage(message, overlay);
   }

   @Override
   public void addCritParticles(Entity target) {
   }

   @Override
   public void addEnchantedHitParticles(Entity target) {
   }
}
