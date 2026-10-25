package a;

import com.mojang.authlib.GameProfile;
import flow.Flow;
import flow.dev.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.KeyInput;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.option.Perspective;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.Entity.RemovalReason;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Vec3d;

final class fwv {
   private static final List<Entity> fww = new ArrayList<>();
   private static final String[] fwx = new String[]{a.c(-1549244495, "柰Ṭ钨"), a.c(-103404170, "ⴲ咯\ude61䀌쯐䵶\uf724"), a.c(1783628664, "̺窬\uf07d渊")};
   private static final String[] fwy = new String[]{
      a.c(374044592, "矦\u0e6c蒸ᫀ"),
      a.c(546817548, "왉뿝㔀ꭾ₵ꘞ\u1c4a閼௪"),
      a.c(1303079224, "楩ღ騲љ辟ह"),
      a.b("ꯣ퉿墻웝", -1983337557),
      a.c(208887909, "怠ᦽ鍲ഝ蛈e"),
      a.c(-123909574, "䩽㏸뤬❀겊⨨"),
      a.b("䧬ぱ몤ⓑ꼉", 1014057382),
      a.b("簳֩轰ᄀ", 1440709753),
      a.d("\udf8fꘌⳕ늺㥪뿈", -1403450249, 1271387053)
   };
   private static final String[] fwz = new String[]{a.d("氮ᖥ齷Ğ諌౺똢", 1138654841, 1090392607), a.c(-83881656, "ᄉ梕\ue251")};

   private fwv() {
   }

