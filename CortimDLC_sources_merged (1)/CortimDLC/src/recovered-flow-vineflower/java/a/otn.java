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
   private final vmc oto = this.add(new vmc(a.c(2015664505, "餸\ue0a8橲\uf40e翁"), 60.0, 0.0, 500.0, 10.0).suffix(a.b("뭬싃", 424655619)));
   private final vmc otp = this.add(new vmc(a.d("핬곮☲롉㎕딦", -78782486, -1419900206), 40.0, 0.0, 300.0, 10.0).suffix(a.c(1416209304, "ꏷ\uda58")));
   private final vkl otq = this.add(new vkl(a.d("昍ᾈ镚ର肨ٚ밆㗴ꮷℐ", -1516567235, -402496645), true));
   private final vkl otr = this.add(new vkl(a.c(-1737755196, "\uf583谓ڏ颶፦闌⾉ꙻ㠷"), false));
   private static final long ots = 180L;
   private static final long ott = 300L;
   private final Random otu = new Random();
   private Screen otv;
   private long otw;
   private long otx;
   private long oty;

   public otn() {
      super(a.c(238885778, "ᯝ扇\ue899盾ﴮ箸쇌䠬홷峋\udb11ⅷ"), a.b("ퟯ깶Ⓒ뫍ㄇ랺\u0dff葝ᩖ郻ᜥ\ued11掅憎灡\uf686䳎쌘姸\udff0嘑ⱚꊼ㤢뽂㖆谾", -648751183), kfa.PLAYER);
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      Screen var2 = var1.field_1755;
      long var3 = System.currentTimeMillis();
      if (var2 != this.otv) {
         this.otv = var2;
         this.otw = var3;
         this.oty = var3;
         this.otx = var3 + 180L;
      }

      if (var2 instanceof HandledScreen var5 && vxl.isStorage(var2) && !oqv.busy() && !osq.busy() && !oub()) {
         ScreenHandler var6 = var5.method_17577();
         if (var6.method_34255().method_7960() && var3 >= this.otx) {
            PlayerInventory var7 = var1.field_1724.method_31548();

            for (Slot var9 : vxl.own(var6, var7)) {
               if (var9.method_7681() && var9.method_7674(var1.field_1724) && vxl.room(var6, var7, var9.method_7677(), !this.otr.get()) != null) {
                  if (this.otr.get()) {
                     Slot var10 = vxl.room(var6, var7, var9.method_7677(), false);
                     vxl.click(var1, var6, var9.field_7874, 0, SlotActionType.field_7790);
                     vxl.click(var1, var6, var10.field_7874, 0, SlotActionType.field_7790);
                     if (!var6.method_34255().method_7960()) {
                        vxl.click(var1, var6, var9.field_7874, 0, SlotActionType.field_7790);
                     }
                  } else {
                     vxl.click(var1, var6, var9.field_7874, 0, SlotActionType.field_7794);
                  }

                  this.oty = var3;
                  this.otx = var3 + this.oto.getInt() + (this.otp.getInt() > 0 ? this.otu.nextInt(this.otp.getInt() + 1) : 0);
                  return;
               }
            }

            if (this.otq.get() && var3 - this.oty > 300L && var3 - this.otw > 480L) {
               var5.method_25419();
            }
         }
      }
   }

   private static boolean oub() {
      nxa var0 = nxa.mainInstance();
      if (var0 != null && var0.isEnabled() && var0.busy()) {
         return true;
      } else {
         mpq var1 = mpq.mainInstance();
         return var1 != null && var1.isEnabled() && var1.busy();
      }
   }
}
