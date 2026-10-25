package a;

import flow.dev.a;
import java.lang.reflect.Field;
import net.fabricmc.fabric.api.client.screen.v1.ScreenKeyboardEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenKeyboardEvents.AllowKeyPress;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.RecipeBookScreen;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;

public class lwx extends kfe {
   static final Field lwy = vxr.find(
      RecipeBookScreen.class,
      a.d("쵆듼㸾ꀕ⮁괴ᝠ麚Ã詣ඣ\uf7d5礐\ue0fb櫥\uec1b噙\ud99a䌩암䳍㚝렬⏹ꖀ", -1820797324, -558556347),
      a.d("\ue6d0齮ᖱ诉\u0016蚜㲥땕⬊ꆸ♨", 1736400144, -1498629203),
      a.d("蟜﹏璗\ueaf7慻\ue788巟퐩䩽샊䜈뵪㎺ꨙ‑ꚬᳬ錰\u0991迀؛簠\uf296楀\uef33", -34768457, -1570636226)
   );
   static final Field lwz = vxr.find(
      RecipeBookWidget.class,
      a.c(-2006701995, "⠬冖\udb54䕿컫䡞\uf20a篰\ue5a9漉\ue8c9\u12bf鱺֑辏ॱ댳㳰ꙃ‾ꦣ폷嵃"),
      a.d("䏴㩊낕⻭ꔲ⎸馇ၵ踢Ғ", -1104652422, 569578722),
      a.b("뗺챩䚱\ud8d1卝햮濹\ue60f硛\uf2ec甮轌Ɯ頿ሷ钊⻊ꄖ㮷뷦㐽一살季\udd15", 1739765167)
   );
   static lwx lxa;
   final vkl lxb = this.add(new vkl(a.c(-181852024, "⣕兇\udb96䗼츬䢇\uf280笾\ue560澟\ue82fቩ鲸ԗ"), true));
   final vkl lxc = this.add(new vkl(a.d("闖\uec58暓\uf8ff", 138811725, -1000698667), true));
   final vkl lxd = this.add(new vkl(a.b("ᛕ潃\ue5de篬\uf034皀쳟䔥\udb60内혛Ɫꊾ㬔", -890300782), true));
   final vkl lxe = this.add(new vkl(a.d("\ud8aeꄰ⯹떕㸋룗ʼ譔ᔓ龿ᡄ\ue217泗\uf57b缮吏䎌", -964803076, -1197040382), true));
   final vyn lxf = new vyn();
   boolean lxg;

   public lwx() {
      super(a.b("贊\uf489繆\ue013毦\ued4e圎", 1015582026), a.c(1246025295, "혦꾵╿묝わ뙩త藈ᮋ酲ᛵ\uec98扂﮶熬\uf75a䴍싏塷\ude3c埐\u2d9cꌤ㢬뺜㑐趱έ饒Ἀ钠樤\ue024秊ﾌ甶"), kfa.MOVEMENT);
      lxa = this;
   }

   public static void attach(Screen var0) {
      lwx var1 = lxa;
      if (var1 != null) {
         if (var0 instanceof HandledScreen) {
            ScreenKeyboardEvents.allowKeyPress(var0)
               .register((AllowKeyPress)(var1x, var2) -> !var1.isEnabled() || !var1.lxc.get() || !var1.mc.options.jumpKey.matchesKey(var2) || lxk(var1x));
         }

         if (var1.isEnabled() && var1.lxj(var0) && !var1.lxf.isHeld()) {
            var1.lxl(var1.mc);
            var1.lxg = true;
         }
      }
   }

   @Override
   protected void onDisable() {
      vwy.setActive(false);
      this.lxf.release(this.mc);
      if (this.mc.currentScreen != null && this.mc.options != null) {
         lxm(this.mc);
      }

      this.lxg = false;
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      vwy.setActive(this.lxe.get());
      if (this.lxe.get()) {
         vwy.ensure(var1);
         if (vwy.waiting()) {
            this.lxf.hold(var1);
            return;
         }
      }

      boolean var2 = this.lxf.isHeld();
      this.lxf.release(var1);
      Screen var3 = var1.currentScreen;
      if (var3 == null) {
         if (this.lxg) {
            lxn(var1);
         }

         this.lxg = false;
      } else if (this.lxj(var3)) {
         this.lxl(var1);
         this.lxg = true;
      } else if (this.lxg || var2) {
         lxm(var1);
         this.lxg = false;
      }
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      if (this.lxe.get() && vwy.waiting()) {
         vwy.poke(false);
      }
   }

   boolean lxj(Screen var1) {
      if (var1 instanceof hlc var2) {
         return this.lxd.get() && !var2.typing();
      } else {
         return var1 instanceof iwf ? true : var1 instanceof HandledScreen && !lxk(var1);
      }
   }

   static boolean lxk(Screen var0) {
      for (Element var2 : var0.children()) {
         if (var2 instanceof TextFieldWidget var3 && var3.isFocused() && var3.isVisible()) {
            return true;
         }
      }

      if (var0 instanceof RecipeBookScreen && lwy != null && lwz != null) {
         try {
            return lwy.get(var0) instanceof RecipeBookWidget var6 && var6.isOpen() && lwz.get(var6) instanceof TextFieldWidget var5 && var5.isFocused();
         } catch (IllegalAccessException | RuntimeException var4) {
         }
      }

      return false;
   }

   void lxl(MinecraftClient var1) {
      GameOptions var2 = var1.options;
      lxo(var1, var2.forwardKey, true);
      lxo(var1, var2.backKey, true);
      lxo(var1, var2.leftKey, true);
      lxo(var1, var2.rightKey, true);
      lxo(var1, var2.jumpKey, this.lxc.get());
      if (!var2.getSprintToggled().getValue()) {
         lxo(var1, var2.sprintKey, this.lxb.get());
      }

      if (!var2.getSneakToggled().getValue()) {
         var2.sneakKey.setPressed(false);
      }

      var2.useKey.setPressed(false);
   }

   static void lxm(MinecraftClient var0) {
      GameOptions var1 = var0.options;

      for (KeyBinding var5 : new KeyBinding[]{var1.forwardKey, var1.backKey, var1.leftKey, var1.rightKey, var1.jumpKey, var1.useKey}) {
         var5.setPressed(false);
      }

      if (!var1.getSprintToggled().getValue()) {
         var1.sprintKey.setPressed(false);
      }

      if (!var1.getSneakToggled().getValue()) {
         var1.sneakKey.setPressed(false);
      }
   }

   static void lxn(MinecraftClient var0) {
      GameOptions var1 = var0.options;

      for (KeyBinding var5 : new KeyBinding[]{var1.forwardKey, var1.backKey, var1.leftKey, var1.rightKey, var1.jumpKey}) {
         lxo(var0, var5, true);
      }

      if (!var1.getSprintToggled().getValue()) {
         lxo(var0, var1.sprintKey, true);
      }

      if (!var1.getSneakToggled().getValue()) {
         lxo(var0, var1.sneakKey, true);
      }
   }

   static void lxo(MinecraftClient var0, KeyBinding var1, boolean var2) {
      var1.setPressed(var2 && vzz.isPhysicallyDown(var0, var1));
   }
}
