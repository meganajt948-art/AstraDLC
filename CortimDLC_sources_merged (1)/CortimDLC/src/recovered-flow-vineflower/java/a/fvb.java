package a;

import flow.Flow;
import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.MouseInput;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;

final class fvb {
   private static int fvc;
   private static BlockPos fvd;

   private fvb() {
   }

   static boolean tick(MinecraftClient var0, int var1) throws Exception {
      kfx var2 = Flow.getInstance().getModuleManager();
      if (var1 == 1) {
         fvu(var0, a.d("\ueab6錁᧞螧౸請ん륣❹궋⩉퀯廼의䴖쯸熤", 359719877, -728954619));
         fvu(var0, a.d("䭥㋉렞♧귵⬗酒ᢲ蚹ఞ诋熺ｭ", -561393896, 721847300));
         fvu(var0, a.b("떞창䛪\ud88e卅헹澽\ue61e砂\uf2bc畦輓Ǘ", 1172813284));
         fvl();
         fvp();
         fvq(var2);
         fvd = var0.player.getBlockPos();
         fvu(var0, a.b("넽좚䉘\udc3f埦텔欋\ue2f2糦\uf609熖诵ռ鲓\u169e逥⩾ꗢ㽕뤃ヿ䪨쐊忈\ud9b0即\uea8e撆ﹺ砦\uf383ൕ", -744246930));
         fvu(var0, a.b("\uf2e3譄Ɔ鿡ᐸ銊⣕ꄬ㼸뗗㉈젫䚢\udf5c唞펱榴\ue671粏\ufada猪॰蟅ᰅ驩Ⴟꤞ✁붯㯵끋二쓄", 291369649));
         fvu(
            var0,
            a.c(
               2137639030,
               "졤뇃㬁ꕦ⺿ꠍቒ鮫ֿ轐࣏\uf2ac簥\ue5db澙\ue936匴\udcf6䘈쁝䦭㏷뵂⚂ꃮ⨸鎙ᶆ蜤Ż諂琧﹀枧\ue1f9歈풬廱\ud838䆇쯑딕㽻룍∘걣ᖷ鼏ᤚ芘೪\uf626羗栗挜\ued6b囉퀌婢쎲䴟㝥낽㫽ꐯⶒ鞏ᄿ魾Ӈ踂ࡳ\uf1be笉\ue558溿\ue8a1剱\udbdb䆰쭺䴤㚝롃☡꿾⥃錒᳣蚼\u000f觐玩ﵸ暴\ue0c5樊"
            )
         );
         fvu(var0, a.b("鄢\ue885扇ﰠ矹\uf14b䬔십峹혖冖꯸┽볒㛟끰ੵ薰\u1f4e餛ძ檱\ue404翄令獾쫟䓀\ude6e場펊ⵍ꜅", -1173909136));
         fvu(
            var0,
            a.c(
               1219345604,
               "본앟依퇺娣\udc91曎\uef37焣\ufbcc籌蘢ࣧ鄈ᬔ鷴⟥\ua87e㋙듅㴶䝠짘刏푡庣\ue717楔\uf3ed痩﹔\u008f諴ጩ镠῟ꀁ⩥겫㔎뽌솼䯵챯嚓\ud8f3愽\ueb80涁\uf611硴芭ଌ赝ូ駫≖꒑⺫뜛㧕䞇쁤䩄퓵崻\ue30b旴\uefad瀜贈精蕡\u0fde醃ᩲ鱚⛋꼘"
            )
         );
      }

      if (var1 == 20) {
         BlockPos var3 = pte.find(var0, fvd, a.c(1428921349, "頸\ue18c歐\uf52b绳"), a.b("ඨ琑ﻅ悾\ueb65淘힏", -2026829422));
         BlockPos var4 = pte.find(var0, fvd, a.b("痮య蚍ᢂ錪", 173896106));
         fvr(a.c(-1752077886, "榐့髩Ҙ較ৡ뎨㩗ꐁ\u2efeꥠ匝\uddd9䑱츺䢘\uf283絎\ue7f0懤\ue850鈊Ჴ蝳ċ讎㉴밸⚛ꂂ⬸헦徠왅䁅쪻畭"), fvd.add(2, 1, 4).equals(var3), String.valueOf(var3));
         fvr(a.c(-1459945252, "\u0089礿\uf3f9涇\ue65a惦\udab2半쵒䞰쁹㨆듘ⴧꜹ⇄鮘ᑐ軻ࣹ腚ﬗ疩\uee3d栁\ue2db孥픢俒짗䈱볻㚾꽎⤊ꏩᱷ阛"), fvd.add(-2, 0, 4).equals(var4), String.valueOf(var4));
      }

      if (var1 == 24) {
         wap.set(wam.EN);
         fvs(var0, var2.get(nxa.class).lootList());
      }

      if (var1 == 36) {
         fvv(var0, a.b("⒘崮ퟮ䦀숗䓧ﺷ睆\ue902揪\ue463Ḅ郀१茵\u05cf뿃ずꫢ", 1708270829));
      }

      if (var1 == 37) {
         var0.setScreen(null);
         wap.set(wam.RU);
         fvs(var0, var2.get(mpq.class).lootList());
      }

      if (var1 == 49) {
         fvv(var0, a.d("Ⳡ啖\udf96䇸쩯䲟\uf6cf缾\ue17a殒\uec09ᙳ颮Ŗ譚ඬ", 528783803, -796609235));
      }

      if (var1 == 50) {
         fvt(var0.currentScreen, a.d("항겮♶렄㎪", -69843545, -1833200499));
      }

      if (var1 == 58) {
         fvv(var0, a.c(-432105100, "餆\ue0b0橰\uf41e羉凉䌩쫘咜\ude74姯ꎕⵈ뒰㺽롚ȑ跓\u1771鄫"));
         var0.setScreen(null);
      }

      if (var1 == 60 || var1 == 116) {
         wap.set(var1 == 60 ? wam.RU : wam.EN);
         fvk(var0, a.d("ᦼ怱\ueaef璆ｍ秫", 518154455, 2137813309));
      }

      if (var1 == 70 || var1 == 126) {
         fvi(var0, nxa.class);
      }

      if (var1 == 86) {
         fvv(var0, a.c(-1099881592, "⏡婗킗仹앮䎆硫瀿\uee63擊\ue304ᥬ韦จ葜"));
      }

      if (var1 == 87) {
         fvh(var0, nxa.class, 1);
      }

      if (var1 == 100) {
         fvv(var0, a.b("\uf5df豩ک飇ፐ閯\u2ffeꘜ㡕늭㔡콗", 542242229));
      }

      if (var1 == 101) {
         fvh(var0, oqv.class, 1);
      }

      if (var1 == 112) {
         fvv(var0, a.d("ȗ管\uf161漏\ue498执\ud836凔쾝䕥싷㢅뙒⿸ꖺ⍜", 1928486297, 1694916600));
      }

      if (var1 == 142) {
         fvv(var0, a.b("㓻䵍잍姣퉴咜\ueed4朥凉珐\uf41e\u0e76胼ᤅ鍝", -469748590));
         var0.setScreen(null);
         wap.set(wam.RU);
      }

      if (var1 == 146) {
         System.out.println(a.c(-704239828, "❁廷퐷䩙쇃䜦ﵤ璃\ueadb怤\ue7ed") + (fvc == 0 ? a.b("峯╓꾀㆝먺㲚蛛༪酣ᯓ", 1468161188) : fvc + a.b("刎⯙ꄍ㽴뒦㈞行", 1795838505)));
         return true;
      } else {
         return false;
      }
   }

