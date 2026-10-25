package a;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import flow.Flow;
import flow.dev.a;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents.After;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents.Before;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.decoration.DisplayEntity.TextDisplayEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket.Action;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.network.ServerCommonNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Direction.Axis;
import org.lwjgl.glfw.GLFW;

final class gef {
   private static final String geg = System.getenv().getOrDefault(a.c(2061907829, "㜼亇쑗娾톌坐\ued11擤謁瀆\uf7cfථ荸᫋邍"), a.b("挏᪹遵", 1141400420));
   private static final boolean geh = System.getenv(a.c(970909087, "\ue5c9鱲ᚢ裋\u0379薥㿤똑⡉ꋳ┺\udf40冑젳䉢쒕")) != null;
   private static final String gei = System.getenv().getOrDefault(a.c(1537989051, "\ud9edꁖ⪆듯㽝릁π訵ᑭ黗ᤞ\ue374涨\uf40c繀\uf8a6"), a.c(-1036911146, "ﶾ萌ໟ邪"));
   private static volatile BlockPos gej;
   private static volatile Direction gek;
   private static final boolean gel = geg.equals(a.c(-698367663, "섧뢒㉓갢⟠"));
   private static final int gem = 8;
   private static final int gen = gel ? 10 : 6;
   private static double geo = -1.0;
   private static double gep = -1.0;
   private static int geq = -1;
   private static int ger;
   private static int ges = -1;
   private static Entity get;
   private static volatile int geu;
   private static int gev = -1;
   private static volatile int gew;
   private static final List<String> gex = new ArrayList<>();
   private static final int gey = 3;
   private static final List<gec> gez = new ArrayList<>();
   private static final List<BlockPos> gfa = new ArrayList<>();
   private static final List<String> gfb = new ArrayList<>();
   private static boolean gfc;
   private static boolean gfd;
   private static long gfe;
   private static gec gff;
   private static BlockPos gfg;
   private static gec gfh;
   private static long gfi = -1L;
   private static long gfj = -1L;
   private static int gfk;
   private static int gfl;
   private static int gfm;
   private static String gfn;
   private static TrackedData<Text> gfo;
   private static int gfp;
   private static int gfq;
   private static float gfr;
   private static float gfs;
   private static boolean gft;
   private static final List<Double> gfu = new ArrayList<>();
   private static final List<Double> gfv = Collections.synchronizedList(new ArrayList<>());
   private static float gfw;
   private static float gfx;
   private static boolean gfy;
   private static volatile long gfz;
   private static String gga = "";
   private static int ggb;
   private static boolean ggc;
   private static boolean ggd;
   private static boolean gge;
   private static int ggf;
   private static double ggg;
   private static long ggh = -1L;
   private static volatile int ggi = Integer.MAX_VALUE;
   private static double ggj = -1.0;

   private gef() {
   }

