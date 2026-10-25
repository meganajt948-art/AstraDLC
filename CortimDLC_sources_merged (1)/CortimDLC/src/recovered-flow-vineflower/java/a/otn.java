package a;

import flow.dev.a;
import java.util.Random;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;

public class otn extends kfe {
   final vmc oto = this.add(new vmc(a.c(2015664505, "餸\ue0a8橲\uf40e翁"), 60.0, 0.0, 500.0, 10.0).suffix(a.b("뭬싃", 424655619)));
   final vmc otp = this.add(new vmc(a.d("핬곮☲롉㎕딦", -78782486, -1419900206), 40.0, 0.0, 300.0, 10.0).suffix(a.c(1416209304, "ꏷ\uda58")));
   final vkl otq = this.add(new vkl(a.d("昍ᾈ镚ର肨ٚ밆㗴ꮷℐ", -1516567235, -402496645), true));
   final vkl otr = this.add(new vkl(a.c(-1737755196, "\uf583谓ڏ颶፦闌⾉ꙻ㠷"), false));
   static final long ots = 180L;
   static final long ott = 300L;
   final Random otu = new Random();
   Screen otv;
   long otw;
   long otx;
   long oty;

   public otn() {
      super(a.c(238885778, "ᯝ扇\ue899盾ﴮ箸쇌䠬홷峋\udb11ⅷ"), a.b("ퟯ깶Ⓒ뫍ㄇ랺\u0dff葝ᩖ郻ᜥ\ued11掅憎灡\uf686䳎쌘姸\udff0嘑ⱚꊼ㤢뽂㖆谾", -648751183), kfa.PLAYER);
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      Screen var2 = var1.currentScreen;
      long var3 = System.currentTimeMillis();
      if (var2 != this.otv) {
         this.otv = var2;
         this.otw = var3;
         this.oty = var3;
         this.otx = var3 + 180L;
      }

      if (var2 instanceof HandledScreen var5 && vxl.isStorage(var2) && !oqv.busy() && !osq.busy() && !oub()) {
         ScreenHandler var6 = var5.getScreenHandler();
         if (var6.getCursorStack().isEmpty() && var3 >= this.otx) {
            PlayerInventory var7 = var1.player.getInventory();

            for (Slot var9 : vxl.own(var6, var7)) {
               if (var9.hasStack() && var9.canTakeItems(var1.player) && vxl.room(var6, var7, var9.getStack(), !this.otr.get()) != null) {
                  if (this.otr.get()) {
                     Slot var10 = vxl.room(var6, var7, var9.getStack(), false);
                     vxl.click(var1, var6, var9.id, 0, SlotActionType.PICKUP);
                     vxl.click(var1, var6, var10.id, 0, SlotActionType.PICKUP);
                     if (!var6.getCursorStack().isEmpty()) {
                        vxl.click(var1, var6, var9.id, 0, SlotActionType.PICKUP);
                     }
                  } else {
                     vxl.click(var1, var6, var9.id, 0, SlotActionType.QUICK_MOVE);
                  }

                  this.oty = var3;
                  this.otx = var3 + this.oto.getInt() + (this.otp.getInt() > 0 ? this.otu.nextInt(this.otp.getInt() + 1) : 0);
                  return;
               }
            }

            if (this.otq.get() && var3 - this.oty > 300L && var3 - this.otw > 480L) {
               var5.close();
            }
         }
      }
   }

   static boolean oub() {
      nxa var0 = nxa.mainInstance();
      if (var0 != null && var0.isEnabled() && var0.busy()) {
         return true;
      }

      mpq var1 = mpq.mainInstance();
      return var1 != null && var1.isEnabled() && var1.busy();
   }
}
