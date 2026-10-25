package a;

import flow.dev.a;

final class haj {
   private final int hak;
   private final String hal;
   private final long ham;
   private final float han;
   private final float hao;
   private final int hap;
   private final boolean haq;
   private final String har;
   private final String has;

   haj(int var1, String var2, long var3, float var5, float var6, int var7, boolean var8) {
      this(var1, var2, var3, var5, var6, var7, var8, a.d("砧ƙ譃ᔶ黲", 1314169443, -1279010270), hav.hay);
   }

   haj(int var1, String var2, long var3, float var5, float var6, int var7, boolean var8, String var9) {
      this(var1, var2, var3, var5, var6, var7, var8, var9, hav.hay);
   }

   private haj(int at, String name, long time, float yaw, float pitch, int lift, boolean on, String weather, String quality) {
      this.hak = at;
      this.hal = name;
      this.ham = time;
      this.han = yaw;
      this.hao = pitch;
      this.hap = lift;
      this.haq = on;
      this.har = weather;
      this.has = quality;
   }

   public int at() {
      return this.hak;
   }

   public String name() {
      return this.hal;
   }

   public long time() {
      return this.ham;
   }

   public float yaw() {
      return this.han;
   }

   public float pitch() {
      return this.hao;
   }

   public int lift() {
      return this.hap;
   }

   public boolean on() {
      return this.haq;
   }

   public String weather() {
      return this.har;
   }

   public String quality() {
      return this.has;
   }
}
