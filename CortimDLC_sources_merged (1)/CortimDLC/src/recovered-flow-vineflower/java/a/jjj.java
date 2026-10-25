package a;

import net.minecraft.entity.player.SkinTextures;
import net.minecraft.item.ItemStack;

final class jjj {
   final String jjk;
   final SkinTextures jjl;
   final float jjm;
   final float jjn;
   final float jjo;
   final boolean jjp;
   final ItemStack[] jjq;
   final ItemStack jjr;
   final ItemStack jjs;
   final float jjt;
   final int jju;

   jjj(
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
