package a;

import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents.Join;
import net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents.AllowMouseClick;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.gui.hud.ChatHudLine;
import net.minecraft.client.gui.hud.ChatHudLine.Visible;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Style;
import net.minecraft.util.math.MathHelper;

public class lre extends kfe {
   private static lre lrf;
   private final vkl lrg = this.add(new vkl(a.b("箒Ȁ裒ᚪ鴺ᯃꆑ⡺똢㲈뭆䄼", 1981709266), true));
   private final vmc lrh = this.add(new vmc(a.c(-603737482, "눹쮩䅠\udf16哚퉶栮"), 1000.0, 200.0, 5000.0, 100.0));
   private final vkl lri = this.add(new vkl(a.d("࿃癜ﲏ拫\ue96c澞헆尾쉴", 1755679320, -395475495), true));
   private final vkl lrj = this.add(new vkl(a.d("䆄㠝닙ⲽꝨ↜鮝ቻ谱ڕ腂符\uf5f6", 1314207725, 143095337), true));
   private final vkl lrk = this.add(new vkl(a.b("鱺\ue5e7漫\uf153竝ﰣ䙱쿎凃\udb69岴ꛊ⠁뇤㯴봊݀袛ሠ", -1622565846), true));
   private static final int lrl = 100;
   private static Field lrm;
   private static Field lrn;
   private static Field lro;
   private static boolean lrp;
   private static ChatHud lrq;
   private static ChatHudLine lrr;
   private static String lrs;
   private static int lrt;

   public lre() {
      super(
         a.d("門\uec1a曀\uf8a4獓\uf5c1侀왵堠튉", -1538528471, 660045536),
         a.b("\ueb73鋡ᠳ虋ඞ謸ㄹ뢋⛟걧⮡톈当욯䳴쨒灈ﾛ攩\ue33c檙ჟ鹹ֽ菆ं낶㺸ꑃ≑ꧮ圠\udd66䓎싒䡢\uf7fb緉ﬕ抡\ue8f4阍", -1138758891),
         kfa.MISC
      );
      lrf = this;
      this.lrh.visibleWhen(this.lrg::get);

      try {
         ClientPlayConnectionEvents.JOIN.register((Join)(var0, var1, var2x) -> var2x.execute(() -> {
            if (lrw() && lrf.lri.get() && var2x.field_1705 != null) {
               var2x.field_1705.method_1743().method_1817();
            }
         }));
      } catch (Throwable var2) {
         System.out.println(a.c(-1023039319, "ꣾ텊実엩买좄狄ﬦ敲\uefd9桞鉺Ჶ蔈ཌ親㏭밹⚇ꃕ⤬却\udd8e䙓쁧䪸\uf31e絋\ue7e8懺\uea42ᒚ黀ݥ腥\u0bcf됟㹶뢡⅃ꭓ햣徾\ud85b䊐쳬畺ﾅ私\ue20d汲雷Ἅ饔α跠㙍낚㫫ꍥⷈ") + var2);
      }
   }

   private static boolean lrw() {
      return lrf != null && lrf.isEnabled();
   }

   @Override
   public boolean ticksWhenOff() {
      return true;
   }

   @Override
   public void onEndTick(MinecraftClient var1) {
      if (!lrp && var1.field_1705 != null && var1.field_1705.method_1743() != lrq) {
         lrx(var1.field_1705.method_1743());
      }
   }

   private static void lrx(ChatHud var0) {
      try {
         if (lrm == null) {
            for (Field var4 : ChatHud.class.getDeclaredFields()) {
               if (!Modifier.isStatic(var4.getModifiers())) {
                  if (var4.getType() == int.class && lro == null) {
                     var4.setAccessible(true);
                     lro = var4;
                  }

                  if (var4.getType() == List.class && var4.getGenericType() instanceof ParameterizedType var6 && var6.getActualTypeArguments().length == 1) {
                     Type var7 = var6.getActualTypeArguments()[0];
                     if (var7 == ChatHudLine.class) {
                        var4.setAccessible(true);
                        lrm = var4;
                     } else if (var7 == Visible.class) {
                        var4.setAccessible(true);
                        lrn = var4;
                     }
                  }
               }
            }

            if (lrm == null || lrn == null) {
               throw new IllegalStateException(a.b("굤퓞帄쁠䯣촞睈ﺣ惻\uea4d淍韲ᤤ肎ઉ谾㙸릳⌛ꕀ", -1383486189));
            }
         }

         List var9 = (List)lrm.get(var0);
         List var10 = (List)lrn.get(var0);
         if (!(var9 instanceof lqy)) {
            lrm.set(var0, new lqy(var9, var0));
         }

         if (!(var10 instanceof lqu)) {
            lrn.set(var0, new lqu(var10));
         }

         lrq = var0;
      } catch (Throwable var8) {
         lrp = true;
         System.out.println(a.c(2026985386, "埐\u2e6a꒰㫔녗㞲跢Ё驚ს霪洈\ue38a稠\uf07c皚쳂䌛\ud9ad忱혅걚⋠륮㼋") + var8);
      }
   }

   private static int lry() {
      return lrw() && lrf.lrg.get() ? lrf.lrh.getInt() : 100;
   }

   private static void lrz(List<Visible> var0, ChatHudLine var1) {
      MinecraftClient var2 = MinecraftClient.method_1551();
      double var3 = (Double)var2.field_1690.method_42554().method_41753();
      int var5 = MathHelper.method_15357(ChatHud.method_1806((Double)var2.field_1690.method_42556().method_41753()) / var3);
      List var6 = var1.method_75757(var2.field_1772, var5);

      for (int var7 = 0; var7 < var6.size(); var7++) {
         var0.addFirst(new Visible(var1.comp_892(), (OrderedText)var6.get(var7), var1.comp_894(), var7 == var6.size() - 1));
      }
   }

