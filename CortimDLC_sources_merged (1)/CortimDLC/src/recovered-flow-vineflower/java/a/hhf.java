package a;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.SkinTextures;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.Vec3d;

public final class hhf {
   public static final vkl PROTECT = new vkl(a.d("̥窶\uf078渒\ue5d4捣\ud927傂캛䐾쏶㦋띗⻬꒨", 1895487715, -1268130919), true);
   public static final List<vmo> OPTIONS = List.of(PROTECT);
   public static final vkl CLICK = new vkl(a.b("\ued12钌Ṛ耡\u0bfe贄㜑뻴₰ꨍⷕ\ud7ae", 316468573), true);
   public static final vmc CLICK_RANGE = new vmc(a.d("ഞ璀﹖怭\uebf2洈휉廫삻䨃췒", 1756299799, 7343937), 8.0, 3.0, 160.0, 1.0)
      .suffix(a.d("\u1a9c挣\ue9f3瞎ﱑ竸", 1401237017, 409548001));
   public static final List<vmo> CLICK_OPTIONS = List.of(CLICK_RANGE);
   public static final List<vmo> ALL = List.of(PROTECT, CLICK, CLICK_RANGE);
   public static final int MAX_NAME = 20;
   private static final double hhg = 0.3;
   private static final Gson hhh = new GsonBuilder().setPrettyPrinting().create();
   private static final List<hhc> hhi = new ArrayList<>();
   private static final Set<String> hhj = new HashSet<>();
   private static boolean hhk;
   private static int hhl;

   private hhf() {
   }

   public static int version() {
      return hhl;
   }

   public static List<hhc> all() {
      hhq();
      return Collections.unmodifiableList(hhi);
   }

   public static boolean isFriend(String var0) {
      hhq();
      return var0 != null && hhj.contains(hho(var0));
   }

   public static boolean isFriend(Entity var0) {
      return var0 instanceof PlayerEntity var1 && isFriend(nameOf(var1));
   }

   public static boolean protects(Entity var0) {
      return PROTECT.get() && isFriend(var0);
   }

   public static boolean add(String var0) {
      hhq();
      String var1 = clean(var0);
      if (var1 != null && !hhj.contains(hho(var1))) {
         hhi.add(new hhc(var1));
         hhj.add(hho(var1));
         hhp();
         return true;
      } else {
         return false;
      }
   }

   public static boolean remove(String var0) {
      hhq();
      if (var0 != null && hhj.remove(hho(var0))) {
         hhi.removeIf(var1 -> hho(var1.name).equals(hho(var0)));
         hhp();
         return true;
      } else {
         return false;
      }
   }

   public static boolean toggle(String var0) {
      if (isFriend(var0)) {
         remove(var0);
         return false;
      } else {
         return add(var0);
      }
   }

   public static String nameOf(PlayerEntity var0) {
      return var0.method_5477().getString();
   }

   public static String clean(String var0) {
      if (var0 == null) {
         return null;
      } else {
         String var1 = var0.trim();
         return !var1.isEmpty() && var1.length() <= 20 && !var1.chars().anyMatch(var0x -> var0x <= 32 || var0x == 167) ? var1 : null;
      }
   }

   private static String hho(String var0) {
      return var0.toLowerCase(Locale.ROOT);
   }