   private static double[] fvg(MinecraftClient var0, Class<? extends kfe> var1) throws Exception {
      if (var0.currentScreen instanceof hlc var2) {
         Field var11 = hlc.class.getDeclaredField(a.d("\uf24a诤ĭ齆ᒚ鈥⡿", 113480592, -554737237));
         var11.setAccessible(true);

         for (Object var5 : (List)var11.get(var2)) {
            if (var1.isInstance(fvj(var5, a.d("譲\uf2c1砙\ue679涷\ueb0f", -2012826531, 1957642052)))) {
               float var6 = (Float)fvj(var5, a.d("ﯿ", -2116758154, 944778992)) + 24.0F;
               float var7 = (Float)fvj(var5, a.d("䖸", -1359732373, -507812693)) + 10.0F;
               float var8 = (Float)fvj(var2, a.c(-1149644514, "텶\ua8da−뱭㞴넂୧"));
               float var9 = (Float)fvj(var2, a.d("ꥅ탩娡쑞侇줱獕", -2147268934, -1005195369));
               float var10 = (Float)fvj(var2, a.b("亴㜕뷄⎸ꡦ", -1361228094));
               return new double[]{var8 + var6 * var10, var9 + var7 * var10};
            }
         }

         System.out.println(a.d("ꀽ\ud98b卋촥䚿쁚稘\uf3ff涧\ue758悑骮ᑸ趆ޖ腥㬹듾⸉ꠞ⇠宬핍", 1530949356, -269431136) + var1.getSimpleName());
         return null;
      } else {
         return null;
      }
   }