   static boolean tick(MinecraftClient var0, int var1) throws Exception {
      ClientPlayerEntity var2 = var0.field_1724;
      ghc(var0);
      boolean var3 = geg.equals(a.c(165453408, "鸌\ue7b0浫\uf316磃ﹳ䐪췌"));
      boolean var4 = geg.equals(a.b("暃Ἷ闢", -34380060)) || var3 || gel;
      if (var1 == 1) {
         GLFW.glfwSetCursorPosCallback(var0.method_22683().method_4490(), (var0x, var2x, var4x) -> {});
         ghb(var0, a.d("\uf5d5豌ڛ飆ጣ閒\u2fdb\ua630㡨", 1887683373, 1204958896), false);
         ghb(var0, a.d("濃ᙆ鲂˳褍ྟ뗌㰹", -672883749, -1220479914), false);
         ghe(var0, a.c(982801653, "岃┴꿫㆒멍㳾蚦བ酌ᮮ鱻昍\ue8de煰לּ線잘"));
         ghe(var0, a.c(1392789861, "䤥\u3097멄\u2436꿧⥁鍆\u1af0蒡ฏ觏珻﵌擎\ueece桬툱巵읇䄑죵늱㰟ꟈ↶ꬩኋ鳛ج聽\u0bde\uf51b罀\ue6e5悰\uea06嗁"));
         ghe(var0, a.b("\u0600羲\uf561欓\ue0c2晤\udc63嗕쮄䄪웪㳞뉩⯫ꇫ❈鴐\u12d7衾ี蟅ﶁ猽\ue8e1溘\ue40c嶮폾䤉콘䓻먾づ꧀⾕ꔣ\u1ae4", 636421696));
         ghe(var0, a.c(-507759921, "㊍䬿쇬從푏勩\ue8ee慘）疧\uf267ࡓ蛤ὦ镦Ꮩꦑ♎볲㪿덣줛䞷\udc7c娙탎楼\ue763綅ﯕ灦躷Ө鴉ᭊ醯\u2e7eꐈ⋋"));
         ghe(var0, a.d("볨앖侌퇹娽\udcde曭\uef2f", 1641519256, -731700197));
         ghe(var0, a.b("ႆ椪\ue3fd綄\uf616烴쪱䍑\udd5a垯큹⨐", 116789502));
         ghe(var0, a.b("\u3098䤯쏰嶉홉僿\ueab5捍ﵗ瞢\uf07aਠ蓒ᵻ霽ᇉꮈ\u2456뻹㢟녒쬙䖥\ude7d塇틐此\ue538翐聯", 1747661025));
         ghe(var0, a.d("뾖옡䳾튇奇\udff1斻\uec43牙\uf8ac罴蔧\u0bd2鉮᠌點⒀ꭇ\u31ed랻㹋䐓쫧兰휈巔\ue478樿", 1508632464, 1544378493));
         var0.field_1690.method_42503().method_41748(12);
      }

      if (var1 == 5) {
         BlockPos var5 = var2.method_24515();
         gfn = var2.method_5477().getString();
         IntegratedServer var6 = var0.method_1576();
         var6.execute(() -> ggp(var6, var5, var4));
      }

      if (var1 == 40) {
         IntegratedServer var14 = var0.method_1576();
         var14.execute(
            () -> {
               ServerPlayerEntity var2x = var14.method_3760().method_14566(gfn);
               ItemStack var3x = new ItemStack(Items.field_22024);
               var3x.method_7978(var14.method_30611().method_30530(RegistryKeys.field_41265).method_46747(Enchantments.field_9131), 10);
               var3x.method_57379(
                  DataComponentTypes.field_49632,
                  new LoreComponent(
                     List.of(Text.method_43470(a.c(-2035397662, "䭋㉪벟⊼ꤓ⿕闾ᰅ艓࣠轆煗￩晘")), Text.method_43470(a.d("墜↽꽅ㄘ뫌㱳蘥ྮ間Ὃ", -1566566347, 1320239108)))
                  )
               );
               var2x.method_31548().method_5447(3, new ItemStack(Items.field_8802));
               var2x.method_31548().method_5447(20, var3x);

               for (int var4x = 9; var4x < 36; var4x++) {
                  if (var4x != 20 && var4x != 35) {
                     var2x.method_31548().method_5447(var4x, new ItemStack(Items.field_20412, 64));
                  }
               }

               for (int var6x = 5; var6x < 9; var6x++) {
                  var2x.method_31548().method_5447(var6x, new ItemStack(Items.field_20394, 64));
               }

               gec var7x = gez.get(0);
               BlockPos var5x = var4 ? var7x.warp : gfg;
               ggz(var14, var5x, 180.0F, 10.0F);
               gff = var4 ? var7x : null;
            }
         );
      }

      if (var1 == 60) {
         var2.method_31548().method_61496(3);
      }

      if (!ggc && var1 >= 140 && var2 != null && ggn(var2)) {
         ggc = true;
         kfe var15 = Flow.getInstance().getModuleManager().getByName(a.d("\ue64f鿊ᔘ譲\u0087蘒㱆떼", -1255455109, -203906947));
         nfi.solo = var4;
         nfi.anarchies = a.b("귇푷庥색䬒춲矠︕恒\ueaef洭靝ᦈ耧\u0a78貘㛖뤄", -519197212);
         nfi.minMineMs = 15000L;
         nfi.maxMineMs = gel ? 110000L : (var4 ? 75000L : 45000L);
         gev = var2.method_31548().method_18861(Items.field_8477);
         ghb(var0, a.d("縱ި赿ጢ飇Ṷꐿⷔ뎌", -30546963, 405511572), false);
         ghb(var0, a.c(1578336311, "聩茶猶\ued49暞\ue02d婩펨䷚읰"), false);
         ghb(var0, a.c(1937055168, "ᶉ搌\ueede炴ﭘ緒잁乳"), false);
         var0.method_1576().execute(() -> {
            long var0x = gfe;

            for (gec var3x : gez) {
               var3x.refreshAt += var0x;
            }

            gfd = true;
         });
         if (geh) {
            qdz.trace = var0x -> System.out.println(a.b("\u173e溂\ue45f穩", -1471670434) + var0x);
         }

         var15.setEnabled(true);
         gfp = var1;
         gfq = var1 + (gel ? 2000 : (var4 ? 1700 : 4000));
         System.out.println(a.c(1373211119, "覓\uf026竲\ue488漚\ue9ff厽\uda5a䐂컽䤴댖㷆ꑢ⸢꣕ዎ") + geg);
      }

      if (ggc && var1 > gfp && var2 != null) {
         float var16 = var2.method_36454();
         float var18 = var2.method_36455();
         if (gft) {
            double var7 = MathHelper.method_15393(var16 - gfr);
            double var9 = var18 - gfs;
            double var11 = Math.sqrt(var7 * var7 + var9 * var9);
            gfu.add(var11);
            if (var11 > 35.0) {
               String var13 = ((nfl)Flow.getInstance().getModuleManager().getByName(a.c(100858135, "丹胛ਉ鑣ᾖ餃⍗ꪭ"))).debug();
               System.out
                  .println(
                     String.format(
                           Locale.ROOT,
                           a.d("䎳㨆냒⺨ꔺ⏉馑ၮ蹶ғ荁礷\uf7fc渃\ue404押\ud8eb圱춞䮛숪렢㚉굎⭦ꆲ᠊附\u0ce4諾Şﾔ痐\uec3e樺\ue0cd彊픢召쩊䀞㺧등㍋ꦃ➥鸽ᒟ鋋ऑ蝽緻\uf40a爝\ue8e7暺\udd13寄퇹", 541572881, 127073524)
                              + var0.method_1569()
                              + a.d("ᮢ或\ue893皱ﴶ箘쇗䡨혯峈", 405123969, 1953474569),
                           (var1 - gfp) / 20.0,
                           gfr,
                           var16,
                           gfs,
                           var18,
                           var13.substring(0, var13.indexOf(32)),
                           var2.method_73189()
                        )
                        + a.b("孜", 1314020221)
                        + ((nfl)Flow.getInstance().getModuleManager().getByName(a.d("껉흌嶞쏴䠁캔瓀ﴺ", 1209790223, -62963313))).action()
                  );
            }
         }

         gfr = var16;
         gfs = var18;
         gft = true;
         nfl var20 = (nfl)Flow.getInstance().getModuleManager().getByName(a.d("\ue01a馟ፍ货ے聇㨓돩", -337979953, 2088973724));
         String var8 = var20.debug();
         String var21 = var8.substring(0, var8.indexOf(32));
         if (!var21.equals(gga)) {
            if (gga.equals(a.d("〿䦊썞崤", 698466473, 676524255)) && var21.equals(a.b("⾍嘽\udce8䊓쥉俹", -2019217457)) && ggj < 0.0) {
               ggj = (var1 - gfp) / 20.0;
            }

            gga = var21;
            System.out.println(a.b("潆ᛳ鰧ɝ觏༪땨㲏ꋗ⠲꾵喍", -1586139353) + (var1 - gfp) / 20.0 + a.d("辨\uf64a", 1305070154, -1533590125) + var8);
         }

         if (var8.startsWith(a.d("냤쥃䎘\uddf4", -524780108, 478858499)) && !ggd || var8.startsWith(a.c(-780286525, "얊밿㛫ꢑ")) && !gge && var1 - gfp > 1300) {
            if (var8.startsWith(a.b("民ᖶ齭ā", 1997433922))) {
               ggd = true;
            } else {
               gge = true;
            }

            ghd(
               var0,
               a.d("舾ﮛ煉\uef23擶\ue243堗퇭俺씎䋀뢠㘾", -1016964414, 1375590544)
                  + (var8.startsWith(a.c(393267519, "쥬냋㨐ꑼ")) ? a.c(-31466991, "\uda62ꏅ⤞띲") : a.d("挡᪔遀ฺ", 178712417, 1587711017))
            );
         }

         if ((var1 - gfp) % 200 == 0) {
            System.out
               .println(
                  a.c(-1067171860, "㾍䘸쳬劖\ud904忡\ue5a3汄\uf21c磹ｾՆ")
                     + (var1 - gfp) / 20.0
                     + a.d("嗔ⰶ", 1752225080, 2032763037)
                     + var8
                     + a.d("奆₧ꩫ㐆뾟", 2066111919, -1701772084)
                     + var2.method_24515().method_23854()
               );
         }
      }

      if (var1 == gfq) {
         kfe var17 = Flow.getInstance().getModuleManager().getByName(a.c(-1660277954, "⭷勲\ud820䙊춿䬪\uf17e碄"));
         String var19 = ((nfl)var17).debug();
         var17.setEnabled(false);
         gfd = false;
         ggm(var0, var19, var4, var3);
         return true;
      } else {
         return false;
      }
   }

