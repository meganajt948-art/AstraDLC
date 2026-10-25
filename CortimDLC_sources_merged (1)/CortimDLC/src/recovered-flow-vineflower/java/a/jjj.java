package a;

import net.minecraft.entity.player.SkinTextures;
import net.minecraft.item.ItemStack;

final class jjj {
   private final String jjk;
   private final SkinTextures jjl;
   private final float jjm;
   private final float jjn;
   private final float jjo;
   private final boolean jjp;
   private final ItemStack[] jjq;
   private final ItemStack jjr;
   private final ItemStack jjs;
   private final float jjt;
   private final int jju;

   private jjj(
      String name,
      SkinTextures skin,
      float health,
      float max,
      float absorption,
      boolean unknown,
      ItemStack[] armor,
      ItemStack main,
      ItemStack off,
      float distance,
      int hurtTime
   ) {
      this.jjk = name;
      this.jjl = skin;
      this.jjm = health;
      this.jjn = max;
      this.jjo = absorption;
      this.jjp = unknown;
      this.jjq = armor;
      this.jjr = main;
      this.jjs = off;
      this.jjt = distance;
      this.jju = hurtTime;
   }

   public String name() {
      return this.jjk;
   }

   public SkinTextures skin() {
      return this.jjl;
   }

   public float health() {
      return this.jjm;
   }

   public float max() {
      return this.jjn;
   }

   public float absorption() {
      return this.jjo;
   }

   public boolean unknown() {
      return this.jjp;
   }

   public ItemStack[] armor() {
      return this.jjq;
   }

   public ItemStack main() {
      return this.jjr;
   }

   public ItemStack off() {
      return this.jjs;
   }

   public float distance() {
      return this.jjt;
   }

   public int hurtTime() {
      return this.jju;
   }
}
