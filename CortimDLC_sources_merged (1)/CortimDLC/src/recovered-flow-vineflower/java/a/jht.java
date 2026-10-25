package a;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.entry.RegistryEntry;

final class jht {
   private final String jhu;
   private final RegistryEntry<StatusEffect> jhv;
   private final String jhw;
   private final int jhx;
   private final boolean jhy;
   private final float jhz;
   private final int jia;
   private final boolean jib;

   jht(String key, RegistryEntry<StatusEffect> type, String name, int ticks, boolean infinite, float fraction, int color, boolean harmful) {
      this.jhu = key;
      this.jhv = type;
      this.jhw = name;
      this.jhx = ticks;
      this.jhy = infinite;
      this.jhz = fraction;
      this.jia = color;
      this.jib = harmful;
   }

   public String key() {
      return this.jhu;
   }

   public RegistryEntry<StatusEffect> type() {
      return this.jhv;
   }

   public String name() {
      return this.jhw;
   }

   public int ticks() {
      return this.jhx;
   }

   public boolean infinite() {
      return this.jhy;
   }

   public float fraction() {
      return this.jhz;
   }

   public int color() {
      return this.jia;
   }

   public boolean harmful() {
      return this.jib;
   }
}