   private static void ggm(MinecraftClient var0, String var1, boolean var2, boolean var3) {
      System.out.println(a.c(-184603588, "ⱈ嗽\udf29䅓쫁䰤\uf666羁\ue1d9欼\uecaaᛐ頍Ǹ讣ഞ띚㢞ꈲ⑴귑ퟓ奺슯䒝") + gei + a.d("Ἣ暉\uec40", -1666900598, 656802443) + var1);

      for (String var5 : gfb) {
         System.out.println(a.b("︡螔ീ錺ᢨ鹕␅근㏤", -581304763) + var5);
      }

      for (gec var26 : gez) {
         System.out
            .println(
               a.d("创⮮ꅺ㼀뒒", -643111397, 1632285800)
                  + var26.id
                  + a.b("ڔ缿\uf5be毘\ue00c暩\udced唊쭎䇲옷㰈", 1376650914)
                  + var26.refreshes
                  + a.b("ᤚ惩\uea2a瑆ﾕ礪썲䫐", -1193797326)
                  + var26.mined
                  + a.d("敥Მ陕࠳菲ԍ", 127374916, -2087718137)
                  + var26.minedOres
                  + a.c(952005461, "獴")
                  + String.join(a.b("ꛮ\udf03喌", -65624371), var26.events)
            );
      }

      System.out
         .println(
            String.format(
               Locale.ROOT,
               a.d("\uec2f閚\u1f4e脴દ豑㘍뿧↹\uab0fⲅ횴塧쇑䮉촽眽\uf8f1払\ue441淤ឦ餀ˀ蓠ห랝㧇ꌯ┩껜偂\uda10䏶얳佞\uf0cb窾ﱪ", 1869824359, 29863170),
               ggf * 60.0 / Math.max(1.0, ggg)
            )
         );
      ArrayList var25 = new ArrayList<>(gfu);
      var25.sort(Double::compare);
      double var27 = var25.isEmpty() ? 0.0 : (Double)var25.get(var25.size() - 1);
      double var7 = var25.isEmpty() ? 0.0 : (Double)var25.get((int)(var25.size() * 0.95));
      System.out
         .println(
            String.format(
               Locale.ROOT, a.d("퉇꯲Ω뽜㓎눫ࡹ膏ῌ镠ዠ\ue899昅ﾻ痭\uf310䥔욟屸\uda7d厗⧌ꝷ㲾몛す觰߱鵏ᬒ邴湠\ue424緊\ufbce焹캣䓞숔寽톧꽝┑ꋷ㡦뙓ཱྀ蔲̵颿ᛑ\uec0a斵", 839865520, -652245329), var7, var27
            )
         );
      ArrayList var9;
      synchronized (gfv) {
         var9 = new ArrayList<>(gfv);
      }

      var9.sort(Double::compare);
      double var28 = var9.isEmpty() ? 0.0 : (Double)var9.get(var9.size() - 1);
      double var12 = var9.isEmpty() ? 0.0 : (Double)var9.get((int)(var9.size() * 0.95));
      long var14 = var9.stream().filter(var0x -> var0x > 30.0).count();
      System.out
         .println(
            String.format(
               Locale.ROOT,
               a.d(
                  "\uddc8ꑽ⺩냓㭁붤߶踀၃髯ᵯ\ue716榚\uf03d穹ﲌ䛐줖号헶尐♃꣸㌧땉㾟虶࠴鋙ᓆ鼦懯\uebe1牔\uf457纯셴䬐췆呼\ude3cꂚ⪏굳㞨맀K諿\u0cbb靵ᥑ\ue3c6樵\uec65皔\uf88d䍭얭俜혅墼⋼ꕗ⼊뇛㡧舷ӌ躁ᄵ鮧",
                  110775105,
                  -1444309341
               ),
               var9.size(),
               var12,
               var28,
               var14
            )
         );
      ServerWorld var16 = var0.method_1576().method_30002();
      int var17 = 0;

      for (BlockPos var19 : gfa) {
         if (!var16.method_8320(var19).method_26215()) {
            var17++;
         }
      }

      ggo(gfk == 0, a.c(-285880556, "콾뛍㰃ꉩ⦯꼘ᕜ鲼ˢ蠗྆\uf5e7笧\ue292棋\uee71呿\udbbb䄈읈亷㓻멌↚Ɡⵧ") + gfk);
      ggo(gfl == 0, a.c(1450051436, "ܿ纘\uf44d樰\ue1e6杝\udd4a咴쪳䀔쟔㶧댠⫆ꂊ♺鰰Ꮸ褞༛蛽ﲥ爟\ue9db澻\ue577峂튎䡾츦䗈묃") + gfl);
      if (!var2) {
         ggo(gfm == 4, a.b("ଔ犪\uf826晖\ued85欠턧壐요䰩쯬㇎", -791409799) + gfm + a.d("\udc41ꗸ⽴넓㫋뱠٧辇ᇉ魳Ძ\ue6c9栍\uf1ee箪﵊䜃죉剶퐱嶜", -1963355030, 1563707422));
      }

      ggo(var17 == gfa.size(), a.b("\udf11ꚡⱴ눉㧃뼠Լ賐ኘ頿᾿\ue582歜\uf2ee碯︊", -374153371) + var17 + a.c(35258113, "Ｏ") + gfa.size());
      ggo(var28 <= 118.0, a.d("搔ᶤ靰झ芄Ѹ븧㟏꧈", -48410396, 1346385037) + var28);
      if (gel) {
         gec var29 = gez.get(0);
         int var32 = 289 * gen;
         int var20 = var0.field_1724 == null ? 0 : var0.field_1724.method_31548().method_18861(Items.field_8477) - gev;
         double var21 = ggj;
         System.out
            .println(
               String.format(
                  Locale.ROOT,
                  a.c(
                     -180534992,
                     "䇧㡒늆⳼Ꝯ\u218c鯛ሸ豧ۃ腚笱\uf5e3氓\ue604悺\udafc啫쿝䧍쁾멭㓐꼂⥱ꎨᨃ鐁ິ裵͛ﶎ矏\uee35栤\ue299嵋흻凬접䉇㲵뛴ㄝꯆ◻鰡ᚓ郎ୋ蕬羡\uf61b瀏\ueab1擤\udf5c妆펰䨠쒂뺇㥱댫ⷻꐝḈ颪ኢ负߉膳硳\uf295沀\ue733慪\udbd8切챾䚩삤뭋㗅꾾☫ꂕᫌ锿ཬ觞\u0005贈瓧\uef51楁\ue3ca已퐦仙죚䌷㵩랝⸏\ua87a⊮鴔ᜊ釷\u0ba1艑糚\uf6c7焽\ueb6f旊\udc4f噵킣䭒않뾤㦭뀖⫂ꓰὥ饺Ꮢ訋Ѳﺫ礛\uf30c涨\ue7f2帟\ud8c0労촢䟗쇇령㉳겨✓ꅚ᯾閧ఙ蛃 ﬥ痐\uefc3昺\ue068嫗픎余짻䏩㨙뒍⻳ꤥ⎞鷉ᑺ踬\u0891荃絳\uf7e4渐\ue854抟\udcf1圽톇䮏숴뱤㛆널"
                  ),
                  var29.mined,
                  var32,
                  geq,
                  var21,
                  var29.mined / Math.max(1.0, var21 > 0.0 ? var21 : (gfq - gfp) / 20.0),
                  ger,
                  ges,
                  var20,
                  gew,
                  (double)var29.mined / Math.max(1, gew),
                  geu
               )
            );
         ggo(var21 > 0.0 && var21 < 75.0, a.c(-2133174628, "囧⽛ꖅ㯾끠㚂貅Ը魮ᇛ队汽\ue2ef笊\uf145瞹춳䈯\ud898廎휲괦⏜렊㸻뒾ഐ荅ᦺ龴ᐝ") + var21);
         ggo(ges >= 0 && ges <= 4, a.b("㮘䈤죿嚂\udd57寧\ue1be桘\uf654粩ﭳā迄ᘡ鰻ᫍꃌ⽉뗦㎺먈쀔亣핵匁\ud995", 1104100326) + ges);
         ggo(geu == 0, a.d("셈룸㈶갓➐ꄽ᭣鋗\u0cc5虶ƨﮛ生\ueca9曯\ue011婔했似쥤䃔㫌둸\u2fe7꧌⌁骿ᒫ踋ࡌ菧絯", -1053360144, 1004814064) + geu + a.b("ᇟ栺\ue2f4粁\uf75e燹", 2080379385));
      } else if (var3) {
         gec var30 = gez.get(0);
         System.out
            .println(
               a.d("됸춍䝙\ud923励푄渚\ue7e3禰\uf303瓑躪j馒Ꮫ", -1291904548, -1231114874)
                  + var30.minedDiamonds
                  + a.b("媩⍜ꦂ㟻밠㪓胁ऺ靲ᶜ驃", -847488382)
                  + (var30.minedOres - var30.minedDiamonds)
                  + a.d("뙙쾧䕯\udb02僘홾汿\ue5c1箃\uf125盠賎ȕ鯠ᆲ靃ⴙꋝ㡸븮㞍䶈쌮壬\ude86呕\uedf7掷論罔\uf4beਫ", 1835788029, 672092324)
                  + ggi
                  + a.d("죐녩㯦ꖌ⹄ꢥኯ鬚", 2138602915, -995248805)
                  + (var30.y0 - 1)
                  + a.c(979438034, "৶灋\ufadc撬\uef6e槛펔娭")
                  + 3
                  + a.b("얀밴㛫꣖⌈ꖺΏ陞ࡕ苸Ԧ２熈\ue83d扩\ue493庙턉䮯춪", 833799613)
                  + ggj
                  + a.c(1892522599, "驅\ue3a7")
            );
         ggo(var30.minedDiamonds >= 4, a.c(-312276384, "\u0a0b玷塞朑\uecc4橴퀭始쟇䴻쫬゚빆⟶귡") + var30.minedDiamonds);
         ggo(ggi >= var30.y0 - 3, a.b("⫈卨\ud9a9䞟찊䪼\uf0e6礔\ue753涵\uea32ၟ麅ݱ赦\u0b96뇌㸙꒶⊯ꬔ텀忷쐢䉀죟煶ｾ旍", -684512591) + ggi);
         ggo(ggj > 0.0 && ggj < 70.0, a.d("寜≠ꢾ㛅뵛㮹膾ࠃ陕᳠鬤慆\uefd4瘪ﱸ窄샍余햾右\uda09ꀝ⻪딶㍁릜-蹽ᒀ鋆ᤦ\ue7a5淹\uf407爚\uf8e4䜩쵙䯄퉯", 333789177, 86994025) + ggj);
      } else if (var2) {
         ggo(gez.get(0).minedOres >= 25, a.c(-709099924, "︈螤ൠ錇ᢃ鹿\u2428귞㎊뤺㺭") + gez.get(0).minedOres);
      } else {
         gec var31 = gez.get(0);
         gec var33 = gez.get(1);
         ggo(var31.minedOres >= 10, a.c(2042564770, "ႚ椪\ue3f8綘\uf600炬쫨䌏\udd03") + var31.minedOres);
         ggo(var33.minedOres >= 10, a.b("\ue34a髺ါ蹈א荼㤸냟⻓", 2046747506) + var33.minedOres);
         ggo(
            var31.events.stream().anyMatch(var0x -> var0x.startsWith(a.c(984170285, "㽒䛴찤剁\ud981弦\ue56e泆\uf288硷ﾯך謞"))),
            a.d("മ璞﹖恳\uebe5流흆度샸䩈춊㞴륢\u209dꪇⱫ阣ᦡ荀Ԇ賲\uf6b7砓\ue3d4新", -1477220033, 1545102438)
         );
         ggo(
            var33.events.stream().anyMatch(var0x -> var0x.startsWith(a.c(-2048182920, "㔇䲡왱堔폔啳\uef3b暓\uf8dd爢\uf5faྏ腋"))),
            a.b("ꆜ\ud82c勤쳁䝗쇳篴\uf214汊\ue6f9愸鬆ᗐ谯ص胙㪑딓⿲ꦴ⁀娅풡佦줂", -1181769237)
         );
      }

      ggo(
         var1.contains(a.b("䏁㩬낥⻉ꔆ⎮馮", 561005490)) && !var1.contains(a.d("ꁪ\ud9c7匎쵢䚭쀅稅\uf3f9", -46435015, 69129519)),
         a.c(-760404681, "╌峢혪䡞쏂䔽ｯ皅\ue88e扫\ue5a4῏鄅ࢬ苦у븖") + var1
      );
      System.out
         .println(
            a.b("蠉\uf1bc筨\ue512満\ue865刧\udbc0䖘콽", 1379108974)
               + (ggb == 0 ? a.b("종넥㯤ꖕ", -1145190191) : a.d("匿⪉ꁒ㸦떝㌤", -139110730, 98895305) + ggb + a.c(1632743631, "냧"))
         );
   }

