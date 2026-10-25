package a;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import flow.Flow;
import flow.dev.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;

final class fbk {
   private static final String fbl = a.c(1293647272, "紕е躋㚤鬫ᷧꜳ⸀되㺻륣䌑춿味\ude2c壐\ue682浩\uf780燒\uf82e舏ೆ靠ᄑ鮴");
   private static final String fbm = a.b("묉쉹䳛튃契\udfe5旊\uec47爓ﲷ缋蔄\u0bd9鉭ᠺ黏", -108610626);
   private static final List<String> fbn = Collections.synchronizedList(new ArrayList<>());
   private static final List<String> fbo = Collections.synchronizedList(new ArrayList<>());
   private static int fbp;

   private fbk() {
   }

   static boolean tick(MinecraftClient var0, int var1) {
      if (var1 == 1) {
         var0.field_1690.field_1837 = false;
         var0.method_1562().method_45730(a.b("ﲊ蔽\u0fe2醛ᩄ鳷⚯꽟ㅅ뮧㱲옄䣗텹嬵\uddd3枑", -554631940));
         fbs(var0);
      }

      kfe var2 = Flow.getInstance().getModuleManager().getByName(a.b("\ud83fꆺ⭨딂㻩롮ȴ诅", -2064459658));
      if (var1 == 40) {
         for (vmo var4 : var2.getSettings()) {
            if (var4 instanceof vkl var5 && var4.getName().equals(a.b("⓬嵲펶䦦쉳䒼ﻦ睠\ue946揳\ue42c", 775954687))) {
               var5.set(false);
            }
         }

         var2.setEnabled(true);
         fbp = var1;
      }

      if (fbp > 0 && var1 > fbp + 5 && (!var2.isEnabled() || var1 > fbp + 1800)) {
         System.out.println(a.d("\uf58d谨ۭ食\u135c闼⾹ꙏ㡄늦㕣켖䇒\ud872刪퓖溏\ue117箾", -595449031, -1344282938) + fbn);
         System.out.println(a.d("唧Ⲃꙇ㡵돶㕖輓ۥ飮ሌ闃澱\ue16e碁\uf2c8", 39237823, -1779372554) + fbo);
         boolean var6 = fbn.contains(a.b("呪ⶩꝱ㤃늭㑡踾߂鶀ጫ钂滰\ue02c秭\uf3c4畂켃䂦", 2112639034))
            && fbn.contains(a.c(-1258825930, "팏ꪷ\u2061븕㖾덳फ蓏ỿ鐰Ꮹ\ue99d李ﻻ"))
            && fbo.contains(a.c(-1245452352, "\ue7b8鸜ᓂ誶Ż蟔㶋둵⩤ꃌ✒\udd6e"))
            && fbo.contains(a.b("㭯䋏제噱\uddaf孊\ue11e棹\uf6bf簇ﯝ", -1794098427))
            && !var2.isEnabled();
         System.out
            .println(
               a.c(1585088383, "蜗ﺲ瑷\uea45懆\ue766崣퓕䫞")
                  + (var6 ? a.d("헁걡⚠룑", 1462404644, 313086897) : a.d("鹂\ue7f4洯\uf35b", -390288334, -1233636814))
                  + a.b("⪳卋\ud99f䞠", -1104532841)
                  + (var1 - fbp) / 20.0
                  + a.c(-1005345528, "ꔪ\udcc8")
            );
         var2.setEnabled(false);
         return true;
      } else {
         return false;
      }
   }

