package a;

import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;

public class ouc extends kfe {
   static final int oud = 6;
   final vlq oue = this.add(new vlq(a.b("ꧮ큻媾쓞余즣現﨓", 95922613)));
   final vlq ouf = this.add(new vlq(a.d("\uf05b觅̍鵫ᚮ逇⩉ꎡ㶵띏を쫿", 1374212688, 1801200193)));
   final vzh oug = new vzh(Items.FIREWORK_ROCKET);
   final vyn ouh = new vyn();
   boolean oui;
   boolean ouj;
   int ouk;
   int oul;

   public ouc() {
      super(
         a.b("\uf8e1腹ி闃Ḓ颰⋑ꬄ㕍뿭", -937101138),
         a.c(1145135342, "惱ᥤ鎡ශ蘕÷뫰㌝굏➻ꀫ婑풋䴬인䆍ﯞ琂\ueea4棤\ue156魆ᗺ踡ࠚ芟㬰땬\u2fde꧊≰\udcb4囶켁䥁쎱簩\uf659烄\ue93a捤ᶞ鞈ၲ誫ӆ뵀㟽뇧⨰ꑕ庒흶兦쯔䗃ﹳ碹\uf2dd欞\ue5b1鿽᠗鈍\u0c8d蔽㼠릅㏎걲⛤ꃚ夞펳䷭옋"),
         kfa.PLAYER
      );
   }

   @Override
   protected void onEnable() {
      if (!this.oue.isBound() && !this.ouf.isBound() && this.mc.player != null) {
         izx.alert(
            this.getName(),
            wap.s(
               a.d("\uf887脝\u0bc9閲ḡ飄⊋ꭷ㕭뾗㡊숧䳺픘异\ud9f4揵\uec6d盃\uf095礱̳趖ᙖ逩\u1ae5ꍑⴉ럪", -690312238, 1522619146),
               a.d("鈌\ueb90慄＿瓥\uf223䡻엦徣픕勅ꢵ♧뿔㆟덼ഡ蛭᱓驳ᎇ槔\ue719糏荒灨즮", 851516112, 108694746)
            ),
            vhz.KEYBOARD,
            false
         );
      }
   }

   @Override
   protected void onDisable() {
      this.ouj = false;
      this.oup();
      this.ouq();
      this.oug.reset(this.mc);
   }

   @Override
   public void onKey(MinecraftClient var1, int var2) {
      if (var2 == this.oue.get()) {
         this.ouj = true;
         this.ouk = 0;
      } else if (var2 == this.ouf.get() && !this.ouj) {
         this.oug
            .press(
               var1, var2, this.getName(), wap.s(a.c(1730095261, "⣟兏\udbd3䗤츼䢖\uf2d2笱\ue576濚\ue810ቹ"), a.c(-274947199, "ꞓ\ude0a咮캽䄎쟎綑\uf46c橆\ue085村鵕ᏸ詍\u0012"))
            );
      }
   }

   @Override
   public void onStartTick(MinecraftClient var1) {
      this.oug.startTick(var1);
      if (this.oul > 0 && --this.oul == 0) {
         this.ouq();
      }

      if (this.ouj && !this.oui && var1.player != null && !vyn.serverIdle(var1.player)) {
         this.ouh.hold(var1);
         this.oui = true;
      }
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      this.oug.endTick(var1);
      ClientPlayerEntity var2 = var1.player;
      if (this.ouj && var2 != null) {
         if (!wdq.canClick(var2) || var1.currentScreen != null || oxw.busy() || kvz.busy() || this.oug.busy()) {
            if (++this.ouk > 6) {
               this.ouj = false;
               this.oup();
            }
         } else if (!vyn.serverIdle(var2)) {
            if (++this.ouk > 6) {
               this.ouj = false;
               this.oup();
            }
         } else {
            this.ouj = false;
            this.ouo(var1, var2);
            this.oup();
         }
      }
   }

   void ouo(MinecraftClient var1, ClientPlayerEntity var2) {
      ItemStack var3 = var2.getEquippedStack(EquipmentSlot.CHEST);
      boolean var4 = !var3.isOf(Items.ELYTRA);
      vuc var5 = vui.best(
         var2.getInventory(),
         true,
         var1x -> {
            if (!var4) {
               if (vui.wornIn(var1x) == EquipmentSlot.CHEST && !var1x.isOf(Items.ELYTRA)) {
                  String var2x = Registries.ITEM.getId(var1x.getItem()).getPath();
                  int var3x = var2x.startsWith(a.c(744795749, "긁ힻ嵹쌔䣎침琠\ufdcc掂\ue909"))
                     ? 6
                     : (
                        var2x.startsWith(a.c(-1652743933, "Ⅿ壓툈䱵잠䄐שּ犃"))
                           ? 5
                           : (
                              var2x.startsWith(a.b("⟻幑풟䫯섉", -237492329))
                                 ? 4
                                 : (var2x.startsWith(a.c(-117954676, "⟥幟풅䫼섬䞞ﷁ琸\uea62惠")) ? 3 : (var2x.startsWith(a.c(291825617, "\ue7b1鸈ᓘ誡ŷ蟍㶯")) ? 2 : 1))
                           )
                     );
                  return var3x * 100000 + Math.min(99999, vui.left(var1x));
               } else {
                  return 0;
               }
            } else {
               return var1x.isOf(Items.ELYTRA) && vui.left(var1x) > 1 ? 1 + Math.min(9999, vui.left(var1x)) : 0;
            }
         }
      );
      if (var5 == null) {
         izx.alert(
            this.getName(),
            var4
               ? wap.s(a.d("㠏䆟쬃唷\udee9塍\ue213毤\uf5a8", -852681235, -2130369115), a.c(910612228, "판ꪉ\u202d먾㖄덃ओ肘ễ"))
               : wap.s(a.d("\uf584谔ڈ颺፦闚⾟ꙩ㠲늟㕁켥䇣", 138987540, -1493221933), a.d("퉊ꯓⅷ뭤㒮눒ࡂ臀ᾜ镚ኀ\ue8f4昡ﾚ", 538288357, 381056700)),
            vhz.INFO,
            false
         );
      } else if (!vui.roomFor(var2.getInventory(), var5, var3)) {
         izx.alert(
            this.getName(),
            wap.s(a.d("ۓ罃\uf5df毼\ue036暇\udcd6啪쭼䇊왗㱲늹⬅ꄓ➫鷣ሪ袊໐蜽ﵷ珙\ue803", 85146633, 954415756), a.c(118085557, "펽ꨤ₀몓㕘돠ে耵Ḙ邹፸\ued1b柔﹠琼\uf2ca䢍윣巢\udbc3剁")),
            vhz.INFO,
            false
         );
      } else {
         if (vui.equip(var1, EquipmentSlot.CHEST, var5) && var4 && !var2.isOnGround() && !var2.isGliding() && !var2.getAbilities().flying) {
            var1.options.jumpKey.setPressed(true);
            this.oul = 2;
         }
      }
   }

   void oup() {
      if (this.oui) {
         this.ouh.release(this.mc);
         this.oui = false;
      }
   }

   void ouq() {
      if (this.mc.options != null && this.mc.getWindow() != null) {
         this.mc.options.jumpKey.setPressed(vzz.isPhysicallyDown(this.mc, this.mc.options.jumpKey));
      }

      this.oul = 0;
   }
}
