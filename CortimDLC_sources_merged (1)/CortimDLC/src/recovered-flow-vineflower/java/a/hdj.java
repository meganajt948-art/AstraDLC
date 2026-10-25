package a;

import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.a;
import java.util.UUID;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.Entity.RemovalReason;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;

final class hdj {
   private static final String[] hdk = new String[]{
      a.b("懇ᡈ銙೨蜤Ɖ", 1309303186),
      a.d("畩\u0cff蘹ᡝ鎗ᔬ", -1636847984, -1280910420),
      a.b("闬\uec76暽\uf8d5", 1901172140),
      a.c(1216785013, "ꨡ펯奸윇"),
      a.c(314991719, "搼ᶻ靡च苩ѻ븪㟓"),
      a.d("ﾴ蘦ೱ銒\u1942", 607229871, 1605593176),
      a.b("\uf8be脴ொ閘ṍ飴", -663553812),
      a.c(1683305060, "㈣䮼셬弑퓎"),
      a.b("㢯䄴쯾喔\ude4f壵", 79247592),
      a.b("ǐ硑\uf295泠\ue73d", -1825242729),
      a.d("䠛㆛뭇┼껪⡌", 138220016, -1947051587),
      a.d("ﻊ蝄ක鏤ᠩ", -1017444188, 1637086776)
   };
   private static Entity hdl;

   private hdj() {
   }

   static boolean tick(MinecraftClient var0, int var1) {
      kfx var2 = Flow.getInstance().getModuleManager();
      if (var1 == 1) {
         hdr(var0, a.d("催⤛ꏄ㶽뙢パ誉\u0379鵣ទ道樵\ue4e6終\uf70c燢쮾", 819305885, -668938937));
         hdr(var0, a.d("헃걯⚸룁㍓떱\u0ff4蘔\u181f銸ᕭ\uef1c懋", -716155402, 261390412));
         hdr(var0, a.c(-632811462, "၀槣\ue334結\uf69b瀧쩣䏀\udddc坢킸⫍ꐉ"));
         izx.TARGET.enabled.set(false);
      }

      if (var1 == 6) {
         hdq(var0, 0.0F, 6.0F);
         hdl = hdo(var0, a.b("㬧䊹졭嘀\uddd0", -838714523), 3.0);
         var2.getByName(a.d("詳\uf3f9礭\ue744沭\uea3b偰\ud99e䟛쵰䪨냗㸉", 516418130, -1419485057)).setEnabled(true);
      }

      if (var1 == 16) {
         hds(var0, a.b("ጢ檗\ue05a縬\uf5f2猉줞䃨\udeaf吁폈⦣ꝿ㻀뒚㈣蠠ߢ鵎ᬝ鋰\ue8a6", -358083769));
      }

      if (var1 == 18) {
         var2.getByName(a.c(1960988967, "兹⣳ꈧ㱎랧ㄱ譺ʔ鳑ᙺ醢毝\ue503")).setEnabled(false);
         var0.world.removeEntity(hdl.getId(), RemovalReason.DISCARDED);
         var0.player.getInventory().setSelectedSlot(0);
         var0.player.getInventory().setStack(0, new ItemStack(Items.DIAMOND_SWORD));
         var2.getByName(a.c(1310351504, "惌ᥙ鎔\u0de2蘼«뫗㌡굺⟇ꀁ婭풼䴌읂")).setEnabled(true);
      }

      if (var1 == 22) {
         hds(var0, a.c(1647135115, "䧲ぇ몊⓼꼢⧙鏕ᨳ葺໌"));
      }

      for (int var3 = 0; var3 < hdk.length; var3++) {
         int var4 = 26 + var3 * 14;
         if (var1 == var4) {
            ((vlv)hdp(var2.getByName(a.b("᪺振\ue9e2瞔ﱊ竝삡䥗휌嶱\uda77‛껊㝺봴", 1090919142)), a.d("파ꪟ⁇븷", 1042341301, 2102464240))).set(hdk[var3]);
         } else if (var1 == var4 + 2) {
            var0.player.swingHand(Hand.MAIN_HAND);
         } else if (var1 == var4 + 5) {
            hds(var0, a.d("\ue437鶂ᝏ褹˧萜", -328261857, -1850606755) + hdk[var3].toLowerCase());
         }
      }

      int var5 = 26 + hdk.length * 14 + 30;
      if (var1 == var5 - 28) {
         var0.player.getInventory().setStack(0, new ItemStack(Items.MACE));
      }

      if (var1 == var5 - 2) {
         hds(var0, a.c(1319480217, "ꯥ퉐墝웫䴵쯎燝\uf820晽\uecca歑酿᾿蘘ౌ"));
      }

      if (var1 == var5) {
         hdr(var0, a.d("잗븠㓿ꪆ⅙\ua7eaᶲ鑂\u0a58肺ݯﴙ珊\uea64怨\ue6ce岌", 1873316609, -510112544));
         hdr(var0, a.d("\ue918邪᩹萋࿚襼㍻뫍⒜긲⧲폆嵱쓳仳졏爄\ufdd2杪\ue13d棛ኙ鰭߮臟\u0b46닢㲥Ꙉ ꮷ啳\udf33䛏삚䩮\uf5aa翘亂悻\ueae5鐄ḃ馴ͤ贅", 1941496049, -1330706014));
         hdr(var0, a.b("쥶냃㩀ꑑ⾵\ua957ፚ髵Ӵ踊ড়\uf3b9細", 2079639823));
      }

      if (var1 == var5 + 22) {
         hds(var0, a.b("榳ဆ髋ҽ轣ঘ뎋㩶ꐫ⺜꤇匸\udde4䑜츜䣸\uf2b5", -579900975));
      }

      if (var1 == var5 + 60) {
         hdr(var0, a.b("ڴ缃\uf5dc殥\ue07a曉\udc91啡쭻䆉왋㰭닾⭚ꄔ⟺鶦", -1445853502));
         var2.getByName(a.b("뗻챮䚣\ud8d5匋햜濠\ue616硍\uf2f0甶轚Ƌ頻ት", -1569868377)).setEnabled(false);
         System.out.println(a.b("琫ඞ蝓ᤥ鋻ᐍ긊⟪릣㌕뒒产쁻始펓", 53113943));
         return true;
      } else {
         return false;
      }
   }

