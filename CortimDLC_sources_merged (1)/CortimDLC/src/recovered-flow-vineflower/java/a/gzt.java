package a;

import com.mojang.datafixers.util.Pair;
import flow.Flow;
import flow.dev.a;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap.Type;
import net.minecraft.world.biome.BiomeKeys;
import org.lwjgl.glfw.GLFW;

final class gzt {
   private static final int gzu = 520;
   private static final String gzv = System.getenv(a.b("韃\uee78撨贈煳\uf7af䷰쐆婂탮圢", -156526706));
   private static final gzj[] gzw = new gzj[]{
      new gzj(0, a.d("䜐㺤둯⩊ꇘ❮鴠ᓊ誆\"蟰", -51852174, 424184589), 6000L, 20.0F, -5.0F, true),
      new gzj(40, a.b("⩗口\ud928䜍첟䨩\uf067禍\ue7c1浥\ueab7ႅ鸐ި跻", 435169852), 6000L, 20.0F, -5.0F, false),
      new gzj(80, a.d("繴߀贋ጮ颧Ḏꑏ", 1647265527, -576243488), 6000L, 20.0F, -45.0F, true),
      new gzj(120, a.c(-6405728, "䇂㡶늽Ⲙꜗ↣"), 6000L, 110.0F, -80.0F, true),
      new gzj(160, a.b("ѐ緤\uf72f椊\ue297搳\ude7d垖짒䍩", -1166408642), 6000L, 0.0F, 35.0F, true),
      new gzj(200, a.d("焸ࢌ艇ᱢ韯ᅈꬖ⋧", 900366508, -400428552), 6000L, -90.0F, 8.0F, true),
      new gzj(240, a.b("\u18ac愘\uebd3痶ﹼ磜슚䭷", 1598429376), 6000L, 180.0F, 30.0F, true),
      new gzj(280, a.c(-1478492971, "ﲠ蔗\u0fdf醳ᩲ鳒"), 12600L, 90.0F, -6.0F, true),
      new gzj(320, a.c(-500062101, "ꠒ톥孭씁什졠牪ﯙ斏\uef3e"), 12600L, 90.0F, -6.0F, false),
      new gzj(360, a.c(1540584367, "珀\u0a60肵Ờ镍Ꮆ꧰“빙㓳댪"), 13000L, 0.0F, 30.0F, true),
      new gzj(400, a.c(-584332884, "짇끱㪬ꓒ⼙"), 18000L, 20.0F, -20.0F, true),
      new gzj(440, a.b("\udb1dꊫ⡶똈㷃묫Ĳ裖ᚔ鰿\u1bf7\ue18c", -416228481), 18000L, 0.0F, 30.0F, true),
      new gzj(480, a.b("淌ᑺ麧Ù謒\u0dfa럦㸚ꁆ⫯", 123170216), 18000L, 30.0F, -8.0F, true, a.b("!禝\uf34d洤\ue6bd怏\uda55厤", -1050279861)),
      new gzj(520, a.b("Ǵ础\uf28b沮\ue736憊\udbda刳", 283050392), 6000L, 30.0F, -8.0F, true, a.d("燒\u086e芾᳗靎ᇳꮣ≗", 1712026096, -1742208952)),
      new gzj(560, a.c(-1883623624, "⽝囫\udc36䉈즃佫\uf573粈\ue2da桹\uefb1"), 18000L, 20.0F, -25.0F, true, a.c(-89595739, "\ue0ca饱Ꭿ跌\u0600胣㪼덋ⴔ")),
      new gzj(600, a.c(-1310810088, "ꁠ\ud9c2匙쵯䛻쀄穘\uf3aa淩\ue74e"), 6000L, 60.0F, 0.0F, true),
      new gzj(700, a.b("鈝\ueba5慽１", 1869714037), 6000L, 20.0F, -50.0F, true, a.b("扏ᯣ鄡", -1817812444)),
      new gzj(800, a.b("㨫䎏쥋圮\udcb2婂\ue012槻", 1365588563), 6000L, 20.0F, -20.0F, true, a.b("嗉ⱛꚐ", -896445050)),
      new gzj(880, a.c(-890242893, "\uf8c8腬ந闍ṑ颠⋻ꬋ㕙뿴㠿"), 6000L, 20.0F, -20.0F, true, a.b("짍끔㪆ꓺ⼱ꦘ", -1577006714)),
      new gzj(960, a.c(-1438407290, "ꗿ\udc5b嚟죺䍦얒翀\uf63f桯"), 6000L, 20.0F, -20.0F, true, a.c(-1823389408, "䥬ー먡\u245f")),
      new gzj(1140, a.d("肋郎珨\ued9d晙\ue0ff嫳퍝䴑잨䁼", -940827439, -1434018782), 6000L, 20.0F, -5.0F, true, a.d("蒳ﴑ矊\ue9bc", 1410256285, -195081896)),
      new gzj(1190, a.c(403609009, "闎\uec69暷\uf8c6獐\uf5aa俾옜"), 6000L, -140.0F, -4.0F, true),
      new gzj(1230, a.c(1837369384, "ࡕ燲שּׁ敝\ueecb栰퉶宔에佾"), 6000L, -45.0F, 4.0F, true),
      new gzj(1270, a.b("疽చ蛄ᢵ錣ᗙ꾍♯롯㊜땆伷", 508720582), 6000L, -140.0F, -4.0F, false)
   };
   private static final String[] gzx = new String[]{
      a.c(60010768, "녜죞䈔\udc65垜턝歕\ue2aa糺\uf657"),
      a.b("্灅歹擽\uef32榋평娾쑺仁줷㍯붰", 484706710),
      a.d("\udaadꌧ⧽랉㱟뫹«", 2064107261, 115416068),
      a.b("ꨗ펝奇윳䳥쩃瀱笠枵", 710126157),
      a.d("阪\uefb9敱יִ烌\uf67c䰃엜定턬", 1943758016, -996281683)
   };
   private static boolean[] gzy;
   private static volatile BlockPos gzz;
   private static volatile boolean haa;
   private static int hab = -1;