   private static void fbs(MinecraftClient var0) {
      var0.method_1576()
         .execute(
            () -> {
               IntegratedServer var1 = var0.method_1576();
               CommandDispatcher var2 = var1.method_3734().method_9235();
               var2.register(
                  (LiteralArgumentBuilder)((LiteralArgumentBuilder)CommandManager.method_9247(a.b("塓⇫", -599762896))
                        .then(
                           CommandManager.method_9247(a.b("셼룛㈌걮➨ꄒ", 1640022281))
                              .then(CommandManager.method_9244(a.b("筈", 775387960), StringArgumentType.greedyString()).executes(var0xx -> {
                                 ServerPlayerEntity var1x = ((ServerCommandSource)var0xx.getSource()).method_9207();
                                 String var2x = StringArgumentType.getString(var0xx, a.c(-1230087837, "夓"));
                                 fbn.add(var2x);
                                 System.out.println(a.d("⯃剦\ud8a3䚑촒䮲\uf1f7码\ue610治\ueb29ᅑ鿎ج豩જ냀㼀ꖸ⎡", -263186052, 1980969674) + var2x);
                                 fbt(var1x, var2x);
                                 return 1;
                              }))
                        ))
                     .then(
                        CommandManager.method_9247(a.d("䷩㑎뺔⃥", -1277554645, -437756491))
                           .then(
                              CommandManager.method_9244(a.b("ꝥ\uded6吞쩥䆴", 1418241808), StringArgumentType.word())
                                 .executes(
                                    var0xx -> {
                                       ServerPlayerEntity var1x = ((ServerCommandSource)var0xx.getSource()).method_9207();
                                       String var2x = StringArgumentType.getString(var0xx, a.c(908919499, "ʾ笍\uf1c5澾\ue46f"));
                                       ItemStack var3x = var1x.method_6047();
                                       String var4 = var3x.method_31574(Items.field_8288)
                                          ? a.d("\ue863采ᬙ蕭ຠ蠏㉐뮮", -1488463553, 361509152)
                                          : (
                                             var3x.method_31574(Items.field_8463)
                                                ? a.c(266803768, "ᩜ揼\ue92f睂ﲜ") + var3x.method_7947()
                                                : var3x.method_7909().toString()
                                          );
                                       fbo.add(var4 + a.d("衍", -1273448989, -1686684273) + var2x);
                                       System.out
                                          .println(
                                             a.d("\uab6c틉堌옾䶽쬝煘\uf8ae暿\uec14殆釾ὡ蚃ೆ訾ぱ뿬", 1111554602, 1712607541)
                                                + var2x
                                                + a.b("ꋺ\udb43", -352214312)
                                                + var4
                                                + a.d("涴", 703127057, 639021965)
                                          );
                                       var1x.method_6122(Hand.field_5808, ItemStack.field_8037);
                                       var1x.method_64398(
                                          Text.method_43470(a.c(-473268833, "紑Ѧ諆ᓮ魒ᦀꏑ⩞됋㻇륡䌓짚呹\ude53墨\ue2e4浇\uf7f6熭\uf859舋ࢠ靮ᅮ鯊≸갡㛟냹㼨엤侦퉇個\udac5敬\uef17槀\uf077穝"))
                                       );
                                       return 1;
                                    }
                                 )
                           )
                     )
               );
               ServerPlayerEntity var3 = var1.method_3760().method_14566(var0.field_1724.method_5477().getString());
               var3.method_31548().method_5448();
               var3.method_31548().method_5447(9, fbv(Items.field_8288, a.b("䫄㏤륚ŵ곺⨶郢᧑菉४躲瓀\ufa6e探\ue9fd漁텓媸쁑䘃쿿뗞㬗ꂱ⛀걥", 958810745), 1));
               var3.method_31548().method_5447(14, fbv(Items.field_8463, a.c(-2114917427, "\ueb7a鈊Შ苰ढ辖㖹밴≠계⽸핷宪숞䡉캼"), 16));
               var1.method_3760().method_14576(var3);
            }
         );
   }

   private static void fbt(ServerPlayerEntity var0, String var1) {
      ArrayList var2 = new ArrayList();
      if (var1.contains(a.d("࿊瘉ﳑ抣\ue90d濁햞屢", -834313699, -515282531))) {
         for (int var6 : new int[]{5000, 1200, 1000, 1300}) {
            var2.add(fbu(Items.field_8288, a.c(729864317, "\ud8c0ꇠ⭞鍱㻾렲˦试ᇍ魮Ჶ\ue6c4桪\uf1a6篹ﴅ䍗좼剕퐇巻⟚ꤓ㊵듄㹡"), 1, var6));
         }
      } else if (var1.contains(a.d("燅ࠊ苓Ყ靴ᇁ", 1834586556, 166192176))) {
         var2.add(fbu(Items.field_8463, a.b("婆⌶궔㏌렞㺪蒅ഈ鍜᷸鹄摋\uea96猢掠羀", 992697073), 16, 800));
         var2.add(fbu(Items.field_8463, a.c(-1902286666, "栁ᅱ鿓Ƌ詙೭뛂㽏ꄛ⾿갃嘌\ud8d1䅥쬲䷇"), 8, 480));
         var2.add(fbu(Items.field_8463, a.d("鐘\ued68揊ﶒ癀\uf0f4䫛썖崂펦倚ꨕⓈ뵼㜫뇞", -532862386, 1129430753), 16, 1120));
      }

      var0.method_51469().method_8503().execute(() -> var0.method_17355(new SimpleNamedScreenHandlerFactory((var1xx, var2xx, var3) -> {
         SimpleInventory var4 = new SimpleInventory(54);

         for (int var5 = 0; var5 < var2.size(); var5++) {
            var4.method_5447(var5, (ItemStack)var2.get(var5));
         }

         return new GenericContainerScreenHandler(ScreenHandlerType.field_17327, var1xx, var2xx, var4, 6) {
            public void method_7593(int var1, int var2x, SlotActionType var3x, PlayerEntity var4x) {
               this.method_7623();
               this.method_34252();
            }

            public ItemStack method_7601(PlayerEntity var1, int var2x) {
               return ItemStack.field_8037;
            }
         };
      }, Text.method_43470(a.b("놂졠䋊\udcc7坮퇙殉\ue20e砺\uf210畘", -77351527) + var1))));
   }

   private static ItemStack fbu(Item var0, String var1, int var2, int var3) {
      ItemStack var4 = fbv(var0, var1, var2);
      var4.method_57379(
         DataComponentTypes.field_49632,
         new LoreComponent(
            List.of(
               Text.method_43470(a.b("\ude9f", -1155014978)),
               Text.method_43470(a.c(-1051773491, "㕦䱆욇売휣嗑\uebda晷\uf873狘\uf58c༿") + String.format(a.d("ﴏ蒷ฬ", 894465, -235840728), var3).replace(',', ' ')),
               Text.method_43470(a.c(405001453, "푘굹⎂붬㘅낾૩茚ᵂ鞀ᐯ\uee44惠不猽\uf5cc侊쁌"))
            )
         )
      );
      return var4;
   }

   private static ItemStack fbv(Item var0, String var1, int var2) {
      ItemStack var3 = new ItemStack(var0, var2);
      var3.method_57379(DataComponentTypes.field_49631, Text.method_43470(var1));
      return var3;
   }
}