   static boolean tick(MinecraftClient var0, int var1) throws Exception {
      kfx var2 = Flow.getInstance().getModuleManager();
      if (var1 == 1) {
         fxn(var0, a.b("䟻㹌뒓⫪ꄵ➆鷞ᐮ訴Æ蜄絢\uf3b1樕\ue05b暵\udce9", -1195292787));
         fxn(var0, a.b("朎Ả鑵\u0a0c膞ݼ봹㓙\uaad2⁵Ꞡ巑팆", -1288411273));
         fxn(var0, a.d("ﻶ蝕ං鏦ᠭ麑ⓕ굶㍪맔㸎쑻䪿", -801001966, 999051422));
         fxn(var0, a.c(1864066707, "替\u1f58閚\u0bfd耤ږ볉㔰ꬤ⇋Ꙇ屩틠䬏섑䟳ﷱ爤\ue890滊\ue73b鵻Ꮫ蠍\u0e60蓿㴅덓⦿꿯\u2457"));
         fxn(var0, a.d("놝젺䋸\udc9f坆퇴殫\ue252籆\uf6a9焵譕ל鰳ᘾ邂⫞ꕂ㿵릣た䨈쒪彨\ud910叓\uea2e搶ﻆ碌\uf33e\u0de4", 235330743, -368611975));
         izx.TARGET.enabled.set(false);
      }

      if (var1 == 6) {
         fxh(
            var0,
            new Vec3d(
               Math.floor(var0.field_1724.method_23317()) + 0.5,
               Math.floor(var0.field_1724.method_23318()) + 0.7,
               Math.floor(var0.field_1724.method_23321()) + 3.5
            )
         );
         fxd(var2, a.c(117294034, "쎜먃ビ꺮╱ꏤᦍ遽ฺ蒎͚鸞"), true);
      }

      for (int var3 = 0; var3 < fwx.length; var3++) {
         int var4 = 10 + var3 * 10;
         if (var1 == var4) {
            fxe(var2, a.c(-1216626906, "뽨웷䰧퉚妅\udf10敹\uec89狎\uf87a羮藔"), a.d("ጀ檓\ue04b縻", 314910037, 1299002908), fwx[var3]);
         } else if (var1 == var4 + 8) {
            fxo(var0, a.b("㵅䓪칬偟\udb92崢\ue769溝\uf0c5穿\ufde4", 1299070248) + fwx[var3].toLowerCase());
         }
      }

      byte var12 = 100;
      if (var1 == var12) {
         fxd(var2, a.c(231819471, "䢁ㄞ믎△깬⣹銐᭠蔧ྒྷ衇爽"), false);
         fxn(var0, a.c(-1173305380, "잲븕㓗ꪰⅩ\ua7dbᶄ鑽੩肆܋ﴤ玭\uea42恜\ue6be岼퍩䧝쾇䙶㰶늖⥀꼭▲鱚ሃ裯"));
         fxn(var0, a.b("翇٠貢ዅ餜ᾮꗱⰈ눜㣳뽯䔏쮆剩\ud864廘\ue484欘\uf1af矹︅葒૰鄲ᝊ鶉⑴ꩾめ뛋", 1906737066));
         var0.field_1690.method_31043(Perspective.field_26665);
         fxg(var0, 0.0F, 35.0F);
         fxd(var2, a.c(1255363447, "匶⪸ꁳ㸟뗻㍠褨È麘ᐠ鏥"), true);
      }

      for (int var13 = 0; var13 < fwy.length; var13++) {
         int var5 = var12 + 4 + var13 * 16;
         if (var1 == var5) {
            fxe(var2, a.b("\ue9aa逤\u1aef蒃ཧ觼㎴메␄꺼⥹", 258206187), a.b("镆\ueccb昕\uf86c玳", -661940969), fwy[var13]);
            if (var0.field_1724.method_24828()) {
               var0.field_1724.method_6043();
            }
         } else if (var1 == var5 + 7) {
            fxo(var0, a.b("謱\uf29e砘\ue627淺\ueb50儒\ud8ec䚺챃", -1378251939) + fwy[var13].toLowerCase());
         }
      }

      int var14 = var12 + 4 + fwy.length * 16 + 4;
      if (var1 == var14) {
         fxd(var2, a.d("榯အ髪҆轢৹뎱㩑ꐁ⺹ꥼ", -25457215, 1660544047), false);
         var0.field_1690.method_31043(Perspective.field_26664);
         fxg(var0, 0.0F, -10.0F);
         kfe var15 = var2.getByName(a.c(1595478387, "ᄧ梪\ue263簋\uf7f5煒쬂"));
         ((vkl)fxf(var15, a.d("픽겮♰렐", -842385269, -1435439617))).set(true);
         var15.setEnabled(true);
         fxn(
            var0,
            a.d(
               "뷾쑉亂탳嬦\udd96枋\uee37灬\ufada紂蝵\u09b3逑ᩅ鲦⚧ꤶ㎐뗃㰻䙡죞半핫忤\ue609栆\uf2af璵３ƙ诣ሳ鑎ỷꅓ⬩궩㑖빶삽䫫쵓垏\ud9e4恹\ueac3泟\uf740祺莿\u0a0c豁ᚫ飧⍐ꖊ\u2fe3뙼㢊䋍씲佫톣堔\ue24e撰\ueeed焂ﮐ緳萡໎邅ᬻ鵨⟞긆ぱ몯㳭䝙즚厣\uda3c岔\ue6de椰\uf369痨ﰉٷ袟ጆ镌ᾉꇥ⠦느㓎뽺섧䯙툊呡\udea9愂\ueb1b淡\uf7fe繏肀",
               -126635076,
               863505984
            )
         );
      }

      if (var1 == var14 + 10) {
         ZombieEntity var16 = fxc(var0);
         System.out.println(a.b("䌙㪶뀽⸟ꗔ⍿餵႒軗м菺禉\uf751滫\ue4b4戀", 463946607) + (var16 != null));
         if (var16 != null) {
            rrx.onAttack(var16);
         }

         fxn(var0, a.c(871493000, "\uedd5鑡Ế胃\u0b12趡㞷븦⁜\uaad3\u2d2f흓妍쀩䨢첃盈爛掦\ue5f1気ᙕ飡̢蔓ྂ똤㡷ꊏⓕ꽪凲\udbfd䈉쑞仫\uf121笙ﷆ摪\uee6a邇᫉鵾ߠ观〚몯㳳ꜵ⥐펆娘\udc34䛖좆猹"));
      }

      if (var1 == var14 + 24) {
         fxo(var0, a.d("㗞䱱웷壘팓喸\ueff2時\uf844狮\uf526ཆ膙", 618332524, -1001179943));
      }

      if (var1 == var14 + 40) {
         fxn(var0, a.b("\uf1ff行ʚ鳫ᝰ醡⯗ꈘ㱨뛔ㄎ쭪䗥\udc04噓킥櫡\ue536羔淪瀦\u0a65蒘Ἁ饣Ꮀꨌ\u2456뺭㣄", -1919487606));
      }

      if (var1 == var14 + 56) {
         fxo(var0, a.d("\uf636辙ԟ鬰჻限Ⱊꖪ㮳넀㛖첧", -123526971, -1513498983));
      }

      int var17 = var14 + 80;
      if (var1 == var17) {
         fxd(var2, a.d("㉙䯔석彵풋刬\ue87c", -1179222205, 67849550), false);
         fxg(var0, 0.0F, 6.0F);
         fww.add(fxi(var0, a.b("\uf7de蹙ҝ髨ᄳ", 296351647), 4.0, 0.0, false));
         fww.add(fxi(var0, a.d("恝ᧈ錘ർ蚳", -1289965007, 1081528866), 6.0, 3.0, false));
         fww.add(fxi(var0, a.d("년죒䈒", 359761655, -966379530), 14.0, -5.0, false));
         hhf.add(a.c(2082645425, "ꗿ\udc6a嚺죞䌑"));
         fxd(var2, a.b("ﯬ艡ࢿ雖ᴝ鮻⇟꠸㙤", -1558971467), true);
      }

      for (int var6 = 0; var6 < fwz.length; var6++) {
         int var7 = var17 + 2 + var6 * 8;
         if (var1 == var7) {
            fxe(var2, a.d("䶮㐣뻽ₔꭟⷹ鞝Ṻ耦", -1490264935, 1187713390), a.b("\ueb32銡\u1879蘉", 1575021435), fwz[var6]);
         } else if (var1 == var7 + 6) {
            fxo(var0, a.d("傀⤯ꎩ㶐뙑ャ諭", -1681612380, -572067515) + fwz[var6].toLowerCase());
         }
      }

      int var18 = var17 + 2 + fwz.length * 8 + 2;
      if (var1 == var18) {
         fxd(var2, a.b("避\ue9f2挬﵅皎\uf028䩌쎫巷", 661032998), false);
         fxd(var2, a.d("\udeb0ꜧⷧ뎙㡓뻡ң赁ጉ馳Ṻ\ue439櫚\uf370礯ￕ䖐쩖", -1688121343, 1353289463), true);
      }

      if (var1 == var18 + 6) {
         fxo(var0, a.c(2075809627, "圲⺝ꐛ㨡뇢㝈贗ӭ骸၀韙涧\ue377竚\uf08e"));
      }

      if (var1 == var18 + 7) {
         fxd(var2, a.d("ⴶ咡\ude61䀟쯕䵧\uf725织\ue08f樵\uedfcឿ饜ö誩\u0c53똖㧐", -1634971933, 1237934995), false);
         hhf.remove(a.b("紽Ҩ蹸လ鯓", 1022852467));
         fww.get(0).method_5648(true);
         fxd(var2, a.b("郞\ue954掀\ufde9瘀\uf096䫝쌳嵶ퟝ倅ꩺ⒤", -511078272), true);
      }

      if (var1 == var18 + 13) {
         fxo(var0, a.b("\u0de3瑌ﻊ惥\ueb29涟ퟔ广쁤䫒촙㝷릺‑ꩉⲶ雰", -164033132));
      }

      int var19 = var18 + 16;
      if (var1 == var19) {
         fxd(var2, a.b("\uef5a雐ᰄ艭\u0984輒㕙벷⋲ꡙ⾁헾嬠", 1603464964), false);

         for (Entity var9 : fww) {
            fxj(var0, var9);
         }

         fww.clear();
         fxn(var0, a.d("ꤸ킆婐쐡侺쥕獕諸擶\uee19榔鎻ᴦ蒃ຎ蠲㉮뷡✟ꅝ⣴勯\udc48䟔솯䭹\uf2c1粖\ue670怲\ueb86ᕅ齄ۼ肨ਂ뗔㾮", 295606913, -1528417287));
         fxn(var0, a.d("ᙬ濋\ue509筮\uf0b7瘅챚䖣\udbb7兘훕⳺ꉳ㮜놆㝠赢ʷ頃ṙ鞨\uede8捈\uf89e绳\uf46c䶁쏝夢\udf7f哎ꨞ⁛릑㿲땞ઞ", 1261701325, -1926357257));
         fxn(var0, a.d("\uf034覓͑鴶ᛯ遝⨂ꏻ㷯뜀゜쫼䑵\udd9a垗턯歷\ue4eb繜\uf80a燶\u0ba1蔃ề颹ቺꮇ█뽲㤫는䱇옉忲\ud99a匛\uecd1暷", 482511765, 1992326132));
         fxn(var0, a.c(38934580, "ᡡ懆\ueb04畣ﺺ砈쉗䮮햺录\ud8d8⋷걯㗏뿂㥺茢ಾ阉ၟ馣\ue3f4浖\uf694烬隷䏒췝圧텾嫁ꐒ⹜랧㇏뭎҄転"));
         fxn(var0, a.b("㱲䗕켗兰\udaa9尛\ue644澽\uf1a9筆ﳋۤ衭ᆂ鮗ᵾꝼ⢩눝㑇붶쟶䥖튀哭\ude72枟\ue9c3猼\uf561绐耀\u0a45鎏ᗬ齀₀", -1538180060));
         fxn(var0, a.c(1066760325, "磓Ŵ讶ᗑ鸈ᢺꋥ⬜딈㿧롧䈉쳌唣\udf3f姟\ue3ce汙\uf6f2烮欄荋ෳ阤၊骈⌼굿㟆뇊㩱쒣令휮免\udbe1搡"));
         fxn(var0, a.b("倜⦻ꍹ㴞뛇ふ訪ϓ鷇ᜨ邷櫔\ue45d網\uf7bf焉쭟䓃\ude74堢퇞ꮉ┫뻩㢑뉒ய薧Ὓ餇ኢ\uec74", 547901519));
         fxn(var0, a.b("\ue3d4驳Ⴑ軖ԏ莽㧢뀛⸏ꓠ⍠\ud90d埋츤䐩슆碆\uf756淵\uebe9戚ᡌ雴ണ譍Ə렻㙸곁⫋ꅷ徫헮䰓쩋䃠＜畖\uf384樲\ue07d麗ᓞ", 673506188));
         fxg(var0, 0.0F, 5.0F);
      }

      if (var1 == var19 + 4) {
         fxd(var2, a.d("\udeeeꝱⶡ돜㠃뺜ә贫", -585514113, -1962926629), true);
      }

      if (var1 == var19 + 14) {
         fxo(var0, a.b("䅡㣎뉈ⱶꞯℝ魂ኻ貢ٛ膞篬", -206487285));
      }

      if (var1 == var19 + 15) {
         fxe(var2, a.b("뭈싗䠇홺嶥\udb3a慿\ue88d", 1760213762), a.b("뒞촍䟕\ud9a5", -588466985), a.d("譥\uf2f8砶\ue65b涇\ueb21关", 1245773470, 246707647));
      }

      if (var1 == var19 + 22) {
         fxo(var0, a.b("영뾮㔨ꬖ\u20cf꙽ᰢ闛ூ脻۾ﲌ爆\uebf9憦\ue74a崙틃䡧츷", -1483618701));
      }

      int var20 = var19 + 26;
      if (var1 == var20) {
         fxd(var2, a.d("맱쁮䪾퓃弜\ud983揆\uea34", -224609552, -1241447605), false);
         fxk(var0, a.b("횦꼠◸뮃さ뛳", -287975694));
      }

      if (var1 == var20 + 12) {
         kfe var21 = var2.getByName(a.d("넯좰䉠\udc1d埂텝欘\ue2ea", -2047458823, -1189482340));
         Method var10 = hlc.class.getDeclaredMethod(a.b("뜀캮䑨\uda12击흳洪\ue4d3窂\uf024", 1523955557), vlj.class);
         var10.setAccessible(true);
         var10.invoke(var0.field_1755, (vlj)fxf(var21, a.c(468176351, "춛됄㻔ꂩ⭶귟")));
      }

      if (var1 == var20 + 22) {
         fxo(var0, a.b("佼㛓뱕≹ꦷ⼌镗Შ苠", -1158131949));
      }

      if (var1 == var20 + 23) {
         fxm(var0.field_1755, a.b("ﲺ蔆\u0fdd醠᩵鳅⚜", 1145044185));
      }

      if (var1 == var20 + 30) {
         fxo(var0, a.d("菅頻烬\ueec0攎\ue3b5姮퀑乙쒷䌺륝㞎긬⑮ꊔ", 1877013680, 1059550979));
      }

      if (var1 == var20 + 31) {
         fxl(var0.field_1755, 256);
         fxl(var0.field_1755, 256);
      }

      if (var1 == var20 + 38) {
         fxo(var0, a.c(-1583265651, "䣻ㅔ믒◾기⢋鋐ᬯ蕧ྉ蠔牪ﲾ攓\uef56榦"));
         var0.method_1507(null);
      }

      int var22 = var20 + 42;
      if (var1 == var22) {
         fxn(var0, a.c(-420455482, "宄∺꣬㚝봆㯩臩ࠆ陊Ქ鬨愇\uef9a瘿ﰲ窎샒佝햣叡\uda48ꁓ\u2ef4땨㌓맅}踪ᓌ銎᤺\ue7f9淸\uf452爉\uf8a3"));
         fxg(var0, 0.0F, 10.0F);
         var0.field_1724.method_31548().method_61496(0);
         var0.field_1724.method_31548().method_5447(0, new ItemStack(Items.field_8802));
         var0.field_1724.method_5673(EquipmentSlot.field_6171, new ItemStack(Items.field_8288));
         fxo(var0, a.b("梕ᄺ鮼ֈ蹖ࣨ늱㭗ꕖ⾺꡵刉\udcd6䕠", -69637891));
      }

      if (var1 == var22 + 2) {
         fxd(var2, a.b("⢵儿\udbe5䖑칇䣡\uf288筐\ue500澻\ue87f", -1318377235), true);
      }

      if (var1 == var22 + 10) {
         fxo(var0, a.c(998713923, "⨨厇\ud901䜵쳫䩕\uf00c秪\ue7eb洖\uead1Ⴇ鹣"));
      }

      int var23 = var22 + 14;
      if (var1 == var23) {
         fxd(var2, a.b("ꆟ\ud815勏첻䝭쇋箢\uf27a氪\ue691慕", -2140036665), false);
         kfe var11 = var2.getByName(a.d("癆࿈蔗᭴邙ᘊ걒▢믴", -651009054, -1202121221));
         ((vmc)fxf(var11, a.c(1708025020, "擥"))).set(-0.15);
         ((vmc)fxf(var11, a.b("쨨", -1068512653))).set(0.2);
         ((vmc)fxf(var11, a.d("ᡷ懧\ueb33畞ﻇ砏", -1441236106, -1772919981))).set(-25.0);
         ((vmc)fxf(var11, a.b("龚\ue611泑\uf2bf", -753492019))).set(0.8);
         var11.setEnabled(true);
      }

      if (var1 == var23 + 6) {
         fxo(var0, a.d("ݔ绻\uf47d橗\ue19f朢\udd63咈쫕䁯잽㷅", -1978312184, -2115150538));
      }

      if (var1 == var23 + 7) {
         fxd(var2, a.c(-34100288, "ꮟ툑壎욭䵀쯓熋\uf87b昭"), false);
      }

      int var24 = var23 + 16;
      if (var1 == var24) {
         var0.field_1724.method_31548().method_5447(0, new ItemStack(Items.field_49814));
         var0.field_1724.method_75203();
      }

      if (var1 == var24 + 4) {
         fxo(var0, a.b("옃뾬㔪\uab1b⃀꙳ᰦ閟ட脹۬ﲖ版\uebea憬\ue75f", 638633589));
      }

      if (var1 == var24 + 5) {
         fxn(var0, a.c(1450754855, "썑뫦〹김▟ꌬᥴ還ພ葼Ω履県\ueea2擮\ue208塊"));
         fxn(var0, a.b("Ꮡ橣\ue0b0绂\uf513玵즲䀄\ude55哻팻⤏Ꞹ㸺됺㊆裍ܛ鶣\u1bf4鈒\ue850曤ﴧ笖\uf18f䠫왬岁\udaca兾꾺◺밆㩓낧ལ蔑ϒ驲ာ滍\ue4ca捽玲矌", 1956058010));
         fxn(var0, a.c(-421777965, "ⶫ吞\ude9d䂌쭨䶊\uf787縨\ue029櫟\ued15\u173a"));
      }

      if (var1 == var24 + 20) {
         fxo(var0, a.d("橠Ꮟ饉ݸ貣ਐ끅㧼ꟽⵒꪍ僮\ude22", 355623171, -196932856));
      }

      if (var1 >= var24 + 40) {
         fxn(var0, a.c(1145741441, "ꃷ\ud940原췦䘹삊竒\uf322洸\ue7ca怈驮ᒽ贙ݗ膹㯥"));
         var0.field_1724.method_31548().method_5447(0, ItemStack.field_8037);
         var0.field_1724.method_5673(EquipmentSlot.field_6171, ItemStack.field_8037);
         izx.TARGET.enabled.set(true);
         hyz.save();
         return true;
      } else {
         return false;
      }
   }

