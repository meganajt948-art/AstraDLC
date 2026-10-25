package a;

import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Item.TooltipContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

public final class pfd {
   static final String pfe = a.c(-235674391, "\ue0ab饩Ꮂ跎");
   static final String pff = a.b("\uda38ꎁⵇ뜦㳻먲`觢ា鴉\u1ad2", 1628560910);
   static final String pfg = a.d("䁪㧞덱ⴏꚢ⑸騼Ꮚ趔ݔ胷竴\uf42d", 2081749670, -116146554);
   static final Pattern pfh = Pattern.compile(a.c(1902488767, "겚핟徴쇺䨪첣盈６愔\ueba7氅阃ᣗ"));

   pfd() {
   }

   public static int of(ItemStack var0) {
      long var1 = pfk(var0);
      return var1 > 0L ? (int)Math.min(2147483647L, var1 / Math.max(1, var0.getCount())) : -1;
   }

   public static int total(ItemStack var0) {
      long var1 = pfk(var0);
      return var1 > 0L ? (int)Math.min(2147483647L, var1) : -1;
   }

   static long pfk(ItemStack var0) {
      if (!var0.isEmpty() && !var0.isOf(Items.GRAY_DYE)) {
         List var1 = lines(var0);

         for (int var2 = 0; var2 < var1.size(); var2++) {
            String var3 = (String)var1.get(var2);
            if (var2 == 0) {
               if (var3.contains(a.b("푘귡⌧륆㊛둒\u0e00螂᧖鍩ᒲ", -688467858))) {
                  return -1L;
               }
            } else {
               int var4 = var3.indexOf(a.d("주넾㯥ꖙ", -530983088, 47848430));
               if (var4 >= 0) {
                  Matcher var5 = pfh.matcher(var3.substring(var4 + a.d("\udf0cꛎⰕ뉩", -1458059680, -1503781586).length()));
                  long var6 = -1L;

                  while (var5.find()) {
                     String var8 = var5.group(1).replaceAll(a.d("섾뢊㈷걛➘ꅍ", 376427464, 237638315), "");
                     if (!var8.isEmpty() && var8.length() <= 12) {
                        var6 = Math.max(var6, Long.parseLong(var8));
                     }
                  }

                  if (var6 > 0L) {
                     return var6;
                  }
               }
            }
         }

         return -1L;
      } else {
         return -1L;
      }
   }

   public static boolean claimed(ItemStack var0) {
      for (String var2 : lines(var0)) {
         if (var2.contains(a.b("悬ᤘ鎷\u0dc9虤Ҿ뫺㌌굒➒ꀱ娲퓫", -745970458))) {
            return true;
         }
      }

      return false;
   }

   static List<Text> tooltip(ItemStack var0) {
      MinecraftClient var1 = MinecraftClient.getInstance();
      return var0.getTooltip(TooltipContext.DEFAULT, var1.player, TooltipType.BASIC);
   }

   public static List<String> lines(ItemStack var0) {
      List<Text> var1 = tooltip(var0);
      ArrayList<String> var2 = new ArrayList<>(var1.size());

      for (Text var4 : var1) {
         var2.add(pfl.title(var4.getString()));
      }

      return var2;
   }
}
