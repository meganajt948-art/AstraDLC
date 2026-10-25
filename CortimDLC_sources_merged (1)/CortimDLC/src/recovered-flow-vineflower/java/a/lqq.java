package a;

import flow.Flow;
import flow.dev.a;
import net.minecraft.network.packet.Packet;
import net.minecraft.text.Text;

public class lqq extends pnc {
   static lqq lqr;

   public lqq() {
      super(
         a.d("ꑬ\uddf2圬쥗䊌쐶繿\uf7bc槄\ue366撪黓ဓ", -1636428255, -796413439),
         a.b(
            "犪଼臼ᾒ鑛ኹꢫ⅕뼇㖼뉣䠙월弱픦取\ue99e晟ﳷ窼\uf318褀\u07b4鰫ᨒ郉⥿꜠㷘뮕と캣䒮\udd51嬁톨湻\ue459拟ﭫ煤\u0fe1薨ȃ颠ᚐ꽌◷ꏼ㡩똗䳈앫䍩\ud9d5垞\uec20檥\ue081祏\uf7f1趵\u0a12耗Ễ靸\u2d6eꯝↄ븸㓹늏䬄쇧徣푁刅\ue8b0慮\uff00",
            -1704889668
         ),
         kfa.MISC
      );
      if (lqr == null) {
         lqr = this;
      }
   }

   @Override
   public boolean isMaintenance() {
      return false;
   }

   public static boolean busy() {
      return false;
   }

   public static lqq get() {
      lqq var0 = lqr;
      if (var0 == null) {
         Flow var1 = Flow.getInstance();
         var0 = var1 != null && var1.getModuleManager() != null ? var1.getModuleManager().get(lqq.class) : null;
      }

      return var0;
   }

   public int mined() {
      return 0;
   }

   public int blasts() {
      return 0;
   }

   public String lastNote() {
      return null;
   }

   public String status() {
      return "";
   }

   @Override
   public void attachBot(efz var1) {
      super.attachBot(var1);
      if (lqr == this) {
         lqr = null;
      }
   }

   @Override
   public void setBotRunning(boolean var1) {
      if (!var1) {
         super.setBotRunning(false);
      }
   }

   public vmo[] botSettings() {
      return new vmo[0];
   }

   public void copySettingsFrom(lqq var1) {
   }

   public void onPacket(Packet<?> var1) {
   }

   public static void onMessage(Text var0) {
   }

   public void onChat(Text var1) {
   }
}
