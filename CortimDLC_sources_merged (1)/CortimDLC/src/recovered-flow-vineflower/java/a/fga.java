package a;

import flow.Flow;
import flow.bot.BotScreen;
import flow.dev.a;
import java.lang.reflect.Field;
import java.util.Locale;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.FilledMapItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameMode;

final class fga {
   private static final String fgb = a.d("ꊋ\udb10净쾩䑋싗碟\uf12b", 89280975, 1072362250);
   private static int fgc;
   private static dtv fgd;
   private static int fge = -1;
   private static double fgf;
   private static int fgg;
   private static float fgh;
   private static float fgi;

   private fga() {
   }

   static boolean tick(MinecraftClient var0, int var1) {
      IntegratedServer var2 = var0.getServer();
      if (var2 == null) {
         return var1 > 40;
      }

      if (var1 == 1) {
         var2.setOnlineMode(false);
         fgc = 25570 + (int)(System.nanoTime() % 20L);
         boolean var3 = var2.openToLan(GameMode.SURVIVAL, true, fgc);
         fgq(a.b("돰쩌䂐\udeaf唷펙槟\ue025縴", 954577813) + var3 + a.c(-669091689, "碱Ő讜ᗰ鸡ᣄ") + fgc);
         if (!var3) {
            fgp(a.d("\uf4aa贖ߊ駕ቆ铺⺤꜑㤀뎰㑸칝䃅\ud96b匭헗", -1636469545, 1283620897));
            return true;
         }
      }

      if (var1 == 10) {
         fgd = egq.get().add(a.c(1666217046, "琘ඃ蝓᤺鋘ᑄ긌➸"), a.c(-509571510, "踬\uf79e絁\ue332棨\uee5d吉\udde4䎼쥃") + fgc);
         fgq(a.b("ଃ犿\uf877晒\uedc4歰턣壓욍䱸", 2105019243) + (fgd != null));
         if (fgd != null) {
            fgd.setAddress(a.c(35446680, "\udffeꙌⲓ닠㤺뾏כ谶ቮ频") + fgc);
            if (fgd.getStatus() == dts.OFFLINE || fgd.getStatus() == dts.FAILED) {
               fgd.connect();
            }
         }
      }

      if (fgd == null) {
         return var1 > 20;
      }

      if (var1 > 10 && var1 % 20 == 0 && fge < 0) {
         fgq(
            a.d("㉷䯁섇彣풵刂\ue802", -1605762203, 526528870)
               + fgd.getStatus()
               + a.d("\u2d29", 1224311547, -224808973)
               + fgd.getStatusText()
               + a.d("䬱㋐렖♬궱⬍酙ᢡ蚹", 192220901, 1219708413)
               + fgd.getPendingPackets()
         );
      }

      if (fge < 0 && fgd.getStatus() == dts.ONLINE && fgd.getPlayer() != null) {
         fge = var1;
         fgq(a.d("싷뭇㆖꿢\u2432ꊈᢾ鄎ང薡Ȧ\uf81e", 1732825670, -719253262) + var1);
      }

      if (fge < 0) {
         if (var1 > 900) {
            fgp(a.c(1397391619, "腶\uf8ca爂\uec27枾\ue104孄튦䳮옍䆝믮㔵게⚚ꀤᩪ閹༏襙¥窫\uf402") + fgd.getStatusText());
            fgn();
            return true;
         } else {
            return false;
         }
      } else {
         int var8 = var1 - fge;
         ClientPlayerEntity var4 = fgd.getPlayer();
         if (var8 == 40) {
            fgo(var0.player != null && var0.player != var4, a.b("転\uf75f綄\ue3f2桫\uee8a哅\udd39䍾짓丗됴㪪ꌁ⤁꾾ᗰ騺Ý蛘༳畯ﮙ怊\ue678沲", 808750741));
            fgo(var0.world != null && var0.world != fgd.getWorld(), a.b("츮랓㵈ꌾ⢧깁ᐊ鷦Χ褞ຉ\uf4b1穼\ue39e榃\uef73唧\udaa2䁅예俲㗦묗\u20cbꚯⰭ闊", -1080242600));
            fgo(!ejp.isActive(), a.b("傂⤲ꎮ㶝뙇ロ諪͘鴋ុ遲樒\ue4d8絥\uf762燜쮉䑙\udeed墦템ꬌ◺빿㠜닀ଶ蔡ῂ馀ሿ\uece6曬ｕ礁\uf3b0䱣", -1342615351));
            ServerPlayerEntity var5 = var2.getPlayerManager().getPlayer(a.d("㭞䋅정噼\udd9e嬂\ue14a棾", 445396861, -1192489875));
            fgo(var5 != null, a.b("烗॰莴᷁阅Ⴃꪢ⌀뵉㟸뀽䨟쒜崱흯凛\uebd6搊ﺢ", 621965495));
            if (var4 != null) {
               fgq(
                  a.b("\ue6a5鼙ᗑ说b蛆㳁", -333257024)
                     + var4.getBlockPos()
                     + a.b("재빕㒞꪿", 468305800)
                     + var4.getHealth()
                     + a.c(1051366678, "锾\uecc3易\uf86c玾\uf50e作웩")
                     + (var4.networkHandler != null && var4.networkHandler.method_76760())
               );
               fgo(var4.networkHandler.method_76760(), a.d("㖅䰹웱壔퍎嗳\uefb3晛\uf80a犺\uf52d༐臄\u187b鈭ᓝ꺓", -2115151787, 1252945315));
            }

            fgd.sendChat(a.c(1252426910, "蓸﵄瞞\ue9ef戻\ue4c5廐휵䥷쏄䑚빩コꤙ"));
            var2.execute(() -> {
               ServerPlayerEntity var1x = var2.getPlayerManager().getPlayer(a.b("耝閭獖\ued3f曝\ue041娉펽", -2097774509));
               if (var1x != null) {
                  var1x.sendMessage(Text.literal(a.c(-277837053, "譾\uf2d9砝\ue668涬\ueb0a儋\ud8a9䛤챍䮔놶㼩ꚙ")));
                  var1x.getInventory().insertStack(new ItemStack(Items.DIAMOND, 5));
               }
            });
         }

         if (var8 == 80) {
            boolean var9 = false;

            for (ech var7 : fgd.getChat().lines()) {
               if (var7.text.getString().contains(a.b("ꄾ\ud899剝차䟬셊筋\uf2e9沤\ue60d懔鯶ᕩ賙", 623092035))) {
                  var9 = true;
               }
            }

            fgo(var9, a.d("\ue225鮙ᅑ轴Ӡ艚㠀뇤\u2fefꔙ⋂\ud8a8嘫쿎䖁썽祷\uf6f5汐\uea16揥ᦧ霃ಀ課k많㞟굺⬭ꂜ", -765163163, -1426035907));
            boolean var16 = var4 != null && var4.getInventory().count(Items.DIAMOND) == 5;
            fgo(var16, a.c(-1171144340, "섯뢓㉛걾⟠ꅖᬝ鋿ಫ蘀ǈﮤ畸\uec90暐\ue06b娳헯佚줊䂹㫠둎⾊ꦱ⍭髖ᒋ蹾\u082e莗絑\uf744"));
            var0.setScreen(new BotScreen());
         }

         if (var8 == 110) {
            fgr(var0, a.c(2086426012, "嗵ⱉꚁ㣷덾㖕还خ须\u12c1锊"));
         }

         if (var8 == 120) {
            fgf = var4 == null ? 0.0 : var4.getZ();
            fgd.getControl().setActive(true);
            fgd.getControl().setMovement(true, false, false, false, false, false, false);
         }

         if (var8 == 160) {
            fgd.getControl().setMovement(false, false, false, false, false, false, false);
            fgd.getControl().setActive(false);
            double var10 = var4 == null ? 0.0 : Math.abs(var4.getZ() - fgf);
            fgq(a.b("袟\uf122篰\ue59b湊\ue8e6劶\udb0b䔙쾪䡠눂㳔ꔡ", 492996850) + String.format(a.c(1109517561, "\ue4d8鵢ឭ覈"), var10));
            fgo(var10 > 1.0, a.d("\uf45d跡ܩ餌ኌ鐫\u2e75ꞃ㧄댦㒠컊䀗\ud9a7口핀潌\ue091稣ﱨ疙࿕腥", -1726780876, 579116572));
            var2.execute(
               () -> {
                  ServerPlayerEntity var1x = var2.getPlayerManager().getPlayer(a.d("㜹亢쑲娛퇹坥\ued2d撙", -1514888023, -1153002530));
                  if (var1x != null) {
                     SimpleInventory var2x = new SimpleInventory(27);
                     var2x.setStack(0, new ItemStack(Items.EMERALD, 3));
                     var1x.openHandledScreen(
                        new SimpleNamedScreenHandlerFactory(
                           (var1xx, var2xx, var3x) -> GenericContainerScreenHandler.createGeneric9x3(var1xx, var2xx, var2x),
                           Text.literal(a.c(-1018002040, "膥\uf803犤\uecd6杽\ue1c0寪퉩䠯웿䄮묡㗿갹☓"))
                        )
                     );
                  }
               }
            );
         }

         if (var8 == 200) {
            boolean var11 = var4 != null && var4.currentScreenHandler != var4.playerScreenHandler;
            fgo(var11, a.b("냮쥒䎚\uddbf嘻킜櫏\ue328紤\uf7c1瀎該Ӡ鴞ᝒ醶⯲ꐨ㺚뢏ㄻ䭡엟帘\ud860", 1025618069));
            fgo(
               a.d("ꙍ\udfeb啌쬾䂕온簂\uf581濇\ue117曆鳉ሗ译ǻ", -1023977768, -367856456).equals(fgd.getOpenedScreenTitle()),
               a.d("䟺㹀뒞⫹ꄩ⟌鷋ᐧ詥Ì蜖索\uf3a7樁\ue056暥\udce1匽즏侚옹뱴㋊\ua95e⽣ꖿᰗ", -885922151, -134373093)
            );
            fgr(var0, a.d("휨꺔\u245c먪ㆣ띜ഄ蓸᪱逇", -1352342703, -1670171631));
            if (var11) {
               fgd.clickSlot(var4.currentScreenHandler.syncId, 0, 0, SlotActionType.QUICK_MOVE);
            }
         }

         if (var8 == 240) {
            fgo(var4 != null && var4.getInventory().count(Items.EMERALD) == 3, a.c(-1138314966, "녝죡䈩\udc0c垏턥歶\ue283粗\uf672熽证Փ鲧\u16fc逅⩝ꖟ㼡른\u3098"));
            fgd.closeScreen();
         }

         if (var8 == 260) {
            fgo(var4 != null && var4.currentScreenHandler == var4.playerScreenHandler, a.b("\uddb0ꐌ⻄냡㭵뷋ޛ蹶ဿ骏ᴘ\ue73d槶\uf04a穜ﳮ䚪쥶叓햅", 842259910));
            fgd.setF1(true);
         }

         if (var8 == 320) {
            fgl(a.d("큁ꧥ⌵뵙㚆", -1408031883, -529075355));
         }

         if (var8 == 325) {
            fgr(var0, a.b("\ueefd靁ᶉ菿ࡶ躞㓘봪⌺꧑⸔푶媷쌇䥟", -310710640));
         }

         if (var8 == 340) {
            fgo(fgd.f1Run(), a.c(1992991707, "ꎀ\uda05僗캽䕒쏕禕\uf072測\ue496挋館៸蹒М芾㢾띮ⶓꮖ≽堡훗䵄쬶䇼"));
            fgq(a.b("\uf6ca轭֭鯊လ隦ⲻꔙ㭁뇥㘣챃䋑", 993392304) + fgd.f1ref().getStateIndex());
            fgd.setF0(true);
         }

         if (var8 == 400) {
            fgl(a.d("좤넀㯐ꖼ\u2e71", -675965019, -532914352));
         }

         if (var8 == 405) {
            fgr(var0, a.c(198825007, "푝귡✩륟㋖됾\u0e78螊ᦚ鍧ᒠ\ueed0怜獵珿\uf504"));
            fgm(a.d("⮼刎\ud8dd䚷쵄䯌\uf195硬\ue63d沛", 1365152139, 1654635089), true);
         }

         if (var8 == 410) {
            fgr(var0, a.b("쥨냔㨜ꑪ\u2fe3ꤓፃ骲Ӷ踞ঐ\uf3f8紥\ue49c滁\ue827", 315017498));
            fgm(a.d("\uee79韋ᴘ荲ࢁ踉㑐붩⏸\ua95e", 956481740, -244175149), false);
         }

         if (var8 == 420) {
            fgo(fgd.f0Run() && !fgd.f1Run(), a.b("\ufb3d芸ࡪ阀᷽魧ℾꢋ㚆밠㯦솋佑훢岷\uda47恌\ueffc畻\uf32b竇®踫ᗩ鎀ᥐꃨ", 1765800807));
            fgq(a.c(-724339235, "疴\u0c11蛃ᢩ鍴ᗎ꾗☢") + fgd.f0ref().getStateDescription());
            fgd.stopAutomation();
         }

         if (var8 == 460) {
            fgo(!fgd.isActive(), a.b("\ue1d3顶ኤ賎ܛ膦㯠눌ⱕꛥⅸ\udb5a喊찠䙬삝竇\uf517", 1614995872));
            var2.execute(() -> {
               ServerPlayerEntity var1x = var2.getPlayerManager().getPlayer(a.c(1623804685, "䭃㋘레♡궃⬟酗ᣣ"));
               if (var1x != null) {
                  var1x.kill(var1x.getEntityWorld());
               }
            });
         }

         if (var8 == 480) {
            fgl(a.c(-1257686291, "㪬䌐짘"));
         }

         if (var8 == 485) {
            fgr(var0, a.d("悔莁ॉ霿Ჶ驞‘ꧪ㟺봄㫚산", -34642725, 1228512904));
            fgl(a.d("腭\uf8d1爂", -868218746, -1739159127));
         }

         if (var8 == 490) {
            fgr(var0, a.c(-516886420, "\uf002覾Ͷ鴀ᚉ遡⨧ꏕ㷅뜸ユ쪗"));
            fgl(a.d("啉ⳳ꘩㡍", -1281559410, 886743424));
         }

         if (var8 == 640) {
            ClientPlayerEntity var12 = fgd.getPlayer();
            fgo(var12 != null && var12.isAlive(), a.b("뽦웚䰒툷妲\udf14救\ueca3狭\uf84a羀藺ବ鋙ᣈ鸢\u2434ꮬ\u3102띔㺵䓭쩔", -821969133));
            var2.execute(() -> {
               ServerPlayerEntity var1x = var2.getPlayerManager().getPlayer(a.d("䖥㰾뛮⢇ꍥ◹龱ᘅ", 2105076975, -909596412));
               if (var1x != null) {
                  ItemStack var2x = FilledMapItem.createMap(var1x.getEntityWorld(), var1x.getBlockX(), var1x.getBlockZ(), (byte)0, true, false);
                  var1x.getInventory().setStack(var1x.getInventory().getSelectedSlot(), var2x);
               }
            });
         }

         if (var8 == 700) {
            fgo(fgd.getCaptcha().isPresent(), a.c(-638171101, "䡡㇒묐╥꺥⠟鉅\u1bf5藺དྷ袋狲ﰫ斛\uef8c椨퍢峣옄䁉즳뎧㵙Ꚅ⃪ꩫ᎑鷇ݾ腧\u0add\uf403繆"));
            fgr(var0, a.d("뚛켧䗯\udb99倐훯沾\ue55e笅\uf1a3登调", 254067128, 841774925));
         }

         if (var8 == 760) {
            fgq(
               a.b("\uf718身ѩ騜ᇜ靦ⴼꒌ㪒뀷㟥춏䌍\udaa6僲", 2011690868)
                  + fgd.getCaptcha().getAutoCode()
                  + a.b("誮\uf318禘\ue7ee氬\uea88僊\ud97e䜦", -1442542976)
                  + fgd.getCaptcha().getAutoState()
                  + a.c(452633577, "ꏏ")
            );
            fgd.getCaptcha().dismiss();
            var2.execute(
               () -> {
                  ServerPlayerEntity var1x = var2.getPlayerManager().getPlayer(a.b("\ude93꜈ⷘ뎱㡓뻏҇贳", 2071781085));
                  if (var1x != null) {
                     ServerWorld var2x = var1x.getEntityWorld();
                     var1x.getInventory().setStack(var1x.getInventory().getSelectedSlot(), new ItemStack(Items.DIAMOND_PICKAXE));
                     BlockPos var3x = var1x.getBlockPos();

                     for (int var4x = -4; var4x <= 4; var4x++) {
                        for (int var5x = 0; var5x <= 3; var5x++) {
                           var2x.setBlockState(
                              var3x.add(var4x, var5x, 7),
                              var4x == 0 && var5x >= 1 && var5x <= 2
                                 ? Blocks.GLASS.getDefaultState()
                                 : (var5x == 3 ? Blocks.OAK_LEAVES.getDefaultState() : Blocks.STONE_BRICKS.getDefaultState())
                           );
                        }
                     }

                     for (int var6 = -2; var6 <= 2; var6++) {
                        for (int var7x = 3; var7x <= 5; var7x++) {
                           var2x.setBlockState(var3x.add(var6, -1, var7x), Blocks.WATER.getDefaultState());
                        }
                     }

                     var2x.setBlockState(var3x.add(3, 0, 4), Blocks.TORCH.getDefaultState());
                     var2x.setBlockState(var3x.add(-3, 0, 4), Blocks.DIAMOND_ORE.getDefaultState());
                     var2x.setBlockState(var3x.add(-3, 1, 4), Blocks.POPPY.getDefaultState());
                     var2.getCommandManager()
                        .parseAndExecute(
                           var2.getCommandSource(),
                           String.format(
                              Locale.ROOT,
                              a.c(1298756983, "甚ಯ蘬ᡘ鏙ᔻ꽭⚗룔㈱떤俐섌墡튦向\uee5b憁אַ紫\uf49a軛x鮸᷄"),
                              a.c(1120117411, "ꋭ\udb76冦쿏䐭슱磹\uf14d"),
                              var3x.getX() + 0.5,
                              (double)var3x.getY(),
                              var3x.getZ() + 0.5
                           )
                        );
                  }
               }
            );
         }

         if (var8 == 790) {
            fgm(a.b("冼⠏ꋐ㲩띩㇋讴ɧ鰳ᚃ", 252334549), true);
            fgl(a.b("ᚭ漉\ue5d9箵\uf070", 963974908));
         }

         if (var8 == 830) {
            fgo(fgd.getCamera().isReady(), a.d("朰Ẍ鑄\u0a61臵݆봙㓠ꪨ Ꞙ嶻퍻䫁삘䙨ﰰ珠", 2010703720, 161382440));
            fgq(a.b("⥧僔\uda0b䑲쾲䤐\uf302窵\ue4fe湜\ue983ᏺ鵨", -1561515767) + fgd.getCamera().getRenderMillis() + a.d("뵯쒓乞", 256783636, -451114920));
            fgr(var0, a.c(512459316, "艝ﯡ焩\uef5f擖\ue229塸톅俒앴䊴"));
            fgd.setF2(true);
         }

         if (var8 == 930) {
            fgo(fgd.f2Run(), a.b("郍\ue948掚ﷰ瘅\uf090䫄쌾崤\ud7c7倓꩹⒳뵑㝍놽\u0bbc萹ẖ飊ᅸ歫\ue5d5縟", -1006006124));
            fgq(a.c(-720762679, "ࢥ焙\ufbd1旴\uee62棇튕孿씢侗졃㈹벱┚") + fgd.f2ref().status() + a.b("퍙ꫧ※", 1138348922) + fgd.f2ref().lastNote());
            fgq(
               a.c(-369590155, "者禮獩\ued10曐\ue072婠폜䶏윶䃢뫝㑞귳➺ꅜᬗ铃ิ")
                  + fgd.getCamera().getRenderMillis()
                  + a.d("圙⻥ꐨ㨆뇝㜮赾ҍ髚ၧ鞡淍\ue300窪\uf0f3癆챝䎊\ud92a役횈겜", -238035433, -1813214920)
                  + fgd.getCamera().getTraceMillis()
                  + a.b("㲒䕮쾣", -1911735119)
            );
            fgr(var0, a.c(-1660701371, "딪첖䙞\ud828厡핉漏\ue6fd磭\uf21c痋辽š"));
            fgd.setF2(false);
         }

         if (var8 == 960) {
            fgo(!fgd.f2Run(), a.b("霖\uee93摁飼燞\uf74b䴟쓥嫿퀝埉궣⍫뫚゜뙬౧菹᥋齔ᛷ沺\ue204禐ﾭ畱쳙", -792225972));
            fgm(a.b("숩뮚ㅅ꼼⓼ꉞᠡ釲ྦ蔖", 1766048320), false);
            var0.setScreen(null);
         }

         if (var8 == 1080) {
            fgr(var0, a.b("ꂃ\ud93f号춁䘈샹窦\uf35f洇\ue7f5恽験ᓈ赫", 516530415));
            fgo(var0.player != null && var0.world != null && var0.player.isAlive(), a.b("籚ק輼ᅊ髓ᰲ꙽⾁뇆㭫벯䚌젝冣\udbf7崍", -789808089));
            fgn();
            egq.get().remove(fgd);
         }

         if (var8 == 1140) {
            fgo(var2.getPlayerManager().getPlayer(a.c(-447927251, "Ᵽ嗸\udf28䅁쪣䰿\uf677翃")) == null, a.b("蓒ﵮ瞦\ue983战\ue4a0廰휓䤘쏽䐲빎ボꤾ⍻ꖝῖ途ર", 319849635));
            fgh = var0.player.getYaw();
            fgi = var0.player.getPitch();
            nxa var13 = Flow.getInstance().getModuleManager().get(nxa.class);
            var13.setEnabled(true);
         }

         if (var8 == 1220) {
            nxa var14 = Flow.getInstance().getModuleManager().get(nxa.class);
            fgq(a.d("ꊳ\udb1a凐쿯䑯싈碈\uf16f漱\ue58b或頴ᛤ轀Ԇ菦㧬", -1095201715, 1958489728) + var14.getStateIndex() + a.c(496858290, "璕൷螧ᧉ鈞ᒦ꺳") + pud.INSTANCE.engaged());
            fgo(var14.isEnabled(), a.d("\u09b1瀘㮝擭\uef5b槞펌婦쐁了쥆㌡뷷\u244d깐⣪銫ᵯ蟘ǝ衸\uf22e粆\ue757愯\uebf9剃", 1750999978, 184822383));
            var14.setEnabled(false);
            Flow.getInstance().getModuleManager().get(mpq.class).setEnabled(true);
         }

         if (var8 == 1300) {
            mpq var15 = Flow.getInstance().getModuleManager().get(mpq.class);
            fgq(
               a.d("\ue3d0驹Ⴓ躌Ԛ莿㧭뀇⹒ꓨ⌱\ud904", -1858723772, -1925790729)
                  + var15.getStateDescription()
                  + a.c(259861559, "Ⱀ嗲\udf22䅌쪛䰣\uf636")
                  + pud.INSTANCE.engaged()
            );
            fgo(var15.isEnabled(), a.c(1938160456, "\ufb3f芖\u085c陣ᷕ魐ℂ꣨㚝밇㯞쇫佷훈岎\uda7b恠\uefe3畗\uf31d竪¼踈ᗐ"));
            var15.setEnabled(false);
         }

         if (var8 == 1360) {
            fgq(
               a.b("⤚傩\uda76䐏쿏䥭\uf37f竗\ue490渷\ue9b3", 974662002)
                  + fgh
                  + a.b("閳\uec0f曏\uf8a0", -1932814953)
                  + var0.player.getYaw()
                  + a.d("㸑䞬촯升\ud88d師\ue473淊", 2114299029, 1981717152)
                  + fgi
                  + a.d("巴⑈꺈ョ", 1811799430, -874872746)
                  + var0.player.getPitch()
            );
            fgo(!pud.INSTANCE.engaged(), a.c(-1866540694, "\ud90dꂦ⩰됈㿔륿\u0378諟ᒟ鸢᧣\ue3c5浀\uf4e6纼\uf844䈏췌坩턹"));
            fgo(var0.player.isAlive(), a.b("\ueafa鍇ᦜ蟪\u0c73誒ポ뤡❦귋⨏퀬庺윆䵐쮾燢ﹶ撄\ue2d2欷ᅷ鿓ѐ艠ࢩ넃㼜ꖭ⏻ꡛ嚕\udc97䔫썺䧀\uf606籮華挓", 1558440639));
            fgr(var0, a.c(836500773, "﵉蓵\u0e3d運ᯂ鴱❺꺒ゎ멳㶧쟄䤂키"));
            fgq(a.b("쫜덦㦴\ua7ceⱐꫭჸ餎ݙ跭ਡ\uf003", -1359492428) + fgg);
            return true;
         } else {
            return false;
         }
      }
   }