   private static ZombieEntity fxc(MinecraftClient var0) {
      ZombieEntity var1 = null;

      for (Entity var3 : var0.field_1687.method_18112()) {
         if (var3 instanceof ZombieEntity var4 && (var1 == null || var4.method_5858(var0.field_1724) < var1.method_5858(var0.field_1724))) {
            var1 = var4;
         }
      }

      return var1;
   }

   private static void fxd(kfx var0, String var1, boolean var2) {
      var0.getByName(var1).setEnabled(var2);
   }

   private static void fxe(kfx var0, String var1, String var2, String var3) {
      ((vlv)fxf(var0.getByName(var1), var2)).set(var3);
   }

   private static vmo fxf(kfe var0, String var1) {
      for (vmo var3 : var0.getSettings()) {
         if (var3.getName().equals(var1)) {
            return var3;
         }
      }

      throw new IllegalStateException(var0.getName() + a.c(-720921272, "鵠\ue499湃\uf020箤ﵛ䜉캷") + var1);
   }

   private static void fxg(MinecraftClient var0, float var1, float var2) {
      var0.field_1724.method_36456(var1);
      var0.field_1724.method_36457(var2);
      var0.field_1724.field_5982 = var1;
      var0.field_1724.field_6004 = var2;
   }

   private static void fxh(MinecraftClient var0, Vec3d var1) {
      Vec3d var2 = var1.method_1020(var0.field_1724.method_33571());
      fxg(
         var0,
         (float)Math.toDegrees(Math.atan2(-var2.field_1352, var2.field_1350)),
         (float)(-Math.toDegrees(Math.atan2(var2.field_1351, Math.hypot(var2.field_1352, var2.field_1350))))
      );
   }