   private static boolean ggn(ClientPlayerEntity var0) {
      for (int var1 = 0; var1 < 36; var1++) {
         if (var0.method_31548().method_5438(var1).method_31574(Items.field_22024)) {
            return true;
         }
      }

      return false;
   }

   private static void ggo(boolean var0, String var1) {
      if (!var0) {
         ggb++;
         System.out.println(a.d("傪⤟ꏋ㶱똣テ誄ͣ鴻\u17de過樴\ue4ee絙\uf702熸쮱䑧\udedc墈텶ꬦ○븀", -1571011220, 969807283) + var1);
      }
   }

   private static void ggp(MinecraftServer var0, BlockPos var1, boolean var2) {
      ServerWorld var3 = var0.method_30002();
      gez.clear();
      gfa.clear();
      int var4 = var1.method_10264() + 10;
      gfg = new BlockPos(var1.method_10263() + 100, var1.method_10264(), var1.method_10260() - 250);

      for (int var5 = (gfg.method_10263() >> 4) - 2; var5 <= (gfg.method_10263() >> 4) + 2; var5++) {
         for (int var6 = (gfg.method_10260() >> 4) - 2; var6 <= (gfg.method_10260() >> 4) + 2; var6++) {
            var3.method_8497(var5, var6);
         }
      }

      if (gel) {
         gez.add(new gec(0, var1.method_10263(), var1.method_10260() + 40, var4, false, 8000L, 8000L, a.c(-1226431568, "➩帷풞䫣셎䟲\ufdde")));
      } else if (var2) {
         gez.add(
            new gec(0, var1.method_10263(), var1.method_10260() + 40, var4, false, 120L, 1800L, a.b("햖갈⚡룜㍱뗍\u0fe1", 38523279), a.b("쓕뵀㟯ꧢ≊ꒉẮ霤ॱ莿", -466698045))
         );
      } else {
         gez.add(
            new gec(
               101,
               var1.method_10263(),
               var1.method_10260() + 40,
               var4,
               false,
               1000L,
               2000L,
               a.d("蟝﹈瓧\ueaea慂\ue781嶦퐬䩹삷", 1170327791, -568898780),
               a.c(419298126, "ｗ蛉ౠ鈝ᦰ鼌┠")
            )
         );
         gez.add(
            new gec(
               102,
               var1.method_10263() + 220,
               var1.method_10260() + 40,
               var4,
               true,
               2400L,
               2400L,
               a.b("ᒮ洱\ue7e4禓\uf24c瓴캣䜢\ud900厼퐐", -283897666),
               a.d("臋\uf855狼\uec81本\ue190宼", 465268563, -705238399)
            )
         );
         gez.add(
            new gec(
               103,
               var1.method_10263() + 440,
               var1.method_10260() + 40,
               var4,
               false,
               4000L,
               2000L,
               a.c(-1212736577, "ᾦ昸\uec91独論翽엑"),
               a.d("૱獤溜柆\uec6e檭킊夀읕䶛", 77332126, -292032391)
            )
         );
      }

      for (gec var11 : gez) {
         ggv(var3, var11, var1.method_10264());
      }

      if (gel) {
         VillagerEntity var9 = (VillagerEntity)EntityType.field_6077.method_5883(var3, SpawnReason.field_16462);
         gec var12 = gez.get(0);
         var9.method_5808(var12.cx + 0.5, var12.y0, var12.cz + 0.5, 0.0F, 0.0F);
         var9.method_5977(true);
         var9.method_5684(true);
         var9.method_5803(true);
         var3.method_8649(var9);
         get = var9;
      }

      if (!gfc) {
         gfc = true;
         ServerTickEvents.END_SERVER_TICK.register(gef::ggt);
         PlayerBlockBreakEvents.BEFORE.register((Before)(var0x, var1x, var2x, var3x, var4x) -> {
            if (gfd && !var0x.method_8608()) {
               for (gec var6x : gez) {
                  if (var6x.inMine(var2x)) {
                     return true;
                  }
               }

               gfk++;
               gfb.add(a.b("ꎩ\uda1a僔캾䕸쏏禋\uf06b渵\ue4c0", -61496365) + var2x.method_23854() + a.d("둳", 1358619015, -62237227) + var3x.method_26204());
               return false;
            } else {
               return true;
            }
         });
         PlayerBlockBreakEvents.AFTER.register((After)(var0x, var1x, var2x, var3x, var4x) -> {
            if (gfd && !var0x.method_8608() && var1x instanceof ServerPlayerEntity var5x) {
               for (gec var7x : gez) {
                  if (var7x.inMine(var2x)) {
                     if (geh) {
                        System.out.println(a.b("О綮\uf779楞\ue2cb摪\ude24埑즀䍴", -648018841) + var2x.method_23854() + a.c(-831419046, "赹\uf49c縆") + gfe);
                     }

                     ggi = Math.min(ggi, var2x.method_10264());
                     ggr(var7x, var3x);
                     ggs((ServerWorld)var0x, var5x, var7x, var2x);
                  }
               }
            }
         });
      }

      CommandDispatcher var10 = var0.method_3734().method_9235();

      for (gec var7 : gez) {
         var10.register((LiteralArgumentBuilder)CommandManager.method_9247(a.d("콤뛚", 312840183, -1160494864) + var7.id).executes(var1x -> {
            ServerPlayerEntity var2x = ((ServerCommandSource)var1x.getSource()).method_9207();
            if (gff == var7) {
               var2x.method_64398(Text.method_43470(a.b("木ṝ郿໗腫ι릟ねꨧ⒋ꍕ契\ud7fd乆쐙䊒\uf8aa眏\uedb1澌\ue266頺ኙ败୕臸㡉누Ⲓꪷⅱ\udfd2喚찞䨸쒝", -692426837)));
               return 1;
            } else {
               gfh = var7;
               gfi = gfe + 25L;
               return 1;
            }
         }));
      }

      var10.register(
         (LiteralArgumentBuilder)CommandManager.method_9247(a.c(-554375817, "\ue504鲣ᙣ蠐"))
            .then(
               CommandManager.method_9247(a.d("쒽봈㟜ꦦ", -1597473755, -2145601295))
                  .executes(
                     var0x -> {
                        ServerPlayerEntity var1x = ((ServerCommandSource)var0x.getSource()).method_9207();
                        if (gfj >= 0L) {
                           gfl++;
                           gfb.add(a.d("㠡䇙", -2035115413, 421372476) + gfe / 20.0 + a.b("圓⻑ꐔ㩣놸㜈赑ӄ髬။鞋淸\ue35f窹\uf0f5瘅챏䎗\ud961彤횂곚≠릤㿄딈ಽ英᠁鹙", 1586517805));
                        }

                        gfj = gfe + 140L;
                        var1x.method_64398(Text.method_43470(a.b("訛\uf33b彿\ue78f泟\ueaaf咅\udd5e䍴즰乪됒㪹ꍴ⤯꿛ᖙ鹝ó蚯ୈ甋﮺怛\ue61b棕퇡彲얍䏘졬㚶밻┋ꌐ", -1861121377)));
                        var1x.method_64398(
                           Text.method_43470(a.b("ୀ爵\uf8de䁕\ued7e殲헣尅쉔䣫켲㕂믫≘\ua879\u2efe铏᭩薴Ϥ誔\uf004竎\ue135朿\ued9b吡\uda79䃲웟䵤뎰㧲ꐖ☢곡ፃ饇ᾖ舰ࣨ盟ﳚ筼\ue5ca每툓", -118551608))
                        );
                        var1x.method_64398(
                           Text.method_43470(
                              a.d("彺☏곤ᑯ륄㾈臩࠷陭᳘鬇慻\uefa9瘕\uf852红쑪䭺햲友\ude29ꁧ⻕딁㌆맓\u0017蹏ᓃ鋥ᵃ\ue315榞\uf44f爟\uf8d0䜄쥨似홌塋⛆ꣷ⭞놂㾀蘭ಘ諓ᄎ魮", -590989279, 1566205903)
                           )
                        );
                        var1x.method_64398(Text.method_43470(a.d("\uecbf闊\u1f5a脫ૼ豍㘞뿯↰ꬁⲩ튝尖엙侃쥺猰ﲛ昦\ue41b榎Ꭸ鴕ۊ肿੯뎢㷱ꌙ", 1408165053, 1252591800)));
                        return 1;
                     }
                  )
            )
      );
      var10.register(
         (LiteralArgumentBuilder)CommandManager.method_9247(a.d("⸇垹\udd35䍅좖", -275467316, 1988795823))
            .executes(
               var0x -> {
                  gfm++;
                  ((ServerCommandSource)var0x.getSource())
                     .method_9207()
                     .method_64398(
                        Text.method_43470(
                           a.b(
                              "ὄ昱\ue8a0盅ﵧ箤쇰䡴퉋峧\udb39╘꾕㘠및㪂肳ཀྵ閨០騥\ue02d櫵\uf53b猰裡䀩칽哽틛夜Ꟁ⧣됍㉟룤ܽ赍௫鉓ᡳ書\ueca5欙\uf1c0篞옟䢼쫧儲\udf4c▝걜⩿뒕㻘蕥ζ觌ပ黝\ue0ee挀\ue959瞗︬䐀싲䢤흩嶰\udbc9☊",
                              1783832490
                           )
                        )
                     );
                  return 1;
               }
            )
      );
      ServerPlayerEntity var14 = var0.method_3760().method_14566(gfn);
      if (var14 != null) {
         var0.method_3760().method_14576(var14);
         ggq(var0, var14);
      }
   }