   private static void fvh(MinecraftClient var0, Class<? extends kfe> var1, int var2) throws Exception {
      double[] var3 = fvg(var0, var1);
      if (var3 != null) {
         var0.currentScreen.mouseClicked(new Click(var3[0], var3[1], new MouseInput(var2, 0)), false);
      }
   }

   private static void fvi(MinecraftClient var0, Class<? extends kfe> var1) throws Exception {
      double[] var2 = fvg(var0, var1);
      if (var2 != null) {
         double var3 = var0.getWindow().getScaleFactor();
         double var5 = var2[0] * var3;
         double var7 = var2[1] * var3;
         long var9 = var0.getWindow().getHandle();
         GLFWCursorPosCallback var11 = GLFW.glfwSetCursorPosCallback(var9, null);
         GLFW.glfwSetCursorPosCallback(var9, var11);
         GLFW.glfwSetCursorPos(var9, var5, var7);
         if (var11 != null) {
            var11.invoke(var9, var5, var7);
         }
      }
   }

   private static Object fvj(Object var0, String var1) throws Exception {
      for (Class var2 = var0.getClass(); var2 != null; var2 = var2.getSuperclass()) {
         try {
            Field var3 = var2.getDeclaredField(var1);
            var3.setAccessible(true);
            return var3.get(var0);
         } catch (NoSuchFieldException var4) {
         }
      }

      throw new NoSuchFieldException(var1);
   }

   private static void fvk(MinecraftClient var0, String var1) throws Exception {
      Field var2 = hlc.class.getDeclaredField(a.c(192585945, "ꂫ\ud90f叟춇䙾샓"));
      var2.setAccessible(true);
      var2.set(null, var1);

      for (String var6 : new String[]{a.c(-826463788, "⦤個\udadf䒤콸䧑\uf3ad"), a.b("뉘쯷䄣\udf58咄툭桐", -430788056)}) {
         Field var7 = hlc.class.getDeclaredField(var6);
         var7.setAccessible(true);
         var7.setFloat(null, Float.NaN);
      }

      var0.setScreen(new hlc());
   }