   private gzt() {
   }

   static boolean tick(MinecraftClient var0, int var1) {
      kfe var2 = Flow.getInstance().getModuleManager().getByName(a.b("䥨ル먼\u2458꾓⤯鍫", 1993754936));
      if (var1 == 1) {
         gzy = new boolean[gzx.length];

         for (int var14 = 0; var14 < gzx.length; var14++) {
            kfe var16 = Flow.getInstance().getModuleManager().getByName(gzx[var14]);
            gzy[var14] = var16 != null && var16.isEnabled();
            if (gzy[var14]) {
               var16.setEnabled(false);
            }
         }

         var0.field_1690.field_1842 = true;
         var0.field_1690.field_1837 = false;
         var0.field_1690.method_42503().method_41748(12);
         var0.field_1690.method_41808().method_41748(70);
         hah(var0, a.c(2088924329, "瓟൨螷\u19ce鈑ᒢ껺✊뤐㏢될乆삕失퍿喑\uefcd"));
         hah(var0, a.c(929463682, "緻ь躓ც鬪ᶜꟖ⸮뀴㫁봙䝃즱倘\uda5e岪\ue6eb椵\uf39a痼ﰱ虺ࣆ錞ᔤ龳☇ꡛ㊳듴"));
         hah(var0, a.c(-2031809362, "\u0cd4畣ﾼ懅\uea05河훹弁섛䯮찶㙿뢚ℯꭩⶄ韆᠀节ө贄\uf75a秠\ue274摍\uee9b圥\ud96b䎊"));
         hah(var0, a.b("峣╀꾗ㇳ머㲄蛀ལ酿ᯁ鰛普\ue8aa", -466527079));
         GLFW.glfwSetWindowSize(var0.method_22683().method_4490(), 1920, 1080);
         hae(var0);
         return false;
      } else if (var1 < 10) {
         return false;
      } else if (hab < 0) {
         if (!haa) {
            return false;
         } else {
            BlockPos var13 = gzz;
            if (var13 == null) {
               System.out.println(a.d("뚤켒䗚\udbb6偾횘泑\ue56e笰\uf1ce癍谠˺魃ᄗ韻ⷧꉰ㣊뺁㝭䴶", -1066735519, -975544672));
               return true;
            } else {
               System.out.println(a.b("圡⺗ꑟ㨳뇻㜇贕ӱ髺", 845436763) + var13.method_23854());
               hah(
                  var0,
                  a.b("熏࠺芹Შ靌ᆮ", -1708297731)
                     + var13.method_10263()
                     + a.d("\uf382", -612820508, 1748757063)
                     + var13.method_10264()
                     + a.b("\uf2ff", -368184610)
                     + var13.method_10260()
                     + a.c(393713989, "饡\ue0c0樃\uf462")
               );
               hah(var0, a.d("櫒\u137e馩ߐ豂ઠ냥㤅꜎ⶩꩼ倍\udeda", 143055043, -1572425112));
               ((vlv)hag(var2, a.c(-1035039376, "败\uf4a2繵\ue016毝\ued6d"))).set(a.d("ﯧ艥ࢾ雈", 893300861, 618089420));
               ((vmc)hag(var2, a.d("圥⺧ꑼ㨊뇕㝣贽ӌ", 966683043, -1209909540))).set(0.7);
               ((vmc)hag(var2, a.d("\uf8b1脥௸閆ṍ飦⊲ꭄ㔒", -415442843, 1256136849))).set(0.0);
               ((vmc)hag(var2, a.d("說耿૯钄ὂ駤", -2060895661, 1597555639))).set(0.9);
               ((vmc)hag(var2, a.d("穥Ͽ褯\u175e鲋", 1092827518, 1117733721))).set(0.6);
               ((vmc)hag(var2, a.d("\udc56ꗛ⼒노㪥밃", 2032628115, 1257549200)))
                  .set(
                     Double.parseDouble(System.getenv().getOrDefault(a.c(-41168118, "퍝ꫦ‶빟㗭댱८肘Ờ鑰Ꮌ\ue9df朄ﺩ瓠\uf20a䡏"), a.d("阉\uefa6敩ײַ", 924644733, -1993907392)))
                  );
               ((vkl)hag(var2, a.c(-364400684, "꾛혆峖스䥩쿟痞ﱨ戢\ue880潖锦"))).set(true);
               ((vkl)hag(var2, a.d("켉뚑㱉ꈥ⦡꽔ᔑ鳽ʽ蠏", 1964666462, 1378590993))).set(true);
               ((vlv)hag(var2, a.b("籞\u05cb輌ᅰ骢ᰎꙐ", 671841288))).set(a.c(-1234508476, "\ue508鲘ᙅ蠻"));
               var2.setEnabled(true);
               hab = var1;
               return false;
            }
         }
      } else {
         int var3 = var1 - hab - 520;
         if (var3 == -500) {
            hah(var0, a.d("\udaa2ꌜ⧊랻㰠뫏Ï褢\u177e鷝ᩐ\ue07f滶\uf714絛ﮩ䇴칻咇틕嬰ℿ꿊㐃눢㢼脌ཏ闹Ꭰ須", -1389541723, -1483498370));
            hah(var0, a.d("쐕붫㝽ꤌ⊗ꑸṸ鞕\u09c9荪ӧﻅ瀎\ue9ae掣\ue501归킀䨡찮䖖㿄녥⫪곆☋龩ᆦ謞ൌ蛭硻\uf221毃\ued82朳\ud8c8劄푙䷫잸륁", 558560400, 2007380169));
            hah(var0, a.c(375565197, "꯴퉊墜웭䵶쮙熙\uf877昺\uecd5歕鄸῾蘑ఏ諭ー뽡◀ꏏ⩫倦\ude84䔋쌼䧻\uf01f繘\ue4ba拺\ue95e"));
            hah(var0, a.d("ᢊ愴\uebe2疓︈磧싾䬛픚念\ud878≚겔㔱뼼㦇菜\u0c53隭ჯ饆\ue35d淺\uf678瀀響䍸촢埯톃娠ꓪ⺯띖ㄝ", -10025834, 1188895833));
            hah(var0, a.c(-367724837, "\uf695輫\u05fd鮌ဗ雸\u2cf8ꔕ㭛놴㘴챙䊟\udb70兰힝淑\ue212磿ﻡ眇ഈ菨ᠥ鹋ᓄ괤⍫릏㾝됢䫾삱奎\udf14喳\uea63怉\ue6db罡"));
            hah(var0, a.b("䇚㡤늲ⳃꝘ↷鮷ቝ谔ۻ腶筙\uf5dd汷\ue632悝\uda81啋쿮䧡쁚먙㓴꽶⤒ꏕᨩ鑶\u0e8b裮ͮﶼ矻", -785301091));
            hah(var0, a.d("\ueb46鋸ᠮ號හ謫ㄴ룇⚈걧⯪퇅彁웩䲾쩟灎ￕ敧\ue323檊႔鸤ק菆ॄ냩㺳ꑜ≞ꧪ圠\udd6e䒔싽䡱\uf7b6緜ﬅ押\ue8fb", -256150883, 1014602132));
            hah(var0, a.b("뫜썢䦴ퟅ属\udab1悮\ue95d眒﷽穽耐໖霹ᴹ鯖↝깛㒶늭㭛䄟쿲呰툓壓\ue13e漼\uf5d5率\uf824ڲ賨ᔊ鍋᧺ꘁⱍꪐ㌢륱있", 2040838800));
         }

         if (var3 == -480) {
            var0.field_1724.method_31549().field_7479 = false;
         }

         if (var0.field_1755 != null) {
            var0.method_1507(null);
         }

         if (var3 == -40) {
            uxx.timing(true);
            uxx.gpuMillis();
         }

         if (var3 == -1) {
            System.out.println(a.b("௹牏\uf887曫\ued23毟퇋堭왷䲓", -1257501824) + uxx.gpuReport());
         }

         for (gzj var7 : gzw) {
            if (gzv == null || var7.gzl.startsWith(gzv)) {
               int var8 = var7.gzq.equals(a.b("\udd1d꒱\u2e73", 1334238582)) ? 90 : (var7.gzq.equals(a.b("\uf5ea豈ړ飥", 439874972)) ? 130 : 36);
               if (var3 == var7.gzk - var8) {
                  hah(var0, a.c(-209631884, "䔉㲥뙲⠋ꎙ╻鼾ᛞ裕") + var7.gzm);
                  var2.setEnabled(var7.gzp);
                  var0.field_1690.field_1842 = !var7.gzq.equals(a.b("\uf221讍ŏ", -160501174));
                  if (var7.gzq.equals(a.c(1159962363, "麴\ue726淭"))
                     || var7.gzq.equals(a.d("맙쁀䪒퓮弥\ud98c", -978177975, 1316129243))
                     || var7.gzq.equals(a.d("聼溺猱\ued4f", -1488011237, -597278677))) {
                     ((vlv)hag(var2, a.d("莜降烎\ueeb2敠\ue3cc妒", 420493145, -233524077))).set(var7.gzq);
                  }

                  haf(var0, var7.gzn, var7.gzo);
                  if (var7.gzq.equals(a.d("Ⲻ唘\udfc3䆵", 174860185, 1521486677))) {
                     hah(var0, a.b("騀\ue3a3楴\uf710糛逸䀣즀垍\udd2f嫴ꂂ", 2105580155));
                  }
               } else if (var3 != var7.gzk - 30
                  || !var7.gzq.equals(a.c(-46849522, "≁寓턘"))
                     && !var7.gzq.equals(a.c(-1378828215, "쀂릛㍉괵⛾ꁗ"))
                     && !var7.gzq.equals(a.d("\u0bd8版\uf895曫", -131874378, -894514654))) {
                  if (var3 != var7.gzk - 3 || !var7.gzq.startsWith(a.b("累胳ਣ鑊ΐ", 725350696)) && !var7.gzq.startsWith(a.c(-1329097185, "陿\uefc4攚ﭹ炵\uf656"))) {
                     if (var3 == var7.gzk - 2) {
                        haf(var0, var7.gzn, var7.gzo);
                     } else if (var3 == var7.gzk) {
                        if (var7.gzq.equals(a.b("艺ﯨ焣", 1441169973))
                           || var7.gzq.equals(a.b("碄ĝ诏ᖳ鹸ᣑ", -1753515825))
                           || var7.gzq.equals(a.c(1280185584, "ᒼ洬\ue7f1福"))) {
                           System.out
                              .println(
                                 a.c(838323896, "컍띻㶳ꏟ⠗껫")
                                    + var7.gzl
                                    + a.d("콎뚸㱼ꈈ⦊", 899869419, -333830784)
                                    + uxx.gpuReport()
                                    + a.b("缐ہ豲", 256278323)
                                    + var0.method_47599()
                                    + a.c(-395673399, "胭駱珟\uedad")
                              );
                        }

                        hai(var0, a.b("䐱㶇띏⤣ꋫ␚", -1219148732) + var7.gzl);
                        System.out.println(a.b("蘑ﾧ畯\ueb03惋\ue637尥헀䮎섲䛧볙", -1073117586) + vss.report());
                     } else if (var3 == var7.gzk + 2 && var7.gzq.equals(a.d("మ疌ｗ愡", 1620330410, 767118322))) {
                        System.out
                           .println(
                              a.b("ꞌ\ude3a哲쪞䅖잪綪\uf44d樅\ue0b0杰鴖᎓詰0蛉㲁댞⧪꾮♊尞튠䥽켉䗂ﰥ", 792438756)
                                 + var0.field_1687.method_8430(1.0F)
                                 + a.d("悎ᥭ鎭ු蘄²뫦㌞괆", -965558439, 789766142)
                                 + var0.field_1687.method_8419()
                           );
                        hah(var0, a.b("擑ᵲ鞥ু舊Ҷ뻲㝑ꥍ⏳ꐩ幜킘", -32676693));
                     } else if (var3 == var7.gzk + 4
                        && (var7.gzq.startsWith(a.d("铉\ued75枥琉牕", 1833965833, -619868761)) || var7.gzq.startsWith(a.b("\ue547鳼ᘢ衁\u038d蕮", -1916541657)))) {
                        ((sbp)var2).testStrike(100000.0F, false, 0.0, 10.0);
                     }
                  } else {
                     float var9 = Float.parseFloat(var7.gzq.substring(var7.gzq.indexOf(58) + 1));
                     float var10 = var7.gzn * (float) (Math.PI / 180.0);
                     double var11 = Math.atan2(Math.cos(var10), -Math.sin(var10));
                     ((sbp)var2).testStrike(var9, var7.gzq.startsWith(a.b("湼ៀ鴐\u0379裠", 380923419)), var11, 0.03);
                  }
               } else {
                  uxx.gpuMillis();
               }
            }
         }

         if (var3 > gzw[gzw.length - 1].gzk + 10) {
            uxx.timing(false);
            var0.field_1690.field_1842 = false;

            for (int var15 = 0; var15 < gzx.length; var15++) {
               kfe var17 = Flow.getInstance().getModuleManager().getByName(gzx[var15]);
               if (var17 != null) {
                  var17.setEnabled(gzy[var15]);
               }
            }

            return true;
         } else {
            return false;
         }
      }
   }

