package a;

import flow.dev.a;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;

public final class qaj {
   private static final Item[] qak = new Item[]{Items.REDSTONE, Items.LAPIS_LAZULI, Items.COAL, Items.IRON_INGOT};
   private static final long qal = 6000L;
   private static final long qam = 4000L;
   private static final long qan = 12000L;
   private static final long qao = 1300L;
   private final Map<Item, Long> qap = new HashMap<>();
   private final Map<Item, String> qaq = new HashMap<>();
   private qag qar = qag.IDLE;
   private long qas;
   private long qat;
   private int qau;
   private boolean qav;
   private String qaw = "";

   public boolean active() {
      return this.qar != qag.IDLE && this.qar != qag.DONE;
   }

   public boolean ok() {
      return this.qav;
   }

   public String result() {
      return this.qaw;
   }

   public void begin(MinecraftClient var1, String var2, long var3) {
      this.qap.clear();
      this.qaq.clear();
      this.qau = 0;
      this.qav = false;
      this.qaw = "";
      this.qas = var3;
      String var5 = var2.trim();
      if (var5.startsWith(a.d("㉶", -2117650585, 1868367167))) {
         var5 = var5.substring(1);
      }

      if (var1.player != null && var1.currentScreen instanceof HandledScreen) {
         var1.player.closeHandledScreen();
      }

      if (!var5.isEmpty() && var1.getNetworkHandler() != null) {
         var1.getNetworkHandler().sendChatCommand(var5);
         this.qba(qag.MENU, var3);
      } else {
         this.qbb(var1, false, a.b("⭂勻\ud85f䉌춁䬴\uf165碘\ue6ca汲\uebdeᗄ齲ڸ貒ਟ뀦㾆ꔷ⍬", -799527061));
      }
   }

   public void cancel(MinecraftClient var1) {
      if (this.active() && var1.player != null && var1.currentScreen instanceof HandledScreen) {
         var1.player.closeHandledScreen();
      }

      this.qar = qag.IDLE;
   }

   public boolean tick(MinecraftClient var1, ClientPlayerEntity var2, long var3) {
      if (!this.active()) {
         return true;
      }

      if (var3 - this.qas > 12000L) {
         this.qbb(var1, false, a.b("ἄ曎\uec64物杻缈앙䢲티塉\udb8f◠ꭋ㊊룞㹘葭ி锗\u1754麯\ue4f2樳\uf197矡﵃", 1952127839));
         return true;
      }

      HandledScreen var5 = var1.currentScreen instanceof HandledScreen var6 && vxl.isStorage(var6) ? var6 : null;
      switch (this.qar) {
         case MENU:
            if (var5 == null) {
               if (var3 - this.qat > 6000L) {
                  this.qbb(var1, false, a.c(748480639, "\ue842醾᭺蔇໌衪㉫뾇⇐꽴ⲹ횴堛쇐䮈촉眼\uf8e3"));
               }

               return !this.active();
            }

            ScreenHandler var8 = var5.getScreenHandler();
            if (qbc(var8, var2) > 0) {
               this.qba(qag.TOGGLE, var3);
               return false;
            }

            Slot var9 = qbe(var8, var2);
            if (var9 == null) {
               if (var3 - this.qat > 6000L) {
                  this.qbb(var1, false, a.d("剺⯃ꅧ㭴듃㈂衖Ƥ鿺ᕅ銝泼\ue2a0羒\uf5d9獝줕䛗\udc75廟ힳ꧰⍑뢏㺽둻හ莉ᥩ", -226063115, -344991057));
               }

               return !this.active();
            }

            vxl.click(var1, var8, var9.id, 0, SlotActionType.PICKUP);
            this.qau++;
            this.qba(qag.SECTION, var3);
            break;
         case SECTION:
            if (var5 != null && qbc(var5.getScreenHandler(), var2) > 0) {
               this.qba(qag.TOGGLE, var3);
               return this.qaz(var1, var2, var5, var3);
            }

            if (var3 - this.qat > 4000L) {
               if (var5 != null && this.qau < 2) {
                  this.qba(qag.MENU, var3);
               } else {
                  this.qbb(var1, false, a.c(-87497882, "\ue73d黼ᐨ詚ƌ蜳㥻뀁⫝ꁴ⟒\udda4占쫀䑨숂籐\uf389洯\uef60曫᳂鈋\u09d1连յ볈"));
               }
            }
            break;
         case TOGGLE:
            if (var5 == null) {
               this.qbb(var1, false, a.d("륨샐䨋퐉宰\ud960捈\ueac0瓣︤禆菵ന邉ọ頻≾귕㝭녌㢾䊐찮", -1858643312, 1644881875));
               return true;
            }

            return this.qaz(var1, var2, var5, var3);
      }

      return !this.active();
   }

