package a;

import net.minecraft.client.render.Camera;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.client.sound.SoundInstanceListener;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.client.sound.TickableSoundInstance;
import net.minecraft.client.sound.SoundSystem.PlayResult;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import org.jspecify.annotations.Nullable;

final class eks extends SoundManager {
   private eks() {
      super(null);
   }

   @Override
   public void playNextTick(TickableSoundInstance sound) {
   }

   @Override
   public PlayResult play(SoundInstance sound) {
      return PlayResult.NOT_STARTED;
   }

   @Override
   public void play(SoundInstance sound, int delay) {
   }

   @Override
   public void updateListenerPosition(Camera camera) {
   }

   @Override
   public void pauseAllExcept(SoundCategory... categories) {
   }

   @Override
   public void stopAll() {
   }

   @Override
   public void tick(boolean paused) {
   }

   @Override
   public void resumeAll() {
   }

   @Override
   public void refreshSoundVolumes(SoundCategory category) {
   }

   @Override
   public void stop(SoundInstance sound) {
   }

   @Override
   public void setVolume(SoundCategory category, float volume) {
   }

   @Override
   public boolean isPlaying(SoundInstance sound) {
      return false;
   }

   @Override
   public void registerListener(SoundInstanceListener listener) {
   }

   @Override
   public void unregisterListener(SoundInstanceListener listener) {
   }

   @Override
   public void stopSounds(@Nullable Identifier id, @Nullable SoundCategory soundCategory) {
   }
}