   private static void hae(MinecraftClient var0) {
      gzz = null;
      haa = false;
      IntegratedServer var1 = var0.method_1576();
      BlockPos var2 = var0.field_1724.method_24515();
      var1.execute(() -> {
         try {
            ServerWorld var2x = var1.method_30002();
            Pair var3 = var2x.method_42108(var0xx -> var0xx.method_40225(BiomeKeys.field_9451), var2, 6400, 32, 64);
            if (var3 != null) {
               BlockPos var4 = (BlockPos)var3.getFirst();
               var2x.method_8500(var4);
               int var5 = var2x.method_8624(Type.field_13203, var4.method_10263(), var4.method_10260());
               gzz = new BlockPos(var4.method_10263(), var5, var4.method_10260());
            }
         } catch (Throwable var6) {
            System.out.println(a.b("弾⚈걀㈬매㼘蔇\u0cf5銦᠕鿓斳\ueb21狖\uf882繻쐱䯩텛坔\udeb9", 787439448) + var6);
         }

         haa = true;
      });
   }

   private static void haf(MinecraftClient var0, float var1, float var2) {
      var0.field_1724.method_36456(var1);
      var0.field_1724.method_36457(var2);
      var0.field_1724.field_5982 = var1;
      var0.field_1724.field_6004 = var2;
   }

   private static vmo hag(kfe var0, String var1) {
      for (vmo var3 : var0.getSettings()) {
         if (var3.getName().equals(var1)) {
            return var3;
         }
      }

      throw new IllegalStateException(var0.getName() + a.c(825255096, "撐ᵩ鞳\u09d0艔ҫ뻹㝇") + var1);
   }

   private static void hah(MinecraftClient var0, String var1) {
      var0.method_1562().method_45730(var1);
   }

   private static void hai(MinecraftClient var0, String var1) {
      System.out.println(a.b("ㄼ䢛쉁尺\ud7ab兎\ueb0c拫ﲳ癖", 1767715141) + var1 + a.c(-678339050, "帵⟤굗") + var0.method_47599() + a.d("䩗㎠륥✗", -1698887769, 701779412));
      ScreenshotRecorder.method_22690(
         var0.field_1697,
         a.d("Ｑ蚊ౚ鈳ᦡ鼏", -406698519, 135838392) + var1 + a.b("蚖ｹ疴\uebcc", 1204324028),
         var0.method_1522(),
         1,
         var0x -> System.out.println("" + var0x.getString())
      );
   }
}
