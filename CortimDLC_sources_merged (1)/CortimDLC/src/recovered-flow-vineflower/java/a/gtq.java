package a;

import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.hud.BossBarHud;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.world.CreateWorldScreen;
import net.minecraft.client.gui.screen.world.WorldCreator;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.KeyInput;
import net.minecraft.client.input.MouseInput;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.Perspective;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ChargedProjectilesComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.Entity.RemovalReason;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.boss.BossBar.Color;
import net.minecraft.entity.boss.BossBar.Style;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.s2c.play.BossBarS2CPacket;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;

public final class gtq {
   static int gtr;
   static int gts;
   static final String gtt = System.getenv(a.d("ꇍ\ud876劦쳏䝽송篾\uf219汏\ue6f4愵魕ᖔ谢ٺ肇㫘딏⾷ꧭ", -2057813570, -1980833759));
   static final List<PlayerEntity> gtu = new ArrayList<>();
   static Team gtv;
   static final int gtw = 70;
   static final String[] gtx = new String[]{
      a.d("ꉈ\udbf0儣", -1446839478, -795453074),
      a.b("羞ز賰ዥ饾Ὴꖁⱴ눷㢋", 1699446748),
      a.d("걒헪弹", 1844249284, 116109050),
      a.b("ﯕ艹ࢻ隮ᴪ鮇⇗ꠣ㙱", 202505108),
      a.d("ᗤ汜\ue68f", -614747790, -21846790),
      a.c(2036579230, "믾쉀䢟훦崠\udb84懑\ue834瘸ﳎ笖腪ྯ阞"),
      a.c(561752018, "Ꞿ\ude06哕"),
      a.c(-65997612, "\uf4b3贏ߜ駡ቹ铉"),
      a.b("ਲ玊陵", -1402926498),
      a.b("ᲃ政\uefec燑爫糹웤佁턟宩\udc66☐ꣀㅸ", -816374548),
      a.c(459575618, "鄦\ue89e才ﱺ矹\uf149䬝싰岨혞凄"),
      a.d("뷻쑇五킩嬱\udd81果\uee39灧𣏕紞蝨স退", 313983572, 781696960)
   };
   static final int[] gty = new int[]{0, 1, 0, 4, 0, 5, 0, 7, 0, 8, 9, 8};
   static long gtz;
   static long gua;
   static boolean gub;
   static PlayerEntity guc;
   static String gud;
   static final List<ServerBossBar> gue = new ArrayList<>();
   static double guf;
   static float gug = Float.NaN;
   static double guh;
   static float gui;
   static int guj;
   static final int[] guk = new int[]{Integer.MIN_VALUE, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 8};
   static final int gul = 70;
   static int gum;
   static int gun;
   static int guo;
   static int gup;
   static String guq;
   static String gur = a.b("敧᳟阄\u083f莩ԛ뽈㚽ꢤ", -1344969464);
   static int gus = -1;
   static int gut;

   gtq() {
   }

   public static void install() {
      if (Boolean.getBoolean(a.d("⻁坺\uddaa䏃졑仼\uf4f2紕\ue343槸\uee39ᑙ骘̮", 384057136, -695070311))
         && !a.d("䋍㭴놬⿆", -2116604378, 1141140610).equals(gtt)
         && !a.c(-1446649412, "\ue1cf顡\u12bf賏ܒ").equals(gtt)
         && !a.d("䋏㭽놮\u2fdb", 44444519, -1781962304).equals(gtt)
         && !a.b("\ue33c骇ၗ踾׳荊㤒냸", 1887429458).equals(gtt)) {
         System.out.println(a.c(1189386822, "騺\ue39d楇\uf73c粭煮䀊짭垵\udd50嫂ꂠ\u2e68럑㶃"));
         ClientTickEvents.END_CLIENT_TICK.register(gtq::guw);
      }
   }

