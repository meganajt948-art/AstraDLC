package a;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import flow.Flow;
import flow.dev.a;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Consumer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents.StartTick;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents.EndTick;
import net.minecraft.SharedConstants;
import net.minecraft.block.Blocks;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.block.entity.SignText;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.resource.ResourceType;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.WorldSavePath;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Direction.Type;

final class fdx {
   private static final String fdy = System.getenv()
      .getOrDefault(a.d("\uee69韒ᴂ荫ࣙ踅㑋붹⏴꥓\u2e9a퓻娭쎞䧘", -2125142414, 835455058), a.b("蠢\uf19e筕\ue532滿\ue84f剄\udbfb䖧켄䣁당㱠ꗆ⾙ꥴጬ鲣و耟৻玻", 1705609304));
   private static String fdz;
   private static BlockPos fea;
   private static BlockPos feb;
   private static BlockPos fec;
   private static BlockPos fed;
   private static BlockPos fee;
   private static BlockPos fef;
   private static BlockPos feg;
   private static long feh;
   private static long fei = -1L;
   private static long fej = -1L;
   private static int fek;
   private static int fel;
   private static int fem;
   private static boolean fen;
   private static int feo;
   private static final List<String> fep = new ArrayList<>();
   private static final qof feq = new qof();
   private static boolean fer;
   private static qaj fes;
   private static qdz fet;
   private static final tel feu = new tel();
   private static final qmh fev = new qmh();
   private static boolean few;
   private static BlockPos fex;
   private static int fey = 1;
   private static volatile boolean fez;
   private static volatile boolean ffa = true;
   private static volatile long ffb;
   private static final List<Item> ffc = new ArrayList<>();

   private fdx() {
   }

   static boolean tick(MinecraftClient var0, int var1) throws Exception {
      ClientPlayerEntity var2 = var0.player;
      ffx(var0);
      if (var1 == 1) {
         if (System.getenv(a.d("Ǣ硙\uf289泠\ue752憎\udbcf刺챢䛘섑㭫떺Ⱈꙉ₾", 138791207, 1291438227)) != null) {
            qsw.trace = var0x -> System.out.println(a.d("\uedf7鑁ẇ胤ନ跑", -354314714, -290554972) + var0x);
         }

         ffw(a.d("㌤䪽쁪帷헒卣\ue92a惁ﺙ", -1268483825, -1493415325), false);
         ffw(a.c(1976889784, "\uf1f6衳ʷ鳆\u1738醪⯹ꈌ"), false);
         ffw(a.b("\ue9a6連\u1af1蒛ཷ觽㎵멕␂", 322824686), false);
         ffw(a.d("湉៌鴞ʹ袘ฒ둁㶳", -1680684380, 1187226788), false);
         ffz(var0, a.c(-1308812717, "ᨥ排\ue94d眴ﳫ穘쀀䧰ퟪ崈\udadd₫깸㟖붚㭼脾"));
         ffz(var0, a.d("裔\uf166箵\ue5c7渖\ue8b0劷\udb01䕐쿾䠾눊㲽ꔿ⼿ꦜᏄ鰃ڪ胡ऑ獕\ufde9昵\ue04c櫘퍺崪쟝䆌쨯㓪뺱✔ꅁ⯷鐰", -2136770993, -1864433957));
         ffz(var0, a.c(274223750, "勄⭶ꆥ㿗됆㊠袧đ齀ᗮ鈮栚\ue6ad缯\uf52f玐짘䘇\udcbb嫶팪ꥒ⟾밵㩐낇व蜪᷌鮜ု\ueefe撡﵀笃\uf1e6丷쑁䊂"));
         ffz(var0, a.c(2106547120, "寈≤ꢳ㛊뵘㮺臿ࠟ阔᳡鬷慞"));
         ffz(var0, a.d("㩄䏳줬坕\udc95娣\ue069榑\uf78b絾益ü踎ឧ鷡ᬕꅔ⺊됥㉃뮎쇅佹풡力\ud80c憸\uefe4甌\uf34b", -1982658438, -1882574265));
         ffz(var0, a.c(-40414019, "哆\u2d71Ɪ㧗눗㒡軫ܓ餉ᏼ鐤湷\ue082社\uf35c疎쿐䀗\udabd峫픛꽃↷먠㱘뚄༨腯"));
         ffz(var0, a.d("躣\uf71d緇\ue3b2桶\uee95咦\udd64", -1077189503, -1941181879));
         if (!fen) {
            fen = true;
            ClientTickEvents.START_CLIENT_TICK
               .register(
                  (StartTick)var0x -> {
                     if (var0x.player != null && fel == 11 && fem % 20 == 0 && System.getenv(a.c(294736627, "劥⬞ꇎ㾧됕㋉袈Ž鼥ᖟ鉖栬\ue6fd罟\uf50e珹")) != null) {
                        System.out
                           .println(
                              a.c(-1560111989, "铳\ued41枀裏牵\uf490仒융奭펈合깾₼뤞㍋뗣\u0ff5耹᪀鳙ᕿ漴\ue1d2稅ﱬ盥")
                                 + var0x.options.useKey.isPressed()
                                 + a.b("ၡ榃\ue340素\uf6e0灑쨉䎫", -649916343)
                                 + var0x.currentScreen
                                 + a.d("鐬\uedde朁殺犤\uf41d久재姪팈", 1061314130, -792999340)
                                 + var0x.player.getItemCooldownManager().isCoolingDown(var0x.player.getMainHandStack())
                           );
                     }

                     if (fer && var0x.player != null) {
                        feq.startTick(var0x);
                     }

                     if (few && var0x.player != null) {
                        feu.newTick();
                        fet.startTick(var0x, var0x.player);
                     }
                  }
               );
         }
      }

      if (var1 == 5) {
         fdz = var2.getName().getString();
         BlockPos var3 = var2.getBlockPos();
         IntegratedServer var4 = var0.getServer();
         var4.execute(() -> ffh(var4, var3));
      }

      if (var1 == 30) {
         ffz(var0, a.c(-1212977058, "瀪ঌ荖ᴤ雽၉"));
      }

      if (var1 >= 40 && !fez && var1 % 20 == 0) {
         IntegratedServer var7 = var0.getServer();
         int var16 = var1;
         var7.execute(
            () -> {
               boolean var2x = var7.getRecipeManager()
                  .get(RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(a.c(-111277964, "ࠚ熡ﭱ攘\ueecc桬툩察"), a.b("᪀挹\ue9c5瞉ﱓ竹삪䥃휕", -192931087))))
                  .isPresent();
               if (!fez && (var2x || var16 > 1200)) {
                  System.out.println(a.c(1517545227, "\ue775黇ᐆ詡ǳ蜖㵔뒳⫫ꀔ⟝\uddd4匋쫊䃋옭籤\uf3bf椕\uef51曣\u1cfe鉎\u0991迫Ի벉㊁") + var2x);
                  ffi(var7);
                  fez = true;
               }
            }
         );
      }