   private static PlayerEntity fxi(MinecraftClient var0, String var1, double var2, double var4, boolean var6) {
      OtherClientPlayerEntity var7 = new OtherClientPlayerEntity(var0.field_1687, new GameProfile(UUID.randomUUID(), var1));
      Vec3d var8 = var0.field_1724
         .method_73189()
         .method_1019(new Vec3d(0.0, 0.0, 1.0).method_1021(var2))
         .method_1019(new Vec3d(-1.0, 0.0, 0.0).method_1021(var4));
      var7.method_5808(var8.field_1352, var0.field_1724.method_23318(), var8.field_1350, 180.0F, 0.0F);
      var7.method_5636(180.0F);
      var7.method_5847(180.0F);
      var7.field_6220 = 180.0F;
      var7.field_6259 = 180.0F;
      var7.method_5673(EquipmentSlot.field_6174, new ItemStack(Items.field_8058));
      var7.method_5673(EquipmentSlot.field_6173, new ItemStack(Items.field_22022));
      var7.method_5648(var6);
      var0.field_1687.method_53875(var7);
      return var7;
   }

   private static void fxj(MinecraftClient var0, Entity var1) {
      if (var1 != null) {
         var0.field_1687.method_2945(var1.method_5628(), RemovalReason.field_26999);
      }
   }