   private boolean qaz(MinecraftClient var1, ClientPlayerEntity var2, HandledScreen<?> var3, long var4) {
      ScreenHandler var6 = var3.getScreenHandler();
      int var7 = 0;
      int var8 = 0;

      for (Item var12 : qak) {
         Slot var13 = qbd(var6, var2, var12);
         if (var13 != null) {
            var8++;
            String var14 = loreLine(var13.getStack());
            if (enabled(var14)) {
               var7++;
            } else {
               Long var15 = this.qap.get(var12);
               boolean var16 = var15 != null && !var14.equals(this.qaq.get(var12));
               if (var15 == null || var16 || var4 - var15 > 1300L) {
                  vxl.click(var1, var6, var13.id, 0, SlotActionType.THROW);
                  this.qap.put(var12, var4);
                  this.qaq.put(var12, var14);
               }
            }
         }
      }

      if (var8 <= 0 || var7 != var8 || var8 != qak.length && var4 - this.qat <= 1500L) {
         return false;
      }

      this.qbb(var1, true, var7 + a.b("\u196e擇\uee1b瑽", 1976703306) + qak.length + a.c(1910294584, "젗떻㽥ꔄ⫃거ᙓ鿞֒譏೧\uf6ef硄\ue1f0殬"));
      return true;
   }

   private void qba(qag var1, long var2) {
      this.qar = var1;
      this.qat = var2;
   }

   private void qbb(MinecraftClient var1, boolean var2, String var3) {
      this.qav = var2;
      this.qaw = var3;
      this.qar = qag.DONE;
      if (var1.player != null && var1.currentScreen instanceof HandledScreen) {
         var1.player.closeHandledScreen();
      }
   }

   private static int qbc(ScreenHandler var0, ClientPlayerEntity var1) {
      int var2 = 0;

      for (Item var6 : qak) {
         if (qbd(var0, var1, var6) != null) {
            var2++;
         }
      }

      return var2;
   }

   private static Slot qbd(ScreenHandler var0, ClientPlayerEntity var1, Item var2) {
      for (Slot var4 : vxl.own(var0, var1.getInventory())) {
         ItemStack var5 = var4.getStack();
         if (var5.isOf(var2) && loreLine(var5).contains(a.d("鯁\ue20b梡\uf6ac絾", 960845424, -1930769931))) {
            return var4;
         }
      }

      return null;
   }

   private static Slot qbe(ScreenHandler var0, ClientPlayerEntity var1) {
      Slot var2 = null;

      for (Slot var4 : vxl.own(var0, var1.getInventory())) {
         ItemStack var5 = var4.getStack();
         if (!var5.isEmpty()) {
            String var6 = pfl.title(var5.getName().getString());
            if (var6.contains(a.c(-16408195, "ꔱ\udcf8噞젨"))) {
               return var4;
            }

            if (var2 == null && var5.isOf(Items.LAPIS_LAZULI)) {
               var2 = var4;
            }
         }
      }

      return var2;
   }

   static String loreLine(ItemStack var0) {
      LoreComponent var1 = var0.get(DataComponentTypes.LORE);
      if (var1 == null) {
         return "";
      }

      for (Text var4 : var1.lines()) {
         String var5 = pfl.title(var4.getString());
         if (var5.contains(a.d("\uf7a5蹯Ӆ髈ᄚ", -441072656, 1379348497))) {
            return var5;
         }
      }

      return "";
   }

   static boolean enabled(String var0) {
      return var0.contains(a.c(-1180267091, "覘\uf021竳\ue4f7漩\ue9ea厱")) && !var0.contains(a.b("़烴節搦\uef84椼", -1867117304));
   }
}