      if (fez && var1 >= 90 && ffa) {
         fem++;
         switch (fel) {
            case 0:
               fff(
                  fdy.contains(a.c(-758616752, "洺ᒆ鹍*诧ൗ"))
                     ? 1
                     : (fdy.contains(a.c(1344518484, "뤲삀䩁퐦")) ? 10 : (fdy.contains(a.d("徨☎곑㊼를", 1473419330, -1793734771)) ? 20 : 30))
               );
               break;
            case 1:
               ffs(var0, var0x -> {
                  PlayerInventory var1x = var0x.getInventory();
                  var1x.clear();
                  var1x.setStack(4, ffp(var0x, 1800));
                  var1x.setStack(0, new ItemStack(Items.COBBLESTONE, 64));
                  var1x.setStack(7, new ItemStack(Items.DIAMOND, 40));
                  var1x.setStack(12, new ItemStack(Items.GOLD_INGOT, 30));
                  var1x.setStack(20, new ItemStack(Items.REDSTONE, 12));
                  var1x.setStack(21, new ItemStack(Items.REDSTONE, 7));
                  var1x.setStack(22, new ItemStack(Items.LAPIS_LAZULI, 9));
                  var1x.setStack(25, new ItemStack(Items.IRON_INGOT, 3));
                  var1x.setStack(26, new ItemStack(Items.COAL, 5));
                  var1x.setStack(30, new ItemStack(Items.ANCIENT_DEBRIS, 1));
                  var1x.setStack(31, new ItemStack(Items.GRANITE, 33));
                  var1x.setStack(33, new ItemStack(Items.RAW_IRON, 4));
                  var1x.setStack(34, new ItemStack(Items.GOLDEN_CARROT, 20));
                  var1x.setStack(35, new ItemStack(Items.TOTEM_OF_UNDYING));
                  var0x.currentScreenHandler.sendContentUpdates();
               });
               fff(2);
               break;
            case 2:
               if (feq.busy()) {
                  feq.endTick(var0, var2, Set.of(a.b("닒쭧䆳\udfc9吘트棸\ue10e罃\uf5bc父衋ڑ鼠ᕽ鎅⧜ꘊ㲢뫲㌎", 2063250090), a.c(-1032805051, "ꔹ\udc8c噘젢䏳앓缓\uf6e5梨\ue257旙龽ᅹ裇ʓ葿㸡")));
               }

               if (fem == 20) {
                  fer = true;
                  feq.layout();
               } else if (fem > 20 && !feq.busy()) {
                  fer = false;
                  PlayerInventory var15 = var2.getInventory();
                  StringBuilder var19 = new StringBuilder();

                  for (int var20 = 0; var20 < 36; var20++) {
                     ItemStack var6 = var15.getStack(var20);
                     var19.append(var20)
                        .append('=')
                        .append(var6.isEmpty() ? a.b("\uea27", 119794187) : fft(var6.getItem()) + a.d("\ue931", 537940214, -1907967554) + var6.getCount())
                        .append(' ');
                  }

                  System.out
                     .println(
                        a.b("媠⌒꧓㞴밦㫃肁०霾ᷛ驄怸\ueef7睐ﴙ篩쇨丣", -1791534384)
                           + var19
                           + a.b("䗨㰖뛌⢽ꌱ", -2062006835)
                           + fft(var2.getOffHandStack().getItem())
                           + a.b("ࠃ", 1218971770)
                           + var2.getOffHandStack().getCount()
                     );
                  int var21 = qpw.misplaced(var15, qpw.targets(var15, var2.getOffHandStack()));
                  ffu(feq.laidOut(), a.c(1874885331, "窱̍视ឡ鱬\u1adcꃛ⥭뜴㶒멒䁦커坐"));
                  ffu(var21 == 0, a.b("㭅䋹젲噕\udd98嬨\ue12f梓\uf6c8籣﮳Ǟ輄ᚷ鳢ᨒꀙ", 1006975800) + var21);
                  ffu(var15.getStack(0).isOf(Items.NETHERITE_PICKAXE), a.b("믰쉘䢁훸崥\udb8d懃\ue877癦ﳖ笞脻ྥ阓ᰎ骬\u20fc꼮㖆뎃㩤", -887112811));
                  ffu(
                     var2.getOffHandStack().isOf(Items.GOLDEN_CARROT), a.d("ᢣ愐\uebd0疡﹫磁슕䬷픦徖\ud85e≻곥㕓뽎㧫莸\u0c64隒ႌ饲\ue323涞\uf646瀶\ufaed", 1905017172, -1143187058)
                  );
                  ffu(
                     qpw.count(var15, Items.DIAMOND) == 40 && qpw.count(var15, Items.GOLD_INGOT) == 30,
                     a.d("斪ᰖ雍ࢰ荥ו뾌㙪ꡩ⊐ꕋ弹퇦䠓숌䓾ﺭ煻\ueb86淍", 1216049576, -2146429838)
                        + qpw.count(var15, Items.DIAMOND)
                        + a.c(1156368751, "쥁")
                        + qpw.count(var15, Items.GOLD_INGOT)
                  );
                  ffu(qpw.count(var15, Items.COBBLESTONE) == 0 && qpw.count(var15, Items.GRANITE) == 0, a.b("⎃娭탥云씍䏯僚灗\uee0d撼\ue323ᤆ韍\u0e71萵˓", 238822393));
                  ffu(qpw.count(var15, Items.REDSTONE) >= 1 && qpw.count(var15, Items.REDSTONE) <= 12, a.b("⹇埡\udd33䍕종丯\uf47d綇", 859844157));
                  ffu(qpw.count(var15, Items.TOTEM_OF_UNDYING) == 1, a.b("ꬭ튇塏옯䷰쬌焋\uf8e6暣\uec0f毄醬", 645704533));
                  ffu(var15.getStack(32).isOf(Items.ANCIENT_DEBRIS), a.b("㥬䃜쨈呩\udfa5夎\ue30e檱\uf4ef繅蓼Ϻ贪ᓕ黏ᠣꉫⷩ뜉ㅇ뢳싹", -1513801442));
                  ffy(var0, a.d("竢͗覃៹鰩\u1a9bꃚ⤽뜪㷚먄䁭캬圇\udd55", 285540812, 839678796));
                  fff(fdy.contains(a.c(1687638, "쀰릂㍃괤")) ? 10 : (fdy.contains(a.c(-1751761189, "㺼䜚췅厨\ud868")) ? 20 : 30));
               } else if (fem > 600) {
                  ffu(false, a.c(1314056084, "\ue7ed鹑ᒚ諽İ螀㶇됸⩬ꃎ✎\udd68叭쨚䁆우糸\uf333榛\uefc7昱"));
                  fer = false;
                  feq.cancel(var0);
                  fff(30);
               }
               break;
            case 10:
               ffs(var0, var1x -> {
                  PlayerInventory var2x = var1x.getInventory();
                  var2x.clear();
                  var2x.setStack(0, ffp(var1x, 90));

                  for (int var3x = 1; var3x <= 8; var3x++) {
                     var2x.setStack(var3x, new ItemStack(Items.DIAMOND, 64));
                  }

                  var2x.setStack(9, new ItemStack(Items.REDSTONE, 5));
                  var2x.setStack(10, new ItemStack(Items.LAPIS_LAZULI, 3));
                  var2x.setStack(11, new ItemStack(Items.IRON_INGOT, 1));
                  var2x.setStack(12, new ItemStack(Items.COAL, 2));
                  var2x.setStack(13, new ItemStack(Items.GOLD_INGOT, 64));
                  var2x.setStack(14, new ItemStack(Items.GOLD_INGOT, 64));
                  var2x.setStack(15, new ItemStack(Items.GOLD_INGOT, 40));

                  for (int var7x = 16; var7x <= 26; var7x++) {
                     var2x.setStack(var7x, new ItemStack(Items.GOLD_INGOT, 1));
                  }

                  var2x.setStack(27, new ItemStack(Items.DIAMOND, 64));
                  var2x.setStack(28, new ItemStack(Items.DIAMOND, 30));

                  for (int var6x : new int[]{29, 30, 31, 33, 34}) {
                     var2x.setStack(var6x, new ItemStack(Items.DIAMOND, 1));
                  }

                  var2x.setStack(35, new ItemStack(Items.COBBLESTONE, 64));
                  var2x.setStack(32, new ItemStack(Items.ANCIENT_DEBRIS, 3));
                  var1x.getInventory().setStack(40, new ItemStack(Items.GOLDEN_CARROT, 2));
                  var1x.currentScreenHandler.sendContentUpdates();
                  feo = ffo(ffn(var1x.getEntityWorld(), fed), Items.EXPERIENCE_BOTTLE);
                  ffq(ffr(var0), feg);
               });
               fff(11);
               break;
            case 11:
               if (fem == 30) {
                  kfe var13 = Flow.getInstance().getModuleManager().getByName(a.b("\uf788踍ӟ骵ᅀ韕ⶁꑻ", 2009200577));
                  nfi.solo = false;
                  nfi.anarchies = a.c(922749055, "ࡍ燽אָ");
                  ffv(var13, a.b("眇ປ葏ᨴ闳ᜣ괋⓻몯〚럍", -826182884), a.b("퀐ꦮ⌦뵓㚆", -2076716940));
                  ffv(var13, a.b("\ued11钄ṕ耨௲赊㜝뫼\u20c2ꨈⷚ힠女샆", -232199931), a.b("쟸빎㒟ꫦ", 85182356));
                  ffv(var13, a.b("\uf290謉Ǜ鿟ᐁ鋇⣦ꄙ㬪떋㉚졛䛰\udb52啭폧槑\ue67c糊\ufae2", 1759245974), false);
                  ffv(var13, a.b("퓮굀➓맭㉂뒏໔蜠ᤈ", -2138582842), true);
                  var13.setEnabled(true);
                  System.out.println(a.d("䟼㹎뒏⫨ꅺ➟鷝ᐺ詢\u009d蝔組\uf3a7樗\ue05f暌\udce7匱즉依옥뱵", -1427954175, 1796366729));
               } else if (fem > 30) {
                  nfl var14 = (nfl)Flow.getInstance().getModuleManager().getByName(a.b("\ud97dꃸ⨪둀㾵뤠ʹ誎", -1941710540));
                  String var18 = nfl.hudStatus();
                  if (fem % 40 == 0) {
                     System.out
                        .println(
                           a.d("ﾑ蘣ೢ銅ᤗ鿲▰걗㈏룪㽭압", -2079425755, 1751418074)
                              + fem / 20.0
                              + a.d("Վ粬", -1563558148, 396164035)
                              + var18
                              + a.d("\uea41鎠ᥬ蜁ಘ", -778999576, 842498700)
                              + var2.getBlockPos().toShortString()
                              + a.c(1611293639, "揢ᨗ郕ຣ蔻")
                              + qpw.pickaxeDurability(var2)
                        );
                  }

                  if (fem == 900) {
                     ffy(var0, a.c(-1191784252, "키ꤑ⏅붿㙯냝જ荻ᵬ鞒၂\uea21擠"));
                  }

                  boolean var5 = fem > 200 && !var14.debug().startsWith(a.d("\uf4bc贎ߏ馨", 1401547029, -132243985));
                  if (var5 || fem > 4800) {
                     System.out.println(a.c(233969619, "ឧ渕\ue4d4窳\uf121矄춆䑡\uda39僆휏ⴼꏨ㩋뀎㚺貺Ͳ駒ᾔ阫\uec60") + var18 + a.c(2054524464, "踑") + var14.debug());
                     var14.setEnabled(false);
                     ffg(var0, var2);
                     fff(fdy.contains(a.d("굯퓉帖쁻䮻", -1016724713, -1339642337)) ? 20 : (fdy.contains(a.b("䱔㗣뼣⅃", -775140316)) ? 30 : 99));
                  }
               }
               break;
            case 20:
               if (fem == 10) {
                  fes = new qaj();
                  fes.begin(var0, a.c(-557219377, "臦\uf81a狞\ueca3杨\ue1ce"), System.currentTimeMillis());
               } else if (fem > 10) {
                  if (fem == 14) {
                     ffy(var0, a.b("ⶻ后\udeda䂠쭰䷂\uf783繤\ue073檍\ued49᜴駿Y", 1979264472));
                  }

                  if (fes.tick(var0, var2, System.currentTimeMillis())) {
                     System.out
                        .println(
                           a.b("酅\ue8f7戶ﱑ矃\uf126䭤슃峛혾冯ꯉ┒벿㛻끂ਗ薉Ἶ餹", 609980723)
                              + fes.ok()
                              + a.b("䭙", 973556600)
                              + fes.result()
                              + a.d("뛞켦䗲\udbcd", -451571633, -1260771659)
                              + (fem - 10)
                              + a.b("ꮄ퉡墯월䴋쮢", 175811490)
                        );
                     ffu(fes.ok(), a.b("\ue9c0遦᪹蓔༔觭㎤", -100931163) + fes.result());
                     ffs(var0, var0x -> {
                        for (Item var4x : new Item[]{Items.REDSTONE, Items.LAPIS_LAZULI, Items.COAL, Items.IRON_INGOT}) {
                           ffu(ffc.contains(var4x), a.b("鈴耗ૈ钥ὥ馆⎙ꩡ㐽뺞㤙", -1884292648) + fft(var4x) + a.d("㑩䶗읍夼", 173344004, 1582248265));
                        }
                     });
                     fff(fdy.contains(a.c(-821468533, "拻ᭌ醌\u0fec")) ? 30 : 99);
                  } else if (fem > 400) {
                     ffu(false, a.d("軜\uf77a綥\ue3c8栈\ueeeb哰\udd1c䍘짠", 71973402, 1727902894));
                     fff(30);
                  }
               }
               break;
            case 30:
               if (fem == 5) {
                  BlockPos var9 = fea.add(-6, 0, -6);
                  ffs(var0, var2x -> {
                     ffq(ffr(var0), var9);
                     var2x.getInventory().setStack(0, ffp(var2x, 1500));
                     var2x.getInventory().setSelectedSlot(0);
                  });
                  fex = var9.up();
               } else if (fem == 30) {
                  fet = new qdz();
                  fet.configure(fev, false, false);
                  fet.guard(pzc.empty(var2.getBlockPos()));
                  feu.use(tck.profile1());
                  few = true;
                  BlockPos var10 = BlockPos.ofFloored(var2.getEyePos());
                  fex = var10;
                  ffs(var0, var1x -> {
                     ServerWorld var2x = var1x.getEntityWorld();

                     for (Direction var4x : Type.HORIZONTAL) {
                        var2x.setBlockState(var10.offset(var4x), Blocks.STONE.getDefaultState());
                        var2x.setBlockState(var10.down().offset(var4x), Blocks.STONE.getDefaultState());
                     }

                     var2x.setBlockState(var10.up(), Blocks.STONE.getDefaultState());
                     var2x.setBlockState(var10, Blocks.STONE.getDefaultState());
                     var2x.setBlockState(var10.down(), Blocks.STONE.getDefaultState());
                  });
                  System.out.println(a.b("髳\ue341榀\uf7e7籵敖䃒줵坭\udd92婛ꁹ⺩뜃㵑뮫ơ踠ᒖ鋆᭥慽\uefc9瑖\uf27d碰섎会향叹\ud84e⚚겑㔡덧㦂", 1090362037) + var10.toShortString());
               } else if (fem > 32) {
                  fet.endTick(var0, var2, feu);
                  if (fem % 20 == 0) {
                     Box var11 = var2.getBoundingBox().contract(0.001);
                     System.out
                        .println(
                           a.c(-650781963, "\uda83ꌱ⧰랗㰅뫠¢襅\u171d鷸᩿\ue008滌\uf76c絵ﮞ䆔칙哶틿")
                              + var2.getEyePos()
                              + a.d("ﯠ舁࣍隠ᴹ", -1199788952, 107042733)
                              + var2.getEntityPos()
                              + a.d("\ue8b1酅ᮞ藲ม袝㊊", 771710341, -1276725997)
                              + var0.world.isSpaceEmpty(var2, var11)
                              + a.b("鷲\ue417滂\uf0a0筦\ufdd7䞑칡偧", 1036426715)
                              + qdz.trapped(var0.world, var2)
                              + a.b("㔶䳂옍塠펐唏\uef5f暢\uf8f5爒", -193776356)
                              + var0.world.getBlockState(BlockPos.ofFloored(var2.getEyePos()))
                              + a.c(1948688459, "ꁧ\ud99f卋촧䛪쁖稄\uf3c7涮\ue712惁髡")
                              + var2.isInsideWall()
                        );
                     System.out
                        .println(
                           a.d("얿밍㛌ꢫ⌹ꗜᾞ陹ࠡ苄ՃＴ燰\ue850扉\ue4a2庾텹䯃췃", 1968006014, -775641417)
                              + var2.getInventory().getSelectedSlot()
                              + a.d("釗\ue82b拴ﲍ睝\uf1bf", 1768947368, 846688089)
                              + var2.getMainHandStack()
                              + a.c(-1895574493, "퐄균✵륞㊎됶฿")
                              + var2.isUsingItem()
                              + a.d("弟⛻갮㉉맆", -1622353864, -135362814)
                              + var0.options.useKey.isPressed()
                              + a.c(1794907848, "Ỡ朐\uedd6玧\uf865绖쒍䴪")
                              + var0.options.attackKey.isPressed()
                              + a.d("㲽䕟쾜凼\uda3c岍\ue6d5潷", 734713273, 566028588)
                              + var0.currentScreen
                              + a.c(-579507464, "櫝ጤ駶ޚ谄")
                              + var0.crosshairTarget.getType()
                              + a.b("轥", -1723560124)
                              + fet.action()
                              + a.d("诗\uf235磡\ue685浇\uebf7冢\ud81d", 866157505, 174983230)
                              + fet.status()
                        );
                  }

                  boolean var12 = var0.world.getBlockState(fex).isAir() && var0.world.getBlockState(fex.down()).isAir();
                  if (var12) {
                     System.out.println(a.c(-1214745475, "琉ර蝺ᤝ銏ᑪ긨⟏릗㍨뒡五쁒姱폥啛\uef0e惞塀簡\uf5d1迎") + (fem - 30) + a.d("Ὣ暎\uec40爻理罍", 943867712, 279599117));
                     ffu(fem - 30 <= 40, a.c(-127329933, "ᤙ悥\uea78瑃ￖ祽쌯䪊풆帨\ud9f8⎑괋㒠") + (fem - 30) + a.c(1424269031, "黁\ue724淪\uf391硎ﻧ"));
                     few = false;
                     fet.stop(var0);
                     fff(99);
                  } else if (fem > 200) {
                     ffu(false, a.d("\u1774滎\ue40e穬\uf1ac睏쵘䒸\udaf5倃힟ⷴꌢ㫇냛㘣谪", -112920905, 2031477180) + fex.toShortString());
                     few = false;
                     fet.stop(var0);
                     fff(99);
                  }
               }
               break;
            default:
               for (String var17 : fep) {
                  System.out.println(a.b("䲺㔈뿉↮\uaa3cⳁ隑Ὠ腰", 1264930001) + var17);
               }

               System.out
                  .println(
                     a.d("ﶽ萏໎邩ᬻ鷞➜깻〣뫆", -1045224438, 818141663)
                        + (fek == 0 ? a.c(-111434398, "ꔶ\udc96噗젦") : a.c(205282442, "峊╼꾧㇓멨㳑") + fek + a.d("ᦒ", 220901791, 1534634021))
                  );
               return true;
         }

         return false;
      } else {
         return false;
      }
   }

   private static void fff(int var0) {
      fel = var0;
      fem = 0;
   }

   private static void ffg(MinecraftClient var0, ClientPlayerEntity var1) {
      PlayerInventory var2 = var1.getInventory();
      int var3 = qpw.pickaxeDurability(var1);
      System.out
         .println(
            a.d("\udff3ꙁⲀ닧㥵뾐ג谵ቭ颒Ὓ\ue56e殨\uf21e砂", 412799013, -1700393029)
               + var3
               + a.d("ア䥗쎉巰혫傘\ueaca挱ﵹ瞆", 1893658362, 1788730994)
               + qpw.count(var2, Items.DIAMOND)
               + a.c(-1438098032, "嶶⑀꺛ラ묶㷞")
               + qpw.count(var2, Items.GOLD_INGOT)
               + a.b("猍૿耮Ṍ閛ጷ\ua97f₉뺘", -309497052)
               + qpw.food(var1)
               + a.c(-1321241323, "甼\u0ccf蘑\u187b鎬ᔅ꽟⚸뢩")
               + qpw.count(var2, Items.EXPERIENCE_BOTTLE)
         );
      ffu(var3 >= 1500, a.b("ӳ絛\uf782槻\ue226撎\udec0坴쥥䏕쐝㸸낽⤛ꍝ▽鿺ူ誔ೄ蕭Ｆ", 1951663253) + var3);
      ffu(var2.getStack(0).isOf(Items.NETHERITE_PICKAXE), a.b("煀ࣨ舱᱈鞕ᄽꭳ⋇볖㙦놮䮋씞岬훽倄\uea00斘Ｌ礳\uf097諙ѩ龣ᦈ鍉", -11439830));
      ffu(qpw.food(var1) == 64, a.d("㍿䫌쀌幽햷匝\ue949惫", 705319038, -1646632086) + qpw.food(var1) + a.d("\ue180頹ኵ賒܊膡㮦뉁Ⱌꚰ", -291509722, -1591407732));
      ffu(var1.getOffHandStack().isOf(Items.GOLDEN_CARROT), a.b("穓Ϡ褠ᝑ鲛ᨱꁥ⧇럖㵦몮䂋츕垣\uddbe嬛\ue148溔\uf462牼ﮂ臓\u0f6e钶\u12c6頝", -1316324822));
      ffu(qpw.count(var2, Items.DIAMOND) >= 16 && qpw.count(var2, Items.DIAMOND) < 34, a.b("潒ᛮ鰵Ɉ覝༭땴㲒ꊞ⡤꾹嗝\udb0e䋫", -2051313864) + qpw.count(var2, Items.DIAMOND));
      ffu(qpw.count(var2, Items.ANCIENT_DEBRIS) == 0, a.b("ᅐ棠\ue234籕\uf799焲쬲䊍\udcd3噹퇾⯋ꔍ㲤뛪『詀ו", 1237061926) + qpw.count(var2, Items.ANCIENT_DEBRIS));
      ffu(var2.getStack(32).isOf(Items.GOLD_INGOT), a.c(44093101, "컛띫㶿ꏞ⠒꺹ᒹ鴛͛觩ม\uf404窛\ue32d楽\uef84嗜\uda5e") + var2.getStack(32));
      ffu(
         qpw.count(var2, Items.REDSTONE) == 5,
         a.d("誆\uf320秲\ue794汄\ueaee傼\ud946䝜", -819132110, 199787471)
            + qpw.count(var2, Items.REDSTONE)
            + a.d("ꐛ\udda2圮쥉䊑쐺總\uf78d槟\ue36e擱麕ၞ", -527512244, -1739822726)
      );
      ffu(qpw.count(var2, Items.COBBLESTONE) == 0, a.b("\uea5e鏰ᤸ蝌\u0cd0訶び릐⟒괪⪪킏希잡䷨쬄煓ﺛ摦\ue275殅ᇗ齭ҡ苉\u085d놺㿷ꔍ⌙ꣾ嘩\udc7d䖕", 502852118));
      ffu(qpw.count(var2, Items.DIAMOND_BLOCK) == 0 && qpw.count(var2, Items.GOLD_BLOCK) == 0, a.b("\ud93bꂄ⩔됩㿶륟͟諠ᒾ鸔ᦓ\ue3a6浠\uf4c9纇\uf863䈭", -1880696504));
      ffs(
         var0,
         var0x -> {
            ServerWorld var1x = var0x.getEntityWorld();
            Inventory var2x = ffn(var1x, feb);
            int var3x = ffo(var2x, Items.DIAMOND_BLOCK);
            int var4 = ffo(var2x, Items.GOLD_BLOCK);
            int var5 = ffo(var2x, Items.ANCIENT_DEBRIS);
            int var6 = 0;

            for (int var7 = 0; var7 < var2x.size(); var7++) {
               ItemStack var8 = var2x.getStack(var7);
               if (!var8.isEmpty() && !var8.isOf(Items.DIAMOND_BLOCK) && !var8.isOf(Items.GOLD_BLOCK) && !var8.isOf(Items.ANCIENT_DEBRIS)) {
                  var6 += var8.getCount();
               }
            }

            int var9 = var1x.getEntitiesByClass(ItemEntity.class, new Box(feb).expand(16.0), var0xx -> true).size();
            int var10 = ffo(ffn(var1x, fed), Items.EXPERIENCE_BOTTLE);
            System.out
               .println(
                  a.b("ᔣ沑\ue650砷\uf3a5畀켂䛥\ud8bd剘허⾲ꅨ㣏늛㑭蹫Ơ魗ᴗ铸\ueeb4恗﯂綰\uf769他삅婳\udc28垠ꥌ⌍뫿㲠똙ঘ", 719394148)
                     + var3x
                     + a.b("\ued72钄ṟ耭௲赸㜖뻩₵ꨈⷓퟴ", 3206494)
                     + var4
                     + a.b("⒈嵽\ud7af䧙숞䒴\ufefd睂", -2060180320)
                     + var5
                     + a.d("珖ਨ胠ẍ镗Ᏹꧭ", -1677653703, 1563589320)
                     + var6
                     + a.b("噶⾛ꔔ㬡냠㙌谀ױ鮻ᄋ障沬\ue26e箋\uf18c睡촣䊷\ud846帔ퟱ궶⍀", 1291277889)
                     + var9
                     + a.d("慇ᢪ鈥ఌ蟓Ĳ", -1819238829, -735248590)
                     + feo
                     + a.d("帏➳굳㌜", -1132465508, -226644809)
                     + var10
                     + a.b("ꏫ\uda06傉캾䕠쏑禉\uf03c港\ue497捇餤ឧ", -500522042)
                     + ffo(ffn(var1x, fec), Items.GOLDEN_CARROT)
               );
            ffu(var3x >= 40, a.c(-1896778220, "癫࿗蔌᭱邤ᘔ걍◸믥ㅚ뚊䳷숨宁톁圹\ued71拮\uf809繄\uf7be趪͝额Ỻ鐶ⷕ") + var3x);
            ffu(var4 >= 3, a.b("Ⱓ喚\udf4a䄳쪠䱓\uf60e翼\ue1af欖\uecdd\u16ff顡Ǘ诊൯뜼㣠ꈖ␃귥\ud7ac夂슃", -1667683236) + var4);
            ffu(var5 == 3, a.b("䗒㱢뚶⣗ꌛ▰龰ᘈ衐ʯ蔨罅\uf19f桫\ue27c撜\udecb儇쯤", 410797477) + var5);
            ffu(var6 == 0, a.d("न炅穀搭\uefeb楆팔嫢쒴乂짔㎬뵤Ⓝ껕⡰鈣᷻蝇Ř裭\uf2b2簂\ue7df憨\ueb61劁\udc99䙩쁶䮑땜㼞ꚪ₽ꨝᗒ龾ᤧ肌", 1474322924, -2073794401) + var6);
            ffu(var9 == 0, a.d("⽻囗\udc15䉬즥佇\uf540粭\ue2e8桄\uef8fᗧ魾ʀ裉ู됢㮲ꄔ✑꺲퓿婁쇕䟹촯璉響怦\ue625涌", 1840988829, -397775472) + var9);
            ffu(var10 > feo, a.c(174739957, "冄⠴ꊨ㲡띾ㆿ讯ɏ鰃ᚵ酴欔\ue5c2簷\uf62d烛쪎䕄\udfb8妽큖ꨊ⓼뽕㤢뎃ੳ萩ồ颔ጠ"));
            ffu(ffo(ffn(var1x, fec), Items.GOLDEN_CARROT) == 66, a.d("홲꿁━뭰ズ또ౄ藦ᯭ酉ᚐ\uecef戳\ufbcc燈\uf73c䵮슾堄", 253673193, -698914581));
         }
      );
   }

   private static void ffh(MinecraftServer var0, BlockPos var1) {
      ServerWorld var2 = var0.getOverworld();
      fea = var1.add(0, 0, 200);
      feg = var1.add(4, 0, 4);

      for (int var3 = (fea.getX() >> 4) - 2; var3 <= (fea.getX() >> 4) + 2; var3++) {
         for (int var4 = (fea.getZ() >> 4) - 2; var4 <= (fea.getZ() >> 4) + 2; var4++) {
            var2.getChunk(var3, var4);
            var2.setChunkForced(var3, var4, true);
         }
      }

      for (int var8 = -12; var8 <= 12; var8++) {
         for (int var10 = -12; var10 <= 12; var10++) {
            var2.setBlockState(fea.add(var8, -1, var10), Blocks.STONE.getDefaultState(), 3);

            for (int var5 = 0; var5 <= 4; var5++) {
               var2.setBlockState(fea.add(var8, var5, var10), Blocks.AIR.getDefaultState(), 3);
            }
         }
      }

      feb = fea.add(1, 0, 0);
      fec = fea.add(4, 0, 0);
      fed = fea.add(7, 0, 0);
      fee = fea.add(8, 0, 0);
      fef = fea.add(3, 0, -4);
      BlockPos var9 = fea.add(-3, 0, 0);

      for (BlockPos var7 : new BlockPos[]{feb, fec, fed, var9}) {
         var2.setBlockState(var7, Blocks.CHEST.getDefaultState(), 3);
      }

      var2.setBlockState(fee, Blocks.CRAFTING_TABLE.getDefaultState(), 3);
      ffm(var2, feb.north(), a.b("廗❶귔㏛롳", -1756144909));
      ffm(var2, fec.north(), a.d("ﮖ舎ࣘ隬ᴇ鯄⇨", 669578056, -1923674930), a.d("䁟㧬덁ⵊꚙ․騉", 560690363, -227266337));
      ffm(var2, fed.north(), a.d("淤ᒞ騿ѯ迌ॴ", -313918324, -1932160567));
      ffm(var2, var9.north(), a.c(1678566624, "\ue0c6饧Ꮃ跈\u061c肦"));
      Inventory var12 = ffn(var2, fec);
      var12.setStack(3, new ItemStack(Items.GOLDEN_CARROT, 64));
      var12.setStack(5, new ItemStack(Items.GOLDEN_CARROT, 64));
      Inventory var14 = ffn(var2, fed);

      for (int var15 = 0; var15 < 3; var15++) {
         var14.setStack(var15 * 2, new ItemStack(Items.EXPERIENCE_BOTTLE, 64));
      }

      ffn(var2, var9).setStack(0, new ItemStack(Items.DIRT, 10));
      ffj(var0);
      ServerTickEvents.END_SERVER_TICK
         .register(
            (EndTick)var0x -> {
               feh++;
               ServerPlayerEntity var1x = var0x.getPlayerManager().getPlayer(fdz);
               if (var1x != null) {
                  if (fej >= 0L && feh >= fej) {
                     fej = -1L;
                     ffq(var0x, fea.add(0, 0, -70));
                     fep.add(a.d("檆\u137e", 465528863, -157613329) + feh / 20.0 + a.d("ꨔ펪夷읉䳅쩰瀡", 750791080, -1763933285));
                  }

                  if (fei >= 0L && feh >= fei) {
                     fei = -1L;
                     ffq(var0x, fef);
                     fep.add(a.b("揑ᨩ", -1854381145) + feh / 20.0 + a.c(2125335949, "ණ琕ﺁ惷\ueb22涛"));
                  }

                  if (System.getenv(a.d("敟᳤阴\u085d華Գ뽲㚇\ua8df≥ꖬ忖턇䢥싴䐃", -894414678, -2122828381)) != null
                     && var1x.currentScreenHandler instanceof CraftingScreenHandler var2x
                     && feh % 5L == 0L) {
                     StringBuilder var6 = new StringBuilder(a.b("蜊", -1607628976));

                     for (Slot var5x : var2x.getInputSlots()) {
                        var6.append(var5x.getStack().getCount())
                           .append(var5x.getStack().isEmpty() ? "" : fft(var5x.getStack().getItem()).substring(0, 2))
                           .append(' ');
                     }

                     System.out
                        .println(
                           a.d("㚯伟었寯큿四\uec93敯ﭴ", -988344553, 999111106)
                              + var6
                              + a.b("\ue8b1酽ᯡ薊\u0e5c袤", 629729514)
                              + var2x.getOutputSlot().getStack()
                              + a.b("ෆ琥ﻡ悃\ueb1f", 1612123619)
                              + var2x.getRevision()
                              + a.b("幅➠괺", 690445926)
                              + feh
                        );
                  }
               }
            }
         );
   }

   private static void ffi(MinecraftServer var0) {
      CommandDispatcher var1 = var0.getCommandManager().getDispatcher();
      var1.register((LiteralArgumentBuilder)CommandManager.literal(a.c(-421011110, "\ue13e颀ለ豽ި")).executes(var0x -> {
         fej = feh + 30L;
         return 1;
      }));
      var1.register((LiteralArgumentBuilder)CommandManager.literal(a.d("择᭟醎\u0ff7", -467503315, 1681528232)).executes(var0x -> {
         ServerPlayerEntity var1x = ((ServerCommandSource)var0x.getSource()).getPlayerOrThrow();
         var1x.sendMessage(Text.literal(a.b("값핧後\ue707䨬쳠犱ﭗ攆\uefb9桠鈐Ჹ蔊༫覬㎝밻⋦꒶ⷆ坖\udd9c䙧쁭䫉\uf373紫\ue7a0憍\uea36ᓢ麠̈́腰ள됑㸕룄╢꾺톍完\udc2e䊘첝畁", 2093919386)));
         fei = feh + 60L;
         return 1;
      }));
      var1.register(
         (LiteralArgumentBuilder)CommandManager.literal(a.b("ȍ箫\uf174漙\ue4d9", 1814561386))
            .executes(
               var0x -> {
                  ServerPlayerEntity var1x = ((ServerCommandSource)var0x.getSource()).getPlayerOrThrow();
                  var1x.openHandledScreen(
                     new SimpleNamedScreenHandlerFactory((var0xx, var1xx, var2x) -> ffk(var0xx, var1xx), Text.literal(a.d("䱃㗩뽃ⅎꫯⰯ陾", 1675479264, -1475706747)))
                  );
                  return 1;
               }
            )
      );
      ServerPlayerEntity var2 = var0.getPlayerManager().getPlayer(fdz);
      if (var2 != null) {
         var0.getPlayerManager().sendCommandTree(var2);
      }
   }

   private static void ffj(MinecraftServer var0) {
      try {
         Path var1 = var0.getSavePath(WorldSavePath.DATAPACKS).resolve(a.d("ⱋ嗰\udf20䅉쪝䰽\uf678美", 125219284, -497508879));
         Files.createDirectories(var1.resolve(a.b("㋟䭫솭忉푐动\ue8f1愃ｄ痶\uf234ࡓ蚃Ὡ镧ᎁ꧈☓벹㫽", 712651439)));
         int var2 = SharedConstants.getGameVersion().packVersion(ResourceType.SERVER_DATA).major();
         Files.writeString(
            var1.resolve(a.d("䎺㨚냋⺲ꔠ⏒馏ၰ踧҇荁", -1474930666, 479861719)),
            a.b("鄄\ue8ec扭ﰍ矘\uf161䭻슒岌홤凱ꮁ╀볡㚣끉ਟ藊ὤ餳Ⴥ櫘\ue473羺女獚쫪䒣\ude03堆펤ⵣꜫ㺌룑㉮跶ރ腗ᣗ銱\uec49昇\ue1a9筲\uf516䲓옺", -2059759281)
               + var2
               + a.c(-609008157, "䗁㱾뛢⢟ꍑ◇龭ᙕ蠗ʹ蕦缂\uf183株")
               + var2
               + a.b("\uf62c辝", 2030564947),
            StandardCharsets.UTF_8
         );
         Files.writeString(
            var1.resolve(a.d("팏ꪻ⁽븙㖀델ड胓Ẕ鐦Ꮴ\ue983杓ﺹ璷\uf251䠘쟃嵩\udb2d劐⢖\ua62d㷓뮑ㅍ裥ڴ鱛ᨃ釻潮\ue538糕慎", -1997005760, 1047645960)),
            a.d(
               "ﰿ藗དྷ鄮\u1af0鱔♀꾩\u31ee묐㳇욱䡭퇚官\udd7a朲\ue8f1爌\uf404緢ޠ褔\u12d7钵ṣꟙ⦰덫㔡뺛䁛쨁叱헤彛\ue082檲\uec63症ﾉ腺ଡ貍ᙑ须↰\uab19ⴙ뛌㢥쉤䮒췍地\ud933抝\ue459渪\uf7ea祊̇蒸\u0ef1遟ᦗꏆ╙꽠ビ먎㱱엂佹턠媽\udce4晛\uef8a熕הּ絧ګ蠋ቲ鯪ᵗꜚ⢾닷㐅붍䞖줫劀퓉幉\ue03c槨\uf352甃ﻣ肣ਕ鏘ᗧ齩⃐ꪄⱽ똕㾕셁䬂쳱嚢\ud804憃\uebfe洡\uf6f8磏Ȥ葭ඕ靀ᤴꋮ⒧긇㟇릱䍴쒋了큺娭\ue390敁\uef31烬福簗ַ迶ᅷ髓Ეꙥ⠭놆㬁뵦䛶제分\udbfc巫\ue740梉\uf289瑼︨螒ृ錣ᓣ鹕‘ꦧ㎫딇㻘삼䩸폒喑\udf4b愵\ueae2汯\uf603翽Ʒ謈ು隻ᠭꆔ⯋굹㜤룱䉛쐒䶵ퟺ奄\ue2df撮",
               -669155324,
               -395346808
            ),
            StandardCharsets.UTF_8
         );
         System.out.println(a.d("ﺸ蜊\u0dcb鎬ᠾ黛⒙굾㌦맙㸐쐥䫷퍓夕\udff5斫\uea78烃\uf6d9罨\u0530讞ၐ阣᳧ꔀ", -631022284, 1113367541) + var2 + a.b("꓄\udd34埲짗", -1318345504) + var1);
      } catch (Exception var3) {
         System.out.println(a.b("ㄹ䢋쉊尭ힿ党\ueb18拿ﲧ癘\uf191ம蕸ᲆ隑ၥ\uaa3f◻뽙㤙냬쪵䑗\udf9c", -33607357) + var3);
      }
   }

   private static GenericContainerScreenHandler ffk(int var0, PlayerInventory var1) {
      final SimpleInventory var2 = new SimpleInventory(27);
      ItemStack var3 = new ItemStack(Items.LAPIS_LAZULI);
      var3.set(DataComponentTypes.CUSTOM_NAME, Text.literal(a.c(1992469431, "\uab18툷峵슜䤾쾈痈ﰨ")));
      var2.setStack(11, new ItemStack(Items.WHEAT));
      var2.setStack(13, var3);
      var2.setStack(15, new ItemStack(Items.ROTTEN_FLESH));
      ffc.clear();
      ffc.add(Items.LAPIS_LAZULI);
      return new GenericContainerScreenHandler(ScreenHandlerType.GENERIC_9X3, var0, var1, var2, 3) {
         private boolean fdu;

         @Override
         public void onSlotClick(int slotIndex, int button, SlotActionType actionType, PlayerEntity player) {
            if (slotIndex >= 0 && slotIndex < 27) {
               if (this.fdu) {
                  ItemStack var7 = var2.getStack(slotIndex);
                  if (actionType == SlotActionType.THROW && !var7.isEmpty()) {
                     if (var7.isOf(Items.IRON_INGOT) && fdx.fey-- > 0) {
                        return;
                     }

                     if (fdx.ffc.contains(var7.getItem())) {
                        fdx.ffc.remove(var7.getItem());
                     } else {
                        fdx.ffc.add(var7.getItem());
                     }

                     var2.setStack(slotIndex, fdx.ffl(var7.getItem()));
                  }
               } else {
                  if (slotIndex == 13 && actionType == SlotActionType.PICKUP) {
                     this.fdu = true;
                     var2.clear();
                     Item[] var5 = new Item[]{Items.REDSTONE, Items.LAPIS_LAZULI, Items.COAL, Items.IRON_INGOT};

                     for (int var6 = 0; var6 < var5.length; var6++) {
                        var2.setStack(10 + var6 * 2, fdx.ffl(var5[var6]));
                     }
                  }
               }
            }
         }
      };
   }

   private static ItemStack ffl(Item var0) {
      ItemStack var1 = new ItemStack(var0);
      boolean var2 = ffc.contains(var0);
      var1.set(
         DataComponentTypes.LORE,
         new LoreComponent(
            List.of(
               Text.literal(a.c(606977887, "뿲웓䠑홳嶬\udb10敉\ueca2独\uf8ce")),
               Text.literal(
                  var2
                     ? a.c(858614413, "樵ጕ馫ߐ谋ે뀓㤣ꌪ⦙긺吷\udef3䌮줆侎\uf5bd穩\ue0d0抋\ueb66醰\u1fc5聇ذ賠㔦뭾⇻ꞢⰜ")
                     : a.d("Მ斻\uef05煾瘟籩욽侍햄強\ud894⊙ꡝ㖀뾨㤠茓ೇ陾ᐥ鷈\ue71e楩\uf6e9烯祐䏽췙圧턄媿ꑣ", -1103542309, 1759665095)
               )
            )
         )
      );
      return var1;
   }

   private static void ffm(ServerWorld var0, BlockPos var1, String... var2) {
      var0.setBlockState(var1, Blocks.OAK_WALL_SIGN.getDefaultState().with(WallSignBlock.FACING, Direction.NORTH), 3);
      if (var0.getBlockEntity(var1) instanceof SignBlockEntity var3) {
         SignText var6 = new SignText();

         for (int var5 = 0; var5 < var2.length; var5++) {
            var6 = var6.withMessage(var5, Text.literal(var2[var5]));
         }

         var3.setText(var6, true);
         var0.updateListeners(var1, var0.getBlockState(var1), var0.getBlockState(var1), 3);
      }
   }

   private static Inventory ffn(ServerWorld var0, BlockPos var1) {
      return (ChestBlockEntity)var0.getBlockEntity(var1);
   }

   private static int ffo(Inventory var0, Item var1) {
      int var2 = 0;

      for (int var3 = 0; var3 < var0.size(); var3++) {
         if (var0.getStack(var3).isOf(var1)) {
            var2 += var0.getStack(var3).getCount();
         }
      }

      return var2;
   }

   private static ItemStack ffp(ServerPlayerEntity var0, int var1) {
      ItemStack var2 = new ItemStack(Items.NETHERITE_PICKAXE);
      Registry var3 = var0.getEntityWorld().getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
      var2.addEnchantment(var3.getOrThrow(Enchantments.EFFICIENCY), 5);
      var2.addEnchantment(var3.getOrThrow(Enchantments.MENDING), 1);
      var2.setDamage(var2.getMaxDamage() - var1);
      return var2;
   }

   private static void ffq(MinecraftServer var0, BlockPos var1) {
      var0.getCommandManager()
         .parseAndExecute(
            var0.getCommandSource(),
            String.format(Locale.ROOT, a.b("ꕧ\udcd2噑젥䎤앆缐\uf6ea梪\ue24c旙龭ᄻ裎ʘ葢㸲놴⭁관ⓧ座퀕", -2061196028), fdz, var1.getX() + 0.5, var1.getY(), var1.getZ() + 0.5)
         );
   }

   private static MinecraftServer ffr(MinecraftClient var0) {
      return var0.getServer();
   }

   private static void ffs(MinecraftClient var0, Consumer<ServerPlayerEntity> var1) {
      IntegratedServer var2 = var0.getServer();
      ffa = false;
      var2.execute(() -> {
         ServerPlayerEntity var2x = var2.getPlayerManager().getPlayer(fdz);
         if (var2x != null) {
            var1.accept(var2x);
         }

         ffb = feh;
         ffa = true;
      });
   }

   private static String fft(Item var0) {
      return Registries.ITEM.getId(var0).getPath();
   }

   private static void ffu(boolean var0, String var1) {
      if (!var0) {
         fek++;
         System.out.println(a.d("吅\u2db7ꝶ㤑늃㑦踤߃馛\u137e铮溔\ue04e秹\uf3a2甘켑䃇\uda7c尨헖꾆Ⅻ몠", 375045787, -254416156) + var1);
      }
   }

   private static void ffv(kfe var0, String var1, Object var2) {
      for (vmo var4 : var0.getSettings()) {
         if (var4.getName().equals(var1)) {
            if (var4 instanceof vkl var5) {
               var5.set((Boolean)var2);
            } else if (var4 instanceof vmc var6) {
               var6.set(((Number)var2).doubleValue());
            } else if (var4 instanceof vmu var7) {
               var7.set((String)var2);
            }
         }
      }
   }

   private static void ffw(String var0, boolean var1) {
      kfe var2 = Flow.getInstance().getModuleManager().getByName(var0);
      if (var2 != null) {
         var2.setEnabled(var1);
      }
   }

   private static void ffx(MinecraftClient var0) throws Exception {
      for (Field var4 : Mouse.class.getDeclaredFields()) {
         if (var4.getName().equals(a.c(1643402817, "嘮⾉ꕝ㬭냦㙊谧\u05f5鮦ᄟ雂沲"))) {
            var4.setAccessible(true);
            var4.setBoolean(var0.mouse, true);
         }
      }
   }

   private static void ffy(MinecraftClient var0, String var1) {
      ScreenshotRecorder.saveScreenshot(
         var0.runDirectory, a.b("쇰롋㊛곲❠ꇎ", -941833840) + var1 + a.c(-1110502141, "ᔩ泆\ue60b硳"), var0.getFramebuffer(), 1, var0x -> {}
      );
   }

   private static void ffz(MinecraftClient var0, String var1) {
      var0.getNetworkHandler().sendChatCommand(var1);
   }
}
