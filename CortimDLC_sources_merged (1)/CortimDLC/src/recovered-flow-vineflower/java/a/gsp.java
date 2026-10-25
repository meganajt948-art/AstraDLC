package a;

import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

record gsp(String name, RegistryKey<Biome> biome, String season, String sky, long time, int lift, float pitch) {
   private final String gsq;
   private final RegistryKey<Biome> gsr;
   private final String gss;
   private final String gst;
   private final long gsu;
   private final int gsv;
   private final float gsw;

   private gsp(String name, RegistryKey<Biome> biome, String season, String sky, long time, int lift, float pitch) {
      this.gsq = name;
      this.gsr = biome;
      this.gss = season;
      this.gst = sky;
      this.gsu = time;
      this.gsv = lift;
      this.gsw = pitch;
   }

   public String name() {
      return this.gsq;
   }

   public RegistryKey<Biome> biome() {
      return this.gsr;
   }

   public String season() {
      return this.gss;
   }

   public String sky() {
      return this.gst;
   }

   public long time() {
      return this.gsu;
   }

   public int lift() {
      return this.gsv;
   }

   public float pitch() {
      return this.gsw;
   }
}
