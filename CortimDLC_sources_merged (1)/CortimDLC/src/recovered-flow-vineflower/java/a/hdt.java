package a;

import com.mojang.authlib.GameProfile;
import flow.dev.a;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.Entity.RemovalReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;

final class hdt {
   private static final List<Entity> hdu = new ArrayList<>();
   private static Team hdv;

   private hdt() {
   }

   static boolean tick(MinecraftClient var0, int var1) {
      rjy var2 = rjy.get();
      hdy(var0);
      switch (var1) {
         case 1:
            var2.setEnabled(true);
            var2.background.set(a.d("秀M誝ᓩ鼳", 2138941933, 1150865531));
            var2.items.set(a.b("ᆿ栭\ue2f3粛\uf75f", 1484198395));
            var2.health.set(a.b("麄\ue704淊\uf3b7", 1930862292));
            var2.size.set(2.0);
            var2.shrink.set(0.0);
            PlayerEntity var5 = hdz(var0, a.c(-1339486958, "ൻ瓝︙恿\uebbd洎흌庣샾䩂춆㟱"), 4.0, 0.9);
            hdz(var0, a.c(1551262735, "摏ᷕ霍ॴ芷"), 4.6, -1.4);
            Scoreboard var6 = var0.field_1687.method_8428();
            hdv = var6.method_1171(a.b("䥃ヸ먨⑁꿓⤤鍢᪕", 522340653));
            hdv.method_1139(Text.method_43470(a.d("Ɽ喲\udf54䄾쫭", 2005490548, 412448565)).method_27692(Formatting.field_1060));
            var6.method_1172(var5.method_7334().name(), hdv);
            hhf.add(a.d("鋼\ueb5a憞\ufff8琺\uf289䣋설役헅刁꡶", 881614664, 9686493));
            break;
         case 30:
            hea(var0, a.c(-1480700372, "之㟯봺⌁ꢝ⸸鑰ᶍ菙ॢ軸瓗靖掮\ue9f8漄픂媆쁿"));
            break;
         case 31:
            var2.background.set(a.d("\ufbca艐ࢎ雭ᴺ", 1540755239, -200739665));
            break;
         case 45:
            hea(var0, a.b("\ueef7靓ᶆ莽ࠡ躄㓌봱⍥꧞⹄푿媣쌟䥞쾯疾墨惃", -1662587248));
            break;
         case 46:
            var2.background.set(a.c(757350136, "㺲䜦췭厘\ud853廯"));
            break;
         case 60:
            hea(var0, a.b("\uddc7ꑣ⺶낍㬑붴\u07fc踁ၕ髮ᵴ\ue744榖\uf03f穨ﲅ䛇쥟厹햢", 1853283751));
            break;
         case 61:
            var2.background.set(a.c(-1613307956, "\udf86ꘖⳄ늾"));
            break;
         case 75:
            hea(var0, a.b("䝥㻁됔⨯ꆳ✖鵞ᒣ諷L蟖緤\uf332檂\ue0da晣\udc79叢", 1471366915));
            break;
         case 76:
            var2.background.set(a.c(2057023957, "놃젎䋞\udcaa坰"));
            var2.items.set(a.d("ո糮\uf63f桋\ue39b攡", -2061395244, 1738186723));
            var2.size.set(1.0);
            break;
         case 90:
            hea(var0, a.d("嵐⓴긡〚뮆㴣蝫ຖ郂᩹鷣柌\ue907炵\ufae3簟옙䦝퍧", 650538331, 1302605932));
            break;
         case 91:
            for (Entity var4 : hdu) {
               var0.field_1687.method_2945(var4.method_5628(), RemovalReason.field_26999);
            }

            hdu.clear();
            var0.field_1687.method_8428().method_1191(hdv);
            hhf.remove(a.d("琍ණ蝯ᤉ鋋ᑸ긺⟕릈㌴듰亇", -686412065, -1281074501));
            var2.background.set(a.b("㈜䮑셁張퓯", -1401474486));
            var2.items.set(a.c(-725481712, "ݟ绉\uf418橬\ue1bc朆"));
            var2.size.set(1.0);
            var2.shrink.set(0.7);
            hyz.save();
            return true;
      }

      return false;
   }

   private static void hdy(MinecraftClient var0) {
      var0.field_1724.method_36456(0.0F);
      var0.field_1724.method_36457(-4.0F);
      var0.field_1724.field_5982 = 0.0F;
      var0.field_1724.field_6004 = -4.0F;
   }

   private static PlayerEntity hdz(MinecraftClient var0, String var1, double var2, double var4) {
      OtherClientPlayerEntity var6 = new OtherClientPlayerEntity(var0.field_1687, new GameProfile(UUID.randomUUID(), var1));
      Vec3d var7 = var0.field_1724
         .method_73189()
         .method_1019(new Vec3d(0.0, 0.0, 1.0).method_1021(var2))
         .method_1019(new Vec3d(-1.0, 0.0, 0.0).method_1021(var4));
      var6.method_5808(var7.field_1352, var0.field_1724.method_23318(), var7.field_1350, 180.0F, 0.0F);
      var6.method_5636(180.0F);
      var6.method_5847(180.0F);
      var6.field_6220 = 180.0F;
      var6.field_6259 = 180.0F;
      var6.method_5673(EquipmentSlot.field_6169, new ItemStack(Items.field_22027));
      var6.method_5673(EquipmentSlot.field_6174, new ItemStack(Items.field_22028));
      var6.method_5673(EquipmentSlot.field_6172, new ItemStack(Items.field_22029));
      var6.method_5673(EquipmentSlot.field_6166, new ItemStack(Items.field_22030));
      var6.method_5673(EquipmentSlot.field_6173, new ItemStack(Items.field_22022));
      var6.method_5673(EquipmentSlot.field_6171, new ItemStack(Items.field_8367, 64));
      var6.method_6033(15.0F);
      var0.field_1687.method_53875(var6);
      hdu.add(var6);
      return var6;
   }

   private static void hea(MinecraftClient var0, String var1) {
      System.out
         .println(a.d("\uf6e8轏֕鯮ၿ隚Ⳙꔿ㭧놂", 461015729, -2098299872) + var1 + a.b("떽챬䛟", 1227863454) + var0.method_47599() + a.c(-514856328, "\uea5c鎫\u196e蜜"));
      ScreenshotRecorder.method_22690(
         var0.field_1697,
         a.b("튩ꬒ⇂뾫㐹늗", -1494756663) + var1 + a.b("⒕嵺ힷ䧏", 704324799),
         var0.method_1522(),
         1,
         var0x -> System.out.println("" + var0x.getString())
      );
   }
}