   public static PlayerEntity aimed(MinecraftClient var0, double var1) {
      Entity var3 = var0.method_1560();
      if (var3 != null && var0.field_1687 != null && var0.field_1724 != null) {
         if (var0.field_1692 instanceof PlayerEntity var4 && var4 != var0.field_1724) {
            return var4;
         } else {
            Vec3d var18 = var3.method_5836(1.0F);
            Vec3d var19 = var3.method_5828(1.0F);
            double var6 = var1;
            HitResult var8 = var3.method_5745(var1, 1.0F, false);
            if (var8 != null && var8.method_17783() != Type.field_1333) {
               var6 = var8.method_17784().method_1022(var18);
            }

            Vec3d var9 = var18.method_1019(var19.method_1021(var6));
            PlayerEntity var10 = null;
            double var11 = Double.MAX_VALUE;

            for (PlayerEntity var14 : var0.field_1687.method_18456()) {
               if (var14 != var0.field_1724 && var14 != var3 && !var14.method_7325() && var14.method_5805()) {
                  Optional var15 = var14.method_5829().method_1014(0.3).method_992(var18, var9);
                  if (var15.isPresent()) {
                     double var16 = ((Vec3d)var15.get()).method_1025(var18);
                     if (var16 < var11) {
                        var11 = var16;
                        var10 = var14;
                     }
                  }
               }
            }

            return var10;
         }
      } else {
         return null;
      }
   }

   public static void toggleAimed() {
      if (CLICK.get()) {
         MinecraftClient var0 = MinecraftClient.method_1551();
         PlayerEntity var1 = aimed(var0, CLICK_RANGE.get());
         if (var1 != null) {
            String var2 = nameOf(var1);
            boolean var3 = toggle(var2);
            izx.alert(
               var2,
               var3 ? wap.s(a.b("宣∦꣮㚓뵏㯴", -983737373), a.b("홭꾈╘뭙", -1335307651)) : wap.s(a.b("ʖ笐\uf1cb澸\ue476拔\ud886", 1320420035), a.c(1252930131, "㙶俐씇孽타嘝")),
               vhz.FRIENDS,
               var3
            );
         }
      }
   }

   public static SkinTextures skinOf(String var0) {
      MinecraftClient var1 = MinecraftClient.method_1551();
      if (var1.field_1687 != null) {
         for (PlayerEntity var3 : var1.field_1687.method_18456()) {
            if (nameOf(var3).equalsIgnoreCase(var0) && var3 instanceof AbstractClientPlayerEntity var4) {
               return var4.method_52814();
            }
         }
      }

      PlayerListEntry var5 = listEntry(var0);
      return var5 != null ? var5.method_52810() : null;
   }

   public static PlayerListEntry listEntry(String var0) {
      ClientPlayNetworkHandler var1 = MinecraftClient.method_1551().method_1562();
      if (var1 != null && var0 != null) {
         try {
            return var1.method_73471(var0);
         } catch (RuntimeException var3) {
            return null;
         }
      } else {
         return null;
      }
   }

   public static PlayerEntity inWorld(String var0) {
      MinecraftClient var1 = MinecraftClient.method_1551();
      if (var1.field_1687 == null) {
         return null;
      } else {
         for (PlayerEntity var3 : var1.field_1687.method_18456()) {
            if (nameOf(var3).equalsIgnoreCase(var0)) {
               return var3;
            }
         }

         return null;
      }
   }

   private static void hhp() {
      hhl++;
      hhr();
   }

   private static void hhq() {
      if (!hhk) {
         hhk = true;
         String var0 = ewk.get(a.b("g秂\uf30a海\ue6ab怐\uda54", 705691654));
         if (var0 != null && !var0.isBlank()) {
            try {
               List var1 = (List)hhh.fromJson(var0, (new TypeToken<List<hhc>>() {}).getType());
               if (var1 != null) {
                  for (hhc var3 : var1) {
                     String var4 = var3 != null ? clean(var3.name) : null;
                     if (var4 != null && hhj.add(hho(var4))) {
                        var3.name = var4;
                        hhi.add(var3);
                     }
                  }
               }
            } catch (Exception var5) {
               System.out.println(a.c(272987972, "眳\u0e80葜ᩤ釠ᜅ괄ⓢ몹」랚䶭썮嫄킛噡\uec24揢落罓") + var5);
            }
         }
      }
   }

   private static void hhr() {
      ewk.put(a.d("嘉⾬ꕤ㬙냅㙾谺", -1945592374, -1723479134), hhh.toJson(hhi));
   }
}