   private static void ggq(final MinecraftServer var0, ServerPlayerEntity var1) {
      try {
         ClientConnection var2 = null;

         for (Field var6 : ServerCommonNetworkHandler.class.getDeclaredFields()) {
            if (var6.getType() == ClientConnection.class) {
               var6.setAccessible(true);
               var2 = (ClientConnection)var6.get(var1.field_13987);
            }
         }

         Channel var9 = null;

         for (Field var7 : ClientConnection.class.getDeclaredFields()) {
            if (Channel.class.isAssignableFrom(var7.getType())) {
               var7.setAccessible(true);
               var9 = (Channel)var7.get(var2);
            }
         }

         var9.pipeline()
            .addBefore(
               a.d("ꚽ\udf1d嗌쮵䁬워粴\uf572欤\ue19a晃鰺ዤ譂", 1702866934, 233113909),
               a.d("┸岃홓䠺쎨䕴５盠\ue8b8戂\ue5ebᾷ酷ࣀ芟ѳ븪ㇺꭞ", -1715231539, -1686732416),
               new ChannelInboundHandlerAdapter() {
                  public void channelRead(ChannelHandlerContext var1, Object var2x) throws Exception {
                     if (var2x instanceof PlayerMoveC2SPacket var3 && var3.method_36172()) {
                        float var4 = var3.method_12271(0.0F);
                        float var5 = var3.method_12270(0.0F);
                        if (gef.gfe < gef.gfz) {
                           gef.gfy = false;
                        } else if (gef.gfy && gef.gfd) {
                           double var6x = MathHelper.method_15393(var4 - gef.gfw);
                           double var8x = var5 - gef.gfx;
                           double var10 = Math.sqrt(var6x * var6x + var8x * var8x);
                           gef.gfv.add(var10);
                           if (var10 > 30.0) {
                              System.out
                                 .println(
                                    String.format(
                                       Locale.ROOT,
                                       a.d(
                                          "ࠉ熼ﭨ攒\uee80桡툣寐얇伸죺㋟뱜◬꾸⥕鍔ᲀ蘸v觖\uf3c1紫\ue6e2悋\uea0d去\udde1䜉섏䫷됵㹡ꞛ⇗ꬱᒠ麁ᡋ臧ய畕ｎ磺\ue226汈헌弶\ud96a䊠쳘㘖뿶㧡ꍆⵞ雹ၩ",
                                          105609737,
                                          -1500548521
                                       ),
                                       var10,
                                       gef.gfw,
                                       var4,
                                       gef.gfx,
                                       var5,
                                       gef.gfe
                                    )
                                 );
                           }
                        }

                        gef.gfw = var4;
                        gef.gfx = var5;
                        gef.gfy = true;
                     }

                     if (var2x instanceof PlayerActionC2SPacket var12 && var12.method_12363() == Action.field_12968) {
                        gef.gej = var12.method_12362().method_10062();
                        gef.gek = var12.method_12360();
                        if (gef.gfd) {
                           gef.gew++;
                        }
                     }

                     if (gef.gfd && var2x instanceof PlayerInteractEntityC2SPacket) {
                        gef.geu++;
                     }

                     if (gef.geh && var2x instanceof PlayerActionC2SPacket var13) {
                        var0.execute(
                           () -> {
                              ServerPlayerEntity var2xx = var0.method_3760().method_14566(gef.gfn);
                              BlockState var3x = var2xx.method_51469().method_8320(var13.method_12362());
                              System.out
                                 .println(
                                    String.format(
                                       Locale.ROOT,
                                       a.c(341530865, "墺ℊꯝ㗺븨㣏苏\u0b3b锲ῐ顗扯\ueca0畐ｇ秲쎼䱤훏傋\ud920ꍩⷑ똝〷몠͔贐\u17fa醱ᨙ\ue4c2滔\uf73d焸ﯚ䑅츽䣡텚孜▵꾰⡒닁㲽蕴࿂规ል鱵暸\uef5b楌\uf3ba綽"),
                                       var13.method_12363(),
                                       var13.method_12362().method_23854(),
                                       gef.gfe,
                                       var3x.method_26165(var2xx, var2xx.method_51469(), var13.method_12362()),
                                       var2xx.method_24828(),
                                       var2xx.method_6047().method_7909(),
                                       Math.sqrt(new Box(var13.method_12362()).method_49271(var2xx.method_33571())),
                                       var3x.method_26204()
                                    )
                                 );
                           }
                        );
                     }

                     super.channelRead(var1, var2x);
                  }
               }
            );
      } catch (ReflectiveOperationException var8) {
         throw new RuntimeException(var8);
      }
   }

