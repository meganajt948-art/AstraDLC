package a;

import java.util.Locale;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.WorldTimeUpdateS2CPacket;

public class rdd extends kfe {
   private static final long rde = 24000L;
   private final vmc rdf = this.add(new vmc("Time", 12.0, 0.0, 24.0, 0.25).format(rdd::rdr));
   private static volatile boolean rdg;
   private static volatile long rdh;
   private static volatile long rdi;
   private static volatile boolean rdj = true;
   private static volatile long rdk;

   public rdd() {
      super(new String(new char[]{'C', 'u', 's', 't', 'o', 'm', 'T', 'i', 'm', 'e'}), "Your own time of day, on your screen", kfa.RENDER);
      wcn.rewrite(rdd::rdo);
   }

   @Override
   protected void onEnable() {
      ClientWorld var1 = this.mc.world;
      if (var1 != null) {
         rdi = var1.getTimeOfDay();
         rdj = true;
         rdk = var1.getTime();
         wcn.ensure(this.mc);
      }

      rdh = this.rdq();
      rdg = true;
      rdn(this.mc);
   }

   @Override
   protected void onDisable() {
      rdg = false;
      ClientWorld var1 = this.mc.world;
      if (var1 != null) {
         long var2 = rdj ? Math.max(0L, var1.getTime() - rdk) : 0L;
         var1.setTime(var1.getTime(), rdi + var2, rdj);
      }
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      wcn.ensure(var1);
      rdh = this.rdq();
      rdn(var1);
   }

   private static void rdn(MinecraftClient var0) {
      ClientWorld var1 = var0.world;
      if (var1 != null) {
         long var2 = rdp(var1.getTimeOfDay());
         if (var1.getTimeOfDay() != var2) {
            var1.setTime(var1.getTime(), var2, false);
         }
      }
   }

   private static Packet<?> rdo(Packet<?> var0) {
      if (rdg && var0 instanceof WorldTimeUpdateS2CPacket var1) {
         rdi = var1.timeOfDay();
         rdj = var1.tickDayTime();
         rdk = var1.time();
         return new WorldTimeUpdateS2CPacket(var1.time(), rdp(var1.timeOfDay()), false);
      } else {
         return var0;
      }
   }

   private static long rdp(long var0) {
      return Math.floorDiv(var0, 24000L) * 24000L + rdh;
   }

   private long rdq() {
      return Math.floorMod(Math.round((this.rdf.get() - 6.0) * 1000.0), 24000L);
   }

   private static String rdr(double var0) {
      int var2 = (int)Math.round(var0 * 60.0) % 1440;
      return String.format(Locale.ROOT, "%02d:%02d", var2 / 60, var2 % 60);
   }
}