   private static void fxk(MinecraftClient var0, String var1) throws Exception {
      Field var2 = hlc.class.getDeclaredField(a.d("貗\uf533翣\ue1bb橂\uecef", -1214216446, 1279986663));
      var2.setAccessible(true);
      var2.set(null, var1);

      for (String var6 : new String[]{a.c(-1177159865, "\uf737躘ь騷ᇫ靂ⴾ"), a.d("銗\ueb38懬ﾗ瑋\uf2e2䢟", -2091486387, 1639113130)}) {
         Field var7 = hlc.class.getDeclaredField(var6);
         var7.setAccessible(true);
         var7.setFloat(null, Float.NaN);
      }

      var0.method_1507(new hlc());
   }

   private static void fxl(Screen var0, int var1) {
      if (var0 != null) {
         var0.method_25404(new KeyInput(var1, 0, 0));
      }
   }

   private static void fxm(Screen var0, String var1) {
      if (var0 != null) {
         for (char var5 : var1.toCharArray()) {
            var0.method_25400(new CharInput(var5, 0));
         }
      }
   }

   private static void fxn(MinecraftClient var0, String var1) {
      var0.method_1562().method_45730(var1);
   }

   private static void fxo(MinecraftClient var0, String var1) {
      System.out.println(a.c(-1758931688, "핡곆☜롧㏶딓ད蚶ᣮ鈋") + var1 + a.d("쑤붵㜆", 1184295006, -1008587751) + var0.method_47599() + a.c(-1535618344, "勼⬋ꇎ㾼"));
      ScreenshotRecorder.method_22690(
         var0.field_1697,
         a.b("灍৶茦ᵏ雝ၳ", -184979411) + var1 + a.b("ᜓ滼\ue431穉", 738334521),
         var0.method_1522(),
         1,
         var0x -> System.out.println("" + var0x.getString())
      );
   }
}
