package a;

import flow.bot.BotScreen;
import flow.dev.a;

public class oqm extends kfe {
   private final vkl oqn = this.add(new vkl(a.c(305493345, "甿ಲ虢᠉鏍ᔹ꼩⛚뢔㈡뗥侟셁"), true));

   public oqm() {
      super(a.d("⠝冁\udb49䔿", -2045997647, -1448499734), a.c(1139491451, "䈠㮬녳⼄꓀∰頡ᇝ辙ռ苮碝\uf64a濷\ue5be捔\ud901囗찷䨠쏞릒㝳곤⪜ꁞ᧲鞧ൗ謏"), kfa.PLAYER);
   }

   public boolean solvesCaptcha() {
      return this.oqn.get();
   }

   @Override
   public boolean isAction() {
      return true;
   }

   @Override
   public boolean isMaintenance() {
      return false;
   }

   @Override
   public void toggle() {
      if (!this.isMaintenance()) {
         if (this.mc.currentScreen instanceof BotScreen) {
            this.mc.setScreen(null);
         } else {
            this.mc.setScreen(new BotScreen());
         }
      }
   }
}