   private static void fvl() {
      List var0 = List.of(ppu.WARDEN_DEFAULTS);
      List var1 = List.of(ppu.END_DEFAULTS);
      fvr(a.d("\uee70韗ᴗ荰ࢦ踜㐁붼⏦ꥍ⺙풼娣쎛䧚콸產\ufaf1恕\ue648澺ᗬ魔\u0093", 1971120378, 1994196709), var0.size() == 57, String.valueOf(var0.size()));
      fvr(a.c(981350604, "㢼䄆쯟嗪\ude71壅\ue28c歺\uf571羈\uf852ȱ貵ᔑ齎ᦦꎥⱱ뛅ゟ륾"), var1.size() == 59, String.valueOf(var1.size()));
      fvm(a.d("\u181a憢\ueb64甘ﻉ硫", -1562568576, 1620639993), new ItemStack(Items.ELYTRA), true, true);
      fvm(a.c(-876147091, "ฌ瞶ﵴ挙\ue8c3湥퐭巁쎏䥻컪㒖멁⏫ꦿ"), new ItemStack(Items.NETHERITE_BOOTS), true, true);
      fvm(a.c(-54121679, "⭛勡\ud83f䙅춛䬥\uf16c碌\ue6d2氧\uebb5ᇕ鼂گ賵"), new ItemStack(Items.ENCHANTED_GOLDEN_APPLE), true, true);
      fvm(
         a.c(-102886311, "ᐢ涞\ue746礤\uf2fc瑗칐䟵\ud9bf匃퓕⺾ꁷ㧊뎖"),
         fvn(Items.TOTEM_OF_UNDYING, a.c(-1371863710, "Ԫ嫅\uf64e桂\ue797愴\udb6c办첸䙴솫㯗넝Ⲯꛧ\u206e驑ᖍ輳")),
         true,
         true
      );
      fvm(
         a.b("\uf454跶ܢ饘ዖ鐳\u2e75꞉㧓델㒵컈䀐\ud9f5厼픨潌\ue097穠ﱾ疈\u0fdb腽", 1648882725),
         fvn(Items.TOTEM_OF_UNDYING, a.c(-1202624810, "暞㥱闺௶萣ʀ룘ㄪ꼌◀ꈟ塣튩众씫䎤璉癆\uec8f")),
         false,
         true
      );
      fvm(a.d("⛾彃햒䯥쁷䚎ﳐ甥\ueb7f憐\ue659ᱍ銱ଊ脝ޣ뷭㈾ꢘ", -1636613435, 184837189), new ItemStack(Items.HEAVY_CORE), false, true);
      fvm(a.c(-48757466, "Ղ糢\uf62c桋\ue38f敿\udf7f嚍죊䉶얲㿔"), fvn(Items.PLAYER_HEAD, a.d("\uda37藘⥓띟㢉빝ѿ跻Ꮤ鵵ẕ\ue4cf樔\uf3d1禉", 1016128547, 1326267968)), true, true);
      fvm(
         a.c(-608273165, "粘ԯ迯ᆏ騈Ჱꚹ⽘넖㮴뱶䙗죗典\udb36巛\ue7dc桙\uf2f6璪ﴘ蜊\u09bb鉬ᐑ麅❵ꤦ㏃떕㹻"),
         fvo(Items.NETHERITE_SCRAP, a.c(-885893216, "埱ࠞ꒕㪙때㎟覼B鸘ᒣ"), a.b("㣧䅼쯞喬\uda03岨\ue2c6欟\uf535羇\uf85fɞ貍ᔰ鼜ᶂꏗⰇ뚺゜뤓썈", 1345207531)),
         true,
         true
      );
      fvr(
         a.c(-1230220475, "匹⫉ꁎ㸹뗽㍝襞æ麣ᑁ鏜榬\ue760纅\uf498牢젼䟱\udd4f嬉틥ꢩ☋붟㮳녲࣐蚒ᱴ"),
         !ppu.picked(
            fvo(Items.NETHERITE_SCRAP, a.c(-1588496992, "痱⨞蚕ᢙ靌ᆟꮼ≂반㚣"), a.c(1158358909, "⍱嫪큈为솕䜾縷炉\ueea3搑\ue3c9ᧈ霛\u0ea6蒊ؔ롁㞑괬⬊ꊅ\ud8de")),
            Set.of(a.c(1106050426, "ﴛ蒡\u0e63逎ᯔ鵲✺껖\u3098먓㷬잍䥋탩媫"))
         ),
         ""
      );
      fvr(
         a.d("喯Ⰲꛜ㢥덵㖊辊٫頥ኇ镅潤\ue1fa硑\uf251瓮캪䅪\udbc5嶙푹긳\u209d뭝㵧럥ๆ耆\u1ae2鲢", 1943216333, 1028748556),
         ppu.picked(new ItemStack(Items.NETHERITE_SCRAP), Set.of(a.c(-874594990, "봳쒉之퀦导\udd5a朒\ueefe炰層緄螥ॣ郁᪃"))),
         ""
      );
      ItemStack var2 = fvo(Items.TNT, a.b("㻯愀춋厇\udc61嫺\ue0df楙", -692568388), a.b("㖣䰌웞壐퍸嗆\uef91晨ﰪ犉\uf55f༧膎ᡍ鈜ᒟ껞╣믎㶐됗츿䂀\udb5d崪ퟶ", -1549127272));
      fvr(
         a.d("벙씦俸톋婔\udcae暉\uef62焧ﯢ籸蘓\u0897酤ᬹ鷅➈ꡑ㊥듸㵁䜑즹刼퐔廚\ue768椤\uf3c2痖︪æ諻ፚ锕ᾩꁶ⨀", -216373198, 974509295),
         ppu.picked(var2, Set.of(a.d("㽊䛵찫剘\ud987异\ue57a沑\uf2d4", -1934723647, -360166688)))
            && !ppu.picked(var2, Set.of(a.c(-1383198576, "ხ楀\ue392緾\uf638炳쫋䌠\udd65"), a.c(548423481, "䝎㻥됬"))),
         ""
      );
      fvr(
         a.b("ꅟ\ud8f2刬챕䞅셺筝\uf2b6泳\ue636憬鯇ᕃ貢ۭ耑㩖떀⽽\ua958₵嫾", 927506745),
         ppu.picked(new ItemStack(Items.TNT), Set.of(a.d("軇\uf76c綥", -1160098614, 1384891002)))
            && !ppu.picked(new ItemStack(Items.TNT), Set.of(a.b("扌ᯢ鄰ཛྷ蒚ȑ롩ㆂ꿇", 325935666), a.d("伶㚉뱗∤ꧻ⽾锆᳭芨", -2025542650, -326442149))),
         ""
      );
      fvm(a.c(-1371588117, "㦏䀽쫢咛\udf57姿\ue3a6機"), fvn(Items.TRIPWIRE_HOOK, a.c(-855751823, "䌾᳑끚⹖ꆿ❒鵿ᓹ說f螿秞\uf313溸\ue0ea晾\udc40古줧佺")), true, true);
      fvm(
         a.b("\ue2ab鬌ᇌ辻Ѥ苔㣉녫⼬ꖟ≋", 1116594884),
         fvo(
            Items.PAPER,
            a.d("삕齺㏱귽∞ꓻỘ霣ॸ菊М\ufe6c璢\ue972捚\ue5a9忣", -1523819686, -96953467),
            a.b("럒칎䒛\udae0儳ퟸ淜\ue034繧\uf0b1睧赪β驹ᑁ隯ⳡꌵ㧾뾫㘣䰈습崈\udf43嗆\uec05扞\uf8ad绿\uf549ங藏ᡟ鹷ᓄꬖ", 2072753130)
         ),
         true,
         true
      );
      fvm(
         a.c(-1393361415, "ﶓ萨\u0eee郆᭜鷯➷깋〛몥㵺윜"),
         fvo(Items.FEATHER, a.d("紞≕蹺ၶ龝ᤎꍗ⪪뒉㹄릕䏮쵋咆\udeab尺\ue26a涺\uf70c焷\uf8d3苰", -55062592, -731794797), a.d("矘ใ蓯\u1a9d酋ឆ꧊␡빤㓚덀䤻쟹", 848060730, -256896261)),
         true,
         true
      );
      fvm(a.c(565637939, "\uf359諠0鹉ᖟ錥⤸ꂊ㻗둵㎦짊䜆"), new ItemStack(Items.GOLDEN_CARROT), true, true);
      fvm(a.d("戎ᮼ酸༖蓉ɳ렺㇚꾄╱ꋧ墊홁", -431120216, -969096499), new ItemStack(Items.FERMENTED_SPIDER_EYE), true, true);
      fvr(a.d("谰\uf5c0罃\ue12e櫴\uec4d嘙\udfa6䆭쬇䳏뚯㡰ꆌ\u2b96굽ᝡ飾Ɍ葒෩瞽契拓", -1178905405, -1584473974), !ppu.known(new ItemStack(Items.TOTEM_OF_UNDYING)), "");
      fvr(a.b("骃\ue33f槷\uf780簃\ufafb䂲줐圁\uddb1娭ꀐ⻂띴㴬", -1386439960), !ppu.known(new ItemStack(Items.DIRT)), "");
      fvr(a.c(-1379258625, "⺄坴\uddf7䎚졀仹\uf4ad紒\ue30b榹\uee6eᐊ髁ͽ褹ྚ떜㩗ꂷ⚨꽞핀宿쁫䘓쳉"), !ppu.known(new ItemStack(Items.FEATHER)), "");
      fvr(
         a.d("魊\ue2e7根\uf60d綨מּ䅫좚囟\udc66宺ꆅ⼜뚢㳽먄\u000e辖ᔢ錽᪸惎\uee7b疪\uf3cf礖삪", 895776694, -602608493),
         ppu.byId(a.d("쓿뵛㞅꧱∼꒓Ọ露ड़菆И﹢炦\ue918捑", -158138273, 1121240283)).name.equals(a.c(-50827258, "琫ඈ蝐ᤢ銌ᑀ긟⟣붡㌒듛仒쁵姉펗")),
         ""
      );
   }