   private static void ggr(gec var0, BlockState var1) {
      var0.mined++;
      String var2 = Registries.field_41175.method_10221(var1.method_26204()).method_12832();
      if (var2.endsWith(a.b("ⲉ唵\udfee䆓쩆䳶\uf6af罥\ue10a殦\uec62", 457518310))) {
         var0.minedDiamonds++;
      }

      if (var2.endsWith(a.c(1741729315, "깸ퟹ崷썑"))) {
         var0.minedOres++;
         if (var0 == gez.get(0) && var0.refreshes == 1) {
            ggf++;
            if (ggh < 0L) {
               ggh = gfe;
            }

            ggg = (gfe - ggh) / 20.0;
         }
      }
   }

   private static void ggs(ServerWorld var0, ServerPlayerEntity var1, gec var2, BlockPos var3) {
      if (!gei.equals(a.c(1392639718, "ﺌ蜼෮鎔"))) {
         float var4 = var1.method_36455();
         ArrayList var5 = new ArrayList();
         float var6 = MathHelper.method_15393(var1.method_36454());
         boolean var7 = Math.abs(var6) < 45.0F || Math.abs(var6) > 135.0F;
         Axis var8 = Math.abs(var4) > 50.0F ? Axis.field_11052 : (var7 ? Axis.field_11051 : Axis.field_11048);
         if (gei.equals(a.b("\udda2ꐔ⻅낲", 1133632960)) && var3.equals(gej) && gek != null) {
            var8 = gek.method_10166();
         }

         for (int var9 = -1; var9 <= 1; var9++) {
            for (int var10 = -1; var10 <= 1; var10++) {
               if (var9 != 0 || var10 != 0) {
                  if (var8 == Axis.field_11052) {
                     var5.add(var3.method_10069(var9, 0, var10));
                  } else if (var8 == Axis.field_11051) {
                     var5.add(var3.method_10069(var9, var10, 0));
                  } else {
                     var5.add(var3.method_10069(0, var10, var9));
                  }
               }
            }
         }

         for (BlockPos var15 : var5) {
            BlockState var11 = var0.method_8320(var15);
            if (var2.inMine(var15) && !var11.method_26215()) {
               for (ItemStack var13 : Block.method_9609(var11, var0, var15, null, var1, var1.method_6047())) {
                  var1.method_31548().method_7394(var13);
               }

               var0.method_8652(var15, Blocks.field_10124.method_9564(), 3);
               ggr(var2, var11);
            }
         }
      }
   }

