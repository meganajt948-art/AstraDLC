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
   static final List<Entity> hdu = new ArrayList<>();
   static Team hdv;

   hdt() {
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
            Scoreboard var6 = var0.world.getScoreboard();
            hdv = var6.addTeam(a.b("䥃ヸ먨⑁꿓⤤鍢᪕", 522340653));
            hdv.setSuffix(Text.literal(a.d("Ɽ喲\udf54䄾쫭", 2005490548, 412448565)).formatted(Formatting.GREEN));
            var6.addScoreHolderToTeam(var5.getGameProfile().name(), hdv);
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
               var0.world.removeEntity(var4.getId(), RemovalReason.DISCARDED);
            }

            hdu.clear();
            var0.world.getScoreboard().removeTeam(hdv);
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

   static void hdy(MinecraftClient var0) {
      var0.player.setYaw(0.0F);
      var0.player.setPitch(-4.0F);
      var0.player.lastYaw = 0.0F;
      var0.player.lastPitch = -4.0F;
   }

   static PlayerEntity hdz(MinecraftClient var0, String var1, double var2, double var4) {
      OtherClientPlayerEntity var6 = new OtherClientPlayerEntity(var0.world, new GameProfile(UUID.randomUUID(), var1));
      Vec3d var7 = var0.player.getEntityPos().add(new Vec3d(0.0, 0.0, 1.0).multiply(var2)).add(new Vec3d(-1.0, 0.0, 0.0).multiply(var4));
      var6.refreshPositionAndAngles(var7.x, var0.player.getY(), var7.z, 180.0F, 0.0F);
      var6.setBodyYaw(180.0F);
      var6.setHeadYaw(180.0F);
      var6.lastBodyYaw = 180.0F;
      var6.lastHeadYaw = 180.0F;
      var6.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.NETHERITE_HELMET));
      var6.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.NETHERITE_CHESTPLATE));
      var6.equipStack(EquipmentSlot.LEGS, new ItemStack(Items.NETHERITE_LEGGINGS));
      var6.equipStack(EquipmentSlot.FEET, new ItemStack(Items.NETHERITE_BOOTS));
      var6.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.NETHERITE_SWORD));
      var6.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Items.ENCHANTED_GOLDEN_APPLE, 64));
      var6.setHealth(15.0F);
      var0.world.addEntity(var6);
      hdu.add(var6);
      return var6;
   }

   static void hea(MinecraftClient var0, String var1) {
      System.out
         .println(a.d("\uf6e8轏֕鯮ၿ隚Ⳙꔿ㭧놂", 461015729, -2098299872) + var1 + a.b("떽챬䛟", 1227863454) + var0.getCurrentFps() + a.c(-514856328, "\uea5c鎫\u196e蜜"));
      ScreenshotRecorder.saveScreenshot(
         var0.runDirectory,
         a.b("튩ꬒ⇂뾫㐹늗", -1494756663) + var1 + a.b("⒕嵺ힷ䧏", 704324799),
         var0.getFramebuffer(),
         1,
         var0x -> System.out.println("" + var0x.getString())
      );
   }
}