   private static void fvm(String var0, ItemStack var1, boolean var2, boolean var3) {
      boolean var4 = ppu.picked(var1, Set.of(ppu.WARDEN_DEFAULTS));
      boolean var5 = ppu.picked(var1, Set.of(ppu.END_DEFAULTS));
      fvr(var0, var4 == var2 && var5 == var3, a.b("沦ᔁ鿁Ʀ詰ೊ뛊", -383357738) + var4 + a.c(-233890183, "Ṝ枨\ued70猋\uf885") + var5);
   }

   private static ItemStack fvn(Item var0, String var1) {
      ItemStack var2 = new ItemStack(var0);
      var2.set(DataComponentTypes.CUSTOM_NAME, Text.literal(var1));
      return var2;
   }

   private static ItemStack fvo(Item var0, String var1, String var2) {
      ItemStack var3 = fvn(var0, var1);
      var3.set(DataComponentTypes.LORE, new LoreComponent(List.of(Text.literal(var2))));
      return var3;
   }

   private static void fvp() {
      Object var0 = new Object();
      Object var1 = new Object();
      Object var2 = new Object();
      Object var3 = new Object();
      Object var4 = new Object();
      fvr(a.c(-821206589, "懴᠇鋓\u0cf6蝨Ǟ"), pjd.enter(var0, a.c(449629999, "콋뛵㱺ꈊ⧖")), "");
      fvr(a.b("\ude7eꞓⵊ덿㣡빗", 251780682), pjd.enter(var1, a.c(-723595278, "쿛똤㳸ꋕ⤃꾹")), "");
      fvr(a.c(-409328469, "⒞嵮\ud7ab䦞숀䒶"), pjd.enter(var2, a.c(-612345464, "妹 \uaad1")), "");
      fvr(a.b("붻쑊亅킼嬼\udd9b柀\uee2c灴", -1312309882), !pjd.enter(var3, a.b("㨭䎓줜坬\udcb0", -1496040887)), "");
      fvr(a.d("㚰佁얎宷퀩嚂\uec82攵ﭥ燏\uf61d౫苨ᬐ酄\u17fb그∬뢘㻂", 613815792, -1604443296), pjd.position(var3) == 1, String.valueOf(pjd.position(var3)));
      fvr(
         a.d("淣ᐓ黜å譥ෂ랙㹵ꀭ⫏굞在\ud9f2䁂쨖䳭\uf6e6祾\ue3d0", 713278384, 1481354869),
         !pjd.enter(var4, a.d("仑㝯뷠⎐ꡌ", -1112946602, -78215453)) && pjd.position(var4) == 2,
         ""
      );
      fvr(a.b("\uee87霹ᷫ莁ࡊ軶㒲봑⌏ꦱ\u2e6d퐏嫉썳䤱쾙疟穀悴\ue6a3潀ᔆ鮵", -302715151), pjd.hasRoom(a.d("ᚂ漼\ue5b3篃\uf01e", -768327130, -676506432), var4), "");
      fvr(a.b("ၽ槍\ue315紡\uf6ba瀂쩕䎳\uddff坘탘⫯ꐱ㶝랜ㄹ譪Ҷ鹀ᡝ醩\uebf8敐", 83169285), pjd.enter(var0, a.c(-1441462124, "ࣰ煎﯁斱\uee6c")), "");
      fvr(a.b("\ud8ddꅰ⮮떚㹘뢨˧譞ᕒ鿤ᠪ\ue25e沉\uf574罰聯䏐찜嚨킪奕⍘귷㘫뀑㫔茧൪韕ᇓ驶撵\ueea9眞\uf142篨쐾么죆", 1663031438), !pjd.enter(var4, a.b("䠃ㆽ묲╂꺞", -1650702233)), "");
      fvr(a.d("녡죌䈒\udc26埥턔歛\ue2e2糺\uf643熚诽չ鲁ᛕ", -1397053933, 1635391241), pjd.enter(var3, a.c(-764753887, "졅뇻㭴ꔄ⻘")), "");
      fvr(a.c(-472222224, "疗\u0c3a蛤ᣐ錒ᗢ꾭☔렂㊩딩伖쇊塦툹咜\uee9d慍ﯦ"), pjd.position(var4) == 1, String.valueOf(pjd.position(var4)));
      pjd.leave(var1);
      fvr(a.d("粲ԟ迁ᇵ騷᳇Ꚉ⼱넩㮐뱉䘮좪兒\udb06嶹\ue7b7桡\uf2c0璀ﵠ蝣\u0991鈁ᐲ黠❛ꥀ㏵떭㸞", 6992128, -150090279), pjd.enter(var4, a.d("∶守턇佷쒫", -412624489, -1325532219)), "");
      fvr(
         a.d("\ue4da鵷ើ觘ȏ蓻㻼뜑⥃ꏥ␡", -111416696, -223736275),
         pjd.count(a.c(-1335151233, "㔛䲥옪塚펆"), null) == 3,
         String.valueOf(pjd.count(a.c(-1967262715, "\uf461跟ݐ餠ዼ"), null))
      );

      for (Object var8 : new Object[]{var0, var1, var2, var3, var4}) {
         pjd.leave(var8);
      }

      fvr(
         a.b("\ua63b\udf87啝쬹䃯옚簁\uf5f7殷\ue156曕鲵ቱ证Ƅ蝴", -1246124449),
         a.c(1432350839, "\uf046觶̮").equals(pnr.anarchy(a.b("\ue111颯ሲ豑އ脽", 1370481014)))
            && a.d("禣\u0013請", 88447192, -986914486).equals(pnr.anarchy(a.d("廊✕귉㏄렒㺨", -283733531, -1693462778))),
         ""
      );
      fvr(
         a.d("毹ቓ颜۠贠\u0bc3뇓㠮꙳Ⳃ\uab1d兣\udfbe䙋챑䪺\uf0a6缹\ue58b掕\uea2a遼Ố", -182273133, 1339412498),
         pnr.anarchy(a.d("쥺냌㨝ꑤ", -709315761, -1728087463)) == null && pnr.anarchy(a.d("紤Ҝ踇ၤ鮲ᴈ", 112504933, -1120547546)) == null,
         ""
      );
      fvr(a.c(1670257366, "᪷挞\ue9d4矫ﱽ竎삝䥠휥嶏\uda46\u2063껽㝋"), pnr.allow(a.d("늤쬚䆕\udfe5吹", 1178038860, -759775092)), "");
      fvr(
         a.b("ჹ楋\ue380綾\uf62b炗쫟䌩\udd25埞퀈⩿꒯㵐띊ㆦ", 883429533),
         pjd.enter(var0, a.b("Ι稧\uf0a8滘\ue504", -1681587203)) && pjd.enter(var1, a.d("⤄傺\uda35䑅쾙", 575934141, -962254883)),
         ""
      );
      fvr(
         a.d("滲ᜂ鷂ϲ蠳ໆ듗㴫ꍯ⦊긎呩\udab6䌚쥎俬\uf5e1稷\ue089曙\uef29镲ᮅ耀٣貿㕉뭗↸\ua7f0Ⰽ튝壐섡䝾췕爙\uf872", -525093227, -271460320),
         !pjd.enter(var2, a.d("翑ٯ賠ነ饌", -356192282, -1772318637)),
         ""
      );
      pjd.leave(var0);
      pjd.leave(var1);
      pjd.enter(var0, a.b("Ꝉ\udef6呹쨎䇝", -1366907092));
      pjd.enter(var1, a.c(2116194217, "迍\uf673糼\ue28b楘"));
      pjd.enter(var2, a.b("２蚬ణ鉔ᦇ", -92405898));
      fvr(
         a.c(1354888291, "\uf43a趓ݙ饦ደ鑃⸐\ua7ed㦨댂㓋컩䁪\ud988厏핳漵\ue0f1穃ﱖ痩྿脓᪒鲹ᙳ꾏↟묩㴾뚞䡖숙室\uddb6圈\ue8d0抲\ue470緊\uf784褬̶蒝ḙ造⧾ꍆ━뺔ゥ쩷䏂얛"),
         !pnr.allow(a.d("ᙲ濌\ue543笴\uf0e7", -529951476, -789871846)),
         ""
      );
      fvr(
         a.b("儤⢘ꉂ㰪럺ㅂ譖ˮ鲬ᙉ釛殬\ue57d糄\uf690瀯쨣䗰\udf4c夐탡ꪹ␕뾗㦼덱\u0acf蓛ṻ頼ᎇ\ued4b", 1494241648),
         !pnr.allow(a.c(-1673381854, "㡆䇸쭷唀\uded3")) && pjd.position(pjd.MAIN) == 0,
         ""
      );

      for (Object var12 : new Object[]{var0, var1, var2, pjd.MAIN}) {
         pjd.leave(var12);
      }
   }