   private static void ggt(MinecraftServer var0) {
      if (gfd || !gez.isEmpty()) {
         gfe++;
         ServerWorld var1 = var0.method_30002();
         ServerPlayerEntity var2 = gfn == null ? null : var0.method_3760().method_14566(gfn);
         if (gfi >= 0L && gfe >= gfi && var2 != null) {
            gfi = -1L;
            gff = gfh;
            ggz(var0, gff.spawn, 0.0F, 0.0F);
            gfb.add(a.d("幗➯", -94601621, 1543053386) + gfe / 20.0 + a.d("\u1ae6挝\ue9cb瞼ﱬ竖삄䤱", -2009955039, 1974509551) + gff.id);
         }

         if (gfj >= 0L && gfe >= gfj && var2 != null) {
            gfj = -1L;
            if (gff != null) {
               ggz(var0, gff.warp, 180.0F, 15.0F);
               var2.method_6092(new StatusEffectInstance(StatusEffects.field_5919, 50, 0));
               gfb.add(a.b("赪\uf492", 934710556) + gfe / 20.0 + a.c(1077131345, "롹솟䭚픸廭\ud849戛\uebae") + gff.id);
            }
         }

         if (gfd) {
            if (gel && gfe % 10L == 0L && !gez.isEmpty()) {
               gec var3 = gez.get(0);
               if (gep < 0.0 && var3.mined > 0) {
                  gep = gfe / 20.0;
               }

               int var4 = 0;
               int var5 = 0;
               ArrayList var6 = new ArrayList();

               for (int var7 = var3.cx - 8; var7 <= var3.cx + 8; var7++) {
                  for (int var8 = var3.cz - 8; var8 <= var3.cz + 8; var8++) {
                     for (int var9 = var3.y0 - gen; var9 <= var3.y0 - 1; var9++) {
                        BlockState var10 = var1.method_8320(new BlockPos(var7, var9, var8));
                        if (var10.method_27852(Blocks.field_10442)) {
                           var5++;
                        }

                        if (!var10.method_26215()) {
                           var4++;
                           if (var6.size() < 80) {
                              var6.add(var7 - var3.cx + a.c(-68451006, "蕯") + (var9 - var3.y0) + a.c(1598297430, "ᕻ") + (var8 - var3.cz));
                           }
                        }
                     }
                  }
               }

               synchronized (gex) {
                  gex.clear();
                  gex.addAll(var6);
               }

               geq = var4;
               ges = var5;
               if (get != null && var2 != null && gfe % 40L == 0L) {
                  Vec3d var17 = var2.method_5720().method_18805(1.0, 0.0, 1.0).method_1029();
                  get.method_5808(var2.method_23317() + var17.field_1352 * 1.6, var2.method_23318(), var2.method_23321() + var17.field_1350 * 1.6, 0.0F, 0.0F);
               }

               int var18 = 289 * gen;
               if (geo < 0.0 && var4 <= var18 / 50) {
                  geo = gfe / 20.0;
                  gfb.add(String.format(Locale.ROOT, a.d("쪪댔㧎ꞻⱿ\uaad9ႋ餾ܠ趄ਃ\uf077纫\ue705洁\uebb6冪\ude28䒓싏䭹ㅬ뾓\u244bꈷ⣴鄚", 1834278111, 1114379789), geo, var4));
               }

               if (gfe % 100L == 0L) {
                  System.out
                     .println(
                        a.c(-1317240905, "翗٢貶ዌ饞ᾼꗫⰈ뉗㣳뽰䕕쯋")
                           + gfe / 20.0
                           + a.c(223179014, "焠ࣝ與ᱵ鞰ᅈ")
                           + var4
                           + a.d("\ue90b郸ᨻ著྄褻㍣뫁", -368287644, -151680697)
                           + var3.mined
                     );
               }
            }

            for (gec var14 : gez) {
               if (gfe >= var14.refreshAt) {
                  var14.refreshAt = var14.refreshAt + var14.period;
                  var14.tierAt++;
                  var14.refreshes++;
                  ggw(var1, var14, new Random(var14.id * 31L + var14.refreshes), 0.0);
                  String var15 = var2 != null && var2.method_24515().method_19771(var14.warp, 30.0) ? a.c(2047603691, "\uf381註ì麎") : a.c(874314334, "層莜ख़霰");
                  var14.events
                     .add(
                        a.b("檍ጫ駻ޞ豞ૹ낱", 1518365432)
                           + var14.refreshes
                           + a.d("ẙ", -1619439929, 553013375)
                           + var15
                           + a.d("﹈螭ഷ", 1891392184, 1576903891)
                           + gfe / 20.0
                     );
               }

               if (gfe % 20L == 0L) {
                  ggx(var14);
               }

               if (var2 != null && gfe % 2L == 0L) {
                  ggu(var1, var2, var14);
               }
            }
         }
      }
   }

   private static void ggu(ServerWorld var0, ServerPlayerEntity var1, gec var2) {
      Box var3 = new Box(var2.cx - 8 - 2, var2.y0 - gen - 2, var2.cz - 8 - 2, var2.cx + 8 + 3, var2.y0 + 4, var2.cz + 8 + 3);

      for (ItemEntity var5 : var0.method_8390(ItemEntity.class, var3, var0x -> var0x.method_24921() == null)) {
         ItemStack var6 = var5.method_6983().method_7972();
         var1.method_31548().method_7394(var6);
         if (var6.method_7960()) {
            var5.method_31472();
         } else {
            var5.method_6979(var6);
         }
      }
   }

   private static void ggv(ServerWorld var0, gec var1, int var2) {
      for (int var3 = var1.cx - 40 >> 4; var3 <= var1.cx + 40 >> 4; var3++) {
         for (int var4 = var1.cz - 140 >> 4; var4 <= var1.cz + 40 >> 4; var4++) {
            var0.method_8497(var3, var4);
         }
      }

      for (int var15 = var1.cx - 8 - 6 >> 4; var15 <= var1.cx + 8 + 6 >> 4; var15++) {
         for (int var17 = var1.cz - 8 - 6 >> 4; var17 <= var1.cz + 8 + 6 >> 4; var17++) {
            var0.method_17988(var15, var17, true);
         }
      }

      byte var16 = 12;

      for (int var18 = var1.cx - var16; var18 <= var1.cx + var16; var18++) {
         for (int var5 = var1.cz - var16; var5 <= var1.cz + var16; var5++) {
            for (int var6 = var1.y0 - gen - 1; var6 <= var1.y0 + 5; var6++) {
               boolean var7 = Math.abs(var18 - var1.cx) == var16 || Math.abs(var5 - var1.cz) == var16;
               BlockState var8 = Blocks.field_10124.method_9564();
               if (var6 < var1.y0) {
                  var8 = Blocks.field_10056.method_9564();
               } else if (var7 && var6 <= var1.y0 + 2 && (var5 != var1.cz + var16 || Math.abs(var18 - var1.cx) > 1)) {
                  var8 = Blocks.field_10056.method_9564();
               }

               var0.method_8652(new BlockPos(var18, var6, var5), var8, 3);
            }
         }
      }

      ggw(var0, var1, new Random(var1.id), gel ? 0.0 : 0.55);
      if (gel) {
         ger = 0;

         for (int var19 = var1.cx - 8; var19 <= var1.cx + 8; var19++) {
            for (int var21 = var1.cz - 8; var21 <= var1.cz + 8; var21++) {
               for (int var25 = var1.y0 - gen; var25 <= var1.y0 - 1; var25++) {
                  if (var0.method_8320(new BlockPos(var19, var25, var21)).method_27852(Blocks.field_10442)) {
                     ger++;
                  }
               }
            }
         }
      }

      BlockPos[] var20 = new BlockPos[]{
         new BlockPos(var1.cx - 8 - 2, var1.y0 - 1, var1.cz),
         new BlockPos(var1.cx + 8 + 2, var1.y0 - 1, var1.cz + 2),
         new BlockPos(var1.cx, var1.y0 - 1, var1.cz - 8 - 2),
         new BlockPos(var1.cx + 3, var1.y0 + 1, var1.cz - var16),
         new BlockPos(var1.cx - 8 - 1, var1.y0 - 2, var1.cz - 3)
      };

      for (BlockPos var30 : var20) {
         var0.method_8652(var30, Blocks.field_10442.method_9564(), 3);
         gfa.add(var30);
      }

      var1.warp = new BlockPos(var1.cx, var1.y0, var1.cz + 8 + 2);
      var1.spawn = var1.id != 101 && var1.id != 0 ? new BlockPos(var1.cx + 3, var1.y0, var1.cz + 8 + 4 + 18) : new BlockPos(var1.cx, var2, var1.cz - 100);
      if (var1.id != 101 && var1.id != 0) {
         for (int var23 = var1.spawn.method_10263() - 3; var23 <= var1.spawn.method_10263() + 3; var23++) {
            for (int var27 = var1.spawn.method_10260() - 3; var27 <= var1.spawn.method_10260() + 3; var27++) {
               var0.method_8652(new BlockPos(var23, var1.y0 - 1, var27), Blocks.field_10566.method_9564(), 3);
            }
         }
      }

      double var24 = var1.cx + 0.5;
      double var29 = var1.y0 + 1.6;
      double var9 = var1.cz + 8 - 0.5;
      if (var1.armor) {
         for (int var11 = 0; var11 < 4; var11++) {
            ArmorStandEntity var12 = new ArmorStandEntity(var0, var24, var29 + 0.27 * (3 - var11), var9);
            var12.method_5648(true);
            var12.method_5875(true);
            var12.method_5880(true);

            try {
               Method var13 = ArmorStandEntity.class.getDeclaredMethod(a.b("慀ᣧ鈥౭螖Ĵ뭾㊁곉", 1131569466), boolean.class);
               var13.setAccessible(true);
               var13.invoke(var12, true);
            } catch (ReflectiveOperationException var14) {
               throw new RuntimeException(var14);
            }

            var0.method_8649(var12);
            var1.labels.add(var12);
         }
      } else {
         TextDisplayEntity var31 = (TextDisplayEntity)EntityType.field_42457.method_5883(var0, SpawnReason.field_16462);
         var31.method_5808(var24, var29, var9, 0.0F, 0.0F);
         var0.method_8649(var31);
         var1.labels.add(var31);
      }

      ggx(var1);
   }