   private static Entity hdo(MinecraftClient var0, String var1, double var2) {
      OtherClientPlayerEntity var4 = new OtherClientPlayerEntity(var0.world, new GameProfile(UUID.randomUUID(), var1));
      Vec3d var5 = var0.player.getEntityPos().add(0.0, 0.0, var2);
      var4.refreshPositionAndAngles(var5.x, var0.player.getY(), var5.z, 180.0F, 0.0F);
      var4.setBodyYaw(180.0F);
      var4.setHeadYaw(180.0F);
      var4.lastBodyYaw = 180.0F;
      var4.lastHeadYaw = 180.0F;
      var4.equipStack(EquipmentSlot.HEAD, new ItemStack(Items.DIAMOND_HELMET));
      var4.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
      var4.equipStack(EquipmentSlot.LEGS, new ItemStack(Items.DIAMOND_LEGGINGS));
      var4.equipStack(EquipmentSlot.FEET, new ItemStack(Items.DIAMOND_BOOTS));
      var4.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.NETHERITE_SWORD));
      var4.setInvisible(true);
      var0.world.addEntity(var4);
      return var4;
   }

   private static vmo hdp(kfe var0, String var1) {
      for (vmo var3 : var0.getSettings()) {
         if (var3.getName().equals(var1)) {
            return var3;
         }
      }

      throw new IllegalStateException(var0.getName() + a.d("짜뀥㫿꒜⼘ꧧᎵ騋", 1095687915, -1256384737) + var1);
   }

   private static void hdq(MinecraftClient var0, float var1, float var2) {
      var0.player.setYaw(var1);
      var0.player.setPitch(var2);
      var0.player.lastYaw = var1;
      var0.player.lastPitch = var2;
   }

   private static void hdr(MinecraftClient var0, String var1) {
      var0.getNetworkHandler().sendChatCommand(var1);
   }

   private static void hds(MinecraftClient var0, String var1) {
      System.out.println(a.c(-136605166, "鉫\uebcc愖ｭ瓼\uf219䡛솼忤픁") + var1);
      ScreenshotRecorder.saveScreenshot(
         var0.runDirectory,
         a.c(954352280, "䋸㭃놓⿺ꑨ⋆") + var1 + a.d("冚⡵ꊸ㳀", -1991321152, -537884560),
         var0.getFramebuffer(),
         1,
         var0x -> System.out.println("" + var0x.getString())
      );
   }
}
