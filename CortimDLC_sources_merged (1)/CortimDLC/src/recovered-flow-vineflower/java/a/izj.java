package a;

import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public final class izj extends jeq<izb> {
   private static Method izk;
   private static Method izl;
   private static final float izm = 15.0F;
   private static final float izn = 10.0F;
   private static final float izo = 64.0F;
   private static Field izp;
   private static Field izq;
   private static boolean izr;

   izj() {
      super(a.b("\ue513鲮ᙽ蠏ϐ蕪㼡뛉⢋", 1568466297), a.b("㚸伥엶宄큛囡\uecaa敂ﬀ", -783141134), vhz.CLOCK, true, 2, 2, 6.0F, 6.0F);
   }

   @Override
   List<izb> items(boolean var1) {
      ArrayList var2 = new ArrayList();
      MinecraftClient var3 = MinecraftClient.getInstance();
      ClientPlayerEntity var4 = var3.player;
      if (var4 != null) {
         try {
            izv(var4, var3.getRenderTickCounter().getTickProgress(true), var2);
         } catch (Throwable var6) {
            if (!izr) {
               izr = true;
               System.out.println(a.c(-2066021231, "ӥ絘\uf78b槹\ue226撜\uded7圿쥽䎟쐙㹳낫⤍ꍉ▰鿺ဦ誖\u0cc9蔷Ｙ熐") + var6);
            }
         }
      }

      if (var2.isEmpty() && var1) {
         var2.add(izu(Items.ENDER_PEARL, 0.8F, 0.8F));
         var2.add(izu(Items.WIND_CHARGE, 0.3F, 0.6F));
      }

      var2.sort(Comparator.comparing(var0 -> -var0.izf));
      return var2;
   }

   private static izb izu(Item var0, float var1, float var2) {
      ItemStack var3 = new ItemStack(var0);
      return new izb(
         a.b("䵕㓦븢⁀ꮈⴵ靴Ỉ", -1985000147) + Registries.ITEM.getId(var0),
         var3,
         shortName(var3, Registries.ITEM.getId(var0)),
         System.nanoTime() + (long)(var1 * 1.0E9F),
         var1 / var2
      );
   }

   private static void izv(ClientPlayerEntity var0, float var1, List<izb> var2) throws Exception {
      if (!izr) {
         ItemCooldownManager var3 = var0.getItemCooldownManager();
         if (izp == null) {
            for (Field var7 : ItemCooldownManager.class.getDeclaredFields()) {
               if (!Modifier.isStatic(var7.getModifiers())) {
                  if (Map.class.isAssignableFrom(var7.getType())) {
                     izp = var7;
                  } else if (var7.getType() == int.class) {
                     izq = var7;
                  }
               }
            }

            if (izp == null || izq == null) {
               throw new IllegalStateException(a.c(768385889, "ꌛ\udaa6偵츇䗘썢礩\uf0c1滐\ue427揻馆\u1758軡ҥ與㠆럖\u2d7eꭻ⋊墒혻䷱쮄"));
            }

            izp.setAccessible(true);
            izq.setAccessible(true);
         }

         Map var17 = (Map)izp.get(var3);
         if (!var17.isEmpty()) {
            int var18 = izq.getInt(var3);
            PlayerInventory var19 = var0.getInventory();
            long var20 = System.nanoTime();

            for (Entry var10 : var17.entrySet()) {
               if (var10.getKey() instanceof Identifier var11 && var10.getValue() != null) {
                  if (izk == null) {
                     RecordComponent[] var21 = var10.getValue().getClass().getRecordComponents();
                     if (var21 == null || var21.length < 2) {
                        continue;
                     }

                     izk = var21[0].getAccessor();
                     izl = var21[1].getAccessor();
                     izk.setAccessible(true);
                     izl.setAccessible(true);
                  }

                  int var22 = (Integer)izk.invoke(var10.getValue());
                  int var13 = (Integer)izl.invoke(var10.getValue());
                  float var14 = Math.max(1, var13 - var22) / 20.0F;
                  float var15 = (var13 - (var18 + var1)) / 20.0F;
                  if (!(var15 <= 0.0F)) {
                     ItemStack var16 = izw(var3, var19, var11);
                     var2.add(new izb(var11.toString(), var16, shortName(var16, var11), var20 + (long)(var15 * 1.0E9F), var14));
                  }
               }
            }
         }
      }
   }

   static String shortName(ItemStack var0, Identifier var1) {
      Item var2 = var0.isEmpty() ? Registries.ITEM.get(var1) : var0.getItem();
      if (var2 == Items.ENCHANTED_GOLDEN_APPLE) {
         return wap.s(a.d("歎\u12d7頏غ趬ଌ녟㢲ꛤ", 375357988, 871426340), a.b("䏨㩎냭⻦ꔻ", 1677477834));
      }

      if (var2 == Items.GOLDEN_APPLE) {
         return wap.s(a.b("㡐䇇쬅啴\udebf堇", -1734789103), a.c(118144588, "멛쎴䤕흠"));
      }

      if (var2 == Items.ENDER_PEARL) {
         return wap.s(a.d("嚰⼴ꗣ㮁끈", -1087293075, 869560200), a.d("玸ਪ胰Ỻ锩Ꮸ", -905268007, -1331575951));
      }

      if (var2 == Items.CHORUS_FRUIT) {
         return wap.s(a.c(-1927313584, "蜕ﺏ瑛\uea37懧\ue750"), a.b("⒗崽힐䧢숷", -969858889));
      }

      if (var2 == Items.WIND_CHARGE) {
         return wap.s(a.d("흠껯\u243b멀㇓뜡൹蒁ᫍ適ី", -1413031756, -192082040), a.c(-1244043857, "憳ᠥ銆\u0cf8蝔ױ뮰㉆걮⛝ꅾ"));
      }

      if (var2 == Items.TOTEM_OF_UNDYING) {
         return wap.s(a.b("\u0bac爦\uf8ee暎\ued51", 1141443581), a.c(515004581, "岂┯꾀ㆆ멘"));
      }

      if (var2 == Items.EXPERIENCE_BOTTLE) {
         return wap.s(a.d("槱၈髫Ә輂ন돻㨒ꑄ", 1436287464, -483432376), a.d("\ue139飔ታ豾ޢ脂㬺뛑Ⲑ꘠ↇ\udbff啚", -335633187, 1051476470));
      }

      String var3 = var2 == Items.AIR ? var1.getPath().replace('_', ' ') : var2.getName().getString();
      return var3.isEmpty() ? var1.getPath() : var3;
   }

   private static ItemStack izw(ItemCooldownManager var0, PlayerInventory var1, Identifier var2) {
      for (int var3 = 0; var3 < var1.size(); var3++) {
         ItemStack var4 = var1.getStack(var3);
         if (!var4.isEmpty() && var2.equals(var0.getGroup(var4))) {
            return new ItemStack(var4.getItem());
         }
      }

      Item var5 = Registries.ITEM.get(var2);
      return var5 == Items.AIR ? ItemStack.EMPTY : new ItemStack(var5);
   }

   static String seconds(float var0) {
      return var0 >= 60.0F ? vxu.clock((int)var0) : vxu.fixed(var0, 1) + wap.unit(a.c(651202924, "鄞"));
   }

   String key(izb var1) {
      return var1.izc;
   }

   @Override
   float rowHeight() {
      return 15.0F;
   }

   float rowWidth(izb var1) {
      return 14.0F + Math.min(64.0F, izx.TEXT.width(var1.ize)) + 12.0F + izx.VALUE.width(a.d("ꔰ\udc81噌젣䎷", -1492954728, -1062538083));
   }

   void drawRow(DrawContext var1, izb var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = var4 + 6.0F;
      if (!var2.izd.isEmpty()) {
         float var10 = 0.625F * var7;
         uut.pushScissor(var1, var3 - 1.0F, var9 - 5.0F - 1.0F, 12.0F, 12.0F);
         var1.getMatrices().pushMatrix();
         var1.getMatrices().translate(var3 + 5.0F, var9);
         var1.getMatrices().scale(var10, var10);
         var1.drawItem(var2.izd, -8, -8);
         var1.getMatrices().popMatrix();
         uut.popScissor(var1);
      }

      float var13 = var3 + 10.0F + 4.0F;
      String var11 = seconds(var2.seconds());
      float var12 = izx.VALUE.width(var11);
      izx.TEXT.draw(var1, izx.TEXT.ellipsize(var2.ize, var5 - (var13 - var3) - var12 - 8.0F), var13, izx.TEXT.centerTop(var9), iov.text);
      izx.VALUE.drawRight(var1, var11, var3 + var5, izx.VALUE.centerTop(var9), iov.textDim);
      bar(var1, var13, var4 + var6 - 3.6F, var5 - (var13 - var3), var2.fraction(), iov.accent(), iov.accent2());
   }
}