   private static void ggw(ServerWorld var0, gec var1, Random var2, double var3) {
      Block[] var5 = new Block[]{Blocks.field_10418, Blocks.field_10212, Blocks.field_10571, Blocks.field_10080, Blocks.field_10090, Blocks.field_10442};
      double[] var6 = new double[]{0.04, 0.035, 0.025, 0.02, 0.018, 0.012};

      for (int var7 = var1.cx - 8; var7 <= var1.cx + 8; var7++) {
         for (int var8 = var1.cz - 8; var8 <= var1.cz + 8; var8++) {
            for (int var9 = var1.y0 - gen; var9 <= var1.y0 - 1; var9++) {
               double var10 = (double)(var1.y0 - 1 - var9) / gen;
               BlockState var12;
               if (var3 > 0.0 && var2.nextDouble() < var3 * (1.0 - var10)) {
                  var12 = Blocks.field_10124.method_9564();
               } else {
                  double var13 = var2.nextDouble();
                  Block var15 = null;
                  double var16 = 0.0;

                  for (int var18 = 0; var18 < var5.length; var18++) {
                     var16 += var6[var18];
                     if (var13 < var16) {
                        var15 = var5[var18];
                        break;
                     }
                  }

                  if (var15 == null) {
                     double var20 = var2.nextDouble();
                     var15 = var20 < 0.35 ? Blocks.field_10474 : (var20 < 0.68 ? Blocks.field_10445 : Blocks.field_10508);
                  }

                  var12 = var15.method_9564();
               }

               var0.method_8652(new BlockPos(var7, var9, var8), var12, 3);
            }
         }
      }
   }

   private static void ggx(gec var0) {
      long var1 = Math.max(0L, var0.refreshAt - gfe);
      if (!gfd) {
         var1 = var0.refreshAt;
      }

      long var3 = (var1 + 19L) / 20L;
      String var5 = String.format(Locale.ROOT, a.b("瓣േ螖ᦱ鈸ᒖ껐✣뤪", -1893174065), var3 / 60L, var3 % 60L);
      String[] var6 = new String[]{
         a.c(1603983993, "\udaceꏮྙ띚㢽븮Ѝ趀៌饸ẳ\ue4b7橧\uf3a4緧\udda4"),
         a.d("髯\ue39f洋\uf360碹︉䐭췑厉\ud941廭ꃩ⸤뜒㶂", 104776162, 2082298789) + var0.tier(),
         a.c(2098878652, "堈ⅸ꿓ㆍ멖㳤蚻གྷ鄒᮫鱽昁\uecc3焕הּ綰잊䡙훧"),
         a.d("ሯ欏", 216376886, 1565373628) + var5
      };
      if (var0.armor) {
         for (int var7 = 0; var7 < 4 && var7 < var0.labels.size(); var7++) {
            var0.labels.get(var7).method_5665(Text.method_43470(var6[var7]));
         }
      } else if (!var0.labels.isEmpty()) {
         ggy((TextDisplayEntity)var0.labels.get(0), Text.method_43470(String.join(a.d("肼", -1584902860, -413741693), var6)));
      }
   }

   private static void ggy(TextDisplayEntity var0, Text var1) {
      if (gfo == null) {
         for (Field var5 : TextDisplayEntity.class.getDeclaredFields()) {
            if (Modifier.isStatic(var5.getModifiers()) && var5.getType() == TrackedData.class) {
               try {
                  var5.setAccessible(true);
                  TrackedData var6 = (TrackedData)var5.get(null);
                  if (var6.comp_2328() == TrackedDataHandlerRegistry.field_13317) {
                     gfo = var6;
                     break;
                  }
               } catch (ReflectiveOperationException var7) {
                  throw new RuntimeException(var7);
               }
            }
         }
      }

      var0.method_5841().method_12778(gfo, var1);
   }

   private static void ggz(MinecraftServer var0, BlockPos var1, float var2, float var3) {
      gfy = false;
      gfz = gfe + 20L;
      var0.method_3734()
         .method_44252(
            var0.method_3739(),
            String.format(
               Locale.ROOT,
               a.d("㍞䫫쁨帜햝卿\ue929惓ﺓ瑵\uf3e0ঔ蜂ỷ钡ቛꠋ➍뵸㬬닐좟䙺\udded宗텍棠\ue6e7", 1665173619, -1577075899),
               gfn,
               var1.method_10263() + 0.5,
               var1.method_10264(),
               var1.method_10260() + 0.5,
               var2,
               var3
            )
         );
   }

   private static void gha(kfe var0, String var1, Object var2) {
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

   private static void ghb(MinecraftClient var0, String var1, boolean var2) {
      kfe var3 = Flow.getInstance().getModuleManager().getByName(var1);
      if (var3 != null) {
         var3.setEnabled(var2);
      }
   }

   private static void ghc(MinecraftClient var0) throws Exception {
      for (Field var4 : Mouse.class.getDeclaredFields()) {
         if (var4.getName().equals(a.c(1445306881, "ꉮ\udbc9儝콭䒦숊硧\uf1b5濦\ue55f抂飲"))) {
            var4.setAccessible(true);
            var4.setBoolean(var0.field_1729, true);
         }
      }
   }

   private static void ghd(MinecraftClient var0, String var1) {
      ScreenshotRecorder.method_22690(
         var0.field_1697,
         a.c(-782319865, "뽧웜䰌퉥姷\udf59") + var1 + a.d("譂\uf2ad硠\ue618", -1649406285, -78674469),
         var0.method_1522(),
         1,
         var0x -> System.out.println("" + var0x.getString())
      );
   }

   private static void ghe(MinecraftClient var0, String var1) {
      var0.method_1562().method_45730(var1);
   }
}