   static void guw(MinecraftClient var0) {
      gts++;

      try {
         switch (gtr) {
            case 0:
               if (var0.getOverlay() == null && var0.currentScreen != null && gts > 40) {
                  CreateWorldScreen.showTestWorld(var0, () -> var0.setScreen(new TitleScreen()));
                  gwo();
               }
               break;
            case 1:
               if (var0.currentScreen instanceof CreateWorldScreen var4 && gts > 20) {
                  if (a.d("\uf4ef赎ޛ駡ሽ钛⻃", 20342427, -1565421056).equals(gtt)
                     || a.c(29790974, "銊\ueb26懴ﾝ瑎\uf2e7䢦").equals(gtt)
                     || a.c(1859302949, "뙟쿨䔣\udb52傍혫汹\ue590篝").equals(gtt)
                     || a.b("\udd89ꐿ\u2ef7낛㭓", -2054431233).equals(gtt)) {
                     WorldCreator var5 = var4.getWorldCreator();
                     var5.setWorldType(var5.getNormalWorldTypes().get(0));
                     var5.setSeed(System.getenv().getOrDefault(a.d("俖㙭벽⋔ꥦ⾺闥ᰂ艝࣭", 1737432814, 1927893364), a.c(1581267823, "㬃䊸졨嘁\uddc2孼\ue12a棗\uf683簨")));
                  }

                  Method var6 = CreateWorldScreen.class.getDeclaredMethod(a.b("捁\u1ae1逥๐薒̲륈ゐ껜⑾ꎤ", -83795159));
                  var6.setAccessible(true);
                  var6.invoke(var4);
                  gwo();
               }
               break;
            case 2:
               if (var0.world != null && var0.player != null && var0.currentScreen == null) {
                  if (gts > 100 && a.b("サ䤋쏔嶭홫像\uea9a捿", -1941884717).equals(gtt)) {
                     gtr = 4;
                     gts = 0;
                  } else if (gts > 100 && a.d("⾯嘀\udcd4䊯", 1949196665, 1235898021).equals(gtt)) {
                     gtr = 5;
                     gts = 0;
                  } else if (gts > 100 && a.c(1771221851, "댤쪋䁟\ude24嗽퍓椘\ue0f4").equals(gtt)) {
                     gtr = 6;
                     gts = 0;
                  } else if (gts > 100 && a.b("龢\ue606泑\uf2b3祺", 1530568663).equals(gtt)) {
                     gtr = 7;
                     gts = 0;
                  } else if (gts > 100 && a.d("잳븅㓐ꪦⅧꟁᶓ鑥ਭ肊", 671610495, -1517407819).equals(gtt)) {
                     gtr = 8;
                     gts = 0;
                  } else if (gts > 100 && a.d("匃⪤ꁴ", -2001281863, 1050251228).equals(gtt)) {
                     gtr = 9;
                     gts = 0;
                  } else if (gts > 100 && a.c(1818699749, "➁帠퓨䪗셏䟢").equals(gtt)) {
                     gtr = 10;
                     gts = 0;
                  } else if (gts > 100 && a.c(-42717328, "⼕嚭\udc76").equals(gtt)) {
                     gtr = 11;
                     gts = 0;
                  } else if (gts > 100 && a.d("∴完텗伭쓹䉈\uf81f", 2077073306, -1378435633).equals(gtt)) {
                     gtr = 12;
                     gts = 0;
                  } else if (gts > 100 && a.d("揪ᩉ邋", -235161981, -2072259299).equals(gtt)) {
                     gtr = 40;
                     gts = 0;
                  } else if (gts > 100 && a.b("ֵ簚\uf6ce梥\ue363旅", -1154349628).equals(gtt)) {
                     gtr = 41;
                     gts = 0;
                  } else if (gts > 100 && a.b("垎⸭ꓢ㪗녂㟪趪", -1481156626).equals(gtt)) {
                     gtr = 42;
                     gts = 0;
                  } else if (gts > 100 && a.d("硴Ǉ謏ᕣ麲᠂", -1809529027, 1585757986).equals(gtt)) {
                     gtr = 43;
                     gts = 0;
                  } else if (gts > 100 && a.d("\u0093礳\uf3fb涗", -585817970, -1998774150).equals(gtt)) {
                     gtr = 13;
                     gts = 0;
                  } else if (gts > 100 && a.b("㷡䑜캍僺", -1994703480).equals(gtt)) {
                     gtr = 14;
                     gts = 0;
                  } else if (gts > 100 && a.b("微☀곉㊾륽㿁薍", -237543457).equals(gtt)) {
                     gtr = 15;
                     gts = 0;
                  } else if (gts > 100 && a.c(-1027036768, "꧈클媨쓐").equals(gtt)) {
                     gtr = 16;
                     gts = 0;
                  } else if (gts > 100 && a.d("℣境퉘䰮쟣", -2051209135, 1306142983).equals(gtt)) {
                     gtr = 17;
                     gts = 0;
                  } else if (gts > 100 && a.b("瞒ุ蓰᪐酏", 225933283).equals(gtt)) {
                     gtr = 44;
                     gts = 0;
                  } else if (gts > 100 && a.d("䣱ㅛ뮈◺", 94801566, -1949579745).equals(gtt)) {
                     gtr = 45;
                     gts = 0;
                  } else if (gts > 100 && a.b("壳⅜", -858564457).equals(gtt)) {
                     gtr = 46;
                     gts = 0;
                  } else if (gts > 100 && a.d("\ue684鼠ᗤ讁", 2003505768, 287503512).equals(gtt)) {
                     gtr = 61;
                     gts = 0;
                  } else if (gts > 100 && a.d("騭\ue397楉\uf72e糾", 1853017000, -28093981).equals(gtt)) {
                     gtr = 60;
                     gts = 0;
                  } else if (gts > 100 && a.d("뿩왗䲃틶", -1774699523, -1938652047).equals(gtt)) {
                     gtr = 62;
                     gts = 0;
                  } else if (gts > 100 && a.d("\uf2fb譖ƈ鿡ᐪ銌⣞", -1190282581, 895502375).equals(gtt)) {
                     gtr = 47;
                     gts = 0;
                  } else if (gts > 100 && a.b("\ue4f8鵗ឃ觨Ȯ蒈㻙뜴⥦ꏘ␑\ude67", 880665731).equals(gtt)) {
                     gtr = 48;
                     gts = 0;
                  } else if (gts > 100 && a.d("浩ᓉ鸊r", -2106152828, 995935629).equals(gtt)) {
                     gtr = 63;
                     gts = 0;
                  } else if (gts > 100 && a.c(-1058000794, "」䦨썼崞훛偭\uea3f揟ﶍ眺").equals(gtt)) {
                     gtr = 64;
                     gts = 0;
                  } else if (gts > 100 && a.b("牥ீ脔ὶ钳ህꡃ↽뿨㕎", 1574269454).equals(gtt)) {
                     gtr = 65;
                     gts = 0;
                  } else if (gts > 100 && a.b("ꈖ\udbba兹켃䓉", 493134460).equals(gtt)) {
                     gtr = 66;
                     gts = 0;
                  } else if (gts > 100 && a.c(-1489436636, "Q秱\uf331浆\ue69c").equals(gtt)) {
                     gtr = 70;
                     gts = 0;
                  } else if (gts > 100 && a.c(-1391318701, "⤺傟\uda4d䐧쿲䥏\uf31e竩").equals(gtt)) {
                     gtr = 49;
                     gts = 0;
                  } else if (gts > 100 && a.d("ﴂ蒤\u0e6c逗ᯈ鵰", 432807533, -965025013).equals(gtt)) {
                     gtr = 50;
                     gts = 0;
                  } else if (gts > 100 && a.c(-1623059573, "ᏹ橔\ue08a绳\uf52c王").equals(gtt)) {
                     gtr = 51;
                     gts = 0;
                  } else if (gts > 100 && a.b("猓મ聾ḏ闑፦ꤢ\u20c8뺊", 678130553).equals(gtt)) {
                     gtr = 52;
                     gts = 0;
                  } else if (gts > 100 && a.b("씑벭㙥ꠓ", -428227209).equals(gtt)) {
                     gtr = 74;
                     gts = 0;
                  } else if (gts > 100 && a.c(-975589677, "꺱휇巇쎩").equals(gtt)) {
                     gtr = 18;
                     gts = 0;
                  } else if (gts > 100 && a.d("먲쎗䥅휯峺\uda4f怛\ue9e1", 966462147, 1001500824).equals(gtt)) {
                     gtr = 72;
                     gts = 0;
                  } else if (gts > 100 && a.d("꺌휹巭쎗䡇컵璴ﵓ", 958211401, -534475872).equals(gtt)) {
                     gtr = 73;
                     gts = 0;
                  } else if (gts > 100 && a.d("⽳囖\udc1e䉣즿伄\uf547粣\ue2fa", -819199926, 1059139414).equals(gtt)) {
                     gtr = 53;
                     gts = 0;
                  } else if (gts > 100 && a.b("ᮗ戾\ue8ff", 1634474983).equals(gtt)) {
                     gtr = 54;
                     gts = 0;
                  } else if (gts > 100 && a.b("⏥婟킜仪씠", 1110057870).equals(gtt)) {
                     gtr = 56;
                     gts = 0;
                  } else if (gts > 100 && a.b("슸묙㇌꾶⑪ꋌᢔ", 1638056652).equals(gtt)) {
                     gtr = 58;
                     gts = 0;
                  } else if (gts > 100 && a.d("ᢽ愑\uebc3疪ﹹ磐슑", -266775643, -345420948).equals(gtt)) {
                     gtr = 81;
                     gts = 0;
                  } else if (gts > 100 && a.b("ઽ猊療枰\uec6f櫉킛奲윿", -934343993).equals(gtt)) {
                     gtr = 82;
                     gts = 0;
                  } else if (gts > 100 && a.d("Ὺ晜\uec94狸擄", 1154818893, -1533330223).equals(gtt)) {
                     gtr = 83;
                     gts = 0;
                  } else if (gts > 100 && a.c(-71906608, "쪲댈㧖ꞵⱢ").equals(gtt)) {
                     gtr = 84;
                     gts = 0;
                  } else if (gts > 100 && a.b("薈ﰽ盰\ue886捘", 1161004542).equals(gtt)) {
                     gtr = 85;
                     gts = 0;
                  } else if (gts > 100 && a.b("妎‡ꫵ㒎뽐㧭莼ੋ", 855595505).equals(gtt)) {
                     gtr = 86;
                     gts = 0;
                  } else if (gts > 100 && a.b("뤛삾䩻", -153699975).equals(gtt)) {
                     gtr = 87;
                     gts = 0;
                  } else if (gts > 100 && a.d("㨴䎟쥑", 2084374824, -1137888404).equals(gtt)) {
                     gtr = 88;
                     gts = 0;
                  } else if (gts > 100 && a.b("\uf782踿Ӱ骟ᅀ韠ⶮꑕ㨚", 344586216).equals(gtt)) {
                     gtr = 89;
                     gts = 0;
                  } else if (gts > 100 && a.d("蘅ﾾ畮\ueb07惋\ue679尪헟", -1775538895, -576066726).equals(gtt)) {
                     gtr = 90;
                     gts = 0;
                  } else if (gts > 100 && a.c(2115524771, "壊ⅰꮱ㗚븏㢵英").equals(gtt)) {
                     gtr = 93;
                     gts = 0;
                  } else if (gts > 100 && a.b("흶껅␛멻", -949561569).equals(gtt)) {
                     gtr = 94;
                     gts = 0;
                  } else if (gts > 100 && a.d("䝘㻦됮⩞ꆎ✣鵭ᒍ", 1481178597, -898188589).equals(gtt)) {
                     gtr = 91;
                     gts = 0;
                  } else if (gts > 100) {
                     Field var1 = hlc.class.getDeclaredField(a.b("\ue0ec饈᎘跀ع肔", -1792679778));
                     var1.setAccessible(true);
                     var1.set(null, a.b("໌睑ﶀ揾\ue82a溎", 1997082249));
                     gvn();
                     var0.setScreen(new hlc());
                     gwo();
                  }
               } else {
                  gts = 0;
               }
               break;
            case 3:
               gux(var0);
               break;
            case 4:
               gvb(var0);
               break;
            case 5:
               gvp(var0);
               break;
            case 6:
               gvq(var0);
               break;
            case 7:
               gvr(var0);
               break;
            case 8:
               gvw(var0);
               break;
            case 9:
               gvc(var0);
               break;
            case 10:
               gwe(var0);
               break;
            case 11:
               gvx(var0);
               break;
            case 12:
               gvy(var0);
               gwa(var0);
               break;
            case 13:
               if (flm.crit(var0)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 14:
               if (flm.mace(var0)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 15:
               if (hfi.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 16:
               guy(var0);
               break;
            case 17:
               if (gpu.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 18:
               if (fvb.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 55:
            case 57:
            case 59:
            case 67:
            case 68:
            case 69:
            case 71:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 92:
            default:
               break;
            case 40:
               gwb(var0);
               gwa(var0);
               break;
            case 41:
               gwc(var0);
               gwa(var0);
               break;
            case 42:
               if (fyl.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 43:
               if (ghy.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 44:
               if (hbt.totem(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 45:
               if (hbt.tool(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 46:
               if (fwv.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 47:
               if (fug.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 48:
               if (hgq.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 49:
               if (gax.tick(var0)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 50:
               if (fgv.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 51:
               if (heb.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 52:
               if (fjv.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 53:
               if (hdt.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 54:
               if (gxf.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 56:
               if (gkm.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 58:
               if (gsz.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 60:
               if (fif.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 61:
               if (grw.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 62:
               if (fbc.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 63:
               if (fpo.tick(var0)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 64:
               if (fdp.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 65:
               if (fbw.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 66:
               if (gnr.tick(var0)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 70:
               if (grd.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 72:
               if (gef.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 73:
               if (fdx.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 74:
               if (fga.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 81:
               if (gyf.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 82:
               if (hav.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 83:
               if (gzt.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 84:
               if (fxp.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 85:
               if (hdj.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 86:
               if (hge.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 87:
               if (fbk.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 88:
               if (gwv.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 89:
               if (fkm.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 90:
               if (fwd.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 91:
               if (fvw.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 93:
               if (gml.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
               break;
            case 94:
               if (ghf.tick(var0, gts)) {
                  var0.scheduleStop();
                  gtr = 99;
               }
         }
      } catch (Throwable var3) {
         System.out.println(a.b("\ue2db魼ᆦ违ь芩㣫넌⽔ꖱ∤\ud852嚍켹䕣쎓禂\uf649", 711123642) + var3);
         var3.printStackTrace();
         var0.scheduleStop();
         gtr = 99;
      }
   }

   static void gux(MinecraftClient var0) throws Exception {
      Screen var1 = var0.currentScreen;
      switch (gts) {
         case 1:
            kfe var25 = Flow.getInstance().getModuleManager().getByName(a.d("決ᗭ鼥Ś認ా뙺㾻ꇉ⭣", 1566273967, 1962614155));
            if (var25 != null) {
               var25.setEnabled(true);
            }
            break;
         case 25:
            gwp(var0, a.b("듷쵇䞈\ud9b7剬퓟溃\ue771礻", 946648270));
            break;
         case 26:
            gws(var1, 200.0F, 69.0F, 1);
            break;
         case 36:
            gwp(var0, a.d("뤎삽䩱푘徔\ud92d捷\uea85瓒﹢禰", 1632024044, 79891673));
            break;
         case 37:
            for (int var24 = 0; var24 < 5; var24++) {
               gwq(var1, 264);
            }
            break;
         case 55:
            gwp(var0, a.c(-1197233159, "ꯁ퉳墾욖䵝쯡熺\uf843"));
            break;
         case 56:
            gwq(var1, 264);
            gwq(var1, 264);
            break;
         case 70:
            gws(var1, 250.0F, 101.0F, 0);
            gwr(var1, a.b("豱\uf5e6缓", 76188706));
            gwq(var1, 257);
            break;
         case 76:
            gws(var1, 250.0F, 101.0F, 1);
            gwr(var1, a.c(-2145284948, "賥\uf57d羬\ue1d3標"));
            gwq(var1, 257);
            break;
         case 92:
            gwp(var0, a.d("⬩劜\ud856䙩춲䬂\uf159碧\ue6f6汓", 1106080037, -323528138));
            break;
         case 93:
            gwq(var1, 264);
            break;
         case 105:
            int var23 = var0.player.getBlockX();
            int var36 = var0.player.getBlockY();
            int var42 = var0.player.getBlockZ();
            gws(var1, 220.0F, 100.0F, 0);
            gwr(var1, a.b("㕬䳾옿塘", -1340066518));
            gwq(var1, 258);
            gwr(var1, String.valueOf(var23 + 14));
            gwq(var1, 258);
            gwr(var1, String.valueOf(var36));
            gwq(var1, 258);
            gwr(var1, String.valueOf(var42 + 26));
            gwq(var1, 257);
            break;
         case 110:
            int var22 = var0.player.getBlockX();
            int var35 = var0.player.getBlockY();
            int var41 = var0.player.getBlockZ();
            gws(var1, 220.0F, 100.0F, 0);
            gwr(var1, a.d("畛\u0cce蘚ᡠ", 1507992169, 330651515));
            gwq(var1, 258);
            gwr(var1, String.valueOf(var22 - 22));
            gwq(var1, 258);
            gwr(var1, String.valueOf(var35 + 3));
            gwq(var1, 258);
            gwr(var1, String.valueOf(var41 + 40));
            gwq(var1, 257);
            break;
         case 115:
            gws(var1, 189.0F, 167.0F, 0);
            gws(var1, 220.0F, 100.0F, 0);
            gwr(var1, a.b("賶\uf564羦\ue1c1樏", 1734839456));
            gwq(var1, 257);
            break;
         case 120:
            int var21 = var0.player.getBlockX();
            int var34 = var0.player.getBlockY();
            int var40 = var0.player.getBlockZ();
            wlk.add(a.c(-819087867, "뙈쿞䔞\udb3d傼혒汄\ue5b5篧\uf150皁"), var21 + 420, var34 + 8, var40 - 610, wlk.COLORS[4]);
            break;
         case 138:
            gwp(var0, a.b("\uf093褧Ϭ鷇ᘆ邯⫵ꌛ㵂럴〽쩋", -1617694545));
            break;
         case 139:
            gwq(var1, 256);
            break;
         case 160:
            gwp(var0, a.b("쏰멇わ꺻╱ꏑ\u19cb遺ษ蒋́菉矾\uee4e", -1279278130));
            System.out
               .println(
                  a.c(1850462216, "큩\ua9ce⌔뵯㛾뀛ਖ਼莾ᷦ霃Ⴘ\uead4搒ﷇ矗\uf135䭿쓻")
                     + String.format(a.c(1115424523, "ܪ纐\uf45c橺"), izx.cpuMicros())
                     + a.c(1514184265, "鹠\ue784浑\uf37c磢﹇䐇췺厭")
               );
            break;
         case 161:
            guc = gvk(var0);
            jjx.onAttack(guc);
            break;
         case 166:
            guc.setHealth(9.0F);
            guc.hurtTime = 10;
            guc.maxHurtTime = 10;
            break;
         case 169:
            gwp(var0, a.c(204640063, "輂\uf6b4籽\ue255榗\uef35啳\udc80䋎젦侰뗀㬊"));
            break;
         case 184:
            gwp(var0, a.c(-581742801, "伕㚣밥∛ꦕ⼱镱Ვ苈ࡨ"));
            break;
         case 185:
            guc.setInvisible(true);
            break;
         case 195:
            gwp(var0, a.c(1072181565, "ㄙ䢯숨尗힙儽\ueb7d抙ﳄ癤\uf1ee\u0bdb蔋Ტ雮စ꩐▊뼷㥯"));
            break;
         case 196:
            var0.world.removeEntity(guc.getId(), RemovalReason.DISCARDED);
            var0.setScreen(new hlc());
            break;
         case 212:
            gwp(var0, a.b("\uf16a裓ȕ鰻\u17fb酀⬌ꋨ㲼뙎㇃쮠䕻\udcc2囙큱樫\ue5f9", -2076774072));
            break;
         case 213:
            gwq(var1, 265);
            gwq(var1, 265);
            gwq(var1, 265);
            break;
         case 215:
            gwt(var1, 330.0F, 200.0F, -7.0);
            break;
         case 232:
            gwq(var1, 256);
            break;
         case 250:
            var0.setScreen(new hlc());
            break;
         case 275:
            gwp(var0, a.c(-1844247811, "˘筠\uf1a7澉\ue449拲\ud8be党켎䗼쉱㠒뛉⽰ꕫ⏄馛ᙛ賵ધ荐"));
            break;
         case 276:
            gwr(var1, a.c(-1567244307, "뾝옪䳢튝"));
            break;
         case 290:
            gwp(var0, a.d("䂓㤣돭ⷅꘟ₧髭ጛ赍\u07b6耡穞\uf480洰\ue77e憘\udbd6", -1927225233, 1394778332));
            break;
         case 291:
            gws(var1, 400.0F, 23.0F, 0);
            gwr(var1, a.c(-1120386007, "䑙㷮뜦⥙"));
            break;
         case 310:
            gwp(var0, a.d("䀵㦄덋ⵤꚥ‐驐Ꮀ跤", 233828903, 1747956266));
            break;
         case 311:
            gwq(var1, 256);
            gwq(var1, 256);
            gwq(var1, 256);
            break;
         case 315:
            gwp(var0, a.b("켧뚕㱙ꉦ⦾꼌ᕃ鲨˰衈", 653512476));
            break;
         case 335:
            kfx var20 = Flow.getInstance().getModuleManager();
            var20.getByName(a.c(-173327307, "㱫䗼켴克\uda9c尯\ue66b澪\uf1d8筲")).setKey(82);
            var20.getByName(a.b("盎བྷ薀ᯝ逸ᚉ곀┫뭳", -1214220666)).setKey(71);
            var20.getByName(a.c(1903306840, "⠑冔\udb46䔬컇䡒\uf217篷")).setKey(88);
            var0.player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 2400, 1));
            var0.player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 900, 0));
            var0.player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 180, 0));
            var0.player.getInventory().setStack(1, new ItemStack(Items.ENDER_PEARL, 16));
            var0.player.getItemCooldownManager().set(new ItemStack(Items.ENDER_PEARL), 400);
            kfe var33 = var20.getByName(a.b("ꉥ\udbe2儦콓䒗숱硘\uf184濒\ue57f抹食", 1292149306));
            var33.setEnabled(true);

            for (vmo var43 : var33.getSettings()) {
               if (var43 instanceof vlq var45) {
                                    if (java.util.Objects.equals(var45.getName(), a.d("땧체䘗\ud869去픀") || java.util.Objects.equals(var45.getName(), 1260262772) || java.util.Objects.equals(var45.getName(), 856007735))) {
                     var45.set(86);
                  }
                  else if (java.util.Objects.equals(var45.getName(), a.b("樥ᎇ餩ݕ賰ਾ됂㧡Ʝⴉ꫞") || java.util.Objects.equals(var45.getName(), 1822256655))) {
                     var45.set(90);
                  }
                  else if (java.util.Objects.equals(var45.getName(), a.b("륻샖䨆퐋徬\ud911挼\ueab0瓬﹖") || java.util.Objects.equals(var45.getName(), -1245528752))) {
                     var45.set(66);
                  }
               }
            }

            ItemStack var39 = new ItemStack(Items.NETHERITE_SCRAP, 6);
            var39.set(DataComponentTypes.CUSTOM_NAME, Text.literal(a.b("岯╼꿟ㆡ멳㳈", 743200907)));
            var0.player.getInventory().setStack(12, var39);
            ItemStack var44 = new ItemStack(Items.SPLASH_POTION, 2);
            var44.set(DataComponentTypes.CUSTOM_NAME, Text.literal(a.c(770437488, "\uf55a賸ٖ頪ᎏ镁⭽ꚞ㣍뉶㖡")));
            var0.player.getInventory().setStack(20, var44);
            var0.player.getItemCooldownManager().set(var39, 300);
            break;
         case 360:
            gwp(var0, a.d("䌻㪈끅\u2e71ꖻ⌛", 366801436, -477253360));
            break;
         case 361:
            Flow.getInstance().getModuleManager().getByName(a.b("\uf0b4褭Ϻ鶧ᙂ郳⪺ꍑ㴉", -1353387780)).toggle();
            break;
         case 368:
            gwp(var0, a.d("ꗖ\udc62嚨좝䍐엾羠\uf65e栋\ue2f3敬鼐ᇎ表Ƚ", -1005608849, 81724807));
            break;
         case 400:
            var0.setScreen(new ChatScreen("", false));
            break;
         case 425:
            gwp(var0, a.d("㙩俜씗嬣탩噉\uec53旬﮸焀\uf6c6", -785130367, 1407838930));
            break;
         case 426:
            Field var19 = hlc.class.getDeclaredField(a.d("읻뻟㐏꩗↮꜃", -2032123304, -1695906479));
            var19.setAccessible(true);
            var19.set(null, a.d("\uea47鏫ᤩ", -1181746092, -1692002728));
            var0.setScreen(new hlc());
            break;
         case 455:
            gwp(var0, a.b("㕯䳙옑堥폯問\uef55曽\uf8b7爅", -928893612));
            break;
         case 456:
            var0.setScreen(new jbs());
            break;
         case 480:
            gwp(var0, a.d("Τ稓\uf0da滮\ue524掄\ud99e倧칹䓅쌋㥡랫", 682813124, 576185692));
            break;
         case 481:
            float var18 = gvo(izx.KEYBINDS, a.c(1906330302, "䫇"));
            float var32 = gvo(izx.KEYBINDS, a.b("簹", -1094615999));
            float var37 = gvo(izx.KEYBINDS, a.c(-1925402679, "꾿"));
            var1.mouseClicked(new Click(var18 + 10.0F, var32 + 6.0F, new MouseInput(0, 0)), false);
            var1.mouseDragged(new Click(var1.width - var37 + 8.0F, var32 + 26.0F, new MouseInput(0, 0)), 0.0, 0.0);
            break;
         case 490:
            gwp(var0, a.b("鄰\ue888扎ﱺ瞰\uf110䬊슲峻홙册", 579178762));
            break;
         case 491:
            var1.mouseReleased(new Click(0.0, 0.0, new MouseInput(0, 0)));
            gwq(var1, 256);
            break;
         case 500:
            gwq(var0.currentScreen, 256);
            break;
         case 520:
            iov.PRESET.set(a.c(1177681311, "\ufddc葙ທ郺ᬪ"));
            break;
         case 545:
            gwp(var0, a.c(1836508307, "\ue4ae鴗័觤Ȯ蒎㺔뜮⥥ꏉ␆\ude70"));
            break;
         case 546:
            iov.PRESET.set(a.c(-2074664447, "≄寑턏佴쒤䈛\uf847熪"));
            izx.resetLayout();
            jgn.shutdown();
            Field var17 = jgn.class.getDeclaredField(a.c(420220490, "\u0e3b瞌﵌挿\ue8e0"));
            var17.setAccessible(true);
            var17.set(
               null,
               new jgd(
                  a.b("ਵ玧參朁\ueccb橵퀹妟잋䴧쫩", -1183053203),
                  a.c(-894316669, "쿎뙑㲇ꋱ⤬꾐ᗄ鰼Ȥ裹༏\uf570箨\ue205桑"),
                  a.d("봥쒨乶큂寢\udd61朲\ueecd炗館", 2041865592, 1444337667),
                  true,
                  64000L,
                  200000L,
                  System.currentTimeMillis()
               )
            );
            Field var31 = jgn.class.getDeclaredField(a.c(1591621186, "㘨侒안嬶탨噛\uec09旝﮷"));
            var31.setAccessible(true);
            var31.setLong(null, System.currentTimeMillis());
            break;
         case 575:
            gwp(var0, a.b("藏ﱼ皲\ue887捊\ue5e4徺홄䠑싩䕧뼊㇐\ua879∶ꓐ", -1789491731));
            break;
         case 660:
            gwp(var0, a.d("㒁䴳쟼姉툄咪\ueef4朊寧玧\uf43a็肒\u193e鍼ᖏ꿗", -1301740275, -1753271889));
            System.out
               .println(
                  a.b("▇尠훺䢁쌐䗵ﾷ癐\ue808拭\ue556Ἲ釼ࠩ船ӛ뺑ㄕ", -1291049498)
                     + String.format(a.b("䕚㳠똬⠊", -1887091333), izx.cpuMicros())
                     + a.c(509672449, "ﰨ藌༙鄴᪪鰏♏꾲\u31e5")
               );
            break;
         case 661:
            for (String var5 : new String[]{a.c(927842855, "쉮믴ㄭ꽝⒝ꉾᡉ醎࿂蕵ʮ\uf8de"), a.b("쮹눶㣸ꚕⵏꯩ", 183487464)}) {
               ServerBossBar var6 = new ServerBossBar(Text.literal(var5), Color.PURPLE, Style.PROGRESS);
               gue.add(var6);
               var0.inGameHud.getBossBarHud().handlePacket(BossBarS2CPacket.add(var6));
            }
            break;
         case 690:
            gwp(var0, a.d("륒샣䨯퐑忋\ud966挵\uea9a璊︸秸莈", 1921365337, 722078773));
            break;
         case 691:
            var0.setScreen(new ChatScreen("", false));
            break;
         case 700:
            float var15 = gvo(izx.KEYBINDS, a.d("⥜", -1662892191, -126063036));
            float var29 = gvo(izx.KEYBINDS, a.c(1261559127, "\udd2f"));
            izx.mouseClicked(var15 + 12.0F, var29 + 6.0F, 0);
            izx.mouseDragged(var0.getWindow().getScaledWidth() * 0.5 - 40.0, var0.getWindow().getScaledHeight() * 0.62);
            break;
         case 712:
            gwp(var0, a.b("\ue394騤ჩ軖Ԋ莲㧴끜⹊ꓭ⌭\ud95a", 2131026858));
            break;
         case 713:
            izx.mouseReleased();

            for (ServerBossBar var28 : gue) {
               var0.inGameHud.getBossBarHud().handlePacket(BossBarS2CPacket.remove(var28.getUuid()));
            }

            var0.setScreen(null);
            izx.resetLayout();
            break;
         case 720:
            gud = isv.selected();
            isv.select(a.d("馗\ue03e櫰\uf49f罀", 2118238366, 778197371));
            Field var13 = hlc.class.getDeclaredField(a.d("筳˗蠇ᙟ鶦ᬋ", -1427046630, -2117827557));
            var13.setAccessible(true);
            var13.set(null, a.d("畢\u0cff蘮ᡐ鎄ᔠ", -1413107149, -1271937260));
            var0.setScreen(new hlc());
            break;
         case 745:
            gwp(var0, a.d("埔\u2e63꒩㪘녇㟽趵М騞Ⴓ靭洔\ue3c4", 1486328961, 1578615658));
            break;
         case 746:
            gwq(var0.currentScreen, 264);
            break;
         case 747:
            for (int var12 = 0; var12 < 4; var12++) {
               gwq(var0.currentScreen, 264);
            }
            break;
         case 765:
            gwp(var0, a.d("ꑊ\uddfc圷줟䋔쑨縳\uf7ca槝\ue331擾麂ၝ觫", -624869637, 2122750605));
            break;
         case 766:
            isv.select(gud);
            var0.setScreen(null);
            break;
         case 770:
            iov.PRESET.set(a.b("ೳ畹ﾮ懍\uea0c泲훏弙셈䯶찹", -1141109588));
            iov.ACCENT.set(a.c(-1533579206, "灿৺茨ᵂ"));
            gvm(var0, a.d("Ṷ査\ued25獜\uf883", -1905020205, 585149684));
            break;
         case 795:
            gwp(var0, a.c(370381534, "鋢\ueb57憟ﾷ瑼\uf2c0䢛셢彵햝剕ꠠ⛥뽂"));
            break;
         case 796:
            gwt(var1, 330.0F, 200.0F, -7.0);
            break;
         case 815:
            gwp(var0, a.c(-592107864, "⚕弡헨䯀쀋䚷ﳬ甕\ueb02懳\ue624᱘銏ଶ腬"));
            break;
         case 816:
            gwt(var1, 330.0F, 200.0F, -12.0);
            break;
         case 835:
            gwp(var0, a.c(666791432, "温ធ鵔ͼ袷ซ두㶩ꎾ⥕꺐哬\uda3b䎖짔伴\uf56e窨\ue01a"));
            break;
         case 836:
            iov.BG_HUE.set(0.93);
            iov.BG_SATURATION.set(0.5);
            iov.BG_BRIGHTNESS.set(0.17);
            gwt(var1, 330.0F, 200.0F, 30.0);
            break;
         case 860:
            gwp(var0, a.b("鍠\ueada思︵痾\uf342䤙샠廷퐈反ꦺ❪뻀㒑", -689466531));
            break;
         case 861:
            Field var11 = hzq.class.getDeclaredField(a.d("㏇䩸삷", 1478027201, 69719150));
            var11.setAccessible(true);
            var11.setInt(hzv.ALL.get(0), 82);
            var11.setInt(hzv.ALL.get(2), 72);
            iov.PRESET.set(a.d("嫶⍼ꦫ㟈밉㫷胊ज靍ᷳ騼", -373474083, 32597620));
            gvm(var0, a.d("跰\uf46d线\ue0c6欞\ueda1埦", -547564049, 45242459));
            break;
         case 875:
            gwt(var0.currentScreen, 330.0F, 200.0F, -10.0);
            break;
         case 895:
            gwp(var0, a.c(396552189, "\ue7c4鹶ᒸ誌Ŝ蟶㶺둅⨆ꂽ"));
            break;
         case 896:
            var0.setScreen(null);
            break;
         case 925:
            gwp(var0, a.c(974439639, "쓵뵆㞉ꦸ≣꓁ẋ靴़莌Ё︼烩\ue958挍\ue5f7徢"));
            break;
         case 926:
            wlk.COLOR.set(a.c(1884074973, "뎑쨘䃒"));
            iov.PRESET.set(a.b("뱋엎伀텭媽", 1515568136));
            break;
         case 950:
            gwp(var0, a.c(-529521502, "⒅崵ퟹ䧈숓䒱ﻻ眄\ue94c揼\ue471Ṃ邍थ茵֏뿔〘ꪷⳡ"));
            break;
         case 951:
            wlk.COLOR.reset();
            iov.PRESET.set(a.b("㮌䈙죇嚼\udd6c寓\ue18f桢", -478266423));
            iov.ACCENT.reset();

            for (vmc var26 : List.of(iov.BG_HUE, iov.BG_SATURATION, iov.BG_BRIGHTNESS)) {
               var26.reset();
            }

            for (hzq var27 : hzv.ALL) {
               var27.reset();
            }
            break;
         case 955:
            for (wkq var3 : wlk.inWorld()) {
               wlk.remove(var3);
            }

            hyz.save();
            gwo();
      }
   }

   static void guy(MinecraftClient var0) throws Exception {
      Screen var1 = var0.currentScreen;
      switch (gts) {
         case 1:
            wap.set(wam.RU);
            Field var5 = hlc.class.getDeclaredField(a.d("\ueb93鈷ᣧ蚿െ诫", -2085129670, -1294362149));
            var5.setAccessible(true);
            var5.set(null, a.c(2130942973, "鮸\ue225棴\uf68a絞ﯺ"));
            gvn();
            var0.setScreen(new hlc());
            break;
         case 25:
            gwp(var0, a.c(594996679, "\ueda5鐙ễ肽ଠ趌㟞븳•ꪟⵎ휰姤쁀"));
            break;
         case 26:
            gws(var1, 200.0F, 69.0F, 1);
            break;
         case 40:
            gwp(var0, a.d("\ufb45苹ࠥ陝᷀魬ℽ꣓㛔뱾㮥쇝伉횰峢\uda12", 2103439908, -1932392163));
            break;
         case 41:
            gws(var1, 400.0F, 23.0F, 0);
            gwr(var1, a.c(1374776945, "樿ᎂ饕͈賻\u0a45뀖㧤Ꞹ\u2d77"));
            break;
         case 60:
            gwp(var0, a.c(-817157862, "⥣僟\uda03䑻쿦䥊\uf31a竵\ue4f4湓\ue984Ꮶ鴠Қ躌࠼뉾㶷꜒⅙ꢯ"));
            gws(var1, 400.0F, 23.0F, 1);
            gwr(var1, a.d("됷춎䝙\udd34勳퐳湠\ue7e8秎\uf37c", 1060563247, -1919330014));
            break;
         case 80:
            gwp(var0, a.b("ｐ蛬ర鉈᧕齹┮곆㋇론㾷엕䬓튩墿\ude17摞\ueb9c焠\uf76c纄Ӑ詾", 1984102187));
            gws(var1, 400.0F, 23.0F, 1);
            gwr(var1, a.b("\ue8d0酠ᮾ藂ฟ袪", 256634089));
            break;
         case 100:
            gwp(var0, a.c(-636291389, "\uf6be輂מ鮦ျ隗ⳁꔨ㬩놎㙙찻䋽\udb47兑\ud7ff涷"));
            var1.close();
            break;
         case 120:
            var0.setScreen(new hlc());
            break;
         case 140:
            gwp(var0, a.c(-1609000816, "飯\ue153殏\uf5f7繪\uf8c6䊓쭹啸\udfdf堈ꉪⲬ딖㼀릷϶谲ᚅ"));
            break;
         case 141:
            gws(var1, 400.0F, 23.0F, 1);
            gwq(var1, 256);
            Field var4 = hlc.class.getDeclaredField(a.b("\ueb04銠ᡰ蘨ෑ譼", -312611978));
            var4.setAccessible(true);
            var4.set(null, a.c(1659057765, "㘱侷앯嬔탂噤"));
            var0.setScreen(new hlc());
            break;
         case 160:
            gwp(var0, a.c(-946742426, "\udb04ꊸ⡤똜㶁묭Ź袒ᚒ鰴ᯬ\ue197潁\uf6e7"));
            guz(var0, var0.currentScreen, 26.0F, 362.0F);
            break;
         case 180:
            gwp(var0, a.c(-902835222, "펓ꨯ\u20f3뺋㔖뎺ৡ者Ḗ钰፴\ue910柒ﹰ瑼\uf2d0䢆읝左\udbb9剙"));
            break;
         case 181:
            guz(var0, var0.currentScreen, 500.0F, 23.0F);
            var0.setScreen(new ida(var0.currentScreen));
            break;
         case 200:
            gwp(var0, a.b("\udef7ꝋ\u2d97돯㡲뻞҄赡\u137f駃ḟ\ue467檢\uf307祒ﾡ䖦쨪傀훛弤╻ꯟ", 339009164));
            break;
         case 201:
            wap.set(wam.EN);
            var0.setScreen(null);
            Flow.getInstance().getModuleManager().getByName(a.d("誈\uf31b租\ue7af汵\ueace傊\ud966䜿춏䩁", -51837954, 1234602285)).setEnabled(true);
            ItemStack var2 = new ItemStack(Items.CROSSBOW);
            ItemStack var3 = new ItemStack(Items.ARROW);
            var2.set(DataComponentTypes.CHARGED_PROJECTILES, ChargedProjectilesComponent.of(List.of(var3, var3.copy(), var3.copy())));
            var0.player.getInventory().setStack(var0.player.getInventory().getSelectedSlot(), var2);
            var0.player.setPitch(-12.0F);
            break;
         case 220:
            gwp(var0, a.d("敜᳠阼ࡄ菙մ뼦㛊꣕≼ꖶ忟턕䢾싶䐀﹔", -717523428, -372042947));
            break;
         case 225:
            Flow.getInstance().getModuleManager().getByName(a.d("㼯䚼챸刈\ud9d2彩\ue52d況\uf298砨￦", 692029487, -280643749)).setEnabled(false);
            hyz.save();
            var0.scheduleStop();
            gtr = 99;
      }
   }

   static void guz(MinecraftClient var0, Screen var1, float var2, float var3) throws Exception {
      float var4 = gva(var1, a.c(-774990299, "降\uefe1攩ﭖ炏\uf639䱜"));
      float var5 = gva(var1, a.d("㡲䇞쬖啩\udeb0堆\ue262", -165481251, 1770179783));
      float var6 = gva(var1, a.c(-1285709508, "ꅊ\ud8eb刺챆䞘"));
      float var7 = gva(var1, a.c(-741277156, "ɩ篈\uf119潥\ue4bb戶"));
      double var8 = var0.getWindow().getScaleFactor();
      GLFW.glfwSetCursorPos(var0.getWindow().getHandle(), (var4 + var2 * var6) * var8, (var5 + var3 * var7) * var8);
   }

   static float gva(Object var0, String var1) throws Exception {
      Field var2 = var0.getClass().getDeclaredField(var1);
      var2.setAccessible(true);
      return var2.getFloat(var0);
   }

   static void gvb(MinecraftClient var0) throws Exception {
      rjy var1 = rjy.get();
      Screen var2 = var0.currentScreen;
      switch (gts) {
         case 1:
            var1.setEnabled(true);
            PlayerEntity var9 = gvi(var0, a.b("猛ઙ聝Ḷ闦ፎꤎ\u20f4뺶㐀돑䦹", -1534037183), 4.6, -1.8, 10.0F);
            var9.equipStack(EquipmentSlot.HEAD, gvj(Items.NETHERITE_HELMET));
            var9.equipStack(EquipmentSlot.CHEST, gvj(Items.NETHERITE_CHESTPLATE));
            var9.equipStack(EquipmentSlot.LEGS, gvj(Items.NETHERITE_LEGGINGS));
            var9.equipStack(EquipmentSlot.FEET, gvj(Items.NETHERITE_BOOTS));
            var9.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.ENCHANTED_GOLDEN_APPLE, 58));
            PlayerEntity var11 = gvi(var0, a.d("䃥㤴뎆ⷷ꘠", 1679540086, -1012924476), 10.5, 4.6, 2.0F);
            var11.equipStack(EquipmentSlot.HEAD, gvl(Items.IRON_HELMET, 0.6F));
            var11.equipStack(EquipmentSlot.CHEST, gvl(Items.IRON_CHESTPLATE, 0.3F));
            var11.equipStack(EquipmentSlot.MAINHAND, gvl(Items.DIAMOND_SWORD, 0.2F));
            var11.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Items.TOTEM_OF_UNDYING));
            PlayerEntity var5 = gvi(var0, a.b("様ၤ骽ӎ輓\u09a9돷㨏ꐏ⺾ꥭ匜\uddcb", -816092743), 22.0, -9.0, 17.0F);
            var5.equipStack(EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
            var5.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
            PlayerEntity var6 = gvi(var0, a.c(1865238867, "䤝よ멘\u243c꿳"), 7.0, 1.2, 20.0F);
            var6.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.NETHERITE_SWORD));
            var6.setAbsorptionAmount(4.0F);
            Scoreboard var7 = var0.world.getScoreboard();
            gtv = var7.addTeam(a.c(-1714558707, "\ue962郙ᨉ葠\u0ff2褅㍇몠⓸"));
            gtv.setPrefix(Text.literal(a.d("ᴫ撄\uee5e瀪ﯠ絀윋亇", -238686938, 592244830)).formatted(Formatting.GOLD, Formatting.BOLD));
            gtv.setSuffix(Text.literal(a.c(-1172129434, "륂쁴䩣\uf315")));
            var7.addScoreHolderToTeam(a.d("ꛏ\udf4d喉쯢䀲욚糚\uf520止\ue1d4昅鱭", 1280257182, 1359514123), gtv);
            hhf.add(a.d("璟ഊ蟚ᦾ鉱", -2120045444, 1795676333));
            break;
         case 40:
            gwp(var0, a.c(-479424838, "躘\uf729緤\ue3d6栎\ueeb3哨\udd08䍂짵串됝㪀ꌺ⥤꾇ᗈ"));
            break;
         case 41:
            var1.background.set(a.b("饈\ue0dc樗\uf462義洛", -511403774));
            break;
         case 55:
            gwp(var0, a.c(90846558, "㕿䳉옃報폩啔\uef0f曯\uf8a5爒\uf5d5\u0ffa腬ᣘ銓ᑦ긵⇩"));
            break;
         case 56:
            var1.background.set(a.b("껧흪嶺쏎䠔", 777039537));
            var1.health.set(a.c(1454506385, "Ǘ硋\uf283泮"));
            var1.items.set(a.d("鐇\ued95杋藍狧", 1546488734, 1469063133));
            var1.distance.set(true);
            break;
         case 70:
            gwp(var0, a.b("끎짹䌲\udd00囘큥樾\ue3de綔\uf723烤請т鷯ឿ酋⬉", 365539436));
            break;
         case 71:
            var1.background.set(a.b("뷸쑨人타", 731758002));
            var1.tint.set(a.d("檝ጉ駉ޡ", 1779921938, -1473700145));
            var1.items.set(a.b("놹젯䋾\udc8a坚퇠", -824331786));
            var1.health.set(a.b("腷\uf8f7爹\uec44", 1094418727));
            var1.distance.set(false);
            break;
         case 85:
            gwp(var0, a.d("▝尩훡䣓쌋䖶￭瘍\ue847拰\ue537Ἐ醌࠼艮Ҕ", -1755359532, 821654378));
            break;
         case 86:
            var1.background.set(a.d("ꉖ\udbcc儒콱䒦", 985360281, 1170261389));
            PlayerEntity var8 = gtu.get(1);
            Vec3d var10 = var8.getEyePos().subtract(var0.player.getEyePos());
            var0.player.setYaw((float)Math.toDegrees(Math.atan2(-var10.x, var10.z)));
            var0.player.setPitch((float)(-Math.toDegrees(Math.atan2(var10.y, Math.hypot(var10.x, var10.z)))));
            hhf.toggleAimed();
            break;
         case 94:
            gwp(var0, a.b("僱⥄ꎍ㶷뙴マ誁ͻ鴮៖遃樼\ue4f7", 232542415));
            System.out
               .println(
                  a.d("၌槫\ue331絊\uf6db瀾쩼䎛\uddc3圦킳⫖ꐚ㶧럿\u3104譜Ӟ", -2047181930, -1893241925)
                     + hhf.all().size()
                     + a.d("\ua6ff\udf46嗯쯾䁈웹粪\uf528欱\ue194晜鰡ዽ譆ŋ螠", 795402739, 1390167868)
                     + hhf.isFriend(a.d("昦ῗ镅\u0b34胣", -293373105, 1602755870))
                     + a.c(550474009, "鄱")
               );
            break;
         case 95:
            gvm(var0, a.d("ꙃ\udfc6唎쭳䂯옔籐", -1117474187, 1349522551));
            break;
         case 120:
            gwp(var0, a.b("썡뫛〝긧◤ꍎᤑ郫\u0ebe萘Ε尿睿\ueecd", 199344988));
            break;
         case 121:
            gvm(var0, a.b("ќ線\uf702楹\ue2af搉", -858258424));
            break;
         case 145:
            gwp(var0, a.c(1233679081, "狊ୱ膶ᾄ鑜ዡꢺ⅚뼐㖧뉠䡏웖彥픥参"));
            break;
         case 146:
            if (var2 != null) {
               gwq(var2, 256);
            }

            var1.setEnabled(false);
            break;
         case 160:
            gwp(var0, a.b("鯬\ue259梗\uf6bd絽\ufbc3䆗졣嘼\udc80嬟ꄷ⿵뙂㰅", -2012111913));
            break;
         case 161:
            for (PlayerEntity var4 : gtu) {
               var0.world.removeEntity(var4.getId(), RemovalReason.DISCARDED);
            }

            gtu.clear();
            var0.world.getScoreboard().removeTeam(gtv);
            hhf.remove(a.d("䋩㭼놬⿈ꐇ", -427658780, 178074435));
            hhf.remove(a.c(1506934745, "ﾎ號೭銜᥋"));
            hyz.save();
            var0.scheduleStop();
      }
   }

   static void gvc(MinecraftClient var0) throws Exception {
      kfx var1 = Flow.getInstance().getModuleManager();
      ruv var2 = (ruv)var1.getByName(a.c(1052493468, "웁뽅㖅ꯡ‴Ꚕᳶ锑୍"));
      switch (gts) {
         case 1:
            var2.setEnabled(true);
            var1.getByName(a.c(-1651905955, "\uea1d鎍\u1943蜅\u0cfe詌〜맰")).setEnabled(true);
            var1.getByName(a.d("鋼\ueb79憫\uffc1琪\uf2b8䣩섃彛헰", -61033399, -1958140162)).setEnabled(true);
            var0.player.setPitch(8.0F);
            guc = gvk(var0);
            ruv.onAttack(guc);
            var0.player.equipStack(EquipmentSlot.HEAD, gvl(Items.NETHERITE_HELMET, 0.05F));
            var0.player.equipStack(EquipmentSlot.CHEST, gvl(Items.NETHERITE_CHESTPLATE, 0.4F));
            var0.player.equipStack(EquipmentSlot.LEGS, gvl(Items.DIAMOND_LEGGINGS, 0.7F));
            var0.player.equipStack(EquipmentSlot.FEET, gvl(Items.DIAMOND_BOOTS, 0.93F));
            ItemStack var11 = new ItemStack(Items.ENCHANTED_GOLDEN_APPLE, 12);
            var11.set(
               DataComponentTypes.CUSTOM_NAME,
               Text.literal(a.b("\ude10肧\u0a11鑋ᾑ餫⍱ꪏ㓊빪㦸쎍䴽풤廴\ud80d扃\ued99睤\uf154碒˃豬឴醎ᬐꊪⲽ똞こ믭䕹콗嚉탗婬\ue5b7濍\ue904烡𥉉萆๒觪ጩ鴋⒣긅⡣뎰㷁윛亦죲划\udc48染\ue17f䰊", 2056780045))
            );
            var0.player.getInventory().setStack(2, var11);
            var0.player.getItemCooldownManager().set(var11, 600);
            var0.player.getInventory().setStack(1, new ItemStack(Items.ENDER_PEARL, 16));
            var0.player.getItemCooldownManager().set(new ItemStack(Items.ENDER_PEARL), 300);
            izx.TARGET.enabled.set(false);
            break;
         case 14:
            izx.cpuMicros();
            ruv.cpuMicros();
            break;
         case 24:
            gwp(var0, a.c(-1066049918, "庺✎귀㏹렸㺊蒄ി鍯᧙鸖摠\ueab0"));
            System.out
               .println(
                  a.c(-1658058012, "\u0a8e猩麟枈\uec19櫼킾奙윁䷤쩤〒뻔❡괷⯛重Ṵ蓚ʚ謉\uf11b羻\ue46f扅")
                     + String.format(a.b("ꍿ\udac5倉츯", 2127209310), izx.cpuMicros())
                     + a.c(863999220, "铛\ued3f柪劉牙\uf4fc亼읁外폮吱긥⃤륖㍵")
                     + String.format(a.c(282202103, "࿖癬ﲠ抆"), ruv.cpuMicros())
                     + a.d("\u16fa漞\ue5cb篦\uf078盝첝䕠\udb37", 1111642054, -1523427051)
               );
            break;
         case 25:
            var2.mode.set(a.b("瘻ྩ蕫ᬉ郇ᙱ갫◌", 2033743456));
            break;
         case 40:
            gwp(var0, a.d("\u0011禤\uf36b浒\ue693怡\uda2f厀췜䝼삼㫔됄ⶼꟹ", -1450575155, -1961624858));
            break;
         case 41:
            var2.mode.set(a.b("厺⨮ꃳ㺍땆㏭覹O鸙", -907979777));
            break;
         case 50:
            gvf(guc);
            break;
         case 52:
            gwp(var0, a.b("\ue3fe驈ႄ躽ռ菎㧀끰⸪꒕⍉\ud924埩칟䐋싳磶\uf762淐\ueb9c", -644750369));
            break;
         case 60:
            gwp(var0, a.c(1718172011, "㥏䃹쩺呄\udfdb奼\ue32c檀\uf49e縪立Ή赂ᓩ麽ᡋꈍ"));
            break;
         case 61:
            var2.mode.set(a.b("쉮믤\u3130꽈", 650232376));
            break;
         case 75:
            gwp(var0, a.d("䖑㰦뛫⣒ꌓ□龯ᘁ衅˳蔩", 1582961642, 913593925));
            break;
         case 76:
            var2.mode.set(a.c(-341037562, "⹃埞\udd0f䍶좰丆"));
            break;
         case 90:
            gwp(var0, a.d("밿얏佅텼媽\udc0f昁\uefbe燭ﭞ粅蛥࠵", -892716194, -1895987367));
            break;
         case 91:
            var2.mode.set(a.c(600957745, "\ue370髮်蹗և茱"));
            break;
         case 105:
            gwp(var0, a.b("凮⡟ꊔ㲭띬㇞诐ɫ鰻ᚍ酂欴\ue5e4簋\uf614烣쪪䕳\udfc7", -1860218424));
            break;
         case 106:
            var2.mode.set(a.c(-1653143758, "ݳ续\uf439橔\ue184朲"));
            break;
         case 111:
            gvf(guc);
            break;
         case 113:
            gwp(var0, a.b("ّ翣\uf52b欒\ue0d3晡\udc6f嗔쮄䄲웽㲋뉛⮴ꆢ❒鴀ኈ衵ศ蟜ﶎ猠", -1711995277));
            break;
         case 114:
            izx.TARGET.enabled.set(true);
            break;
         case 116:
            var0.setScreen(new ChatScreen("", false));
            break;
         case 125:
            ixu var10 = izx.ARMOR;
            float var12 = gvg(var10, a.d("鐮", 1832803711, -8730328));
            float var13 = gvg(var10, a.d("浐", -666082674, 632885158));
            float var14 = gvg(var10, a.d("낁", -1533002251, -957313790));
            float var7 = gvg(var10, a.b("龽", 895459284));
            izx.mouseClicked(var12 + var14 * 0.9, var13 + var7 * 0.2, 1);
            izx.mouseDragged(var12 + var14 * 1.08, var13 - var7 * 0.1);
            break;
         case 135:
            gwp(var0, a.c(-1861394239, "惣ᥐ鎙ඤ虠Î몟㍳굳➝ꁙ娾퓳䵑윝䆤ﮯ瑹\uee89梖\ue16a鬲ᖔ"));
            break;
         case 136:
            izx.mouseReleased();
            var0.setScreen(null);
            break;
         case 138:
            var0.options.forwardKey.setPressed(true);
            break;
         case 144:
            System.out.println(a.c(1543196175, "乔㟳봩⍒ꣃ⸦鑤ᶃ菛ा躌瓉﨟掵\ue9da漈핅媏쀻䙰쿓뗕㭰ꂬ⛔갇ᖳ鯫Ł蜊೪\uf238硵\ue19f柋\ued60努\ud8dc帆쟰") + var0.player.isSprinting());
            var0.options.forwardKey.setPressed(false);
            break;
         case 150:
            gwp(var0, a.c(-59673738, "獕૩耯ḛ闑፱ꥫ⃖뺚㐴돥䦉윁廾풡剐\ue81c柅ﵽ笴\uf2da袖"));
            System.out
               .println(
                  a.c(-1098448287, "Ȁ箧\uf17d漆\ue497扲\ud830凗쾏䕪싑㢽뙻⾮ꖾ⍜餖ᚒ")
                     + String.format(a.c(1681791731, "\u1ad2捨\ue9a4瞂"), izx.cpuMicros())
                     + a.b("蜑ﻵ琠\uea0d憓\ue736嵶풋䫜", -1141930184)
               );
            System.out.println(a.c(-1093256841, "㤐䂷쩭吖\udf87奢\ue320櫇\uf49f繺狀Έ赝ᓷ麣ᡈꈚⷌ띶ㅠ") + var0.player.isSprinting());
            break;
         case 151:
            gvh(izx.ARMOR);
            gvd();
            gve(var0, var2, 0);
            break;
         case 995:
            izx.ENABLED.set(true);
            izx.BACKGROUND.set(a.b("驅\ue3df椁\uf762粵", -1759405561));
            rjy.get().setEnabled(false);
            var2.setEnabled(true);
            var0.world.removeEntity(guc.getId(), RemovalReason.DISCARDED);
            gvm(var0, a.c(-263356906, "繂߄贜፧颱ḗ"));
            break;
         case 1017:
            gwp(var0, a.c(-1182379975, "倁⦼ꍻ㵕뚕〯詶Ά鷎ᜠ邪櫎\ue41a"));
            break;
         case 1018:
            var2.setEnabled(false);
            var1.getByName(a.c(1457476812, "和ⴜ\ua7d2㦔뉯㓝躍ݡ")).setEnabled(false);
            var1.getByName(a.b("圩⺬ꑾ㨔뇿㝭贼Ӗ骎ဥ", 212621154)).setEnabled(false);
            hyz.save();
            var0.scheduleStop();
            break;
         default:
            int var3 = gts - 151;
            if (gts > 151 && gts < 151 + 70 * gtx.length) {
               int var4 = var3 / 70;
               int var5 = var3 % 70;
               if (gty[var4] >= 8) {
                  var0.player.setYaw(var0.player.getYaw() + 3.0F);
               }

               if (var5 == 0) {
                  gve(var0, var2, gty[var4]);
               } else if (var5 == 20) {
                  gtz = 0L;
                  gua = System.nanoTime();
               } else if (var5 == 69) {
                  double var6 = (System.nanoTime() - gua) / 1.0E9;
                  double var8 = var6 * 1000.0 / Math.max(1L, gtz);
                  System.out
                     .println(
                        a.b("䎨㨏냕⺮ꔿ⏚馘ၿ踧ӂ荒礯\uf7e4湒\ue455", -782482476)
                           + gtx[var4]
                           + a.c(-230128457, "蒏ﴤ")
                           + String.format(a.b("䨛㎡륮❋", -662746566), var8)
                           + a.d("柫ḗ铚\u0af7腩ߌ붌㑱ꨦ⃒꜉", -383642705, 1816753263)
                           + Math.round(gtz / var6)
                           + a.d("ا翐\uf515歧\ue0ea", -1522604249, -157097691)
                     );
               }
            }
      }
   }

   static void gvd() {
      if (!gub) {
         gub = true;
         HudRenderCallback.EVENT.register((HudRenderCallback)(var0, var1) -> gtz++);
      }
   }

   static void gve(MinecraftClient var0, ruv var1, int var2) {
      if (var0.currentScreen != null) {
         var0.setScreen(null);
      }

      boolean var3 = var2 == 7 || var2 == 8;
      izx.ENABLED.set(var2 >= 1 && var2 <= 4 || var3);
      izx.BACKGROUND.set(var2 == 4 ? a.b("ᗊ汇\ue697磣\uf339", 1700795804) : a.b("韡\uee7b撥陼焑", -368470109));
      hyv.STYLE.set(var2 == 2 ? a.c(-618272392, "\ue939邼ᩲ萟࿏襯㌽") : a.c(-1861300990, "쵈드㸗ꁢ⮩괕"));
      hyv.FROST.set(var2 == 3 ? 0.0 : 2.0);
      rjy.get().setEnabled(var2 == 5 || var3);
      var1.setEnabled(var2 == 6 || var3);
   }

   static void gvf(PlayerEntity var0) {
      var0.setHealth(Math.max(2.0F, var0.getHealth() - 5.0F));
      var0.hurtTime = 10;
      var0.maxHurtTime = 10;
   }

   static float gvg(jcs var0, String var1) throws Exception {
      Field var2 = jcs.class.getDeclaredField(var1);
      var2.setAccessible(true);
      return var2.getFloat(var0);
   }

   static void gvh(jcs var0) throws Exception {
      Field var1 = jcs.class.getDeclaredField(a.b("砩Ƃ譂ᔬ", 2024503390));
      var1.setAccessible(true);
      var1.setFloat(var0, 1.0F);
   }

   static PlayerEntity gvi(MinecraftClient var0, String var1, double var2, double var4, float var6) {
      OtherClientPlayerEntity var7 = new OtherClientPlayerEntity(var0.world, new GameProfile(UUID.randomUUID(), var1));
      Vec3d var8 = var0.player.getRotationVec(1.0F).multiply(1.0, 0.0, 1.0).normalize();
      Vec3d var9 = new Vec3d(-var8.z, 0.0, var8.x);
      Vec3d var10 = var0.player.getEntityPos().add(var8.multiply(var2)).add(var9.multiply(var4));
      var7.refreshPositionAndAngles(var10.x, var0.player.getY(), var10.z, var0.player.getYaw() + 180.0F, 0.0F);
      var7.setHealth(var6);
      var0.world.addEntity(var7);
      gtu.add(var7);
      return var7;
   }

   static ItemStack gvj(Item var0) {
      ItemStack var1 = new ItemStack(var0);
      var1.set(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true);
      return var1;
   }

   static PlayerEntity gvk(MinecraftClient var0) {
      OtherClientPlayerEntity var1 = new OtherClientPlayerEntity(var0.world, new GameProfile(UUID.randomUUID(), a.c(-36600509, "蔂ﲅ癁\ue834揯")));
      Vec3d var2 = var0.player.getRotationVec(1.0F).multiply(1.0, 0.0, 1.0).normalize();
      Vec3d var3 = var0.player.getEntityPos().add(var2.multiply(3.2));
      var1.refreshPositionAndAngles(var3.x, var0.player.getY(), var3.z, var0.player.getYaw() + 180.0F, 0.0F);
      var1.equipStack(EquipmentSlot.HEAD, gvl(Items.NETHERITE_HELMET, 0.1F));
      var1.equipStack(EquipmentSlot.CHEST, gvl(Items.DIAMOND_CHESTPLATE, 0.45F));
      var1.equipStack(EquipmentSlot.LEGS, gvl(Items.DIAMOND_LEGGINGS, 0.7F));
      var1.equipStack(EquipmentSlot.FEET, gvl(Items.IRON_BOOTS, 0.9F));
      var1.equipStack(EquipmentSlot.MAINHAND, gvl(Items.NETHERITE_SWORD, 0.3F));
      var1.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Items.TOTEM_OF_UNDYING));
      var1.setAbsorptionAmount(4.0F);
      var0.world.addEntity(var1);
      return var1;
   }

   static ItemStack gvl(Item var0, float var1) {
      ItemStack var2 = new ItemStack(var0);
      var2.setDamage(Math.round(var2.getMaxDamage() * var1));
      return var2;
   }

   static void gvm(MinecraftClient var0, String var1) throws Exception {
      Field var2 = hlc.class.getDeclaredField(a.c(1747766233, "쮫눏㣟ꚇ\u2d7eꯓ"));
      var2.setAccessible(true);
      var2.set(null, var1);
      Field var3 = hlc.class.getDeclaredField(a.c(-1450134053, "떏찮䛬\ud880協헥澩"));
      var3.setAccessible(true);
      ((Map)var3.get(null)).clear();
      gvn();
      var0.setScreen(new hlc());
   }

   static void gvn() throws Exception {
      for (String var3 : new String[]{a.d("顲\ue1dd欉\uf572纮\uf807䉻", 283812617, -34325749), a.d("띳컜䐈\uda73冯휆浻", 1029626087, 1635282916)}) {
         Field var4 = hlc.class.getDeclaredField(var3);
         var4.setAccessible(true);
         var4.setFloat(null, Float.NaN);
      }
   }

   static float gvo(Object var0, String var1) throws Exception {
      Field var2 = jcs.class.getDeclaredField(var1);
      var2.setAccessible(true);
      return var2.getFloat(var0);
   }

   static void gvp(MinecraftClient var0) {
      ClientPlayerEntity var1 = var0.player;
      kfe var2 = Flow.getInstance().getModuleManager().getByName(a.c(230570316, "㤓䂔쩐吥\udfe1奇\ue32e櫲\uf4a4縉紐Ω"));
      vlq var3 = null;
      vkl var4 = null;
      vkl var5 = null;

      for (vmo var7 : var2.getSettings()) {
         if (var7 instanceof vlq var8 && var8.getName().equals(a.d("\ue882鄔᮷藉\u0e65賀㊁뭷╟꿬⡏", -1153168875, -423172469))) {
            var3 = var8;
         } else if (var7 instanceof vkl var9 && var9.getName().equals(a.b("無ࣂ艩ᰓ韆ᅵ꼶⋘벆㙈뇡䮞셜峺횮倯\uea6f旅ｲ", -646154973))) {
            var4 = var9;
         } else if (var7 instanceof vkl var10 && var10.getName().equals(a.b("\uddceꐠ\u2ef8냴㬫붞ϗ踴ᑹ骪ᴋ\ue773榡\uf014穂ﲽ", 858905025))) {
            var5 = var10;
         }
      }

      byte var11 = 74;
      if (gts > 1) {
         guh = Math.max(guh, var1.getY());
         if (Float.isNaN(gug) && !oxw.busy()) {
            gug = var1.getPitch();
         }
      }

      switch (gts) {
         case 1:
            var2.setEnabled(true);
            var3.set(var11);
            gwi(var0, a.c(-55187667, "\ue75b黬ᐳ詊ƕ蜦㵾뒎⪔ꁶ➣\uddd5匆쪨䃤옂籀"));
            gwi(var0, a.b("ꄃ\ud8b1剢찐䟁셧筠\uf2d6沇\ue629懩鯝ᕪ賨ۨ聋㨓뗔⽽ꤶ\u20c6媂퐾俢즛䌏着瓽\uee0a桋\ue3ecᴩ露\u0ec5袑Ȱ", -869555902));
            break;
         case 5:
            gwj(var0, a.b("ꥳ탅娎쑬侰줛獓謹擫\uee0d槁鎰", 1227598102), a.b("씹벏㙄ꠦ⏺ꕑἙ雵ࢡ艇֏", 1137034587), 0);
            break;
         case 40:
            gwk(var0, var2, var11, 10.0F);
            break;
         case 41:
         case 42:
         case 43:
         case 44:
         case 45:
            gwl(var0, a.d("\uebd0", -622550451, 836061661));
            break;
         case 90:
            gwm(var0, a.b("\uf8bc", -1658062596), Items.MACE, 20, 7, 0, 9.0, 99.0);
            break;
         case 100:
            gwj(var0, a.b("Ｗ蚁\u0c49鈮᧺齘╗겻", 1824587607), a.b("鱨\ue5de漖\uf171窥ﰇ䘈쿢", -2031838200), 0);
            break;
         case 140:
            gwk(var0, var2, var11, -20.0F);
            break;
         case 141:
         case 142:
         case 143:
         case 144:
         case 145:
            gwl(var0, a.b("\u000b", -2083061688));
            break;
         case 190:
            gwm(var0, a.d("뭚", -822917511, 1656421728), Items.MACE, 3, 7, 5, 9.0, 99.0);
            break;
         case 200:
            var4.set(false);
            gwj(var0, a.b("᰷斁\uef4a焨\ufaf4籟옗俻톯孉\udc85⛴", 412359762), a.d("ཪ盜ﰗ扵\ue9a9漂핊岦싲䠔쿜", -1786010782, 1053076586), 0);
            break;
         case 240:
            gwk(var0, var2, var11, 30.0F);
            break;
         case 241:
         case 242:
         case 243:
         case 244:
         case 245:
            gwl(var0, a.b("辿", 1350340605));
            break;
         case 290:
            gwm(var0, a.d("\uf1c6", 83616783, 1989350795), Items.DIAMOND_SWORD, 20, 7, 0, 9.0, 99.0);
            break;
         case 300:
            var4.set(true);
            var5.set(false);
            gwj(var0, a.c(-632894223, "첑딧㿯ꆈ⩜곾ᛱ鼝"), a.c(-1194519813, "ኛ欭\ue1e5羂\uf456狴죻䄑"), 0);
            break;
         case 340:
            gwk(var0, var2, var11, 0.0F);
            break;
         case 341:
         case 342:
         case 343:
         case 344:
         case 345:
            gwl(var0, a.d("\uefdb", 1629311860, 1996209386));
            break;
         case 390:
            gwm(var0, a.c(127299328, "潅"), Items.MACE, 3, 7, 5, 5.0, 8.0);
            var5.set(true);
            System.out
               .println(
                  a.b("偎⧡ꌵ㵎뛝〸詺Ν鷅ᜠ", -807776205)
                     + (guj == 0 ? a.b("須\ue1a8歩\uf518", -1615292324) : a.b("鎷\uea01惚ﺮ甕\uf3ac", 185308151) + guj + a.d("끀", 315447173, 237168621))
               );
            var0.scheduleStop();
            gtr = 99;
      }
   }

   static void gvq(MinecraftClient var0) {
      ClientPlayerEntity var1 = var0.player;
      if (gts == 1) {
         gwi(var0, a.d("\u16ff潈\ue597篮\uf031皂쳚䔪\udb30凒혇ⱱꊢ㬌녀㞦跤", 1033529558, -1361674657));
         gwi(var0, a.d("ἂ暰\uec63爑燎罦액䳗튆堨\udfe8◜꭫㋩룩㹊萒\u0bd5酼\u1737黇\ue483樿\uf1e3瞚ﴎ䒤쫼個홊巭ꌨ⤳냄㚐백", -1482692515, 345372446));
         gwi(var0, a.c(-490973300, "埧⹙ꒃ㫶넲㟑跢Р"));
         gwi(
            var0, a.d("韱\uee5d撟\ufae6煼\uf79f䷛쐿婼타圑굦⏴먀じ뚳ೡ茭ᦓ龛ᘌ汮\ue28e礗ｯ疥찀䉒\ud8b6庻픖⯗ꇏ㠠빮㓃譜Š螷ḁ鑕\ueaa2惠\ue742綒\uf3f1䩬삐䛁\udd17卮ꦄ\u200fꙕ㲯닭े辔֢鱥ዐ", 1545912420, -62302271)
         );
         var1.getInventory().setSelectedSlot(0);
      } else {
         int var2 = (gts - 40) / 70;
         if (gts >= 40) {
            if (var2 >= guk.length) {
               System.out.println(a.b("鍇\ueae8怼﹇疞\uf330䥻삗庘푭厵꧅✙", 163353405));
               var0.scheduleStop();
               gtr = 99;
            } else {
               int var3 = guk[var2];
               boolean var4 = var3 != Integer.MIN_VALUE;
               int var5 = var4 ? var3 : 0;
               int var6 = 40 + var2 * 70 + 20;
               int var7 = gts - var6;
               var1.setPitch(90.0F);
               if (var7 == -12) {
                  guf = var1.getY();
                  guh = guf;
               }

               if (var7 > -12) {
                  guh = Math.max(guh, var1.getY());
               }

               if (var4 && var7 == -1) {
                  var0.options.jumpKey.setPressed(true);
               } else if (var4 && var7 == 0) {
                  var0.options.jumpKey.setPressed(false);
               }

               if (var7 == var5 - 1) {
                  KeyBinding.onKeyPressed(KeyBindingHelper.getBoundKeyOf(var0.options.useKey));
               }

               if (var7 >= Math.min(-1, var5 - 1) && var7 <= Math.max(var5, 0) + 8) {
                  System.out
                     .println(
                        a.b("䢖ㄹ믭▖깏⣡銪ᭆ蕉", -9484056)
                           + (var4 ? a.d("봽쓞", 1460224770, -1700921774) + var5 : a.c(714056262, "ꈰ\udb86兀켾䓣"))
                           + a.c(1579513375, "瘺࿙蔝᭥郣")
                           + var7
                           + a.d("柙ḱ钦", 851896837, -415265281)
                           + gwn(var1.getY() - guf)
                           + a.d("몭썊䦖힣", 1035458850, -1793039445)
                           + gwn(var1.getVelocity().y)
                           + a.b("ႎ楸\ue3be緒\uf61f炵쫬䍄", 27660454)
                           + var1.isOnGround()
                     );
               }

               if (var7 == 45) {
                  System.out
                     .println(
                        a.b("콚뛵㰡ꉚ⦃꼭ᕦ鲊ʅ衆ྂ\uf5e5笴\ue29c棗\uee52", -1071526083)
                           + (var4 ? a.c(-906782970, "靫\uee88") + var5 : a.b("殇ሱ飷ډ赔", 1778281457))
                           + a.b("㨜䏿줷坜\udc9d婴", 717044282)
                           + gwn(guh - guf)
                     );
               }
            }
         }
      }
   }

   static void gvr(MinecraftClient var0) {
      ClientPlayerEntity var1 = var0.player;
      kfe var2 = Flow.getInstance().getModuleManager().getByName(a.b("랞츁䓎\uda96兴ퟁ涁\ue46e", 1589491677));
      byte var3 = 75;
      switch (gts) {
         case 1:
            var2.setEnabled(true);

            for (vmo var5 : var2.getSettings()) {
               if (var5 instanceof vlq var6) {
                  var6.set(var3);
               }
            }

            gwi(var0, a.c(1458654319, "䰙㖮뽱℈\uaad7Ɽ阼ῌ臖\u0b34賡皗\uf844懪\ueba6浀휂"));
            gwi(var0, a.b("둈췺䜩\ud95b劊퐬渫\ue79d秌\uf362璢躖!馣Ꭳ销⽘ꂟ㨶뱽㖍俉셵媩\udcd0噄\uefe1憶סּ紀\uf6a7ࡢ艹ᮎ鷚\u177b", 2103882761));
            break;
         case 5:
            gvs(var0, a.c(1353123376, "ٕ翣\uf528歊\ue096昽\udc75喙쯍䄫웧㲖"));
            break;
         case 30:
            gvt(var0, var2, var3);
            break;
         case 31:
         case 32:
         case 33:
         case 34:
            gvu(var0, a.b("瞔", 1969125332));
            break;
         case 70:
            gvv(var0, a.d("➧", 1697028118, 669171697), 20);
            break;
         case 75:
            gvs(var0, a.d("࿁癷ﲿ拘\ue90c澮햡届", -1176340671, -624068384));
            break;
         case 100:
            gvt(var0, var2, var3);
            break;
         case 101:
         case 102:
         case 103:
            gvu(var0, a.d("峇", -105797859, 2060057497));
            break;
         case 140:
            gvv(var0, a.d("櫯", 1251275327, -75982701), 4);
            break;
         case 145:
            gvs(var0, a.c(-964669963, "䶐㐦뻭\u208fꭓⷸ鞰Ṝ耈૮财睓"));
            break;
         case 160:
            var0.options.forwardKey.setPressed(true);
            break;
         case 165:
            gvt(var0, var2, var3);
            break;
         case 166:
         case 167:
         case 168:
         case 169:
         case 170:
            gvu(var0, a.c(366785329, "덳"));
            break;
         case 210:
            gvv(var0, a.c(1252205632, "␂"), 20);
            if (var0.options.forwardKey.isPressed()) {
               gum++;
               System.out.println(a.d("\u0b58狼\uf82b晉\ued80歽텍壟웦䱐쮋ㇿ뽄⚳곩⨅遏ᾈ蔨ͯ諜\uf0de繪\ue5a6揜\ue90d僲\udeeb䐑쉉䧲", -1868916409, 1791988336));
            }
            break;
         case 215:
            gwi(var0, a.b("ᕩ泗\ue60d硸\uf3bc畟콬䚮", 94704898));
            break;
         case 225:
            gvt(var0, var2, var3);
            break;
         case 226:
            if (kvz.busy()) {
               gum++;
               System.out.println(a.c(-854650915, "ྌ瘨ﳿ抝\ue954澩햞尋숲䢄콟㔫뮐≣ꠧ⻐钕ᬝ臹\u07b6蹜\uf411窥\ue16e朐\ued95呧\uda77䃐요䴣돡㦰"));
            } else {
               System.out.println(a.d("廔❰궧㏅렌㻱蓆\u0d53鍃᧶", 1643387729, 1029916159));
            }

            System.out
               .println(
                  a.c(-1768112385, "뺄유䷷펕塜\udea1撦\ued46猏惡績") + (gum == 0 ? a.c(-600502780, "๐矰ﴱ捀") : a.c(369175211, "⫫卝\ud986䟲챉䫰") + gum + a.c(525126677, "창"))
               );
            var0.scheduleStop();
            gtr = 99;
      }

      if (var1 != null && gts > 30) {
         gun = Math.max(gun, var0.world.getEntitiesByClass(EnderPearlEntity.class, var1.getBoundingBox().expand(64.0), var0x -> true).size());
      }
   }

   static void gvs(MinecraftClient var0, String var1) {
      gwi(var0, a.c(1683506763, "䘠㾞땄⬱ꃵ☖鰥ᗧ"));
      gwi(var0, a.b("\ud8f2ꅞ⮜뗥㹿뢜˘謼ᕿ鿃᠒\ue265泷\uf503罛聆䏢찮嚐킘夏⍭궍㘔끬㪦范\u0d51鞵ᆸ騕擔\ueecc眣\uf16d節쑟乣좴儂\udb56ꖡ\u2fe3ꡁ㊑볲կ辀ূ鈛ᱤ\ue6b7漁\ue95a玒\ufdef䙔삝䫳팴", -844441433));
      gwi(var0, a.b("\uf716躺Ѹ騁ᆛ靸ⴼꓘ㪛뀧㟶춁䌓\udae7傿화氆\ue3ca祴ｼ盫ಉ艩", 671151976) + var1 + a.c(-1016843499, "㌫䫍쀀幬햧卞\ue940悵ﻭ瑗\uf382ৢ蜦Ẑ铑ቮ\ua87e➤봝㭍늭죑䙍\udd89寲터條\ue680籦侮"));
      var0.player.getInventory().setSelectedSlot(0);
      gun = 0;
   }

   static void gvt(MinecraftClient var0, kfe var1, int var2) {
      ClientPlayerEntity var3 = var0.player;
      var3.getInventory().setSelectedSlot(0);
      var3.setPitch(-35.0F);
      System.out
         .println(
            a.b("Ӻ絞\uf789槫\ue222擟\udedc圯쥧䏀쐓㸫냦⤟ꍁ▹鿾ၶ", 1960772760)
               + var3.getMainHandStack().getItem()
               + a.d("ꌙ\udae1倿칆䖘썱", 336048640, -294186689)
               + vyn.serverIdle(var3)
               + a.c(1011328644, "ꚭ\udf5a喀쯬䀾욙糙\uf53e欸")
               + var0.options.forwardKey.isPressed()
         );
      var1.onKey(var0, var2);
   }

   static void gvu(MinecraftClient var0, String var1) {
      ClientPlayerEntity var2 = var0.player;
      System.out
         .println(
            a.d("\uf82e膊ଢ଼锿Ỷ頋", 1541921167, 677192151)
               + var1
               + a.d("\uea26鏃", 1698201271, 1454937267)
               + gts
               + a.b("\ude50ꟻ\u2d6a댌㣝빦ѱ", 1359863405)
               + kvz.busy()
               + a.b("灚ণ荹ᴇ雚ဲ", -1987022724)
               + var2.getMainHandStack().getItem()
               + a.b("ጌ櫮\ue022繐\uf59c獤", 204215082)
               + var2.getInventory().getSelectedSlot()
               + a.d("\ufada茭৷鞛᱉髮₮ꥉ㝏", 856602379, 1048464888)
               + var0.options.forwardKey.isPressed()
               + a.c(-886743732, "嵪⒒까〵믫㴂")
               + vyn.serverIdle(var2)
         );
   }

   static void gvv(MinecraftClient var0, String var1, int var2) {
      ClientPlayerEntity var3 = var0.player;
      PlayerInventory var4 = var3.getInventory();
      ItemStack var5 = var4.getStack(var2);
      StringBuilder var6 = new StringBuilder();
      if (!var3.getMainHandStack().isOf(Items.DIAMOND_SWORD)) {
         var6.append(a.c(-571063204, "䑺㶃띙⤧ꋺ␒")).append(var3.getMainHandStack().getItem());
      }

      if (!var5.isOf(Items.ENDER_PEARL) || var5.getCount() != 15) {
         var6.append(a.c(1590289386, "\ue3c2騣ქ躐Ք菻㦷끵")).append(var2).append('=').append(var5);
      }

      if (var4.getSelectedSlot() != 0) {
         var6.append(a.c(1013203374, "䆈㡪늦Ⳕꜘ⇠")).append(var4.getSelectedSlot());
      }

      if (gun == 0) {
         var6.append(a.c(-703572630, "啚ⲥꙷ㡉돎㕪輽۟颞ባ闵澏\ue142磮\uf2a0瑜"));
      }

      if (kvz.busy()) {
         var6.append(a.d("㿼䘞쳊劦\ud974必\ue5da汩\uf221碖ｏ", 1502416879, 1986080824));
      }

      if (!var6.isEmpty()) {
         gum++;
      }

      System.out
         .println(
            a.d("谷\uf593罄\ue126櫯\uec12", -354095373, 1781228210)
               + var1
               + (var6.isEmpty() ? a.d("癅ྻ蕬", 1018822907, 1623094941) : a.b("ꑜ\udd8b坟줦䋴", -1949784967) + var6)
         );
   }

   static void gvw(MinecraftClient var0) {
      ClientPlayerEntity var1 = var0.player;
      pbz var2 = pbz.get();
      switch (gts) {
         case 1:
            var2.setEnabled(true);
            gwi(var0, a.c(-63501420, "\u0be2牕\uf88a曳\ued2c殟퇇堷옭䳟쬝ㅻ뾨☌걂⪬郰"));
            var1.setYaw(0.0F);
            var1.setPitch(10.0F);
            break;
         case 10:
            gwi(var0, a.d("\ufbc4艺ࢬ雝ᵆ鮩↩ꡇ㘊볥㭨셇俖홿屲\udacf悒\uef1d痤\uf3a1稈\u001f躴ᔨ鍓ᦅꀽ\u2e6a뒌㋎륺䞹춸吚퉃壴", -483470946, 1764502040));
            break;
         case 14:
            gwi(var0, a.c(1542570319, "섒뢬㉺갋➐ꅿ\u1b7f銒ೌ虭Ǡ﯂甉\ueca9暤\ue01a婖햕佸쥺䂔㫑됼⾦꧌⍃骿ᓧ踈ࠔ莣絵\uf731滆\ue884戦\uddf6垕턈䣭승뱙㘖놪⭪ꔶ᳘陹ိ诶֍ｄ皠\uf0b9橍\ue41f徠\ud972匙"));
            break;
         case 18:
            gwi(var0, a.d("瓓൭螻\u19ca鉑ᒾ꺧❂륃㎬됡丟샋奨퍥嗒\uef85怊\ufaf3粶\uf51f輁Ƶ驲᱀隕⼡ꅻ㮊뷊㙪좼䋡\udb5e嵒ퟨ栵\ue27f撀ﴶ睲ং菚ё麻ლꤒ⎩ꗮ㸧", -1916310090, -195028687));
            break;
         case 22:
            gwi(var0, a.c(-514754464, "砨Ɩ譀ᔱ麪ᡅꉙ⮫뗦㼉뢄䊫찶喓\udf9e夠\ue36a沯\uf642灟了莵ൎ隉Ⴛ驮⏚궀㝱넱㪑쑇业\ud7a5冽\udb08擋\ueea9桼\uf1c3箹յ輨࢚鉁\u1c38"));
            break;
         case 40:
            gwp(var0, a.d("嶟\u2429껼り뭋㷭螿้送᪦", 2034326878, 1145897144));
            gwh(var0, a.c(-1156519466, "\ue9be逕᫇蒱ོ觀㎒"), 3, 0);
            break;
         case 45:
            gwi(var0, a.b("\uf0fa襄Β鷣ᙸ邗⪗ꍹ㴴럛ざ쩹䓨\udd41坌퇱殬\ue423绚\uf89f然ଡ薊Ḗ顭ኻꬃ╔뾲㧰뉄䲇욆弬\ud977叝", -1200754504));
            break;
         case 60:
            gwh(var0, a.b("樘Ꮅ饫܈賘\u0a3d뀩㧐ꞎⴴ", -598644126), 2, 0);
            break;
         case 65:
            gwi(var0, a.b("享㜕뷃⎲꠩⻆铆ᴨ荥ঊ踊瑧瑱捎\ue94e澠헽婲삍䛎콧땻㯛ꁔ♧겤ᕚ鬏ǿ螥ఐ\uf2d0碌\ue17a朻\uedc4剘\ud82d廪읈䴑㏮릘㸔\ua4cd⪿鍠᧙鿝ф訰烢凌缇\ue5ec", 979455738));
            break;
         case 80:
            gwp(var0, a.b("䶩㐟뻊₼ꭽⷛ鞉ṿ耷ઐ贝眨笠恔\uea1d泡횯", 692866507));
            gwh(var0, a.d("㉁䯷섹归품券", 1520715871, -1883407759), 3, 1);
            break;
         case 390:
            gwh(var0, a.c(1096338961, "칩럞㴞ꍾ⣹긍ᑃ鶺ϼ襖ຒ\uf4e2"), -1, 0);
            if ((a.c(-1126796184, "瑑\u0dfb") + var2.describe()).contains(a.d("暝ἷ閐௧耣ڃ변", -1789528288, 172265857))) {
               guo++;
               System.out.println(a.c(22459253, "댤쪒䁇\ude31嗰퍖椄\ue0f2纺\uf41d玝覊ݚ黣ᒵ鈨⠳\ua7e4㵄묄㊣䢡옕巙\udba3兲\ue88d暈ﱹ稻\uf18aན蔒᳢"));
            }

            System.out
               .println(
                  a.d("⤼傊\uda5f䐩쿨䥎\uf31c竪\ue4a2清\ue985Ꭰ鵦Ӂ躕࠰", -481792533, 1766343860)
                     + (guo == 0 ? a.b("࣫煋ﮊ旻", -1449457473) : a.c(1137940641, "飡\ue157殌\uf5f8繃\uf8fa") + guo + a.d("ῦ", 2066435982, 881414208))
               );
            var0.scheduleStop();
            gtr = 99;
      }
   }

   static void gvx(MinecraftClient var0) throws Exception {
      kfx var1 = Flow.getInstance().getModuleManager();
      kfe var2 = var1.getByName(a.c(96451058, "릩쀡䫱풙彖\ud9ef掭\uea5a琞ﺥ祓茋ු"));
      vlv var3 = (vlv)gwg(var2, a.c(40203084, "睞\u0ec5葡ᩢ釁ᝳ교⒭"));
      switch (gts) {
         case 1:
            gwi(var0, a.d("뉵쯂䄝\udf64咻툈桐\ue1a0羺\uf548犊裬ؿ龛ᗕ錻⥧", -478624440, 1572829003));
            gwi(var0, a.d("৪灆晴擨\uef7a榘폝娽쐶亖쥄㌵뷢", -182190085, -333515160));
            gwi(var0, a.d("ꁖ\ud9f5匢쵆䚍쀱穵\uf3d6淊\ue774悮髛ᐟ", -376913244, 910385800));
            var0.player.setYaw(-90.0F);
            var0.player.setPitch(4.0F);
            break;
         case 4:
            gwi(var0, a.d("\uee43韽ᴫ荚ࣁ踮㐶뷒⏓ꤼ⺱풓婛쏸䧵콏甕漢恡\ue626澏ᖍ鬡â蛐అ떱㯫ꄚ❚곺刬\ud871䇎쟈䵷\uf2aa磯️枽\uedea", 1535949828, 1015304712));
            break;
         case 5:
            gwi(var0, a.c(1963487237, "灍৳茥ᵔ雏ဠ\uaa3c⏎붃㝬냡䫎쑔巶ퟻ充\ueb09擊︧砱\uf1df诐Ԯ黬ᣞ鈋⮿ꗥ㼔륔㋴찢䙿\udfc0姚퍬沠\ue6d0怈旅珡ഀ蝈ó騬ᑅ"));
            break;
         case 6:
            gwi(var0, a.c(975348641, "ꏷ\uda49傟컮䕵쎚禅\uf074渹\ue4d6捛饴៰蹔П芰㢳띢ⷃꯌ≴堦횇䴈쬱䇸\uf806癓\ueca3櫹\ue14cᾌ闐ద詧\u0098뼆㕰뎸⨈ꁜ\ude97哹퍘䦔쟯縴\uf49d"));
            break;
         case 7:
            gwi(var0, a.d("\u0be4牚\uf88c曽\ued66殉톝塵왴䲛쬖ㄴ뿹♟걒⫤邲Ἵ藄\u0381訨\uf02a纁\ue545捷\ue9a2倖\ude4c䒽싽䥝랋㷖ꑩ≳ꣁ᜔鵢ᮧ舐ࡵ皫ﳤ筘\ue180濴혿", -1441768513, -92909550));
            break;
         case 8:
            gwi(var0, a.b("喜Ⱒ꛴㢅댞㗱迭؛顒ኽ锰漟\ue180砧\uf22a璔컒䄛\udbf6巪퐎긁\u20f4묽㴏럚\u0e6e耴᫅鲅ᜥ\ue9f3掮﨑簕\uf6a6䥭쌜䗅\udc52嘱⣌ꊒ┣뿺ㆂ衇˱蒥ή鄍", -1222158903));
            break;
         case 60:
            gwp(var0, a.b("㮗䈯죴囏\udd05宴\ue1fa桉\uf61f粮", 1692285947));
            break;
         case 61:
            var2.setEnabled(true);
            vaf.timing(true);
            break;
         case 100:
            vaf.gpuMillis();
            break;
         case 140:
            gwd(a.c(1075743222, "跣\uf40b绒\ue0dc欏\uedba埢"));
            gwp(var0, a.d("梃ᄻ鯠כ踑ࢡ닮㭁ꔘ⾲\ua87d列\udcda䕽콦䧟\uf394籗\ue6e3", 1310277183, -310946103));
            var3.set(a.b("菜煮炔\ueee8攻\ue381", 1864140743));
            break;
         case 141:
         case 181:
         case 221:
            vaf.gpuMillis();
            break;
         case 180:
            gwd(a.c(-1743176652, "㠯䆻쭧唛\udec8塲"));
            var3.set(a.c(-761524139, "ᑳ涣\ue705祵\uf2ab琒칁"));
            break;
         case 220:
            gwd(a.d("縭߽赛ጫ飵Ṍꐟ", -1010891999, 392132906));
            var3.set(a.c(-1478458021, "腾\uf8d7牳\uec0c柙\ue118"));
            break;
         case 260:
            gwd(a.d("\uf0c8襡υ鶺ᙯ邮", -1882970629, -1079193322));
            gwp(var0, a.b("\ud8a9ꄑ⯊뗱㸻뢋ʋ謵ᔲ龚ᡑ\ue226波", -1592338238));
            var3.set(a.c(1987320649, "\u1f5c暴\uec6d牣聆缅앝"));
            var0.player.setYaw(90.0F);
            break;
         case 300:
            gwp(var0, a.c(183539709, "鞈\uee30擫𢡄焚\uf7a9䷥쑊娓킹坶괜⏑멶ね뛆ಛ荜᧨"));
            break;
         case 301:
            gwi(var0, a.c(-486815204, "쩥돉㤞ꝧ\u2cf5ꨗၒ馲\u07b9贞ો\uf0ba繭"));
            var0.player.setYaw(-60.0F);
            break;
         case 340:
            gwp(var0, a.d("釚\ue862抹ﲂ睈\uf1fa䮷숅屛훪儸", -1252261475, 214470698));
            break;
         case 341:
            gwi(var0, a.b("ր簬\uf6fb梂\ue310旲\udfb7噗졜䋼씬㽛놈⠹", 665388538));
            var0.player.setYaw(90.0F);
            break;
         case 380:
            gwp(var0, a.c(2087187079, "\uf2ec譔Ə龴ᑾ鋋⢁ꄮ㽷뗝㈓존䚲"));
            break;
         case 381:
            gwi(var0, a.d("\uefbd阑᳆芿भ迏㖊뱪≡ꣁ⼛핢宵숄", 186911257, -523508258));
            break;
         case 420:
            gwp(var0, a.b("\ueab6錎᧕蟮త誐ホ륩✱궎⩒퀿", -881464612));
            break;
         case 421:
            gwi(var0, a.b("쉏믣ㄴ꽍ⓟꈽᡸ醘ྒྷ蔰ˡ\uf890癇", 313573942));
            var0.player.getAbilities().flying = true;
            gwi(var0, a.d("ഘ璭︮怿\uebdb洹휴庛삚䩧춴㟗륞", 1101760650, -553024021));
            break;
         case 425:
            var0.player.setPitch(35.0F);
            var0.player.setYaw(-60.0F);
            break;
         case 470:
            gwp(var0, a.d("섧뢟㉄걿➵ꄂᭊ鋷ಫ蘗ǝ﮿", -2118641421, -1335305794));
            break;
         case 471:
            gwi(var0, a.d("\uea9a錯\u19ac螽ౙ誻ザ뤙✘귺⨶큇庂읭", 53758000, 2006229712));
            break;
         case 475:
            var0.player.setPitch(10.0F);
            var0.player.setYaw(-90.0F);
            ((vla)gwg(var2, a.c(-213674425, "鉥\uebc0愔２"))).set(a.d("삥뤠㏴궘♒ꃰ", -4736142, -1299350640));
            break;
         case 510:
            gwp(var0, a.c(-1219557800, "س羋\uf550歫\ue0a1昗\udc5e嗣쮨䄞원㲼뉸"));
            break;
         case 511:
            ((vla)gwg(var2, a.d("賥\uf540羔\ue192", 859654287, 205570120))).set(a.d("ℷ墻퉩䰀", -578872668, 1930705860));
            var0.options.setPerspective(Perspective.THIRD_PERSON_BACK);
            var0.player.setPitch(22.0F);
            var0.player.setYaw(0.0F);
            break;
         case 550:
            gwp(var0, a.c(-261601352, "䟑㹩뒲⪉ꅃ⟺鶼ᐓ詋ï蜳絈\uf3d6橹\ue069"));
      }

      if (gts > 552 && gts <= 590) {
         var0.player.setPosition(var0.player.getX(), var0.player.getY(), var0.player.getZ() + 0.28);
      }

      switch (gts) {
         case 591:
            gwp(var0, a.d("뿞왦䲽튆奌\udff4斳\uec18牑\uf8ea缷蔎ே鈵", -731035200, 455079542));
            break;
         case 620:
            gwp(var0, a.d("\u07b3縋\uf4d0櫫\ue120析\uddde呵쨼䂇읚㵣돵⩉ꀏ⛯鲷", 982728806, -294041694));
            break;
         case 621:
            var0.options.setPerspective(Perspective.FIRST_PERSON);
            break;
         case 660:
            gwd(a.d("聶杻猀\ued70暠\ue045婆펢䷪읚䂕뫥", -646326993, -1576577741));
            gwp(var0, a.d("囟⽧ꖼ㮇끌㛽貲Ԉ魘ᇲ阠汖\ue2d8笴\uf172瞔췚䈗\ud8a5", 2113535, -882939563));
            break;
         case 661:
            var2.setEnabled(false);
            vaf.timing(false);
            break;
         case 690:
            gwp(var0, a.b("㟷乏쒔媯텤埖\ued9a搩奔烎\uf756൫莺ᨍ遖ᚠ", 666974081));
            System.out.println(a.d("孍⋵\ua82e㘘붛㬻腾࢈隃ᱶ鮮懞\uef02", 1292597639, 1247748769));
            var0.scheduleStop();
            gtr = 99;
      }
   }

   static void gvy(MinecraftClient var0) throws Exception {
      kfe var1 = Flow.getInstance().getModuleManager().getByName(a.c(748729174, "댍쪅䁕\ude3d嗲퍋椉\ue0fe纺\uf401珷覯ݰ"));
      switch (gts) {
         case 1:
            gwi(var0, a.c(1617012596, "꜂\udeb5呪쨓䇌읿紧\uf4d7櫍\ue03f柽鶛ፈ諬¢虌㰐"));
            gwi(var0, a.b("뾌옠䳷튎夜\udffe斻\uec5b牐\uf8f0缢蕓\u0b84", -1611218955));
            gwi(var0, a.c(790972860, "䧆づ몲ⓖ꼝⦡鏥ᩆ葚\u0ee4褾獋ﶏ"));
            gwi(var0, a.b("澒ᘧ鲤ʵ襑ླ뗰㰑ꈐ⣿꼼", 1794994157));
            break;
         case 4:
            gwi(var0, a.d("朽ẃ鑕ਤ膿ܛ뵝㓲ꫳ⁏ꞃ巠팢䪆삋䘲ﱫ玷\ue91b潘\ue6e2鲷ሃ觙ྠ蕠㳀늖⡳깬▊\udb55儐죕亵쐇篘", 462701025, -562157921));
            break;
         case 5:
            gwi(var0, a.b("윏뺱㑧ꨖ\u218dꜭᵽ钞ટ聰ް\ufdd2猔\ueaa6惧\ue648局펈䤨콪䛐㲅눱⧫꾒╒鳲ኤ衁\u0e5e薤筲\uf126棖\uee8e搅\udbef冎흆份쒪멃", 1771489091));
            break;
         case 6:
            gwi(var0, a.c(235858914, "\ueba8鈖ᣀ蚱പ讉㇚령☸곗⬉텭徢영䱒쪱炠＾斎\ue3cd樢ၫ麕Հ茸ৢ끗㸗ꓳ⊥꤄垛\udd9d䑫숣䢓\uf74f約ﯪ手\ue80f雴Ჯ鬆"));
            break;
         case 7:
            gwi(var0, a.d("汾ᗀ鼖ŧ諼ీ똇㿯ꇮ⬁곟嚴\ud874䇈쮏䵧\uf776磭\ue24a搖\uedf9鞽\u1943芖Ӯ踴㞁링⌥ꕳ⻒큍婋쎹䗨콞炟\ufae8簁\ue59f濜ᄠ魼\u1cc8蘇", -1953578263, 1280945884));
            break;
         case 8:
            gwi(var0, a.b("⟋幵풣䫒셉䟵ﶺ瑌\uea05惪\ue767ᴀ鏁\u0a7d耲ۊ벝㌒ꧬ⾮ꙁ\udc08勶줣佛얁簴\uf274梐\ueec6敧鯸ᇠ蠓\u0e5c蓭㬰녧㞈긵⑧媖탋坳춲䏄兀炼\uf6f8", 1471686556));
            break;
         case 9:
            gwi(var0, a.d("╙峧혱䡀쏛䕹Ｙ皖\ue897戫\ue5e4ᾐ酓ࣶ花О븘㇞ꭠⴭꓘ\ude9a偤쮱䷉윓约\uf0e6樂\uec54柵饪\u137d誇\u0ccf虯㦳돵㔕겧⛰", -1424791047, -639611665));
            break;
         case 40:
            var1.setEnabled(true);
            vaf.timing(true);
            break;
         case 90:
            vaf.gpuMillis();
            break;
         case 130:
            gvz(var0, -90.0F, 4.0F, a.c(1230926813, "玼ਉ胈Ế"));
            break;
         case 170:
            gvz(var0, 90.0F, 4.0F, a.d("ꭚ틹堼왊", 174188137, -1803334336));
            break;
         case 210:
            gvz(var0, 180.0F, -2.0F, a.d("\u1f5e曮\uec20牗列", 890193299, -2089657690));
            break;
         case 211:
            var0.player.getAbilities().flying = true;
            gwi(var0, a.b("煑ࣤ艧ᱶ鞒ᅰꬳ⋒볓㘮뇿䮞앙", -1018662616));
            break;
         case 260:
            gvz(var0, -60.0F, 35.0F, a.c(733093457, "ḵ枇\ued59猱\uf8f5"));
            break;
         case 261:
            gwi(var0, a.b("䡖㇣뭠╱꺕⡷鈴ᯕ藔༶裺犉ﱎ旯", 404637740));
            gwi(var0, a.b("ꊂ\udb2e凹쾀䐒싰碵\uf155潞\ue5fe戮類ᚊ輻", 1890689784));
            break;
         case 300:
            gvz(var0, 90.0F, 2.0F, a.b("膊\uf83d狵\uec99杘\ue1f8", -2053012993));
            break;
         case 311:
            gwi(var0, a.b("朗ẻ鑬ਕ膇ݥ봠㓀\uaacb\u2069ꞹ巈팟", 961308526));
            ((vmc)gwg(var1, a.c(1585929007, "弹⚬걺㉷맟㽭蕁ಳ鋢"))).set(0.8);
            break;
         case 340:
            gvz(var0, -30.0F, 0.0F, a.d("㸟䞯쵷匛\ud8da", 1205054989, -1067151245));
            break;
         case 351:
            ((vmc)gwg(var1, a.c(1819815724, "⬺劯\ud879䙴췜䭮\uf142碰\ue6e1"))).set(0.2);
            break;
         case 380:
            gvz(var0, -30.0F, 0.0F, a.d("\uf301誵h鸖ᗝ", 122080485, -794935411));
            break;
         case 391:
            ((vmc)gwg(var1, a.b("괹풬幺쁷䯟쵭睁ﺳ惢", -387274449))).set(0.45);
            gwi(var0, a.d("\udb3aꊖ⡁똸㶪뭈č裭ᛦ鱆ᮜ\ue1e5漲\uf683", -763781333, 1066484843));
            break;
         case 400:
            gvz(var0, -90.0F, 4.0F, a.b("硾ǈ謕ᕫ麠", -922650603));
            break;
         case 420:
            kfe var2 = Flow.getInstance().getModuleManager().getByName(a.d("〞䦜썖崧훞偟\uea17揨ﶸ眕", 1133996387, -181577423));
            ((vlv)gwg(var2, a.d("툅ꮖⅎ뼾", 245728471, -842836325))).set(a.b("や䤆쏌嶽", -88133434));
            var2.setEnabled(true);
            break;
         case 430:
            gvz(var0, -90.0F, 4.0F, a.d("\uf65b迭\u0530魎ႅ陭Ⱶꖗ㯑녠㚽쳜䈐\udbaf凳휞", -528664934, 455786687));
            break;
         case 450:
            Flow.getInstance().getModuleManager().getByName(a.c(-554216664, "卤⫦ꀬ㹝떤㌥襭\u0092黂ᑯ")).setEnabled(false);
            var1.setEnabled(false);
            var0.scheduleStop();
            gtr = 99;
      }
   }

   static void gvz(MinecraftClient var0, float var1, float var2, String var3) {
      var0.player.setYaw(var1);
      var0.player.setPitch(var2);
      var0.player.lastYaw = var1;
      var0.player.lastPitch = var2;
      guq = var3;
      gus = gts + 8;
   }

   static void gwa(MinecraftClient var0) {
      if (gts == gus) {
         gup++;
         gwd(guq);
         gwp(var0, gur + gup + a.d("澽", -1369990843, 396490452) + guq);
      }
   }

   static void gwb(MinecraftClient var0) throws Exception {
      kfe var1 = Flow.getInstance().getModuleManager().getByName(a.c(-2039851968, "吐ⶓꝄ㤠닫㑗踓"));
      vlv var2 = (vlv)gwg(var1, a.c(-1161351236, "\u2fe9噮\udcb9䋚중価"));
      kfe var3 = Flow.getInstance().getModuleManager().getByName(a.d("䙶㿴딾⭏ꂶ☷鱿ᖀ诐Ž", 907978929, -198381941));
      gur = a.d("႐椳\ue3e4綀\uf64b烷쪳䌝", 653607281, 718295454);
      switch (gts) {
         case 1:
            gwi(var0, a.b("ﾹ蘎\u0cd1銨\u1977鿄▜걬㉶뢄㽆씠䯳퉗堙\udef7撫", 199032783));
            gwi(var0, a.b("Ꜻ\ude96呁쨸䆪읈納\uf4ed櫦\ue046枑鷥ጲ", -1879726269));
            gwi(var0, a.b("\uf7e3蹀җ髳ᄸ鞄ⷀꑣ㩿냁㜛쵮䎪", -1591806055));
            gwi(var0, a.d("䞠㸕뒖⪇ꅣ➁鷂ᐣ訢Í蜎", 298815280, 932301039));
            break;
         case 3:
            gwi(var0, a.c(-1254589507, "篪ɔ袂ᛳ鵨ᯔꆛ⡯똤㳋뭋䄦쿠噜\udc13嫧\ue0bc潼\uf5ca玏都耤\u0e8b镋ጥ駱⁖깊㒹닯㥗잀䷞퐼剨\ud8cb杒\ued6a殾\uf214硊ڰ賙୕醒Ὸ꘡Ⲙ\uaacf"));
            break;
         case 4:
            gwi(var0, a.d("ꁔ\ud9ea匼쵍䛖쁪稥\uf3d1涚\ue775惵骘ᑞ跢ޭ腙㬂듞\u2e74꠱↘定픵仵좛䉏ﯨ痴\uef07楑\ue2e9᰾陠ྂ觖͵볬㛀뀆⦤ꏩ\udd18坧탫䨲쑀綟\uf726", -319127716, -108994722));
            break;
         case 5:
            gwi(var0, a.d("㟡也쒉嫸텣埊\ued81搮隷炓\uf75e഼菳ᩚ遗ᛯ겷⍫맆㾄똾챫䋟\ud905彼햼氜\ue24a碯ﺰ畈讝ǆ頤ṱ铎⬼ꅢ➨븜㑃䪿샿", -893658610, -83759710));
            break;
         case 6:
            gwi(var0, a.d("䈟㮡녷⼆꒝∴顿ᇐ近ճ芳磚\uf615濺\ue5e0挆\ud95a嚘챦䨳쏃릙㜬곬⪀ꁖ᧷韨ൔ謁¦﹤琭\uedd2殤\ue13a廴풀剓쯯䆣", -618412454, -223771638));
            break;
         case 7:
            gwi(var0, a.b("≖寨턾住쓔䉴\uf822燇\uefc6攩\ue2f7ᢓ陜\u0ffc薪͏륞㛈걢⨫ꏄ\ud9d8坯첹䫍쀚禸\uf7fa洊\ueb49悴鸭ᑵ超௭腷㺱듗㈄ꮦ⇻弆핎勿젽", -1924718051));
            break;
         case 8:
            gwi(var0, a.d("\ue91a邤ᩲ萃\u0f98褤㍩몋⒊깶⦶폒崐쒰仲졝牟ﶝ朷\ue17f棅ነ鰤߾膇େ닧㲱Ꙕ⁋ꮭ啲\udf37䛲삎䨣\uf5f9羇陋惸", 4331246, -1902772294));
            break;
         case 9:
            gwi(var0, a.c(1396571394, "﵀蓾ศ遙ᯂ鵠✠꺏ゃ먮㷬잋䥊탭媨\udc07昛\ue9d6獴\uf53c糒ێ衹Ꭿ闛Ἄꚮ⣬눜㑟뾢䄾쭧劃퓁幧"));
            break;
         case 10:
            gwi(var0, a.d("ꣻ템实엹丠좒狍הּ攠\uef87桂鉭᳤蕄༆覺㏱밧⚟ꃈ⤮卬\uddd8䘛쀪䪭\uf313絍\ue7a0懠\uea44ᒉ", -1625896399, 856777369));
            break;
         case 11:
            gwi(var0, a.b("\ue06e駉ጋ赬ڵ耇㩘뎡ⶵ꜐⃗\udaf8呱췍䞁셢筠\uf4b5渁\ue85b憪ᯪ镊ຜ裱ɮ뮀㗚꼮⥧ꋐ将홒侢짺", 285532222));
            break;
         case 12:
            gwi(
               var0,
               a.d(
                  "\u2d78哆\ude10䁡쯺䵆\uf709绺\ue0b6橙\uedd4ូ饲Î誉ౡ뙰㧬ꍌ┌곹횻塅쎐䗨켲皇\uf8c7戣\ue475濔酋᭑芮ӷ蹲㆖믮㴹꒟⻓倴\uda4f巕윗䥱\uf0a3稈ﱝ枋\ue9e9ጳ骞ᲆ蘼\u086b돓㔒뽙", -1323861264, 1650218965
               )
            );
            break;
         case 13:
            gwi(var0, a.b("⸹垇\udd51䌠좻万\uf448綺\ue3f7椘\uee95ᓩ騢ΐ觑༭땷㪾ꁓ♎꾫헷孑삘䚪챿痋ﮑ慠\ue720沀鉖᠋膴\u07bf贅㋉뢩㹱ꟷ\u2d9b卣\ud934庒쑖䨱\uf3ca祐＊擌\ueabeၵ駘ᾎ蕬ଶ낓㘋백◦ꭖ턗囜", -662884768));
            break;
         case 40:
            var2.set(a.c(-493386769, "莹層烠\uee96"));
            var1.setEnabled(true);
            vbb.timing(true);
            break;
         case 70:
            vbb.gpuMillis();
            break;
         case 80:
            System.out.println(a.c(-971456152, "섗뢴㉶걓⟃ꅥᬳ銗") + gwn(vbb.gpuMillis()) + a.b("緦К軗", 1559002565));
            gvz(var0, -90.0F, 12.0F, a.d("\ued3b钎ṏ耹", 324448106, 1517765168));
            break;
         case 96:
            if (System.getenv(a.d("낸줃䏓\uddba嘈탔檋\ue361紹\uf795灀", -1278611935, -789029164)) != null) {
               var0.scheduleStop();
               gtr = 99;
            }
            break;
         case 100:
            gvz(var0, 90.0F, 14.0F, a.d("₳夐폕䶣", -1099689390, 1115959954));
            break;
         case 120:
            gvz(var0, 0.0F, 30.0F, a.b("\uf2c1譭ƾ鿆", 120451767));
            break;
         case 121:
            gwi(var0, a.d("ử杘\ueddb珊\uf82e绌쒒䵷팱姞\ude53\u242fꫧ", 268330552, 505968812));
      }

      if (gts > 130 && gts <= 160) {
         var0.player.setYaw(-90.0F);
         var0.player.setPosition(var0.player.getX() + 0.22, var0.player.getY(), var0.player.getZ());
      }

      switch (gts) {
         case 163:
            var0.options.setPerspective(Perspective.THIRD_PERSON_BACK);
            gvz(var0, -90.0F, 45.0F, a.c(1297525424, "\uaac6퍵妽쟋䰆쪰"));
            break;
         case 180:
            var0.options.setPerspective(Perspective.FIRST_PERSON);
            gvz(var0, 90.0F, 55.0F, a.d("\ud912ꂡ⩩됟㿒륤ͩ諗ᒋ鸸᧣", -1609147074, 361137239));
            break;
         case 200:
            gwi(var0, a.c(-913076713, "蹭\uf7c1紖\ue36f棽\uee1f呚\uddba䎱중仁뒶㩥ꏔ"));
            gvz(var0, 90.0F, 10.0F, a.d("漻ᚌ鱄Ȩ觩ཉ", 690032639, -618438479));
            break;
         case 220:
            gwi(var0, a.b("雘\uef74斣ﯚ灈\uf6aa䳯씏嬄톤噾갇⋐뭡", 471439010));
            gvz(var0, -90.0F, 18.0F, a.c(-1065785098, "條ᄫ鯶ֈ蹃"));
            break;
         case 232:
            ((vlv)gwg(var3, a.c(1800102697, "捠\u1af3逫๛"))).set(a.b("곩핫御쇐", 640134315));
            var3.setEnabled(true);
            break;
         case 236:
            gvz(var0, -90.0F, 18.0F, a.b("丘㞮뵳⌍\ua8c6⸮鐶ᷔ莒ण軾璟禎揬\ue9b0潝", 2072071782));
            break;
         case 250:
            var3.setEnabled(false);
            gwi(var0, a.d("ɞ篲\uf125潜\ue4ce戬\ud869冉쾂䔥싰㢁뙖", 1697673115, 1507749308));
            gwi(var0, a.d("ぁ䧢쌵嵑횚倦\uea62揁\ufdcc睮\uf0b5ૃ", 150639497, 1294377907));
            ((vmc)gwg(var1, a.c(1246027265, "\ude40Ꟈⴉ덧㢳"))).set(1.0);
            gvz(var0, -90.0F, 55.0F, a.d("\ue63d龟ᕄ謲", 1285624296, 1593505699));
            break;
         case 270:
            gwi(var0, a.d("⁸姛파䵨욣䀟者珸\uede4杚\ue080\u1af5鐱", 1108520102, -697922396));
            var2.set(a.b("둳췼䜨\ud943劅퐣", -1613777886));
            vbb.gpuMillis();
            gvz(var0, -90.0F, 12.0F, a.c(1722965214, "岣┌꿘ㆳ멵㳓蛟ཧ鄽ᮔ"));
            break;
         case 285:
            System.out.println(a.b("翀٧貰ዓ餘ᾨꖵⰃ뉋㣿뽹䕟쮖删\ud869庉\ue4d1歒", -755466335) + gwn(vbb.gpuMillis()) + a.d("稕ϩ褤", -1643177633, -1742314647));
            break;
         case 290:
            gvz(var0, 150.0F, 8.0F, a.b("\ud838ꆗ⭃딨㻮롈Ʉ诬ᖵ鼓ᣀ\ue2a7", 1387780163));
            break;
         case 310:
            gwi(var0, a.b("\ue2cf魣ᆴ迍џ芽㣸넘⼓ꖳ≩\ud810囇콶", 1216078517));
            gvz(var0, -90.0F, 12.0F, a.c(-1877910384, "峫╄꾐ㇻ먽㲛蚗༥酽ᯂ鰞晳"));
            break;
         case 330:
            gwi(var0, a.c(-1000506329, "籞ײ輥ᅜ髎ᰬꙩ⾉놂㬥볰䚁졖"));
            var2.set(a.d("庬✾귯㎅롕㻭", -110341268, 2047217045));
            gvz(var0, 150.0F, 8.0F, a.b("\ud8afꄝ⯌떦㹶룎˗譯ᔵ龜", -700917546));
            break;
         case 350:
            var2.set(a.c(-1651424103, "䓌㵛랐⧡ꈾ⒘"));
            gvz(var0, -90.0F, -20.0F, a.c(1920178158, "鞗\uee20擫漢煅\uf7e3䷯쑗娍키"));
            break;
         case 370:
            gwi(var0, a.b("\uf6af較ה鮭ဿ雝Ⲙꕸ㭳뇓㘉챰䊧\udb16", 660797141));
            gvz(var0, 150.0F, 5.0F, a.c(664708650, "ꙕ\udfe2唩쭘䂇옡簭\uf59f毇\ue178暤鳉"));
            break;
         case 390:
            gwi(var0, a.c(-2001903143, "憠᠌鋛ಢ蜰ǒ뮗㉷걼⛛ꄎ孿햨"));
            var2.set(a.b("\uf01b覞͌鴼ᛳ遁", -744624036));
            vbb.gpuMillis();
            gvz(var0, 150.0F, 8.0F, a.b("徲☗곅㊵륺㿈藘ౠ鈺ᢓ", -396206119));
            break;
         case 405:
            System.out.println(a.b("珻ੜ肋Ứ锣᎓ꦎ‸빰㓄덂䥲잱币푓劺\ue8f6杩", 337343386) + gwn(vbb.gpuMillis()) + a.b("ಖ番ﾧ", -2144662347));
            break;
         case 410:
            gwi(var0, a.c(437507870, "흤껈␟멦ㇴ뜖\u0d53蒳᪸逘ែ\uedbb捬\ufadd"));
            ((vlv)gwg(var3, a.c(-459944837, "찲떡㽹ꄉ"))).set(a.d("䀬㦮덤ⴕ", 1598010928, 222819934));
            var3.setEnabled(true);
            break;
         case 414:
            gvz(var0, 150.0F, 8.0F, a.c(-804273509, "십뭈㆚꿪␥ꊗᢇ鄵\u0f6d藒Ȏ\uf863盭\uef17敗\ue3bf姰혯䲌쫆䌿㥡럎"));
            break;
         case 430:
            var3.setEnabled(false);
            var1.setEnabled(false);
            var0.scheduleStop();
            gtr = 99;
      }
   }

   static void gwc(MinecraftClient var0) throws Exception {
      kfe var1 = Flow.getInstance().getModuleManager().getByName(a.c(720668653, "螽︾瓩\uea8d慆\ue7fa嶾"));
      vlv var2 = (vlv)gwg(var1, a.d("슿문\u31ef꾌⑇ꋷ", -1340581858, -1139303692));
      gur = a.c(-548175726, "胢淚玙\uedf2昴\ue092媞");
      switch (gts) {
         case 1:
            gwi(var0, a.c(169841313, "鋗\ueb60憿ￆ琙\uf2aa䣲섂弘헪刨ꡎ⚝뼹㕷뎙\u09c5"));
            gwi(var0, a.b("娖⎺ꥭ㜔벆㩤耡ু韊ᵩ骽惉\uee1e", -1022928273));
            gwi(var0, a.b("\uf770軓Є驠ᆫ霗ⵓꓰ㫬끒㞈췽䌹", -2079852790));
            gwi(var0, a.c(-1253792795, "ꎚ\uda2f催캽䕙쎻秸\uf019渘\ue4f7挴"));
            break;
         case 3:
            gwi(var0, a.b("꧉큷媡쓐佋짷玻社搇\ueee8楨錅᷃葿ำ裄㊟뵜⟩ꆬ⠅切\udca8䝨섅䯒\uf275籩\ue69a惌\ueb74ᖣ鿽؟聋૨땱㽝릛‹ꩴ풅建\ud976䎯췝琂ﺻ", 1643096479));
            break;
         case 4:
            gwi(var0, a.c(-1789329160, "¬礒\uf3c4涵\ue62e悉\udacc卣쵢䟞쀖㩱뒷ⴆꝄ⇫鯩ᐫ躕ࣘ脾ﬢ疕\uee43样\ue2e0孂픀俰즳䉎볖㚞꽴⤦ꎜᱱ阽ჾ襔́緸\uf7b3灑\ueace撸\udd68埙톕䩜"));
            break;
         case 5:
            gwi(var0, a.d("ꋞ\udb60冶쿇䑜싸碾\uf111漄\ue5a1承頔ᛔ轴Ԥ菇㧖뙍⳪ꪫ⍌奐ퟧ䰱쩅䂒擄睲\ued82毁\ue03cẤ铨ഛ譏Ǩ븹㑲늎⬣ꅱ\udf8f嗙퉰", 956490361, -221626131));
            break;
         case 6:
            gwi(var0, a.d("\udc4aꗴ⼢녓㫈뱡ت辅ᆕ鬵ᳫ\ue686桀\uf1e8箢ﴍ䜎죍剳퐾巘⟄ꥳ㊥듑㸆螤০錖ᕕ麨怢\uea65玏", 371111814, 1814522760));
            break;
         case 7:
            gwi(var0, a.c(-1806098806, "Ệ杸\uedae珟\uf844绸쒿䵗퍖妹\ude67␈\uaacc㍰뤷㿟藎\u0a55郲ᚮ齇\ue505毻\uf02e癖ﲌ䔹쭹冝ퟋ屪ꋵ⣳넁㝐뷦ȧ衐ູ霻ᵧ掞"));
            break;
         case 8:
            gwi(var0, a.b("\ue227鮙ᅏ輾ҥ舙㡖놧\u2fe9ꔆ⊘\ud8fa嘠쾉䗏쌳祦\uf6a0汍\uea57掵᧩靆ಆ誴a맕㞏굾⬾ꂞ幈퐕䶪쮰䄂ﻗ璡\uf264毓\ue1b6齴ᔮ銛࡛蘹㿼땥㌁ꣅ⚡\udc71嗜펗䥣윣粗臭灦\ue9fe杏ᴙ髺႓", -875240959));
            break;
         case 9:
            gwi(var0, a.d("ഠ璞﹈怹\ueba2洞흓庱산䩒춝㟽뤼ₛꫛⰹ阨ᦪ茅Յ貣\uf6f2硐\ue3cc斷\uef61囙\ud88e䉨쐪侞녝㭜ꋠ⒥긁ᇇ鮡", 804623126, -880763274));
            break;
         case 10:
            gwi(var0, a.c(-351982886, "⪚匤\ud9f2䞃찘䪽\uf0fa祕\ue754淰\uea36ၑ麐ݿ赲ச뇌㹐ꓧ⊱ꭍ턚徸쑺䈂죁焼Ｔ族\ue393栠雿Ჹ蕞̊覠㙶밌"));
            break;
         case 11:
            gwi(var0, a.d("\uf685輻\u05ed鮜ဇ隣⳥ꕊ㭚뇺㘿챘䊙\udb3e儳힍淓\ue21a碱ﺭ睞ഈ莰ᡧ鸉ᓋ굿⌼릅㾍됲䫮삡奞\udf04喣\uea73怙\ue6cb罱", 1708252346, 495790705));
            break;
         case 12:
            gwi(var0, a.c(-488990478, "颣\ue104毆\uf5a1繸\uf8ca䊕쭬啸\udfc4堎ꉫⳢ딍㽓릷Ϡ豼ᛋ邝ᥡ挶\ued94癖\uf02e竭쌐䴗ퟭ决\uda1aⓚ꺂㝯"));
            break;
         case 13:
            gwi(var0, a.d("Ө絖\uf780槱\ue26a擖\ude99坯줦䏉쑄㸦냢⥞ꌑ◥龾ေ諊\u0c8d蕯Ｋ燕\uea00汸\ue6a2弗텗䮳췥䙄룛㋟ꬪ\u2d6d\ua7cf\u181e鉡ᒗ贉ݏ离\uf3e8瑔\uee90", 1004256995, -1514685888));
            break;
         case 14:
            gwi(var0, a.b("갤햚彌섽䪦찚癖ﾵ憴\ueb5b沅雨ᠼ膟\u0bde贽㜬뢲∐ꑌ\u2da7埵\ud954䋈쒳乥\uf7dd禊\ue36c攮\uee9aၙ驘ϼ薡༚냹㪱뱡◛꾉텾", 24489064));
            break;
         case 40:
            var2.set(a.d("퀥ꦪ⍾봕㛓끵", -2090495806, -1825554250));
            var1.setEnabled(true);
            vbb.timing(true);
            break;
         case 70:
            vbb.gpuMillis();
            break;
         case 90:
            System.out.println(a.c(-1261084814, "弎⚡걵㈞맘㽾蕿\u0cc9銁ᠵ龳") + gwn(vbb.gpuMillis()) + a.d("\udf22ꛞⰓ", 1204550808, 1100882841));
            gvz(var0, -90.0F, 14.0F, a.d("젤놐㭛ꕾ⻡ꡔሕ鯣", -667566279, -308775055));
            break;
         case 110:
            gvz(var0, -135.0F, 10.0F, a.c(-1879836220, "囹耟\u0ad6钡ὠ"));
            break;
         case 130:
            gvz(var0, 108.0F, -8.0F, a.c(-1247176235, "馤\ue013櫗\uf4a6罧"));
            break;
         case 150:
            gvz(var0, 0.0F, 25.0F, a.c(-1042689983, "퀫ꦐ⍅"));
            break;
         case 170:
            gvz(var0, -36.0F, 24.0F, a.c(2135329422, "諸\uf34e禌\ue7e8氼"));
            break;
         case 180:
            gvz(var0, 30.0F, 62.0F, a.d("\ue222鮜ᅌ輡Ӡ", 1491436436, 952394192));
            break;
         case 190:
            gwi(var0, a.d("呏ⷺꝹ㥨늌㑮踰ߞ馃ጢ钯満\ue046秾", 2057489660, 1234802889));
      }

      if (gts > 203 && gts <= 233) {
         var0.player.setYaw(-90.0F);
         var0.player.setPosition(var0.player.getX() + 0.2, var0.player.getY(), var0.player.getZ());
      }

      switch (gts) {
         case 236:
            gvz(var0, 90.0F, 55.0F, a.d("덵쫆䀎\ude78喵팃", -633206660, -1367229569));
            break;
         case 250:
            gwi(var0, a.b("欉ኼ頿خ跊ନ녫㢊ꚋⱤꮧ", 410348406));
            gwi(var0, a.c(606020315, "⊡嬍퇚侣쐱䋓\uf896煶\uef7d旝\ue20d\u187c隩༘"));
            vbb.gpuMillis();
            break;
         case 270:
            gvz(var0, -100.0F, 10.0F, a.d("\udc25ꖒ⽚넶㫷뱗", -346201939, 1125956861));
            break;
         case 282:
            System.out.println(a.d("\uf538貗ك頨Ꮾ镈⽉\ua6ff㢷눃㖅쾧䅶\ud8dc劒푵渫\ue1ae", -76047171, 302672352) + gwn(vbb.gpuMillis()) + a.b("퍱ꪍ⁀", -1805790382));
            gwi(var0, a.d("釞\ue872报ﳜ睎\uf1ac䯩숉専횢典ꬁ◖뱧", 866896910, -2121310806));
            break;
         case 310:
            gvz(var0, 60.0F, 12.0F, a.b("Ꮠ橦\ue0bb绅\uf50e", -1731062853));
            break;
         case 325:
            gwi(var0, a.d("牜௰脧\u1f5e铌ሮꡫ↋뾀㔧닲䢃왔", 1763645492, -1151112687));
            ((vmc)gwg(var1, a.c(1046649219, "駚\ue05a檚\uf4ed缧列䏀쨸呱"))).set(1.0);
            break;
         case 345:
            vbb.gpuMillis();
            gvz(var0, -60.0F, 6.0F, a.b("憙ᠥ鋲ಔ蝌", -287677964));
            break;
         case 357:
            System.out
               .println(a.d("踦\uf789絝\ue336棰\uee56呗\udde1䎩줝些뒢㩸ꏍ⦉꽷ᕡ", -281807792, 1605270032) + gwn(vbb.gpuMillis()) + a.d("⋚嬦퇫", 1255159820, -595256587));
            break;
         case 360:
            ((vmc)gwg(var1, a.d("ஏ爏\uf8cf暸\ued72毉톕塭오", 177237836, -1829477222))).set(0.6);
            var0.player.setYaw(-90.0F);
            var0.player.setPitch(30.0F);
            break;
         case 380:
            vbb.gpuMillis();
            break;
         case 440:
            System.out.println(a.c(-2075273866, "픓겼♨렃㏅땣ར蛔ᢜ鈨ᖮ\uef98慚\uf8f6犿\uf455丐솅") + gwn(vbb.gpuMillis()) + a.c(686550971, "\uef98除Ჩ"));
            break;
         case 445:
            var1.setEnabled(false);
            var0.scheduleStop();
            gtr = 99;
      }
   }

   static void gwd(String var0) {
      System.out.println(a.c(1672833861, "欫ና顈پ跮ୈ넞㢺") + var0 + a.d("니", 739107060, 2134200861) + gwn(vaf.gpuMillis()) + a.d("艕ﮩ煤", 177424450, -285095372));
   }

   static void gwe(MinecraftClient var0) throws Exception {
      kfx var1 = Flow.getInstance().getModuleManager();
      kfe var2 = var1.getByName(a.c(-2068583380, "\uec60闢Ἠ腙ઠ谡㙩뾖⇆꭫"));
      kfe var3 = var1.getByName(a.c(-1287073067, "튜\uab1b⇎뾸㑴닇ࢭ腡Ἲ閃"));
      switch (gts) {
         case 1:
            gwi(var0, a.c(1469341506, "弴⚃걜㈥맺㽉蔑ೡ鋻᠉鿋断\ueb7e狚\uf894繺쐦"));
            gwi(var0, a.b("\uea9b錷᧠螙ఋ諩ガ륌❇균⨵큄库", -2085623070));
            var0.player.setYaw(0.0F);
            var0.player.setPitch(15.0F);
            break;
         case 5:
            gwi(var0, a.b("屒◬꼺ㅋ뫐㰿蘿࿗醜᭳鳳暞\ue858熷﮷絟위䢋퉲吷\udd9eꞅ⤢늭㒘빝ޣ觶ጆ镜ứ\ue029橵\uf383痂］䂣쫕䰝햭忹⅍ꭖⳠ똴㡅膕଼", 283008004));
            break;
         case 50:
            gwp(var0, a.d("쁓맲㌺굅⚝ꀰᨺ鎔ූ蝧¶慎琒\uedaa柹", -799052107, -880759157));
            break;
         case 51:
            ((vlv)gwg(var2, a.d("ꐏ\udd9c坄줴", 1958431251, 1205923413))).set(a.b("픗겕♟렮", 1599591765));
            var2.setEnabled(true);
            break;
         case 80:
            gwp(var0, a.b("ꎣ\uda02僊캵䕭쏀秊\uf064渦\ue497捆饷\u17eb蹉Ѓ苲", -1634163759));
            gwf(var0, a.d("睞\u0ef2萡ᩒ釈\u173f굿⒗뫈", 124682602, 584840783), 15.0, 16.0);
            break;
         case 81:
            ((vlv)gwg(var2, a.d("ᙀ濓\ue50b筻", 2005859398, -1317082545))).set(a.d("䏛㩞낌⻦", 1735087727, -1071901199));
            break;
         case 130:
            gwp(var0, a.b("⯵剔\ud89c䛣촻䮖\uf19c砲\ue670況\ueb10ᄡ龺؟豍ધ", -1517540473));
            gwf(var0, a.b("쯰뉜㢏\ua6fcⵦꮖᇑ頡٥", 1929235339), 6.5, 8.0);
            break;
         case 131:
            gwi(var0, a.c(-786346662, "䴙㒧빱 ꮛ\u2d74靴ẜ胗ਸ趵瞚爛悶\ueaf1汞홛妞썳䕨첋뚄㡽ꎸ▊꽟᛫颱ɀ萀ྠ\uf176笫\ue294撜\uee25凩"));
            break;
         case 190:
            gwp(var0, a.c(129634468, "\u10c9楨\ue3a0緟\uf607炪쪠䌘\udd42埫크⩑꒒㴢띪"));
            gwf(var0, a.c(1470657347, "猯છ聐Ṹ问ፋꤙ\u20f3"), 0.0, 1.05);
            break;
         case 191:
            ((vmc)gwg(var3, a.c(-587588666, "ᮖ戚\ue8cd皴"))).set(0.0);
            var3.setEnabled(true);
            break;
         case 260:
            gwp(var0, a.d("└岵홽䠂쏚䕷ｽ盏\ue897戨\ue5f4ᾙ鄗࣪芭ѝ븉", -907104148, 1262523659));
            gwf(var0, a.b("\uda78ꏎ⤓띭㲦멃Q覴\u17ea鵀", 187226652), 1.2, 1.7);
            long var9 = Math.floorMod(var0.world.getTimeOfDay(), 24000L);
            boolean var13 = var9 == 18000L;
            if (!var13) {
               gut++;
            }

            System.out
               .println(
                  a.d("Ǫ硋\uf283泼\ue724憉\udb8e刼챵䛂섖㭼떩ⱕꙒ₾髵ᔬ迚", -306545626, 1281195453)
                     + (var13 ? a.d("\ua7eb\ude5e", 1894032259, 1656030213) : a.d("\uf88f脹\u0be2閖", -1301173535, 141906476))
                     + a.c(-1644983114, "貝\uf578羶\ue1c3樜\uec87国\udf2e䅔쯽䱪")
                     + var9
               );
            break;
         case 261:
            var2.setEnabled(false);
            break;
         case 280:
            gwp(var0, a.b("씱벐㙘ꠧ⏿ꕒ\u1f58雪ࢲ舍בﾼ焲\ue8c1抛\ue46a", -1587034813));
            double var8 = var0.options.getGamma().getValue();
            boolean var12 = var8 >= 0.0 && var8 <= 1.0;
            if (!var12) {
               gut++;
            }

            System.out
               .println(
                  a.b("窧̆觎ឱ鱩᫄ꃃ⥵뜬㶑멂䀿캩坚\udd0a对\ue1be渤", -1208124713)
                     + (var12 ? a.b("\ue9c3遶", -2120750674) : a.d("캤뜒㷉ꎽ", -662431457, -1969760263))
                     + a.c(-969967984, "皷ཁ薔ᯩ逾ᚃ게")
                     + var8
               );
            break;
         case 281:
            var2.setEnabled(true);
            break;
         case 300:
            var0.options.write();
            String var7 = a.b("\ueb3a", -1559368956);

            for (String var11 : Files.readAllLines(var0.runDirectory.toPath().resolve(a.c(23898258, "ꣶ텘宏엣串좂狌ﭠ敥\uefd8标")))) {
               if (var11.startsWith(a.b("鲳\ue504濛\uf1aa穱ﲛ", -523920174))) {
                  var7 = var11.substring(6);
               }
            }

            boolean var10 = !var7.equals(a.b("믕", 1319353323)) && Double.parseDouble(var7) <= 1.0;
            if (!var10) {
               gut++;
            }

            System.out
               .println(
                  a.b("縃ޢ赪ጕ飍Ṡꑧⷅ뎈㤮뻮䒞쨍叻\ud9ae当\ue51c櫁\uf033", -832799118)
                     + (var10 ? a.c(1401663725, "낀줵") : a.c(-1882037817, "憅ᠳ鋨ಜ"))
                     + a.b("࣒焬ﯠ斕\uee5f棨튺孖암便졠㈝벞╨꼽⧀鎏᱒蚽", -2018637599)
                     + var7
                     + a.c(316644406, "鰐\ue5ed漻\uf155窑ﱸ")
                     + var0.options.getGamma().getValue()
               );
            break;
         case 301:
            var2.setEnabled(false);
            var3.setEnabled(false);
            break;
         case 310:
            long var4 = Math.floorMod(var0.world.getTimeOfDay(), 24000L);
            boolean var6 = var4 != 18000L;
            if (!var6) {
               gut++;
            }

            System.out
               .println(
                  a.c(-780323033, "㝝仼쐴婋톓圾\ued39撛㮝灴\uf7a3ශ茁\u1ae2郥ᘉ걂⎛륭㽾뚊쳙䉢\ud9f8")
                     + (var6 ? a.b("혊꾿", 454350439) : a.d("胣凌玎\uedfa", -1346268083, -650177300))
                     + a.c(-2018014189, "谸\uf5dd缓\ue166檹\uec22噘\udf8b䇱쭘䳏")
                     + var4
               );
            gwp(var0, a.d("\ud9d1ꁰ⪸듇㼟릲θ訐ᑒ黧\u193c\ue305涐\uf428繻", -214188752, -1265539956));
            System.out
               .println(
                  a.d("〯䦎썆崹훡偌\uea4b揮ﶠ眇\uf0d3\u0af6", -677737159, -530334344)
                     + (gut == 0 ? a.d("퐥궅❄뤵", -938493382, 324628043) : a.c(-1454373841, "ѯ緙\uf702楶\ue2cd摴") + gut + a.c(-630462664, "\ue710"))
               );
            var0.scheduleStop();
            gtr = 99;
      }
   }

   static void gwf(MinecraftClient var0, String var1, double var2, double var4) {
      double var6 = var0.options.getGamma().getValue();
      boolean var8 = var6 >= var2 && var6 <= var4;
      if (!var8) {
         gut++;
      }

      System.out
         .println(
            a.d("倚⦻ꍳ㴌뛔べ詾", -1705687308, -919726453)
               + var1
               + (var8 ? a.d("騞\ue3e0椷", 1393945361, -1532530388) : a.d("鿇\ue610泄\uf2bd祯", 1255483176, -1725712182))
               + a.d("싾묈㇝꾠⑷ꋊᣅ", 210917816, -561996959)
               + String.format(Locale.ROOT, a.b("柳ṉ钆ણ", -20944942), var6)
               + a.b("砧ƞ謒ᕵ麭᠆ꈁ", 300447744)
               + var2
               + a.c(1758512704, "왬뿝")
               + var4
               + a.c(173726263, "\uda1f")
         );
   }

   static vmo gwg(kfe var0, String var1) {
      for (vmo var3 : var0.getSettings()) {
         if (var3.getName().equals(var1)) {
            return var3;
         }
      }

      throw new IllegalStateException(var0.getName() + a.b("ꇌ\ud835勯첌䜈쇷箥\uf21b", -1050369564) + var1);
   }

   static void gwh(MinecraftClient var0, String var1, int var2, int var3) {
      pbz var4 = pbz.get();
      int var5 = 0;

      try {
         for (Field var9 : BossBarHud.class.getDeclaredFields()) {
            if (Map.class.isAssignableFrom(var9.getType())) {
               var9.setAccessible(true);
               var5 = ((Map)var9.get(var0.inGameHud.getBossBarHud())).size();
            }
         }
      } catch (ReflectiveOperationException var10) {
         var5 = -1;
      }

      boolean var11 = (var2 < 0 || var4.count() == var2) && var5 == var3;
      if (!var11) {
         guo++;
      }

      System.out
         .println(
            a.d("㥍䃻쨮员\udf99夿\ue36d檛\uf4d3繴林", 1474710363, -1200262546)
               + var1
               + (var11 ? a.c(122131819, "镈\uecb6晡") : a.c(-2072008822, "ꞯ\ude78咬쫕䄇"))
               + a.b("㶯䑝캂僩\udb25嶎\ue794", -1127203448)
               + var4.count()
               + a.b("ኝ歮\ue1be翜\uf40a狵", -33418565)
               + var5
               + a.b("ꖜ\udc37图", 968533439)
               + var4.describe()
         );
   }

   static void gwi(MinecraftClient var0, String var1) {
      var0.getNetworkHandler().sendChatCommand(var1);
   }

   static void gwj(MinecraftClient var0, String var1, String var2, int var3) {
      gwi(var0, a.c(-430470675, "覆\uf038竢\ue497潓\ue9b0厃\uda41"));
      gwi(var0, a.b("\uf538貔ٖ頯Ꮅ镖⼒꛶㢵눉㗘쾯䄽\ud8c9劑푺渨\ue1e4筚ﵒ瓅ວ聇ᯞ鶦ᝬ껉ₛ멿㱲럟䤞쌆嫩\udca7嘊\ue995掩\ue57e糈\uf69c衫ȩ薋Ὓ鄸⢥ꉊ␈뿑ㆮ쭽䋋쒐幘퀥殞\ued57朹\ufefe", -1916930707));
      gwi(
         var0,
         a.c(1972655046, "厸⨔ꃖ㺯딵㏖覒v鸵ᒉ鍘椯\ue7bd繉\uf411狺좨䝤\uddda寒퉅ꠧ⛇")
            + var1
            + a.d("㡶䆐쭝唱\udefa堃\ue21d毨\uf5b0缊\uf8dfʿ豻ᗍ龌ᤳꌱ⳾뙊】망쎰䴈훐傼\uda78揉\ueddd眲", -1921453858, 1014876309)
      );
      gwi(var0, a.d("ᓰ浜\ue79e秧\uf27d璞컚䜾\ud97d叁퐐\u2e67ꃵ㤁덙㖲迠,骒Ლ锍\uef6f憏", -845358937, 273206313) + var2 + a.b("앾벘㙕꠹⏲ꔋἕ雠ࢸ舂חﾷ煳\ue8c5抄\ue43b帣퇾䭏촘", 993772874));
      var0.player.getInventory().setSelectedSlot(var3);
   }

   static void gwk(MinecraftClient var0, kfe var1, int var2, float var3) {
      ClientPlayerEntity var4 = var0.player;
      var4.getInventory().setSelectedSlot(0);
      var4.setPitch(var3);
      gui = var3;
      gug = Float.NaN;
      guf = var4.getY();
      guh = guf;
      System.out
         .println(
            a.d("㹕䟺촮单\ud8c6帧\ue476涐\uf3d9票ﻲҙ訁Ꮁ駋Ἇꕝ⪖뀾㙥뿋", 491472758, 1215723841)
               + var4.isOnGround()
               + a.b("埋⸣꒴", -846440472)
               + gwn(var4.getY())
               + a.b("뗕찬䛲\ud88a单햽", 1637201395)
               + var4.getMainHandStack().getItem()
               + a.d("焗ࣵ船\u1c4b鞇ᅿ", 1261483360, 1911931985)
               + var4.getInventory().getSelectedSlot()
         );
      var1.onKey(var0, var2);
   }

   static void gwl(MinecraftClient var0, String var1) {
      ClientPlayerEntity var2 = var0.player;
      System.out
         .println(
            a.d("⡭凂\udb16䕭컾", 144123815, 15077304)
               + var1
               + a.d("衊\uf1af", 177890526, 901901494)
               + gts
               + a.b("䙰㿛땊⬬ꃽ♆鱑", 1780172365)
               + oxw.busy()
               + a.b("猽ૄ耞Ṡ閽ፕ", 1035432731)
               + var2.getMainHandStack().getItem()
               + a.b("䎞㩼낰⻂ꔎ⏶", 1785938872)
               + var2.getInventory().getSelectedSlot()
               + a.b("非\ueebf摵神燙\uf763䵥", 1745131385)
               + gwn(var2.getPitch())
               + a.d("迫\uf603粔", -1302285060, 1823095604)
               + gwn(var2.getY())
               + a.d("뻀윧䷻폎", -111721954, 55573754)
               + gwn(var2.getVelocity().y)
         );
   }

   static void gwm(MinecraftClient var0, String var1, Item var2, int var3, int var4, int var5, double var6, double var8) {
      ClientPlayerEntity var10 = var0.player;
      PlayerInventory var11 = var10.getInventory();
      ItemStack var12 = var11.getStack(var3);
      boolean var13 = true;
      StringBuilder var14 = new StringBuilder();
      if (!var10.getMainHandStack().isOf(var2)) {
         var13 = false;
         var14.append(a.b("ʳ筊\uf190濮\ue433招", -155909483)).append(var10.getMainHandStack().getItem());
      }

      if (!var12.isOf(Items.WIND_CHARGE) || var12.getCount() != var4) {
         var13 = false;
         var14.append(a.b("灮জ荄ᴼ雸ၜꨍ⏙", 216559686)).append(var3).append('=').append(var12);
      }

      if (var11.getSelectedSlot() != var5) {
         var13 = false;
         var14.append(a.d("\udd0cꓮ⸢끐㮜뵤", 1121388467, 433183385)).append(var11.getSelectedSlot());
      }

      if (Float.isNaN(gug) || Math.abs(gug - gui) > 0.01F) {
         var13 = false;
         var14.append(a.c(1399697156, "꼣훂專쉤䦤켞甘")).append(gwn(gug));
      }

      double var15 = guh - guf;
      if (var15 < var6 || var15 > var8) {
         var13 = false;
         var14.append(a.b("캣띀㶎ꏣ⠢껖", -1891250555))
            .append(gwn(var15))
            .append(a.c(-606228965, "긼힅崉썮䢶츝琚"))
            .append(gwn(var6))
            .append(a.b("畔\u0ce5", 2122937720))
            .append(gwn(var8))
            .append(')');
      }

      if (oxw.busy()) {
         var13 = false;
         var14.append(a.d("뵰쒒乆퀪寸\udd49杖\ueee5炭祥緃", -105995072, -992732773));
      }

      if (!var13) {
         guj++;
      }

      System.out
         .println(
            a.c(-976385626, "觔\uf07b窯\ue4d4潇")
               + var1
               + (var13 ? a.d("̓竭\uf03a", 761071001, 1451230889) : a.d("ċ磜\uf208汱\ue7a3", -741692668, 1763551786) + var14)
               + a.b("䭒㋣렸☓귙\u2b74鄱ᢅ", -1249096838)
               + gwn(guh - guf)
               + a.c(73767034, "顑\ue1ec歷\uf50f绗\uf86c䉻")
               + var10.getMainHandStack().getItem()
               + a.c(-31845278, "ᑊ")
         );
   }

   static String gwn(double var0) {
      return String.format(Locale.ROOT, a.b("틗\uab6d↢뾇", 427807478), var0);
   }

   static void gwo() {
      gtr++;
      gts = 0;
   }

   static void gwp(MinecraftClient var0, String var1) {
      System.out
         .println(
            a.c(2030422834, "쭋달㠶ꙍⷜꬹᅻ颜ۄ谡")
               + var1
               + a.b("\udfdaꘋⲸ", 1520164857)
               + var0.getCurrentFps()
               + a.b("ᵒ撥\uee60瀒ﮚ紧윧仆킈娮\uddfd➇꤃", -1595859585)
               + (var0.currentScreen == null ? a.d("䷦㑖뺄\u20fe", 787818442, -386373050) : var0.currentScreen.getClass().getSimpleName())
         );
      ScreenshotRecorder.saveScreenshot(
         var0.runDirectory,
         a.b("碫Đ诀ᖩ鸻ᢕ", -2065401653) + var1 + a.d("봖쓹临큌", -1404631574, -1589135146),
         var0.getFramebuffer(),
         1,
         var0x -> System.out.println("" + var0x.getString())
      );
   }

   static void gwq(Screen var0, int var1) {
      if (var0 != null) {
         var0.keyPressed(new KeyInput(var1, 0, 0));
      }
   }

   static void gwr(Screen var0, String var1) {
      if (var0 != null) {
         for (char var5 : var1.toCharArray()) {
            var0.charTyped(new CharInput(var5, 0));
         }
      }
   }

   static void gws(Screen var0, float var1, float var2, int var3) throws Exception {
      if (var0 instanceof hlc) {
         float var4 = gwu(var0, a.b("\ud867ꇋ⬃땼㺥렓ɶ", 1040242703));
         float var5 = gwu(var0, a.d("⢘儴\udbfc䖃칚䣬\uf288", -1828865134, -1146252446));
         float var6 = gwu(var0, a.b("沂ᔣ鿲Ǝ詐", 1346923764));
         var0.mouseClicked(new Click(var4 + var1 * var6, var5 + var2 * var6, new MouseInput(var3, 0)), false);
      }
   }

   static void gwt(Screen var0, float var1, float var2, double var3) throws Exception {
      if (var0 instanceof hlc) {
         float var5 = gwu(var0, a.d("쌒몾ぶ급◐ꍦᤃ", 1228529131, 1881087633));
         float var6 = gwu(var0, a.d("⇯塃튋䳴윭䆛ﯿ", 1138024897, -1296252858));
         float var7 = gwu(var0, a.b("椉Ⴈ驹Ѕ进", -1108579969));
         var0.mouseScrolled(var5 + var1 * var7, var6 + var2 * var7, 0.0, var3);
      }
   }

   static float gwu(Object var0, String var1) throws Exception {
      Field var2 = var0.getClass().getDeclaredField(var1);
      var2.setAccessible(true);
      return var2.getFloat(var0);
   }
}