   private static String lsa(List<Visible> var0, int var1) {
      StringBuilder var2 = new StringBuilder();

      for (int var3 = var1 - 1; var3 >= 0; var3--) {
         ((Visible)var0.get(var3)).comp_896().accept((var1x, var2x, var3x) -> {
            var2.appendCodePoint(var3x);
            return true;
         });
      }

      return lsb(var2.toString());
   }

   private static String lsb(String var0) {
      return var0.replaceAll(a.d("\uda83ꎻ⤺띫㲓멺", 2018923283, 1440778545), "");
   }

   private static int lsc(List<Visible> var0, int var1) {
      if (var1 < var0.size() && ((Visible)var0.get(var1)).comp_898()) {
         int var2 = 1;

         while (var1 + var2 < var0.size() && !((Visible)var0.get(var1 + var2)).comp_898()) {
            var2++;
         }

         return var2;
      } else {
         return -1;
      }
   }

   public static void attach(Screen var0) {
      if (var0 instanceof ChatScreen) {
         ScreenMouseEvents.allowMouseClick(var0)
            .register(
               (AllowMouseClick)(var0x, var1) -> {
                  if (var1.method_74245() == 0) {
                     return !wjw.click(lse(var1.comp_4798(), var1.comp_4799()));
                  } else if (var1.method_74245() == 1 && lrw() && lrf.lrk.get()) {
                     String var2 = lsf(var1.comp_4798(), var1.comp_4799());
                     if (var2 == null) {
                        return true;
                     } else {
                        MinecraftClient.method_1551().field_1774.method_1455(var2);
                        izx.alert(
                           lrf.getName(),
                           wap.s(a.d("ꁦ\ud9fb匷쵟䚄쀴", 629863611, 686970008), a.d("\ue9a6逌\u1adb蒫ཻ覲㎟멢\u243f꺃⥓", -2046083955, -360132351)),
                           vhz.CHECK,
                           true
                        );
                        return false;
                     }
                  } else {
                     return true;
                  }
               }
            );
      }
   }

   private static int lsd(List<Visible> var0, ChatHud var1, double var2, double var4) throws IllegalAccessException {
      MinecraftClient var6 = MinecraftClient.method_1551();
      int var7 = lro.getInt(var1);
      double var8 = (Double)var6.field_1690.method_42554().method_41753();
      double var10 = (Double)var6.field_1690.method_42546().method_41753();
      int var12 = (int)(9.0 * (var10 + 1.0));
      int var13 = MathHelper.method_15357((var6.method_22683().method_4502() - 40) / var8);
      double var14 = var2 / var8 - 4.0;
      double var16 = var4 / var8;
      int var18 = MathHelper.method_15384(ChatHud.method_1806((Double)var6.field_1690.method_42556().method_41753()) / var8);
      if (!(var14 < -4.0) && !(var14 > var18 + 8.0) && !(var16 > var13)) {
         int var19 = (int)Math.floor((var13 - var16) / var12);
         if (var19 >= 0 && var19 < var1.method_1813()) {
            int var20 = var19 + var7;
            return var20 < var0.size() ? var20 : -1;
         } else {
            return -1;
         }
      } else {
         return -1;
      }
   }

   private static Style lse(double var0, double var2) {
      MinecraftClient var4 = MinecraftClient.method_1551();
      if (lrn != null && lro != null) {
         try {
            ChatHud var5 = var4.field_1705.method_1743();
            List var6 = (List)lrn.get(var5);
            int var7 = lsd(var6, var5, var0, var2);
            double var8 = var0 / (Double)var4.field_1690.method_42554().method_41753() - 4.0;
            if (var7 >= 0 && !(var8 < 0.0)) {
               float[] var10 = new float[]{0.0F};
               Style[] var11 = new Style[]{null};
               ((Visible)var6.get(var7)).comp_896().accept((var5x, var6x, var7x) -> {
                  float var8x = var4.field_1772.method_30880(OrderedText.method_30741(var7x, var6x));
                  if (var8 < var10[0] + var8x) {
                     var11[0] = var6x;
                     return false;
                  } else {
                     var10[0] += var8x;
                     return true;
                  }
               });
               return var11[0];
            } else {
               return null;
            }
         } catch (Throwable var12) {
            return null;
         }
      } else {
         return null;
      }
   }

   private static String lsf(double var0, double var2) {
      MinecraftClient var4 = MinecraftClient.method_1551();
      ChatHud var5 = var4.field_1705.method_1743();
      if (lrn != null && lro != null) {
         try {
            List var6 = (List)lrn.get(var5);
            int var7 = lsd(var6, var5, var0, var2);
            if (var7 < 0) {
               return null;
            } else {
               int var8 = var7;

               while (var8 > 0 && !((Visible)var6.get(var8)).comp_898()) {
                  var8--;
               }

               int var9 = lsc(var6, var8);
               if (var9 <= 0) {
                  return null;
               } else {
                  StringBuilder var10 = new StringBuilder();

                  for (int var11 = var8 + var9 - 1; var11 >= var8; var11--) {
                     ((Visible)var6.get(var11)).comp_896().accept((var1, var2x, var3) -> {
                        var10.appendCodePoint(var3);
                        return true;
                     });
                  }

                  String var13 = var10.toString().trim();
                  return var13.isEmpty() ? null : var13;
               }
            }
         } catch (Throwable var12) {
            return null;
         }
      } else {
         return null;
      }
   }
}
