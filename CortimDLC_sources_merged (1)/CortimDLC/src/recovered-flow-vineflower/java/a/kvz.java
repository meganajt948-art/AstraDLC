package a;

import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.Items;

public class kvz extends kfe {
   private static kvz kwa;
   private final vlq kwb = this.add(new vlq(a.b("\ueb9c鈊ᣚ蚪൸诃㖀론♎겁⬭턧忺", 66842507)));
   private final vzh kwc = new vzh(Items.field_8634, true);

   public kvz() {
      super(a.d("긗히嵇쌟䣽칈琈\ufde7", 667402227, 1502744999), a.c(-2080823843, "▗尚훓䢿썰䗅ￅ癵\ue825拚\ue54cἶ釫࡛舟Ҽ뺣ㅧꯐⶒꑻ\ude66傚쭊䵻쟫縙\uf003櫺\uecb7"), kfa.COMBAT);
      kwa = this;
   }

   public static boolean busy() {
      return kwa != null && kwa.kwc.busy();
   }

   @Override
   protected void onEnable() {
      this.kwc.reset(this.mc);
   }

   @Override
   protected void onDisable() {
      this.kwc.reset(this.mc);
   }

   @Override
   public void onKey(MinecraftClient var1, int var2) {
      if (var2 == this.kwb.get()) {
         this.kwc.press(var1, var2, this.getName(), wap.s(a.d("Ⓐ崦ힺ䦛쉙䓬ﺬ睃\ue903", 361902441, -7268968), a.c(-411156954, "㨰䎩줍匞\udcdf婭\ue037榽\uf7e6紧\ufaf7")));
      }
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      this.kwc.startTick(var1);
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      this.kwc.endTick(var1);
   }
}