   private static void fvq(kfx var0) {
      wap.set(wam.RU);
      int var1 = 0;

      for (kfe var3 : var0.getModules()) {
         String var4 = wap.t(var3.getDescription());
         boolean var5 = var4.chars().anyMatch(var0x -> var0x >= 1024 && var0x <= 1279);
         if (!var5) {
            var1++;
            System.out
               .println(
                  a.d("⊄嬲퇲侜쐆䋣\uf8a1煆\uef1e旡\ue228᠗雁༿蔞ψ릁㙐곹⪠ꍘ\ud947垰챠䨉새祪\uf720淎\ueb9b怵黢ᒬ贓ଆ膾㹴둗", -28806999, -2116595091)
                     + var3.getName()
                     + a.b("\uec3b閐", 893578243)
                     + var4
               );
         }
      }

      fvr(a.b("ﲉ蔫\u0feb醍ᩑ鲹⚧꽔\u3100뮠㱪옒䢀텵嬧\uddc0枟\ue85f狷\uf4ad絝܍觺ቢ鐚ẅꝄ⤲돃㖒븻䃢쪢", 269941965), var1 == 0, var1 + a.c(445628220, "뼗웯䰻툄妶\udf2c敶\uec8c狖\uf87d羵"));
   }

   private static void fvr(String var0, boolean var1, String var2) {
      if (!var1) {
         fvc++;
      }

      System.out
         .println(
            a.d("늩쬟䇟\udfb1含틎梌\ue16b缳\uf5d6", -1988455556, 1892360633)
               + (var1 ? a.c(-156007812, "舩ﮉ煈\uef39撝") : a.d("毪ቜ颇۳赈", 1067866807, -1804717794))
               + var0
               + (!var1 && !var2.isEmpty() ? a.c(-907926006, "☨徑") + var2 + a.c(395055268, "ႌ") : "")
         );
   }