   private static void fgl(String var0) {
      try {
         Class var1 = Class.forName(a.d("뱉엲伢텋嫅\udc38晦\uef8c熉ﭔ粪蛀࠰醱᯳鴕❚ꢀ㉹둘㶚䟈", -2122152327, 1288583744));
         Field var2 = BotScreen.class.getDeclaredField(a.d("\udcc3ꕧ⾷", 309031401, -2122928803));
         var2.setAccessible(true);
         var2.set(null, Enum.valueOf(var1, var0));
      } catch (ReflectiveOperationException var3) {
         fgp(a.b("䝩㻍됝⨮", -350402791) + var0 + a.b("㹄䟯", -1595064708) + var3);
      }
   }

   private static void fgm(String var0, boolean var1) {
      try {
         Field var2 = BotScreen.class.getDeclaredField(var0);
         var2.setAccessible(true);
         var2.setBoolean(null, var1);
      } catch (ReflectiveOperationException var3) {
         fgp(a.c(-487589604, "勵胄ਚ鑭´") + var0 + a.b("韆\uee6d", 1784518654) + var3);
      }
   }

   private static void fgn() {
      if (fgd != null) {
         for (ech var1 : fgd.getChat().lines()) {
            fgq(a.b("芰\ufb0a燐\uefb4搷\ue2fd", -104955179) + var1.kind + a.c(-1103987934, "筽ʱ") + var1.text.getString());
         }
      }
   }

   private static void fgo(boolean var0, String var1) {
      if (var0) {
         fgq(a.c(-312308744, "讴\uf201碹") + var1);
      } else {
         fgp(var1);
      }
   }

   private static void fgp(String var0) {
      fgg++;
      fgq(a.d("㺃䜵췮厚\ud821", -1100895633, -379087697) + var0);
   }

   private static void fgq(String var0) {
      System.out.println(a.d("\ua8dc텠宨엞乀죫", -504240883, -2012262987) + var0);
   }

   private static void fgr(MinecraftClient var0, String var1) {
      fgq(a.c(435751021, "ࠛ熱ﭥ攏\uee8c") + var1);
      ScreenshotRecorder.saveScreenshot(
         var0.runDirectory,
         a.c(-1261595976, "鋘\ueb63憳ￚ瑈\uf2e6") + var1 + a.d("ퟨ긇Ⓤ몲", 1570177671, -748432059),
         var0.getFramebuffer(),
         1,
         var0x -> System.out.println("" + var0x.getString())
      );
   }
}