   private static void fvs(MinecraftClient var0, vlj var1) throws Exception {
      fvk(var0, a.b("孔⋙ꠇ㙮붥㬃", 1179540226));
      Method var2 = hlc.class.getDeclaredMethod(a.b("艓ﯽ焻\uef41撨\ue220塹톀俑앷", -2008448458), vlj.class);
      var2.setAccessible(true);
      var2.invoke(var0.currentScreen, var1);
   }

   private static void fvt(Screen var0, String var1) {
      if (var0 != null) {
         for (char var5 : var1.toCharArray()) {
            var0.charTyped(new CharInput(var5, 0));
         }
      }
   }

   private static void fvu(MinecraftClient var0, String var1) {
      var0.getNetworkHandler().sendChatCommand(var1);
   }

   private static void fvv(MinecraftClient var0, String var1) {
      System.out
         .println(a.d("\uec53间Ἦ腕ૄ谡㙣뾄⇜ꬹ", -1513393298, 2127535940) + var1 + a.c(-1309758798, "ꪑ퍀姳") + var0.getCurrentFps() + a.d("▣屔횑䣣", 820680132, -1706774461));
      ScreenshotRecorder.saveScreenshot(
         var0.runDirectory,
         a.c(-1820769666, "䈞㮥녵⼜\ua48e∠") + var1 + a.b("欹ዖ頛٣", 1241148179),
         var0.getFramebuffer(),
         1,
         var0x -> System.out.println("" + var0x.getString())
      );
   }
}
